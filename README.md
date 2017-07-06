
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

#### Once Created, Edit the App and Visit the Keys and Access Tokens Page.

![Twitter App page 2 part 1](src/main/resources/app_twitter_page2_part1.png)

#### Copy Your Consumer Key and Consumer Secret to a Text File.  Then Click on The "Create My Access Token" Button.

![Twitter App page 2 part 2](src/main/resources/app_twitter_page2_part2.png)

#### Copy the Access Token and Access Token Secret to a Text File.

### 2) Download Everything Needed

#### This code

- Clone or download this project and open it in an IDE like Intellij.

#### Spark

- Visit [Apache Spark](https://spark.apache.org/downloads.html) and select "Spark release": "2.0.1", "package type": "Pre-built for Apache Hadoop 2.7 and later".  Then click on "Download Spark": "spark-2.0.1-bin-hadoop2.7.tgz.
- Unzip the file and move it to your favorite software directory.

#### Jars

- The Jars needed are already included in the directory src/lib

### 3) Slight Changes Required

#### a) Add a twitter4j.properties File

Create a "twitter4j.properties" file in directory src/main/resources which should include these four lines.  Replace "yourInputHere" with your access information.

	oauth.consumerKey=yourInputHere
	oauth.consumerSecret=yourInputHere
	oauth.accessToken=yourInputHere
	oauth.accessTokenSecret=yourInputHere

#### b) Update Spark Submit Commands File

- Open the file `"SparkTwitter/spark_submit_commands.txt"`.  Replace the code `/Users/peterjmyers/Documents/Other/No_Backup_Needed/spark-2.0.1-bin-hadoop2.7/bin/spark-submit` with your absolute file path to spark-submit.  There are three commands to update.
- If you get an error later on with these commands, try again while removing the quotations around local[4].  The quotations are required for the zsh termainal.

#### Run a Command in the Terminal

Run `sbt package` in the SparkTwitter directory.

## FAQ

sbt versions?  

### What If I Want a Different Spark or Scala Version?

try installing different versions; scala version goes at end of sbt.  You need a connector to go with you rspark release for the Twitter API.

You will need to update the

### What Do the Parts of the SBT Mean?

### Why Are There Jars in src/lib Instead of Using the Sbt (Simple Build Tool)

I believe the Spark Submit needs to have them included in the command.  I put them in the src/lib folder so they are easy to reference by the command.