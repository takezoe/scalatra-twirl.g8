import org.scalatra.sbt._

lazy val Organization = "organization"
lazy val Name = "name"
lazy val Version = "0.0.1"
lazy val ScalaVersion = "2.11.8"
lazy val ScalatraVersion = "2.4.1"
lazy val JettyVersion = "9.3.9.v20160517"

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
    scalacOptions := Seq("-deprecation", "-language:postfixOps"),
    libraryDependencies ++= Seq(
      "org.scalatra"        %% "scalatra"          % ScalatraVersion,
      "org.scalatra"        %% "scalatra-specs2"   % ScalatraVersion % "test",
      "org.scalatra"        %% "scalatra-json"     % ScalatraVersion,
      "org.json4s"          %% "json4s-jackson"    % "3.4.0",
      "io.github.gitbucket" %% "scalatra-forms"    % "1.0.0",
      "com.typesafe.slick"  %% "slick"             % "3.1.1",
      "org.eclipse.jetty"    % "jetty-webapp"      % JettyVersion    % "provided",
      "javax.servlet"        % "javax.servlet-api" % "3.1.0"         % "provided"
    ),
    javacOptions in compile ++= Seq("-target", "8", "-source", "8"),
    testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "junitxml", "console"),
    packageOptions += Package.MainClass("JettyLauncher")
).enablePlugins(SbtTwirl, JettyPlugin)
