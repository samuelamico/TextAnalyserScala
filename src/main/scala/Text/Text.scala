
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

  def readMultipleLines(texto: TextContent,n: Int,m: Int): List[Line] = (n,m) match {
    case (x,y) if (x > y) => Nil
    case (x,y) => readLine(texto,x) :: readMultipleLines(texto,x+1,y)
  }

  def capitalizeLine(line: Line): Line = {
    new Line (line.content.toUpperCase)
  }

  def textWordCount(text: TextContent): Stream[(String,Int)] = {
    val words = text.content.split(" ")

    val output = for {
      (k,b) <- words.groupBy(identity)
      val str = k.toString
      val n = b.length
    } yield (str,n)

    output.toStream
  }

  def LineWordCount(line: Line): List[(String,Int)] = {
    val words = line.content.split(" ")

    val output = for {
      (k,b) <- words.groupBy(identity)
      val str = k.toString
      val n = b.length
    } yield (str,n)

    output.toList
  }


}


