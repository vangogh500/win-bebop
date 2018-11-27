/**
 * Facade for Electron window
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbeboprenderer
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

/**
 * Electron window
 */
@ScalaJSDefined
trait Window extends js.Object {
  /**
   * Maximize window
   */
  def minimize(): Unit
  /**
   * Minimize window
   */
  def maximize(): Unit
  /**
   * Close window
   */
  def close(): Unit
}
