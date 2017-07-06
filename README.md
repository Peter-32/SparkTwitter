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

Easily create a [Twitter app](https://apps.twitter.com/) here.  The application is created easily after you fill out a form.  You can put a placeholder when they ask for your website.  Once the application is created

![Twitter App page 1](src/main/resources/app_twitter_page1.png)

Once created, edit the app and visit the keys and access tokens page.

![Twitter App page 2 part 1](src/main/resources/app_twitter_page2_part1.png)

![Twitter App page 2 part 2](src/main/resources/app_twitter_page2_part2.png)

#### Next

Create a "twitter4j.properties" file at directory src/main/resources which should include these four lines.  Replace "yourInputHere" with your access information.

	oauth.consumerKey=yourInputHere
	oauth.consumerSecret=yourInputHere
	oauth.accessToken=yourInputHere
	oauth.accessTokenSecret=yourInputHere

## FAQ

