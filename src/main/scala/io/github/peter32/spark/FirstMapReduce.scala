package io.github.peter32.spark
/**
  * Created by peterjmyers on 7/1/17.
  */
import org.apache.spark.{SparkConf, SparkContext}
import java.io.File

object FirstMapReduce {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("wordCount")
    val sc = new SparkContext(conf)
    val f = new File("src/main/dictionary.txt")
    // The number 2 is the minimum number of processes running at once.
    val input = sc.textFile(f.getAbsolutePath, 2)
    // Split a text file by spaces and hyphens
    val words = input.flatMap(line => line.split(" ")).flatMap(line => line.split("-"))
    val result = words.map(word => (word, word.length) // Get word lengths
    ).reduceByKey { case (x, y) => (x) // Remove duplicates
    }.map { case (word, length) => (length, word) // swap key and value so length is the new key for sorting
    }.sortByKey(false, 1 // sorting descending by length
    ).map { case (length, word) => word } // remove the length part

    // END
    result.saveAsTextFile("data_output/dictionary_sorted_by_length")
    sc.stop()
  }
}