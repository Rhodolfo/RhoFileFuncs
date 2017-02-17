// Common settings
lazy val commonSettings = Seq(
  libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  organization := "com.upax-research",
  version := "1.1.0",
  scalacOptions := Seq("-feature"),
  scalaVersion := "2.12.1")

// Projects

lazy val filefuncs = (project in file("filefuncs"))
  .settings(commonSettings: _*)
  .settings(name := "FileFuncs")

lazy val checkpoints = (project in file("checkpoints"))
  .settings(commonSettings: _*)
  .settings(name := "Checkpoints")
  .dependsOn(filefuncs)
