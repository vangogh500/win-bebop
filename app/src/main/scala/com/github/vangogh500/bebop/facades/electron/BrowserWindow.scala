package com.github.vangogh500.bebop
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import nodejs._

@js.native
@JSImport("electron", "BrowserWindow")
class BrowserWindow(args: BrowserWindowOptions) extends EventEmitter {
  val webContents: WebContents = js.native
  def loadFile(src: String): Unit = js.native
}

object BrowserWindow {
  def apply(
    width: js.UndefOr[Int] = js.undefined,
    height: js.UndefOr[Int] = js.undefined,
    frame: js.UndefOr[Boolean] = js.undefined,
    titleBarStyle: js.UndefOr[String] = js.undefined
  ) = new BrowserWindow(BrowserWindowOptions(width, height, frame, titleBarStyle))
}
