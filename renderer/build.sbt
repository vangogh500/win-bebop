name := "win-bebop-renderer"
organization := "com.github.vangogh500"

enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true

lazy val fastDist = taskKey[Unit]("Compile and copy paste projects and generate corresponding json file.")

fastDist := {
  val mainProcessDirectory = (fastOptJS in Compile).value.data
  val files = Seq(
    mainProcessDirectory.getParentFile / "win-bebop-renderer.js" -> baseDirectory.value / ".." / "dist" / "renderer.js",
    mainProcessDirectory.getParentFile / "win-bebop-renderer.js.map" -> baseDirectory.value / ".." / "dist" / "renderer.js.map"
  )
  IO.copy(files, true, false, false)
}

libraryDependencies ++= {
  val scalajs_react = "1.2.3"
  val scalacss = "0.5.3"
  Seq(
    "com.github.japgolly.scalajs-react" %%% "core" % scalajs_react,
    "com.github.japgolly.scalajs-react" %%% "extra" % scalajs_react,
    "com.github.japgolly.scalacss" %%% "core" % scalacss,
    "com.github.japgolly.scalacss" %%% "ext-react" % scalacss
  )
}
