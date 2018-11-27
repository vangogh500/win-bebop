package com.github.vangogh500.winbeboprenderer

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object Renderer {
  private val component = ScalaComponent.static("Renderer")(
      <.h1("HELLO WORLD")
  )
  def apply() = component()
}
