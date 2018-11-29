package com.github.vangogh500.winbeboprenderer

import org.scalajs.dom.document

import facades.nodejs._

object Main extends App {
  Renderer().renderIntoDOM(document.getElementById("app"))
}
