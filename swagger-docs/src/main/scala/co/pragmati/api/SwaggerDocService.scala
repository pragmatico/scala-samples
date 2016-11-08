package co.pragmati.api

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import com.github.swagger.akka.{HasActorSystem, SwaggerHttpService}
import scala.reflect.runtime.{ universe => ru }
import com.github.swagger.akka.model.Info


class SwaggerDocService(hostname: String, port: String, system: ActorSystem) extends SwaggerHttpService with HasActorSystem {
  require(hostname != null && port != null)
  override implicit val actorSystem: ActorSystem = system
  override implicit val materializer: ActorMaterializer = ActorMaterializer()
  override val apiTypes = Seq(ru.typeOf[PingHttpService])
  override val host = hostname + ":" + port //the url of your api, not swagger's json endpoint
  override val basePath = "/"    //the basePath for the API you are exposing
  override val apiDocsPath = "api-docs" //where you want the swagger-json endpoint exposed
  override val info = Info() //provides license and other description details
}
