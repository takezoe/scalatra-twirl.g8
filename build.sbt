import org.scalatra.sbt._

organization := "organization"

name := "name"

version := "0.0.1"

scalaVersion := "2.12.1"

scalacOptions := Seq("-deprecation", "-language:postfixOps")

libraryDependencies ++= Seq(
  "org.scalatra"        %% "scalatra"          % "2.5.0",
  "org.scalatra"        %% "scalatra-specs2"   % "2.5.0" % "test",
  "org.scalatra"        %% "scalatra-json"     % "2.5.0",
  "org.json4s"          %% "json4s-jackson"    % "3.5.0",
  "io.github.gitbucket" %% "scalatra-forms"    % "1.1.0",
  "com.typesafe.slick"  %% "slick"             % "3.2.0-M2",
  "org.eclipse.jetty"    % "jetty-webapp"      % "9.3.9.v20160517" % "provided",
  "javax.servlet"        % "javax.servlet-api" % "3.1.0" % "provided"
)

javacOptions in compile ++= Seq("-target", "8", "-source", "8")

testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "junitxml", "console")

packageOptions += Package.MainClass("JettyLauncher")

ScalatraPlugin.scalatraWithJRebel

enablePlugins(SbtTwirl, JettyPlugin)
