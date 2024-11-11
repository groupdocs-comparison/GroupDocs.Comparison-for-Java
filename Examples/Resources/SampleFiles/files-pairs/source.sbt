val scalaTest   = "org.scalatest" %% "scalatest" % "3.0.5"
val akkaVersion = "2.4.2"
val akkaActor   = "com.typesafe.akka" %% "akka-actor" % akkaVersion
val akkaCluster = "com.typesafe.akka" %% "akka-cluster" % akkaVersion

// Set the Scala version used by this build to 2.12.8.
ThisBuild / scalaVersion := "2.12.8"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"

lazy val root = (project in file("."))
  .aggregate(helloCore)
  .dependsOn(helloCore)
  .settings(
    name := "Hello",
    // Add a single dependency, for tests.
    libraryDependencies += scalaTest % Test
  )

lazy val helloCore = (project in file("core"))
  .settings(
    name := "Hello Core",
    libraryDependencies += scalaTest % Test,
    // Add multiple dependencies.
    libraryDependencies ++= List(akkaActor, akkaCluster)
  )