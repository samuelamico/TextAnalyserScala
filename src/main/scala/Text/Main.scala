
package Text
import org.scalameter._

object Main extends App{
  val resource = TextInterface.readSource("C:\\Users\\samfs\\Desktop\\Scala\\Projetos\\TextAnalyserScala\\Dialog.txt")
  val dialogo1 =  resource match {
    case Some(i) => new TextContent(i)
    case None => new TextContent("No file")
  }
  val Line1 = TextInterface.readLine(dialogo1,2)
  //println(Line1)

  val Lines = TextInterface.readMultipleLines(dialogo1,1,2)
  //Lines.foreach(x => println(x))

  val wc = TextInterface.LineWordCount(Line1)
  //println(wc.filter(x => x._2 > 1 ))

  val dialogo2 = resource match {
    case Some(i) => TextInterface.cleanSimbols( new TextContent(i))
    case None => None
  }

  val maintable = List("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,.;/áéíóúÁÉÍÓÚàÀãõÃÕüÜ","mübõaÚfSÀy,NtvKcJ0ouICHB nT2kzóÕD;Lw/3rlZÉRÃ4ãP6éjiÜAGÍYM8OX5àÓWsVqFUxEpÁQ7hgúá1í9.de", ".UPeZO/hIxJlzgcáCÀL5õsvE7au1fóÍ,Q8úq9DéãHGXr3jàR ;oyüdíNMÁwiTÜ24tm6nBÕSÓWKÉb0YÃFVAkpÚ", "fuNDEbmlJ2RÀãovCUGta8AÓ,áXúFYÕWQwh/ rZ1MeSTOPs3yd.IKÜ5BknÃqóíÉ7Íõc4zgÚ9üVjéxHàÁ;0L6ip", "0É;2vtóQwqaIiKzcBVyG9éãCfsHkmüPFngx/8 WÕeíÜÍDÃULu.ZoMhpbú,NAOÚJ5á7r3ÀSlÓ4T6d1RõàÁjEYX", "JhYb1OGÁáIKremü78H2Bsgã.õ69P/Qu;AlVWXàzoCf4íDSNZóÜtRkyipÍajÉ ÓqéFMdúLUEn5xTÕ3,0ÃvÚwcÀ", "ÜãÃHYaQÁi94rGm8ÀxZcàóy2kÚqvU7FouP3VzLXBlgjúÍáIJApWsKtÓCwfdSéíeM0hnbõü1OÕ,T5 ./N6D;ERÉ", "Zõsd8u1V6aGÀÓÚ/9ÁíÃ2áRH5;X4AvCãWwDüióxÉéjcgJKoyú.eIf7YzhTtUSbBO,mP3pqQÜN0ÍàEkrFlnMLÕ ", "6;áMua /.ÍcéP2Ysm,ówÁ347í9iJLnpFHK5àeARÜDõúZüÀgQoÓyqkxObÚÉvBlNrXWÕCETIhd8zV10GtSfÃUjã", "hÉÍ,P7úN;zQõÁocDUàI6rC qOB0ãítMYa8.3pÃyT/2ükdEKxf5éJZÓÜÀRuiH4sASXFó91áwjLGWvlÚngbVÕem")

  //print(dialogo2)

  /** Encryption String */
  val keys = EncryptionInterface.normalize_key("mitzuplick")
  //println(keys)

  val text = Encryption("oia chuchu","mitzuplick",maintable)

  val encryText = EncryptionInterface.encode(text)

  //println(encryText)

  /** Parallel Encryption String */



  val time = withWarmer(new Warmer.Default) measure {EncryptionInterface.encode(text)  }

  println(time)

  val e1 = task {
    EncryptionInterface.encode(text)
  }
  val v1 = e1.join()

}

