import org.scalatra.sbt._

organization := "$organization$"

name := "$name$"

version := "$version$"

scalaVersion := "$scala_version$"

scalacOptions := Seq("-deprecation", "-language:postfixOps")

libraryDependencies ++= Seq(
  "org.scalatra"        %% "scalatra"          % "$scalatra_version$",
  "org.scalatra"        %% "scalatra-specs2"   % "$scalatra_version$" % "test",
  "org.scalatra"        %% "scalatra-json"     % "$scalatra_version$",
  "org.json4s"          %% "json4s-jackson"    % "3.5.0",
  "io.github.gitbucket" %% "scalatra-forms"    % "1.1.0",
  "org.eclipse.jetty"    % "jetty-webapp"      % "9.3.9.v20160517" % "provided",
  "javax.servlet"        % "javax.servlet-api" % "3.1.0" % "provided"
)

javacOptions in compile ++= Seq("-target", "8", "-source", "8")

testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "junitxml", "console")

packageOptions += Package.MainClass("JettyLauncher")

ScalatraPlugin.scalatraWithJRebel

enablePlugins(SbtTwirl, JettyPlugin)
