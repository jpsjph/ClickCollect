package com.trackevent

import com.mongodb.casbah.MongoCollection
import com.trackevent.models.EventCapture
import com.trackevent.services.EventService
import org.scalatra._
import org.scalatra.swagger.{Model, ResponseMessage, Swagger, SwaggerSupport}
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._

class TrackEventController(implicit val swagger: Swagger,
                           implicit val mongoColl: MongoCollection
                           //, implicit val service:EventService
                          )
  extends ScalatraServlet with SwaggerSupport  {


  protected implicit val jsonFormats: Formats = DefaultFormats
  override protected def applicationDescription: String = "TrackEvent API. It exposed operations for collecting all users behaviours"


  get("/") {
    params.get("eventId") match {
      case Some(id)=>Ok(findEvents(id))
      case None=>Ok(all)
    }
  }

  post("/eventClicks"){

  }

  val getEvents= apiOperation("getEvents",Model("id01","Get All Events"))



  def findEvents(name:String):List[String]={
    val events="TrackEvent API. It exposed operations for collecting all users behaviour".split(" ")
    events.filter(x=>x==name).toList
  }

  val all = "TrackEvent API. It exposed operations for collecting all users behaviour".split(" ").toList

}
