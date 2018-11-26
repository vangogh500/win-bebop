package com.github.vangogh500.bebop

import facades.electron._

object Client {
  def main(args: Array[String]): Unit = {
    App.on("ready", () => {
      val win = BrowserWindow(
        width = 800,
        height = 600,
        frame = false
      )
      win.loadFile("index.html")
      //win.webContents.openDevTools()
    })
    App.on("window-all-closed", () => App.quit())
  }
}
