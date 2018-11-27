/**
 * Facade for Electron WebContents
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbebopclient
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * WebContents
 */
@js.native
trait WebContents extends js.Object {
  /**
   * Open dev tools in electron
   */
  def openDevTools(): Unit = js.native
}
