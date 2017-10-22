package com.trackevent

import com.mongodb.casbah.MongoClient
import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike

class TrackEventControllerTests extends ScalatraSuite with FunSuiteLike {
  val mongoClient =  MongoClient()
  implicit val mongoColl = mongoClient("casbah_test")("test_data")
  implicit val swagger = new TrackEventSwagger
  addServlet(new TrackEventController(), "/*")

  test("GET / on TrackEventServlet should return status 200"){
    get("/"){
      status should equal (200)
    }
  }

}
