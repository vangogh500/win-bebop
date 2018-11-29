/**
 * Electron renderer
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbeboprenderer

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import components._

/**
 * Electron renderer
 */
object Renderer {
  /**
   * React component builder
   */
  private val component = ScalaComponent.static("Renderer")(
    <.div(
      TitleBar(),
      <.div(^.id := "appcontainer")(
        Library()
      )
    )
  )
  /**
   * Create a new instance of react component
   */
  def apply() = component()
}
