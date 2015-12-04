lazy val commonSettings = Seq(
  organization := "com.arm",
  version := "0.1.0",
  scalaVersion := "2.11.4"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "adventofcode"
  )

libraryDependencies ++= List(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "commons-codec" % "commons-codec" % "1.10"
)
