import org.apache.spark.SparkConf
import org.apache.spark.streaming._

object wordcnt {

def main(args: Array[String]): Unit = {

val sparkconf = new SparkConf().setAppName("strwordcnt").setMaster("local[2]")

val ssc = new StreamingContext(sparkconf, Seconds(30))

val lines = ssc.socketTextStream("localhost", 9696)
ssc.checkpoint("file:///home/edureka/Desktop/chkpt")

val words = lines.flatMap(_.split(" "))

val wordscount = words.map(x => (x,1)).reduceByKeyAndWindow(((a: Int, b: Int) => a + b), Seconds (120), Seconds(60))

wordscount.print()
//val ssc = StreamingContext.getOrCreate("file:///home/edureka/chkpt", wordcnt _)

ssc.start()

ssc.awaitTermination()

}

}

