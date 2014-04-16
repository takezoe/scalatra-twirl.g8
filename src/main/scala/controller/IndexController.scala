package controller

import org.scalatra._

class IndexController extends ScalatraFilter {

  get("/"){
    html.index()
  }

}
