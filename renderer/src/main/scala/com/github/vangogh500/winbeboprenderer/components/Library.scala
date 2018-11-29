/**
 * Library
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbeboprenderer
package components

import facades.id3.ID3
import facades.fs.FS
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scala.util.{Success, Failure}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Library
 */
object Library {
  case class Item(path: String, name: String, artist: String, album: String)
  case class State(songs: Seq[String])

  class Backend($: BackendScope[Unit, State]) {
    def componentDidMount: Callback = {
      val f: Future[Callback] = FS.dirfiles("""D:\Media\Music""") transform {
        case Success(songs) =>
          songs.filter(AudioFormat.test(_)).foreach(ID3.read(_) onComplete {
            case Success(metadata) => println(metadata.artist)
            case Failure(e) => println(e)
          })
          Success($.modState(s => State(songs)))
        case Failure(e) => Success($.modState(s => State(Seq())))
      }
      Callback.future(f)
    }
    def render(s: State): VdomElement = s match {
      case State(songs) =>
        <.table(^.className := "collection")(
          songs.map(song =>
            <.li(^.className := "collection-item")(song)
          ).toVdomArray
        )
    }
  }
  /**
   * React component builder
   */
  private val component = ScalaComponent.builder[Unit]("Library")
    .initialState(State(Seq()))
    .renderBackend[Backend]
    .componentDidMount(_.backend.componentDidMount)
    .build
  /**
   * Instantiate a component
   */
  def apply() = component()
}
