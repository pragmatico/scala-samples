name := baseDirectory.value.getName

version := "1.0"

scalaVersion := "2.11.8"
crossScalaVersions := Seq("2.11.8", "2.10.6")

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV       = "2.4.7"
  val scalaTestV  = "3.0.0"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaV,
    "com.github.swagger-akka-http" %% "swagger-akka-http" % "0.7.2",
    "co.pragmati" %% "swagger-ui-akka-http" % "0.1.0",
    "org.scalatest"     %% "scalatest" % scalaTestV % "test"
  )
}

mainClass := Some("co.pragmati.MyApp")

// append SHA-1 fingerprint to the assembly file name
//assemblyOption in assembly := (assemblyOption in assembly).value.copy(appendContentHash = true)



