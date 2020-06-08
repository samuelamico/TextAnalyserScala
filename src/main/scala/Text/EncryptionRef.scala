package Text

trait EncryptionRef {
  def normalize_key(key: String): (Int,List[Int])
  def encode(encr: Encryption): String
  def parallelEnc(texto: TextContent,numTask: Int,maintable: List[String],chave: String): Unit
  def encodeList(lista: List[Line],maintable: List[String],chave: String): Unit
  def splitListTask(lines: Int, task: Int): IndexedSeq[(Int,Int)]

}
