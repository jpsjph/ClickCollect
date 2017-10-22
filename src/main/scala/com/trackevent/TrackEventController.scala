package com.trackevent

import com.google.gson.Gson
import com.mongodb.casbah.MongoCollection
import com.trackevent.models.ClickEvent
import com.trackevent.services.EventService
import org.json4s.{DefaultFormats, Formats}
import org.scalatra._
import org.scalatra.swagger.{Swagger, SwaggerSupport}
import org.scalatra.CorsSupport


class TrackEventController(implicit val swagger: Swagger,
                           implicit val mongoColl: MongoCollection,
                           implicit val service:EventService)
  extends ScalatraServlet with SwaggerSupport with CorsSupport {

  protected implicit val jsonFormats: Formats = DefaultFormats
  override protected def applicationDescription: String = "TrackEvent API. It exposed operations for collecting all users behaviours"


/*  get("/") {
    params.get("eventId") match {
      case Some(id)=>Ok(findEvents(id))
      case None=>Ok(all)
    }
  } */

  post("/eventClicks"){
    response.setHeader("Access-Control-Allow-Origin", "*")
     val jsonString= request.body
    try {
      val gson = new Gson
      val event = gson.fromJson(jsonString, classOf[ClickEvent])
      service.saveClick(event)
    } catch {
      case e: Exception =>
        e.printStackTrace
        response.addHeader("ACK", "BOOM!")
    }
  }
}
