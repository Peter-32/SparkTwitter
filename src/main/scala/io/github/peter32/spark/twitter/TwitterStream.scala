package io.github.peter32.spark.twitter

import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}
import twitter4j.Status

/*
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.twitter.TwitterUtils

import scala.math.Ordering

import twitter4j.auth.OAuthAuthorization
import twitter4j.conf.ConfigurationBuilder

*/
/**
  * Created by peterjmyers on 7/3/17.
  */


// Much of this code is copied from:
// https://docs.cloud.databricks.com/docs/latest/databricks_guide/07%20Spark%20Streaming/03%20Twitter%20Hashtag%20Count%20-%20Scala.html

object TwitterStream {
  def main(args: Array[String]) {
    //val SLIDE_INTERVAL = Seconds(1);
    //val WINDOW_LENGTH = Seconds(5);
    //val OUTPUT_DIRECTORY = "spark_streaming_results.txt"

    //  println("Initializing Streaming Spark Context...")
    val conf = new SparkConf().setAppName("twitterStreaming")
    val sc = new SparkContext(conf)
    val ssc = new StreamingContext(sc, Seconds(5))

    val tweetStream = TwitterUtils.createStream(ssc, None)

    // Output
    tweetStream.print() // to console
    tweetStream.saveAsTextFiles("twitter_output", "txt") // to file
    ssc.start()

    ssc.awaitTermination()

    //val hashTagStream = tweetStream.map(_.getText)


    /*
  .flatMap(_.split(" ")).filter(_.startsWith("#"))

  val windowedhashTagCountStream = hashTagStream.map((_, 1)).reduceByKeyAndWindow((x: Int, y: Int) => x + y, WINDOW_LENGTH, SLIDE_INTERVAL)

  windowedhashTagCountStream.foreachRDD(hashTagCountRDD => {
    hashTagCountRDD.saveAsTextFile("pride_and_prejudice_sorted_by_length.txt")
  })
   */

    /*
    System.setProperty("twitter4j.oauth.consumerKey", "3vv5SbXJ9vJN8EtA9R8qzrCd4")
    System.setProperty("twitter4j.oauth.consumerSecret", "xNMABv0gEOQpZXEtiGusFCvILHQ1OPR9L0CjSgklL3mrVJwpCl")
    System.setProperty("twitter4j.oauth.accessToken", "843559131088797698-lqyfsocLTDApIblQgpdk0bIfvSnBJlU")
    System.setProperty("twitter4j.oauth.accessTokenSecret", "NyzOF1DNcwpGkAviyQkYCEkUsotH0UrOnI13S2WyvUad3")

    val auth = Some(new OAuthAuthorization(new ConfigurationBuilder().build()))
    val tweetStream = TwitterUtils.createStream(ssc, auth)



print()
foreachRDD(func)
saveAsObjectFiles(prefix, [suffix])

saveAsHadoopFiles(prefix, [suffix])


    */

  }
}
