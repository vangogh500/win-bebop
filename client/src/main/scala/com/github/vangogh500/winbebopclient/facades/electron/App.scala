/**
 * Facade for Electron App
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbebopclient
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import nodejs._

/**
 * Electron App
 */
@js.native
@JSImport("electron", "app")
object App extends EventEmitter {
  /**
   * Quit electron
   */
  def quit(): Unit = js.native
}
