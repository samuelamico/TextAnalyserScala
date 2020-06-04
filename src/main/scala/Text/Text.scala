package Text

import scala.io.Source


case class TextContent(content: String) {
  override def toString: String =
      "Text: " + " [" + content + "]"
}

object TextInterface extends TextRef{

  def readSource(file: String): Option[String] = {
    def tryOrBlock(file: String): Option[String] = {
      try {
        val fileSource = Source.fromFile(file)
        Some(fileSource.getLines.mkString)
      } catch {
        case e: Exception => None
      }
    }
    tryOrBlock(file)
  }

  def cleanSimbols(texto: TextContent): TextContent = {
    val cleanText = texto.content replaceAll ("[',./-:!?-]","")
    new TextContent(cleanText)
  }


}

