/**
 * Facade for Nodejs Promise
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbeboprenderer
package facades
package nodejs

import scala.scalajs.js

/**
 * Promise
 */
@js.native
trait Promise[T] extends js.Object {
  def then[S](onFufillment:  js.Function1[T, S], onRejected: js.Function1[Error, S]): Promise[S] = js.native
}
