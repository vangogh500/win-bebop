name := "win-bebop-renderer"
organization := "com.github.vangogh500"

enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true
scalaJSModuleKind := ModuleKind.CommonJSModule

lazy val fastDist = taskKey[Unit]("Compile and copy paste projects and generate corresponding json file.")

fastDist := {
  val mainProcessDirectory = (fastOptJS in Compile).value.data
  def processFile(from: File, to: File): Unit = {
    val xs = IO.readLines(from).filter(!_.matches(".*\\s\\$e[\\s;].*"))
    IO.writeLines(to, xs)
  }
  val files = Seq(
    mainProcessDirectory.getParentFile / "win-bebop-renderer-fastopt.js" -> baseDirectory.value / ".." / "dist" / "resources" / "js" / "renderer.js",
    mainProcessDirectory.getParentFile / "win-bebop-renderer-fastopt.js.map" -> baseDirectory.value / ".." / "dist" / "resources" / "js" / "renderer.js.map"
  )
  files.foreach {
    case (in, out) => processFile(in, out)
  }
}

libraryDependencies ++= {
  val scalajs_react = "1.2.3"
  val scalacss = "0.5.3"
  Seq(
    "com.github.japgolly.scalajs-react" %%% "core" % scalajs_react,
    "com.github.japgolly.scalajs-react" %%% "extra" % scalajs_react
  )
}
