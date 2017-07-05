package io.github.peter32.spark
/**
  * Created by peterjmyers on 7/1/17.
  */
import org.apache.spark.{SparkConf, SparkContext}

object FirstMapReduce {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("wordCount")
    val sc = new SparkContext(conf)

    // The number 2 is the minimum number of processes running at once.
    val input = sc.textFile("/Users/peterjmyers/Documents/Projects/SparkTwitter/src/main/resources/dictionary.txt", 2)
    val words = input.flatMap(line => line.split(" ")).flatMap(line => line.split("-"))
    val result = words.map(word => (word, word.length) // Get word lengths
    ).reduceByKey { case (x, y) => (x) // Remove duplicates
    }.map { case (word, length) => (length, word) // swap key and value so length is the new key for sorting
    }.sortByKey(false, 1 // sorting descending by length
    ).map { case (length, word) => word } // remove the length part
    result.saveAsTextFile("data_output/dictionary_sorted_by_length")
    sc.stop()
  }
}