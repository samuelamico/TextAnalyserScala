package Text

trait TextRef {
  def readSource(file: String): Option[String]
  def cleanSimbols(texto: TextContent): TextContent
  def readLine(texto: TextContent,n: Int): Line
  def readMultipleLines(texto: TextContent,n: Int,m: Int): List[Line]
}
