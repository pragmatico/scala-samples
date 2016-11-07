package co.pragmati.api

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives
import spray.json._

// domain model
final case class CompactPrintedItem(name: String, id: Long)

trait CompactJsonFormatSupport extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val printer = CompactPrinter
  implicit val compactPrintedItemFormat = jsonFormat2(CompactPrintedItem)
}

class MyJsonApi extends Directives with CompactJsonFormatSupport {

  // format: OFF
  val route =
    path("items") {
      get {
        pathSingleSlash {
          complete {
            // should complete with spray.json.JsValue = {"name":"akka","id":42}
            CompactPrintedItem("akka", 42) // will render as JSON
          }
        }
      }
    }

}

