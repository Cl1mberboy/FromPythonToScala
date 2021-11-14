object RedactingTextInAFile {
  import scala.io.Source
  import scala.io.BufferedSource
  import scala.io.StdIn.readLine
  import java.io.File
  import java.io.PrintWriter

  def wo(): Array[String] = {
    var words: Array[String] = Array()
    print("\n0 --> Palabras predeterminadas\n1 --> Nuevas palabras\n")
    val if_se: String = readLine()
    //val if_se: String = "0"
    if (if_se == "0") {
      words = Array("the", "music", "algorithm")
    }
    else if (if_se == "1") {
      print("\nIngresa la(s) palabra(s) a enmascarar, separar por un espacio < >\n")
      val temp = List(readLine())
      words = temp.mkString.split(" ").toArray
    }
    else {
      print("Solo 0 o 1")
      wo()
    }
    val old_file: BufferedSource = Source.fromFile("C:/Users/CONSULTOR/Documents/Becario Infomedia/Scala/FromPytonToScala/RedactingTextInAFile/src/TextFileExample.txt")
    var line: Array[String] = old_file.mkString.split("\n")
    for (i <- Range(0, line.length, 1)) {
      for (w <- words){
        line(i) = line(i).replace(w, "*" * w.length)
      }
      old_file.close()
    }
    line
    print("\n0 --> Guardar archivo\n")
    val save_file: String = readLine()
    if (save_file == "0") {
      val pw = new PrintWriter(new File("C:/Users/CONSULTOR/Documents/Becario Infomedia/Scala/FromPytonToScala/RedactingTextInAFile/src/NewFile.txt"))
      try pw.write(line.mkString) finally pw.close()}
    line
  }
}