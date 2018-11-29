/**
 * TitleBar
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbeboprenderer
package components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import facades.electron.Remote

/**
 * TitleBar
 */
object TitleBar {
  /**
   * React component builder
   */
  private val component = ScalaComponent.static("Renderer")(
    <.header(^.id := "titlebar")(
      <.div(^.id := "window-controls")(
        <.div(
          ^.id := "min-button",
          ^.className := "button",
          ^.onClick --> Callback { Remote.getCurrentWindow().minimize() })(
            <.span(^.className := "mdi mdi-window-minimize")
          ),
        <.div(
          ^.id := "max-button",
          ^.className := "button",
          ^.onClick --> Callback { Remote.getCurrentWindow().maximize() })(
            <.span(^.className := "mdi mdi-window-maximize")
          ),
        <.div(
          ^.id := "close-button",
          ^.className := "button",
          ^.onClick --> Callback { Remote.getCurrentWindow().close() })(
            <.span(^.className := "mdi mdi-window-close")
          )
      )
    )
  )
  /**
   * Instantiate a component
   */
  def apply() = component()
}
