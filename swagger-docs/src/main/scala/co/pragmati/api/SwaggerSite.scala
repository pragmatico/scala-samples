package co.pragmati.api

import akka.http.scaladsl.server.Directives

trait Site extends Directives {
  val swaggerSiteRoute =
    path("swagger") { getFromResource("swagger-ui/index.html") } ~ getFromResourceDirectory("swagger-ui")
}
