
  import scala.io.Source
  def com(palabra:String,lista: Array[String]):Int={
    var count: Int = 0
    for (i <- lista if i == palabra)
      count += 1
    count
  }

  val file = Source.fromFile("C:/Users/CONSULTOR/Documents/Becario Infomedia/Scala/FromPytonToScala/WordsThatOccurMost/TextFileExample.txt")
  val directorio = file.mkString("\n").toLowerCase.replace(".","").replace(",","").replace("!","").replace("’","").replace("?","").replace(":","").split(" ")
  val histo = scala.collection.mutable.Map("AYEV" -> 0)
  for (p <- directorio){
    if(!histo.contains(p)){
      histo += (p -> com(p,directorio))
    }
  }
  file.close()
  val lista = histo.toSeq.sortBy(_._2).reverse
