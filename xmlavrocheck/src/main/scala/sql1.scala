import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
//import com.databricks.spark.avro._
object sql1{
  
  def main(args: Array[String])
  {
    val sc = new SparkContext(new SparkConf().setAppName("sql_spark").setMaster("local[2]"))
    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    val df = sqlContext.read.format("com.databricks.spark.xml").option("rowTag", "book").load("file:///home/edureka/Desktop/books.xml")
    val sd = df.select("author", "_id").toDF
    sd.show
    println("--->converting to avro format*****")
   sd.write.format("com.databricks.spark.avro").save("file:///home/edureka/Desktop/avrofile11")
  //dataframe.write.format("com.databricks.spark.avro").save(outputPath)
    
  }  
}

