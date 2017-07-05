# SparkTwitter

## Summary
This project shows you how to get started with Spark.  It starts with a "Hello World" application, then a simple MapReduce application, and lastly a Spark streaming application using the Twitter API.

## Example

![Twitter Stream](src/main/resources/spark_streaming_twitter.png)

## Features 

1. **HelloWorld Application**: This can be used to confirm that Spark is working.
  The code is from the official Spark site's [quick start tutorial](https://spark.apache.org/docs/latest/quick-start.html).
2. **FirstMapReduce Application**: This gets one familiar with the MapReduce functionality available when using Spark Scala.  It takes in a dictionary of words and outputs a file sorting the words by length.
3. **FirstStream Application**: This sets up a twitter spark streaming instance.  It collects tweets from Twitter in real time and outputs them to the console and files.

## Installation

### HelloWorld


### FirstMapReduce


### Spark Streaming Twitter API

#### First
Create a "twitter4j.properties" file at directory src/main/resources which should include these four lines:

	oauth.consumerKey=3vv5SbXJ9vJN8EtA9R8qzrCd4
	oauth.consumerSecret=xNMABv0gEOQpZXEtiGusFCvILHQ1OPR9L0CjSgklL3mrVJwpCl
	oauth.accessToken=843559131088797698-lqyfsocLTDApIblQgpdk0bIfvSnBJlU
	oauth.accessTokenSecret=NyzOF1DNcwpGkAviyQkYCEkUsotH0UrOnI13S2WyvUad3

## FAQ

