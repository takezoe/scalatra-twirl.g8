import org.scalatra.sbt._

lazy val Organization = "organization"
lazy val Name = "name"
lazy val Version = "0.0.1"
lazy val ScalaVersion = "2.11.6"
lazy val ScalatraVersion = "2.3.1"

lazy val project = Project (
  Name,
  file(".")
)
.settings(ScalatraPlugin.scalatraWithJRebel: _*)
.settings(
    sourcesInBase := false,
    organization := Organization,
    name := Name,
    version := Version,
    scalaVersion := ScalaVersion,
    resolvers ++= Seq(
      Classpaths.typesafeReleases,
      "amateras-repo" at "http://amateras.sourceforge.jp/mvn/"
    ),
    scalacOptions := Seq("-deprecation", "-language:postfixOps"),
    libraryDependencies ++= Seq(
      "org.scalatra" %% "scalatra" % ScalatraVersion,
      "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
      "org.scalatra" %% "scalatra-json" % ScalatraVersion,
      "org.json4s" %% "json4s-jackson" % "3.2.11",
      "jp.sf.amateras" %% "scalatra-forms" % "0.1.0",
      "com.typesafe.slick" %% "slick" % "3.0.0",
      "org.eclipse.jetty" % "jetty-webapp" % "8.1.16.v20140903" % "container;provided",
      "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts Artifact("javax.servlet", "jar", "jar")
    ),
    EclipseKeys.withSource := true,
    javacOptions in compile ++= Seq("-target", "8", "-source", "8"),
    testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "junitxml", "console"),
    packageOptions += Package.MainClass("JettyLauncher")
).enablePlugins(SbtTwirl)
