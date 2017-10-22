package com.trackevent

import org.scalatra.ScalatraServlet
import org.scalatra.swagger.{ApiInfo, NativeSwaggerBase, Swagger}

class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with NativeSwaggerBase
object TrackEventSwagger {
  val Info = ApiInfo(
    "The EventTrack API",
    "Docs for EventTrack API",
    "http://eventtrack.com",
    "nadia@/eventtrack.com",
    "MIT",
    "http://opensource.org/licenses/MIT")
}
class TrackEventSwagger extends Swagger("2.0", "1", TrackEventSwagger.Info)


