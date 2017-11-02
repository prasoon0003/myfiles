import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._

object FatalWordCount {
 def main(args: Array[String]) {
   val sparkConf = new SparkConf().setAppName("FatalWordCount").setMaster("local[2]")
   val ssc = new StreamingContext(sparkConf, Seconds(60))
   val lines = ssc.socketTextStream("localhost", 9999)
   val words = lines.flatMap(_.split(" "))
   words.print()
   val fatalWords = words.filter(line => line.contains("fatal")).count
   println("FATAL words count is :::"+fatalWords)   
   fatalWords.print()

    ssc.start()
    ssc.awaitTermination() 

  }
}
