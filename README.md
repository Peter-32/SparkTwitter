
# SparkTwitter

## Summary
This project shows you how to get started with Spark Scala projects in an IDE.  It starts with a "Hello World" application, then a simple MapReduce application, and lastly a Spark streaming application using the Twitter API.

## Example

![Twitter Stream](src/main/resources/spark_streaming_twitter.png)

## Features 

1. **HelloWorld Application**: This can be used to confirm that Spark is working.
  The code is from the official Spark site's [quick start tutorial](https://spark.apache.org/docs/latest/quick-start.html).
2. **FirstMapReduce Application**: This gets one familiar with the MapReduce functionality available when using Spark Scala.  It takes in a dictionary of words and outputs a file sorting the words by length.
3. **FirstStream Application**: This sets up a twitter spark streaming instance.  It collects tweets from Twitter in real time and outputs them to the console and files.

## Installation

### 1) Create a Twitter App (Easy)

First, to get it out of the way, create a [Twitter app](https://apps.twitter.com/) here.  The application is created after you fill out a form.  You can put any placeholder when they ask for your website.

![Twitter App page 1](src/main/resources/app_twitter_page1.png)

#### Once created, edit the app and visit the keys and access tokens page.

![Twitter App page 2 part 1](src/main/resources/app_twitter_page2_part1.png)

#### Copy your Consumer Key and Consumer Secret to a text file.  Then click on the "create my access token" button.

![Twitter App page 2 part 2](src/main/resources/app_twitter_page2_part2.png)

#### Copy the access token and access token secret to a text file.

### 2) Download everything needed

#### This code

- Clone or download this project and open it in an IDE like Intellij.

#### Spark

- Visit [Apache Spark](https://spark.apache.org/downloads.html) and select "Spark release": "2.0.1", "package type": "Pre-built for Apache Hadoop 2.7 and later".  Then click on "Download Spark": "spark-2.0.1-bin-hadoop2.7.tgz.
- Unzip the file and move it to your favorite software directory.

#### Jars

### 3) Slight Changes Required

#### 1) Add a twitter4j.properties file

Create a "twitter4j.properties" file in directory src/main/resources which should include these four lines.  Replace "yourInputHere" with your access information.

	oauth.consumerKey=yourInputHere
	oauth.consumerSecret=yourInputHere
	oauth.accessToken=yourInputHere
	oauth.accessTokenSecret=yourInputHere

## FAQ

sbt versions?  

### What if I want a different Spark or Scala version?

try installing different versions; scala version goes at end of sbt.  You need a connector to go with you rspark release for the Twitter API.

### What do the parts of the sbt mean?
