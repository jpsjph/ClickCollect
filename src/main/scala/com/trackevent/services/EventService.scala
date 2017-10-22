package com.trackevent.services

import com.mongodb.casbah.MongoCollection
import com.trackevent.models.{EventCapture, FieldName}
import com.mongodb.casbah.commons.MongoDBObject

class EventService(cols:MongoCollection){
  def SaveEvents(events: List[EventCapture])={

    val inputData = events.map(doc => MongoDBObject(FieldName.FLD_EVENT_ID -> doc.eventId,
      FieldName.FLD_CONTENT -> doc.content,
      "httpStatus" -> doc.httpStatus,
      "date" -> doc.date,
      "port"->doc.port,
      "userAgent" -> doc.userAgent))

    cols.insert(inputData:_*)

  }
  def findEvent(eventId:String):EventCapture = ???

  def getAll:List[EventCapture] = ???

}
