package co.pragmati.api

import javax.ws.rs.Path

import akka.http.scaladsl.server.Directives
import io.swagger.annotations._

@Path("/ping")
@Api(value = "/ping", produces = "text/plain")
trait PingHttpService extends Directives {

  @ApiOperation(httpMethod = "GET", response = classOf[String], value = "Returns ping response")
  @ApiResponses(Array(
    new ApiResponse(code = 400, message = "Invalid pong!"),
    new ApiResponse(code = 404, message = "Not found")))
  def pingRoute = get {

    path("ping") {

        complete(s"pong!")
    }

  }
}
