package Text


object Main extends App{
  val resource = TextInterface.readSource("C:\\Users\\samfs\\Desktop\\Scala\\Projetos\\TextAnalyserScala\\Dialog.txt")
  val dialogo1 =  resource match {
    case Some(i) => new TextContent(i)
    case None => None
  }
  //print(dialogo1)

  val dialogo2 = resource match {
    case Some(i) => TextInterface.cleanSimbols( new TextContent(i))
    case None => None
  }

  print(dialogo2)
}
