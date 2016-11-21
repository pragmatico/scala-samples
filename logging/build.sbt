name := baseDirectory.value.getName

version := "1.0"

scalaVersion := "2.11.8"
crossScalaVersions := Seq("2.11.8", "2.10.6")

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaHttpV   = "2.4.11"
  val akkaV       = "2.4.12"
  val scalaTestV  = "3.0.0"
  Seq(
    "com.typesafe.akka" %% "akka-http-core" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-jackson-experimental" % akkaHttpV,
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-slf4j" % akkaV,
    "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
    "ch.qos.logback"    %  "logback-classic" % "1.1.7",
    "org.scalatest"     %% "scalatest" % scalaTestV % "test"
  )
}


