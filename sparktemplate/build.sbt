import Dependencies._

lazy val commonSettings = Seq(
  version := "0.0.1",
  organization := "com.example",
  scalaVersion := "2.11.11",
  test in assembly := {}
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "Hello",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += sparkCore,
    parallelExecution in Test := false,
    mainClass in assembly := Some("example.WordCountApp")
  )

lazy val utils = (project in file("utils"))
  .settings(commonSettings: _*)
  .settings(
    assemblyJarName in assembly := "spark-examples.jar"
  )

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
