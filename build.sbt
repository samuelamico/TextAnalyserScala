name := "TextAnalyserScala"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.1.1",
  "com.storm-enroute" %% "scalameter-core" % "0.19",
  "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0"
)