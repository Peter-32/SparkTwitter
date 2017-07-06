package io.github.peter32.spark
/**
  * Created by peterjmyers on 7/3/17.
  */
import org.apache.spark.{SparkConf, SparkContext}
import java.io.File

object HelloWorld {
  def main(args: Array[String]) {
    // The input file is the README.md to this project.
    // Get the absolute path to this input file.
    val inputFile = (new File("README.md")).getAbsolutePath
    // You get a conf and sc variable when starting a Spark application.
    // Getting a SparkConf and calling it conf.  Set the app name.
    val conf = new SparkConf().setAppName("Simple Application")
    // Getting a SparkContext and calling it sc.
    val sc = new SparkContext(conf)
    // Pass in the input file.  The 2 is the minimum number of parallel processes to use.
    // Cache is explained here.  https://spark.apache.org/docs/latest/quick-start.html
    val logData = sc.textFile(inputFile, 2).cache()
    // Filter for only the rows that contain a, then store the count to a variable
    val numAs = logData.filter(line => line.contains("a")).count()
    // Filter for only the rows that contain b, then store the count to a variable
    val numBs = logData.filter(line => line.contains("b")).count()
    // Print the results to the console.
    println(s"Hello World: Lines with a: $numAs, Lines with b: $numBs")
    // Tell the spark context to stop.
    sc.stop()
  }
}