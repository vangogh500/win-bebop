package com.github.vangogh500.bebop
package facades
package nodejs

import scala.scalajs.js

@js.native
trait EventEmitter extends js.Object {
  def on(eventName: String, callback: js.Function): Unit = js.native
}
