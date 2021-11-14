//Scala
def quarter(d: Int, c:Int):Unit = {
  var dollar: Int = d
  var coin: Int = c
  if (dollar - 25 > 0 && coin - 1 > 0) {
    dollar -= 25
    coin -= 1
    quarter(dollar, coin)
  } else if (dollar - 25 == 0 && coin - 1 == 0) {
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
    dollar -= 10
    coin -= 1
    dime(dollar, coin)
  } else if (dollar - 10 == 0 && coin - 1 == 0) {
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
    dollar -= 5
    coin -= 1
    nickels(dollar, coin)
  } else if (dollar - 5 == 0 && coin - 1 == 0) {
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
    dollar -= 1
    coin -= 1
    pennies(dollar, coin)
  } else if (dollar - 1 == 0 && coin - 1 == 0) {
    dollar -= 1
    coin -= 1
  } else{
    print("No se pudo")
  }
}