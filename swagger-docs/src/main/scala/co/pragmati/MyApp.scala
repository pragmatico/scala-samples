package co.pragmati

import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import co.pragmati.api.{PingHttpService, Site, SwaggerDocService}
import com.typesafe.config.{ConfigFactory, Config}

import scala.io.StdIn

object MyApp extends App with Site with PingHttpService {

  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher

  val config = ConfigFactory.load()
  val logger = Logging(system, getClass)

  val host = config.getString("http.host")
  val port = config.getString("http.port")

  val routes = pingRoute ~
    swaggerSiteRoute ~
    new SwaggerDocService(host, port, system).routes

  val bindingFuture = Http().bindAndHandle(routes, host, port.toInt)

  logger.info(s"Server online at http://" + host + ":" + port + "/\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done

}
