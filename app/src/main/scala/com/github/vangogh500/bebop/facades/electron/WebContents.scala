package com.github.vangogh500.bebop
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

@js.native
trait WebContents extends js.Object {
  def openDevTools(): Unit = js.native
}
