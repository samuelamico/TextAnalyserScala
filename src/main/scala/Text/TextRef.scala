package Text

trait TextRef {
  def readSource(file: String): Option[String]
  def cleanSimbols(texto: TextContent): TextContent
}
