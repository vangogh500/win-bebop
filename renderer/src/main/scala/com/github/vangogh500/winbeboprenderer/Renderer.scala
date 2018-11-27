package com.github.vangogh500.winbeboprenderer

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import components._

object Renderer {
  private val component = ScalaComponent.static("Renderer")(
      TitleBar()
  )
  def apply() = component()
}
