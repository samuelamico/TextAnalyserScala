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

      val text = encr.msg.toList

      var pos = 0
      for(char <- text){
        val subtable  = encr.maintable(key(pos % size))
        val new_char_position = encr.maintable(0).indexOf(char)
        if(new_char_position < 0) {
          text.updated(pos,char)
        }
        else{
          text.updated(pos,new_char_position)
        }
      }
      text.mkString
    }

}


