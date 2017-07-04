package io.github.peter32.spark.twitter
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._

/**
  * Created by peterjmyers on 7/1/17.
  */
object MapReduceExample {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("wordCount")
    val sc = new SparkContext(conf)

    //val input = sc.textFile("pride_and_prejudice.txt")
    val input = sc.textFile("/Users/peterjmyers/Documents/Projects/SparkTwitter/pride_and_prejudice.txt", 2)
    val words = input.flatMap(line => line.split(" ")).flatMap(line => line.split("-"))
    val result = words.map(word => (word, word.length) // Get word lengths
    ).reduceByKey { case (x, y) => (x) // Remove duplicates
    }.map { case (word, length) => (length, word) // swap key and value so length is the new key for sorting
    }.sortByKey(false, 1 // sorting descending by length
    ).map { case (length, word) => word } // remove the length part
    result.saveAsTextFile("pride_and_prejudice_sorted_by_length.txt")
    sc.stop()
  }
}