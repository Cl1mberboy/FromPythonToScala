import scala.io.Source
val word_file = Source.fromFile("C:/Users/CONSULTOR/Documents/Becario Infomedia/Scala/FromPytonToScala/TwoWordRandomPassword/src/wolds-db.txt")
val words:List[String] = word_file.getLines().toList
var wless7more3 = Array("Angel")
for (w <- words) {
  if(w.length > 3 && w.length<= 7) {
    wless7more3 :+=  w
  }
}
word_file.close()
val first = wless7more3(scala.util.Random.nextInt(wless7more3.length))
var password = first
while(password.length < 8 || password.length > 10) {
  val second = wless7more3(scala.util.Random.nextInt(wless7more3.length))
  password = first + second
}
s"Tu nueva contraseña es: $password"