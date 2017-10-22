package com.trackevent.services

import com.mongodb.casbah.MongoCollection
import com.trackevent.models.{ClickEvent, EventCapture}
import com.mongodb.casbah.commons.MongoDBObject

class EventService(cols:MongoCollection){

  def saveClick(click:ClickEvent){
    val inputData = MongoDBObject("eventId" -> click.eventId,
      "name" -> click.name,
      "action" -> click.action,
      "browser" -> click.browser,
      "numbers" -> click.numbers
    )
    cols.insert(inputData)
  }

  def findEvent(eventId:String):EventCapture = ???

  def getAll:List[EventCapture] = ???

}
