/**
 * Facade for Electron remote
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbeboprenderer
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * Electron Remote
 */
@js.native
@JSImport("electron", "remote")
object Remote extends js.Object {
  /**
   * Get current window
   */
  def getCurrentWindow(): Window = js.native
}
