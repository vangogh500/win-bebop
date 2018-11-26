name := "win-bebop"
organization := "com.github.vangogh500"

enablePlugins(ScalaJSPlugin)
enablePlugins(ScalaJSBundlerPlugin)

scalaJSUseMainModuleInitializer := true

npmDependencies in Compile ++= Seq(
  "electron" -> "3.0.10"
)

lazy val fastDist = taskKey[Unit]("Compile and copy paste projects and generate corresponding json file.")

fastDist := {
  val mainProcessDirectory = (fastOptJS in Compile).value.data
  val files = Seq(
    mainProcessDirectory.getParentFile / "win-bebop-fastopt.js" -> baseDirectory.value / ".." / "dist" / "main.js",
    mainProcessDirectory.getParentFile / "win-bebop-fastopt.js.map" -> baseDirectory.value / ".." / "dist" / "main.js.map"
  )
  IO.copy(files, true, false, false)
}
