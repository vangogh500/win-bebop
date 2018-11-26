package com.github.vangogh500.bebop
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation._
import nodejs._

@ScalaJSDefined
trait BrowserWindowOptions extends js.Object {
  val width: js.UndefOr[Int]
  val height: js.UndefOr[Int]
  val frame: js.UndefOr[Boolean]
  val titleBarStyle: js.UndefOr[String]
}

object BrowserWindowOptions {
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
