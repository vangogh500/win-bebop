package com.github.vangogh500.winbeboprenderer

import org.scalajs.dom.document

object Main extends App {
  Renderer().renderIntoDOM(document.getElementById("app"))
}
