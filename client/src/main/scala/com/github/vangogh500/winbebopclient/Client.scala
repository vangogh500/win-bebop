/**
 * Win bebop client
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbebopclient

import facades.electron._

/**
 * Main
 */
object Client {
  def main(args: Array[String]): Unit = {
    App.on("ready", () => {
      val win = BrowserWindow(
        width = 800,
        height = 600,
        frame = false
      )
      win.loadFile("./resources/index.html")
    })
    App.on("window-all-closed", () => App.quit())
  }
}
