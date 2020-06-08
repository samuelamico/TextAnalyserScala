package Text

case class Encryption(msg: String, chave: String, maintable: List[String])



object EncryptionInterface extends EncryptionRef {

    def normalize_key(key: String): (Int,List[Int]) = {
      val listChar = key.toList
      val result = listChar.map(x => x.toInt % 10)
      (result.length,result)
    }

    def encode(encr: Encryption): String = {
      val (size, key) = normalize_key(encr.chave)

      val text = encr.msg.toArray

      var pos = 0
      for(char <- text){
        val subtable  = encr.maintable(key(pos % size))
        val new_char_position = encr.maintable(0).indexOf(char)
        //println(s"char_position = $new_char_position")
        if(new_char_position < 0) {
          val new_char = char
          //println(s"char = $new_char")
          text(pos) = new_char
        }
        else{
          val new_char = subtable(new_char_position)
          //println(s"char = $new_char")
          text(pos) = new_char
        }
        pos = pos + 1
      }
      text.mkString
    }

    def encodeList(lista: List[Line],maintable: List[String],chave: String): Unit ={
        val result = for{
          item <- lista
          val encr = new Encryption(item.content,chave,maintable)
        }yield(println(encode(encr)))

    }

    def splitListTask(lines: Int, task: Int): IndexedSeq[(Int,Int)]= {
        val maxTask = Math.min(lines,task)
        val l = if( (lines % task) == 0){
            0 to lines-1 by lines/task
        }else{
          (0 to lines-(lines % task) by (lines-(lines % task))/(maxTask-1)) ++ List(lines)
        }
        l zip l.tail
    }

    def parallelEnc(texto: TextContent,numTask: Int,maintable: List[String],chave: String): Unit = {
      val strip = splitListTask(texto.content.split("\\\\n").length, numTask)

      val tasks = strip.map(x => task {encodeList(TextInterface.readMultipleLines(texto,x._1,x._2),maintable,chave) })

      tasks map (_.join())
    }

}


