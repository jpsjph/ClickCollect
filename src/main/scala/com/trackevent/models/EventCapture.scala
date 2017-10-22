package com.trackevent.models

case class EventCapture(eventId:String,
                        date:Long,
                        userName:String,
                        port:Int,
                        httpStatus:Int,
                        cookie:String,
                        userAgent:String,
                        serverIp:String,
                        content:String,
                        uriStem:String,
                        uriQuery:String)

case class ClickEvent(eventId:String,
                      name:String,
                      action:String,
                      numbers:String,
                      browser:String)