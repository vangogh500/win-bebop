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
  def minimize(): Unit
  def maximize(): Unit
  def close(): Unit
}
