import scala.io.Source


def cleanWord(word: String): List[String] = {
  val wordFilter = word replaceAll ("[',./-:!?-]","")
  wordFilter.split(" ").toList
}

def reduceWordCout(list: List[String]): Stream[(String,Int)] = {

  val output = for {
    (k,b) <- list.groupBy(identity)
    val str = k.toString
    val n = b.length
  } yield (str,n)

  output.toStream

}

//def reduceCountWords(lista: List[String]): List[(String,Int)] =



val fileSource = Source.fromFile("C:\\Users\\samfs\\Desktop\\Scala\\Projetos\\TextAnalyserScala\\Dialog.txt")

///
val fileContents = fileSource.getLines.mkString
val ListaWord = cleanWord(fileContents)

val result = reduceWordCout(ListaWord)

result.filter(x => x._2 > 2).foreach(y => print(s"${y._1} , "))
///

fileSource.close