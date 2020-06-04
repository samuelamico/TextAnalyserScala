<<<<<<< HEAD
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

=======
<<<<<<< HEAD
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

=======
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

>>>>>>> f5a24eee5440226c75c743e1d8d256e42f8db854
>>>>>>> ddb9620e4fa663932a73920ca7a28aac750f2c0f
fileSource.close