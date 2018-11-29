/**
 * Facade for Nodejs errors
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbeboprenderer
package facades
package nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation._
import nodejs._

/**
 * Error
 */
@js.native
trait Error extends js.Object {
  /**
   * Message associated with error
   */
  val message: String
  /**
   * Name associated with error
   */
  val name: String
}

object Error {
  /**
   * Converts error into native scala throwable
   */
  implicit def toThrowable(e: Error): Throwable = new Exception(e.message)
}
