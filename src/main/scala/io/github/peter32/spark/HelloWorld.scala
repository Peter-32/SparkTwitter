package io.github.peter32.spark
/**
  * Created by peterjmyers on 7/3/17.
  */
import org.apache.spark.{SparkConf, SparkContext}
import java.io.File

object HelloWorld {
  def main(args: Array[String]) {
    val f = new File("README.md")
    val logFile = f.getAbsolutePath // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Hello World: Lines with a: $numAs, Lines with b: $numBs")
    sc.stop()
  }
}