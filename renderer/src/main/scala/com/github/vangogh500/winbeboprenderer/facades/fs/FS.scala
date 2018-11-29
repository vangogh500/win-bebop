/**
 * Facade for FS
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbeboprenderer
package facades
package fs

import scala.concurrent.{ Future, Promise, ExecutionContext }
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import nodejs.Error

/**
 * File system
 */
object FS {
  /**
   * Native FS
   */
  @js.native
  @JSImport("fs", JSImport.Namespace)
  object Raw extends js.Object {
    def readdir(path: String, callback: js.Function2[Error, js.Array[String], Unit]): Unit = js.native
    def lstat(path: String, callback: js.Function2[Error, Stats, Unit]): Unit = js.native
  }
  /**
   * Read directory
   * @param path Directory path
   * @return A list of directory names
   */
  def readdir(path: String)(implicit ec: ExecutionContext): Future[Seq[String]] = {
    val p = Promise[Seq[String]]()
    Raw.readdir(path, (e: Error, items: js.Array[String]) => Option(e) match {
      case Some(e) => p failure e
      case None => p success items
    })
    p.future
  }
  /**
   * Get stats of directory
   * @param path Directory path
   * @return Stats of directory
   */
  def lstat(path: String)(implicit ec: ExecutionContext): Future[Stats] = {
    val p = Promise[Stats]()
    Raw.lstat(path, (e: Error, stats: Stats) => Option(e) match {
      case Some(e) => p failure e
      case None => p success stats
    })
    p.future
  }
  /**
   * List files in directory (excludes folders)
   * @param path Directory path
   * @return A list of all files in directory
   */
  def dirfiles(path: String)(implicit ec: ExecutionContext): Future[Seq[String]] = readdir(path) flatMap { items =>
    Future.sequence(
      items map { item =>
        lstat(path + "\\" + item) flatMap { stats =>
          if(stats.isDirectory) dirfiles(path + "\\" + item)
          else Future { Seq(path + "\\" + item) }
        }
      }
    ) map(_.flatten)
  }
}
