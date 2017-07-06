package io.github.peter32.spark.twitter
/**
  * Created by peterjmyers on 7/3/17.
  */
import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * This sets up a twitter spark streaming instance.
  * It shows tweets from Twitter in real time and saves them to a file.
  */
object FirstStream {
  def main(args: Array[String]) {
    // You get a conf and sc variable when starting a Spark application.
    // Getting a SparkConf and calling it conf.  Set the app name.
    val conf = new SparkConf().setAppName("twitterStreaming")
    // Getting a SparkContext and calling it sc.
    val sc = new SparkContext(conf)
    // Getting a StreamingContext and calling it ssc (Spark StreamingContext).
    val ssc = new StreamingContext(sc, Seconds(5))
    // Getting a Twitter Stream and calling it tweetStream.
    // None is passed in as the authentication.
    // The authentication information is passed in using the src/main/resources/twitter4j.properties file.
    // You need to add this file yourself, see the README.md for details.
    val tweetStream = TwitterUtils.createStream(ssc, None)
    // These next two lines are the types of outputs that will be used in the StreamingContext.
      // output to the console.
    tweetStream.print()
      // output to files.
    tweetStream.saveAsTextFiles("data_output/twitter", "txt")

    // Start the StreamingContext.
    ssc.start()
    // Wait for the StreamingContext to end.
    ssc.awaitTermination()
  }
}
