package Text

trait EncryptionRef {
  def normalize_key(key: String): (Int,List[Int])
  def encode(encr: Encryption): String
}
