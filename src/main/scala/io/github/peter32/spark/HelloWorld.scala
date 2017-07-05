/**
  * Created by peterjmyers on 7/3/17.
  */
import org.apache.spark.{SparkConf, SparkContext}

object HelloWorld {
  def main(args: Array[String]) {
    val logFile = "/Users/peterjmyers/Documents/Other/No_Backup_Needed/spark-2.0.1-bin-hadoop2.7/README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Hello World: Lines with a: $numAs, Lines with b: $numBs")
    sc.stop()
  }
}