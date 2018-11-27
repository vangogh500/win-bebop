/**
 * Facade for Electron BrowserWindowOptions
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbebopclient
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation._
import nodejs._

/**
 * Options used for constructing a BrowserWindow
 */
@ScalaJSDefined
trait BrowserWindowOptions extends js.Object {
  /**
   * Width of window
   */
  val width: js.UndefOr[Int]
  /**
   * Height of window
   */
  val height: js.UndefOr[Int]
  /**
   * Window frame type
   */
  val frame: js.UndefOr[Boolean]
  /**
   * Window title bar style (mac OS only)
   */
  val titleBarStyle: js.UndefOr[String]
}

/**
 * Options used for constructing a BrowserWindow
 */
object BrowserWindowOptions {
  /**
   * Instantiate a BrowserWindowOptions
   * @param w Window width
   * @param h Window height
   * @param f Window frame type
   * @param tbs Window title bar style (mac OS only)
   */
  def apply(
    w: js.UndefOr[Int],
    h: js.UndefOr[Int],
    f: js.UndefOr[Boolean],
    tbs: js.UndefOr[String]
  ) = new BrowserWindowOptions {
    val width = w
    val height = h
    val frame = f
    val titleBarStyle = tbs
  }
}
