/**
 * Scala interfacing with supported audio formats
 * @author Kai Matsuda
 */
package com.github.vangogh500.winbeboprenderer

/**
 * Audio format type
 */
sealed trait AudioFormat

/**
 * Audio format type
 */
object AudioFormat {
  def apply(fileName: String): Option[AudioFormat] = fileName match {
    case s if s.matches("""(?i)^.*\.aiff$""") => Some(AIFF)
    case s if s.matches("""(?i)^.*\.flac$""") => Some(Flac)
    case s if s.matches("""(?i)^.*\.mp3$""") => Some(MP3)
    case s if s.matches("""(?i)^.*\.(mp4|m4a|m4v|aac)$""") => Some(MP4)
    case s if s.matches("""(?i)^.*\.wav$""") => Some(WAV)
    case _ => None
  }
  def test(fileName: String): Boolean = fileName.matches("""(?i)^.*\.(aiff|flac|mp3|mp4|m4a|m4v|aac|wav)$""")
  case object AIFF extends AudioFormat
  case object Flac extends AudioFormat
  case object MP3 extends AudioFormat
  case object MP4 extends AudioFormat
  case object WAV extends AudioFormat
}
