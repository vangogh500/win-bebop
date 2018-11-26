package com.github.vangogh500.bebop
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import nodejs._

@js.native
@JSImport("electron", "app")
object App extends EventEmitter {
  def quit(): Unit = js.native
}
