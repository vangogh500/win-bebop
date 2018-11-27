/**
 * Facade for Nodejs EventEmitter
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbebopclient
package facades
package nodejs

import scala.scalajs.js

/**
 * EventEmitter
 */
@js.native
trait EventEmitter extends js.Object {
  /**
   * Add event listener
   * @param eventName Event name
   * @param callback The callback function
   */
  def on(eventName: String, callback: js.Function): Unit = js.native
}
