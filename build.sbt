name := "SparkTwitter"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.1"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming-twitter_2.11
libraryDependencies += "org.apache.spark" % "spark-streaming-twitter_2.11" % "1.5.1" % "provided"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming_2.11
libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "1.5.1" % "provided"

