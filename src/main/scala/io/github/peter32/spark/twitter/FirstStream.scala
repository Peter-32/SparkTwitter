package io.github.peter32.spark.twitter

import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by peterjmyers on 7/3/17.
  */

object FirstStream {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("twitterStreaming")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(5))

    val tweetStream = TwitterUtils.createStream(ssc, None)

    tweetStream.print() // to console
    tweetStream.saveAsTextFiles("data_output/twitter", "txt") // to file
    // tweetStream.foreachRDD(_.saveToMongoDB())
    ssc.start()

    ssc.awaitTermination()
  }
}
