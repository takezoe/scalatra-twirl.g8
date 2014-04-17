package controller

import org.scalatra._
import jp.sf.amateras.scalatra.forms._
import org.scalatra.json.JacksonJsonSupport
import org.scalatra.i18n.I18nSupport
import org.json4s.DefaultFormats

class IndexController extends ScalatraFilter with JacksonJsonSupport with I18nSupport with ClientSideValidationFormSupport {

  implicit val jsonFormats = DefaultFormats

  case class HelloForm(name: String)

  val form = mapping(
    "name" -> text(required, maxlength(40))
  )(HelloForm.apply)

  get("/"){
    html.index()
  }

  post("/hello", form){ form =>
    html.hello(form.name)
  }

}
