import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Sparkapp {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("FirstSparkproject").setMaster("local[2]")
    val sc = new SparkContext(conf)
    val readfile = sc.textFile("file:///home/edureka/Desktop/all-files/datsets/airlines.dat")  // reading file from correct  path where file is saved  :  file:// mentions that it is saved as local (hdfs:// -> takes file from hdfs)
    //readfile.take(3).foreach(println)
    val conind = readfile.filter(line => line.contains("Indian"))
    conind.take(2).foreach(println)
    val indcount = conind.count()
    println(indcount) // prints no of line having word indian in the file
    //conind.saveAsTextFile("file:///home/edureka/Desktop/resultfile") // saving the processed file 
  }
}
