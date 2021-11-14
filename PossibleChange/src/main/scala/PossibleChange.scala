//Scala
import scala.collection.mutable
import scala.io.StdIn.readLine
object PossibleChange {
  object conteo{
    var c: mutable.Map[String, Int] = scala.collection.mutable.Map("quarters"->0,"dimes"->0,"nickels"->0,"pennies"->0,"coins"->0,"l"->0)
    def sum_c:Int = c("quarters") + c("dimes")+ c("nickels") + c("pennies")
  }
  def quarters(d: Int, c:Int):Unit = {
    var dollar: Int = d
    var coin: Int = c
    if (dollar - 25 > 0 && coin - 1 > 0) {
      conteo.c("quarters") += 1
      dollar -= 25
      coin -= 1
      quarters(dollar, coin)
    } else if (dollar - 25 == 0 && coin - 1 == 0) {
      conteo.c("quarters") += 1
      dollar -= 25
      coin -= 1
    } else{
      dime(dollar, coin)//dimes
    }
  }
  def dime(d: Int, c:Int):Unit = {
    var dollar: Int = d
    var coin: Int = c
    if (dollar - 10 > 0 && coin - 1 > 0) {
      conteo.c("dimes") += 1
      dollar -= 10
      coin -= 1
      dime(dollar, coin)
    } else if (dollar - 10 == 0 && coin - 1 == 0) {
      conteo.c("dimes") += 1
      dollar -= 10
      coin -= 1
    } else{
      nickels(dollar, coin)//nickels
    }
  }
  def nickels(d: Int, c:Int):Unit = {
    var dollar: Int = d
    var coin: Int = c
    if (dollar - 5 > 0 && coin - 1 > 0) {
      conteo.c("nickels") += 1
      dollar -= 5
      coin -= 1
      nickels(dollar, coin)
    } else if (dollar - 5 == 0 && coin - 1 == 0) {
      conteo.c("nickels") += 1
      dollar -= 5
      coin -= 1
    } else{
      pennies(dollar, coin)//pennies
    }
  }
  def pennies(d: Int, c:Int):Unit = {
    var dollar: Int = d
    var coin: Int = c
    if (dollar - 1 > 0 && coin - 1 > 0) {
      conteo.c("pennies") += 1
      dollar -= 1
      coin -= 1
      pennies(dollar, coin)
    } else if (dollar - 1 == 0 && coin - 1 == 0) {
      conteo.c("pennies") += 1
      dollar -= 1
      coin -= 1
    } else if (conteo.sum_c < conteo.c("coins") || dollar >= 0){
      print("No se pudo")
      conteo.c("l") = 1
    }
  }
  def main(): Unit ={
    conteo.c.foreach{case(k,v) => conteo.c(k) = 0}
    val dollars = (readLine("Ingresa la cantidad de dolares:\n").toFloat * 100).toInt
    val coins = readLine("Ingresa la cantidad de monedas:\n").toInt
    conteo.c("coins") = coins
    if(dollars.toFloat / 10 == coins) {dime(dollars, coins)}
    else if (dollars.toFloat / 5 == coins) {nickels(dollars, coins)}
    else if (dollars.toFloat / 1 == coins) {pennies(dollars, coins)}
    else {quarters(dollars, coins)}
    if (conteo.c("l") == 0){
      conteo.c -= ("coins")
      conteo.c -= ("l")
      print("\nEl cambio es:")
      conteo.c.foreach{case(k,v) => if(v > 0){print(s"\n$k: $v")}}
    }
  }
}