
package Text

import scala.io.Source


case class TextContent(content: String) {
  override def toString: String =
      "Text: " + " [" + content + "]"
}

case class Line(content: String) {
  override def toString: String =
    "[" + content + "]"
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
 // ???
  def readLine(texto: TextContent,n: Int): Line = {
    val linesContent = texto.content.split("\\\\n")
    if(n > linesContent.length) new Line("")
    else {
      new Line(linesContent(n))
    }
  }

  def readMultipleLines(texto: TextContent,n: Int,m: Int): List[Line] = {

  }


}


