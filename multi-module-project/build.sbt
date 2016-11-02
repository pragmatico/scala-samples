name := "multi-module"

lazy val commonSettings = Seq(
  organization := "co.pragmati",
  version := "0.0.1-SNAPSHOT",
  scalaVersion := "2.11.8"
)

lazy val root = (project in file(".")).settings(commonSettings: _*).aggregate(api, service, domain).dependsOn(api)

lazy val api = (project in file("api")).settings(commonSettings: _*)
  .settings(
    libraryDependencies ++= {

      val akkaHTTPVersion = "2.4.11"
      val Json4sVersion = "3.4.1"
      val scalaTestVersion = "3.0.0"

      Seq(
        "com.typesafe.akka" %% "akka-http-experimental" % akkaHTTPVersion,
        "com.typesafe.akka" %% "akka-http-core" % akkaHTTPVersion,
        "com.typesafe.akka" %% "akka-http-testkit" % akkaHTTPVersion,
        "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaHTTPVersion,
        "org.scalactic" %% "scalactic" % scalaTestVersion,
        "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
        "org.json4s" %% "json4s-native" % Json4sVersion,
        "org.json4s" %% "json4s-ext" % Json4sVersion
      )
    }
  )
  .dependsOn(service)

lazy val service = (project in file("service")).settings(commonSettings: _*).dependsOn(domain)

lazy val domain = (project in file("domain")).settings(commonSettings: _*)

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

javaOptions := Seq("-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005")

libraryDependencies ++= {

  val akkaHTTPVersion = "2.4.11"
  val Json4sVersion = "3.4.1"
  val scalaTestVersion = "3.0.0"

  Seq(
    "com.typesafe.akka" %% "akka-http-experimental" % akkaHTTPVersion,
    "com.typesafe.akka" %% "akka-http-core" % akkaHTTPVersion,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHTTPVersion,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaHTTPVersion,
    "org.scalactic" %% "scalactic" % scalaTestVersion,
    "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
    "org.json4s" %% "json4s-native" % Json4sVersion,
    "org.json4s" %% "json4s-ext" % Json4sVersion
  )
}
