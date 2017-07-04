package io.github.peter32.spark.twitter

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.twitter.TwitterUtils

import scala.math.Ordering

import twitter4j.auth.OAuthAuthorization
import twitter4j.conf.ConfigurationBuilder
/**
  * Created by peterjmyers on 7/3/17.
  */


// Much of this code is copied from:
// https://docs.cloud.databricks.com/docs/latest/databricks_guide/07%20Spark%20Streaming/03%20Twitter%20Hashtag%20Count%20-%20Scala.html


object SecondValueOrdering extends Ordering[(String, Int)] {
  def compare(a: (String, Int), b: (String, Int)) = {
    a._2 compare b._2
  }
}

object TwitterStream {
  val SLIDE_INTERVAL = Seconds(1);
  val WINDOW_LENGTH = Seconds(5);

  println("Initializing Streaming Spark Context...")
  val conf = new SparkConf().setAppName("wordCount")
  val sc = new SparkContext(conf)
  val ssc = new StreamingContext(sc, SLIDE_INTERVAL)


  System.setProperty("twitter4j.oauth.consumerKey", "3vv5SbXJ9vJN8EtA9R8qzrCd4")
  System.setProperty("twitter4j.oauth.consumerSecret", "xNMABv0gEOQpZXEtiGusFCvILHQ1OPR9L0CjSgklL3mrVJwpCl")
  System.setProperty("twitter4j.oauth.accessToken", "843559131088797698-lqyfsocLTDApIblQgpdk0bIfvSnBJlU")
  System.setProperty("twitter4j.oauth.accessTokenSecret", "NyzOF1DNcwpGkAviyQkYCEkUsotH0UrOnI13S2WyvUad3")

  val auth = Some(new OAuthAuthorization(new ConfigurationBuilder().build()))
  val tweetStream = TwitterUtils.createStream(ssc, auth)

  val hashTagStream = tweetStream.map(_.getText).flatMap(_.split(" ")).filter(_.startsWith("#"))

  val windowedhashTagCountStream = hashTagStream.map((_, 1)).reduceByKeyAndWindow((x: Int, y: Int) => x + y, WINDOW_LENGTH, SLIDE_INTERVAL)

  windowedhashTagCountStream.foreachRDD(hashTagCountRDD => {
    val topEndpoints = hashTagCountRDD.top(10)(SecondValueOrdering)
    dbutils.fs.put(s"${outputDirectory}/top_hashtags_${num}", topEndpoints.mkString("\n"), true)
    println(s"------ TOP HASHTAGS For window ${num}")
    println(topEndpoints.mkString("\n"))
    num = num + 1
  })

  newContextCreated = true
  ssc


/*

VISIT: https://apps.twitter.com/   to get auth tokens for data project set up




 */


    /*.createStream(ssc, Utils.getAuth)
    .map(gson.toJson(_))

  tweetStream.foreachRDD((rdd, time) => {
    val count = rdd.count()
    if (count > 0) {
      val outputRDD = rdd.repartition(partitionsEachInterval)
      outputRDD.saveAsTextFile(
        outputDirectory + "/tweets_" + time.milliseconds.toString)
      numTweetsCollected += count
      if (numTweetsCollected > numTweetsToCollect) {
        System.exit(0)
      }
    }
  })*/
}
