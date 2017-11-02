import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object WordCount {
  
  def main(args: Array[String]) {
       val sConf = new SparkConf().setAppName("File word Count App").setMaster("local")
       val sc = new SparkContext(sConf)
       val textFile = sc.textFile("file:///home/edureka/Desktop/readme")
	val counts = textFile.flatMap(l => l.split(" ")).map(word => (word,1)).reduceByKey(_ + _)	   
	counts.take(5).foreach(println) // first 5 lines - remove take(5)to get complete word count

       sc.stop()
      }
}
