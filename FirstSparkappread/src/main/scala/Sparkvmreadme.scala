import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Sparkread {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Readdoc").setMaster("local")
    val sc = new SparkContext(conf)
        println("########################")  
        println("LOading readme document--> --> -->")
        println("########################") 
        //val file = //sc.textFile("file:///home/edureka/Desktop/readme")
        //val filefil = file.filter(_.contains("spark")) // there is no line containing version -in readme document in desktop
        //filefil.foreach(println)
      }
}
