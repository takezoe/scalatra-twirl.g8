import sbt._
import Keys._
import org.scalatra.sbt._
import twirl.sbt.TwirlPlugin._
import com.typesafe.sbteclipse.plugin.EclipsePlugin.EclipseKeys

object MyBuild extends Build {
  val Organization = "organization"
  val Name = "name"
  val Version = "0.0.1"
  val ScalaVersion = "2.10.3"
  val ScalatraVersion = "2.2.2"

  lazy val project = Project (
    "gitbucket",
    file("."),
    settings = Defaults.defaultSettings ++ ScalatraPlugin.scalatraWithJRebel ++ Seq(
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
        "org.json4s" %% "json4s-jackson" % "3.2.5",
        "jp.sf.amateras" %% "scalatra-forms" % "0.0.14",
        "com.typesafe.slick" %% "slick" % "1.0.1",
        "org.eclipse.jetty" % "jetty-webapp" % "8.1.8.v20121106" % "container;provided",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts Artifact("javax.servlet", "jar", "jar")
      ),
      EclipseKeys.withSource := true,
      javacOptions in compile ++= Seq("-target", "6", "-source", "6"),
      testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "junitxml", "console"),
      packageOptions += Package.MainClass("JettyLauncher")
    ) ++ seq(Twirl.settings: _*)
  )
}
