package com.trackevent.services

import com.trackevent.models.EventCapture

trait EventRepository {
  def SaveEvents(list: List[EventCapture])
  def findEvent(eventId:String):EventCapture
}
