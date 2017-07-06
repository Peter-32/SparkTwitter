package io.github.peter32.spark
/**
  * Created by peterjmyers on 7/1/17.
  */
import org.apache.spark.{SparkConf, SparkContext}
import java.io.File
import scala.reflect.io.Path
import scala.util.Try

/**
  * This gets one familiar with the MapReduce functionality available when using Spark Scala.
  * It takes in a dictionary of words and outputs a file of words sorted by length.
  */
object FirstMapReduce {
  def main(args: Array[String]) {
    // The input file is the README.md to this project.
    // Get the absolute path to this input file.
    val inputFile = (new File("src/main/resources/dictionary.txt")).getAbsolutePath
    // Delete the output directory if it exists.  Doesn't stop the program even if the files doesn't exist.
    val path: Path = Path ("data_output/dictionary_sorted_by_length")
    Try(path.deleteRecursively())
    // You get a conf and sc variable when starting a Spark application.
    // Getting a SparkConf and calling it conf.  Set the app name.
    val conf = new SparkConf().setAppName("wordCount")
    // Getting a SparkContext and calling it sc.
    val sc = new SparkContext(conf)
    // Pass in the input file.  The 2 is the minimum number of parallel processes to use.
    val input = sc.textFile(inputFile, 2)
    // Chain the RDD operations together.
    // Variable "result" defines lazy transformations, no data is computed on yet.
      // Split a text file into words by spaces.
    val result = input.flatMap(line => line.split(" ")
      // Get word lengths.  The RDD is now a key-value pair RDD.
    ).map(word => (word, word.length)
      // Remove duplicate keys.
    ).reduceByKey { case (x, y) => (x)
      // Swap key and value so length is the new key.
      // Length is the key so we can sort on it.
    }.map { case (word, length) => (length, word)
      // Sorting by length.
      // Passing in false means sort descending.
    }.sortByKey(false, 1
      // Turn the key-value pair RDD into an RDD.
      // Keep the word and drop the length.
    ).map { case (length, word) => word }
    // Function saveAsTextFile executes the transformation and saves the RDD to a file.
    result.saveAsTextFile("data_output/dictionary_sorted_by_length")
    // Tell the spark context to stop.
    sc.stop()
  }
}