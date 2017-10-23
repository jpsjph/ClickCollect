import com.trackevent._
import org.scalatra._
import javax.servlet.ServletContext

import com.mongodb.casbah.{MongoClient, MongoClientURI}
import com.trackevent.services.EventService

class ScalatraBootstrap extends LifeCycle {
  implicit val swagger =  new TrackEventSwagger

  override def init(context: ServletContext) {
    val client=MongoClient( MongoClientURI("mongodb://jpsjph:Password!234@cluster0-shard-00-00-eu8pu.mongodb.net:27017,cluster0-shard-00-01-eu8pu.mongodb.net:27017,cluster0-shard-00-02-eu8pu.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin"))
   implicit val collection=client("CollectClicks")("clicks")

    implicit val service=new EventService(collection)


    context.mount(new TrackEventController(), "/*")
    context.mount (new ResourcesApp, "/api-docs")
  }
}
