package com.github.vangogh500.winbeboprenderer
package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object TitleBar {
  private val component = ScalaComponent.static("Renderer")(
    <.header(^.id := "titlebar")(
      <.div(^.id := "window-controls")(
        <.div(^.id := "min-button", ^.className := "button")(
          <.span(^.className := "mdi mdi-window-minimize")
        ),
        <.div(^.id := "max-button", ^.className := "button")(
          <.span(^.className := "mdi mdi-window-maximize")
        ),
        <.div(^.id := "close-button", ^.className := "button")(
          <.span(^.className := "mdi mdi-window-close")
        )
      )
    )
  )
  def apply() = component()
}
