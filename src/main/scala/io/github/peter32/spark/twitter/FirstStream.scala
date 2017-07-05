package io.github.peter32.spark.twitter
/**
  * Created by peterjmyers on 7/3/17.
  */
import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

object FirstStream {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("twitterStreaming")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(5))
    val tweetStream = TwitterUtils.createStream(ssc, None)
    // These next two lines are the types of outputs that will be used.
    tweetStream.print() // output to the console
    tweetStream.saveAsTextFiles("data_output/twitter", "txt") // output to files

    ssc.start()
    ssc.awaitTermination()
  }
}
