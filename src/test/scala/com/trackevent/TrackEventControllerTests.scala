package com.trackevent

import com.mongodb.casbah.MongoClient
import com.trackevent.services.EventService
import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike

class TrackEventControllerTests extends ScalatraSuite with FunSuiteLike {
  val mongoClient =  MongoClient()
  implicit val mongoColl = mongoClient("casbah_test")("test_data")
  implicit val swagger = new TrackEventSwagger

  implicit val service=new EventService(mongoColl)
  addServlet(new TrackEventController(), "/*")

  test("GET / on TrackEventServlet should return status 200"){
    get("/"){
      status should equal (200)
    }
  }
}
