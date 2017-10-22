import com.trackevent._
import org.scalatra._
import javax.servlet.ServletContext

import com.mongodb.casbah.MongoClient
import com.trackevent.services.EventService

class ScalatraBootstrap extends LifeCycle {
  implicit val swagger =  new TrackEventSwagger

  override def init(context: ServletContext) {
    val client=MongoClient("127.0.0.1",40025)
   implicit val collection=client("Product")("events")

    implicit val service=new EventService(collection)


    context.mount(new TrackEventController(), "/*")
    context.mount (new ResourcesApp, "/api-docs")
  }
}
