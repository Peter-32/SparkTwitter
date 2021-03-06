
# SparkTwitter

## Summary
This project shows you how to get started with Spark Scala projects in an IDE.  It starts with a "Hello World!" application, then a simple MapReduce application, and lastly a Spark streaming application using the Twitter API.

## Example

<center><img src="src/main/resources/spark_streaming_twitter.png"></center>

## Features 

1. **HelloWorld Application**: This can be used to confirm that Spark is working.
  The code is from the official Spark site's [quick start tutorial](https://spark.apache.org/docs/latest/quick-start.html).
2. **FirstMapReduce Application**: This gets one familiar with the MapReduce functionality available when using Spark Scala.  It takes in a dictionary of words and outputs a file of words sorted by length.
3. **FirstStream Application**: This sets up a twitter spark streaming instance.  It shows tweets from Twitter in real time and saves them to a file.

## Installation

1. Create a Twitter App (Easy)
2. Download Everything Needed
3. Adding Your Personal Configurations
4. Run a Console Command to Build
5. Run the Programs with `spark-submit`

### 1) Create a Twitter App (Easy)

First create a [Twitter app](https://apps.twitter.com/) here.  The application is created after you fill out a form.  You can put any placeholder when they ask for your website.

<center><img src="src/main/resources/app_twitter_page1.png"></center>

#### Once Created, Edit the App and Visit the Keys and Access Tokens Page.

<center><img src="src/main/resources/app_twitter_page2_part1.png"></center>

#### Copy Your Consumer Key and Consumer Secret to a Text File.  Then Click on The "Create My Access Token" Button.

<center><img src="src/main/resources/app_twitter_page2_part2.png"></center>

#### Copy the Access Token and Access Token Secret to a Text File.

That's it!!  You're done creating the Twitter App!

### 2) Download Everything Needed

#### Get This Project

- Clone or download this project and open it in an IDE like Intellij.

#### Spark

- Visit [Apache Spark](https://spark.apache.org/downloads.html) and select "Spark release": "2.0.1", "package type": "Pre-built for Apache Hadoop 2.7 and later".  Then click on "Download Spark": "spark-2.0.1-bin-hadoop2.7.tgz".
- Unzip the file and move it to your favorite software directory.

#### Jars

- The Jars needed are already included in the directory src/lib

#### Scala Plugin

- Make sure your IDE has the Scala plugin.  You will know you have the plugin when you can create Scala classes in the `src/main/scala` directory.  If you're unsure, try searching online how to add the plugin for your IDE.

### 3) Adding Your Personal Configurations

#### a) Add a twitter4j.properties File

Create a "twitter4j.properties" file in directory src/main/resources which should include these four lines.  Replace "yourInputHere" with the information you copied from your Twitter App.

	oauth.consumerKey=yourInputHere
	oauth.consumerSecret=yourInputHere
	oauth.accessToken=yourInputHere
	oauth.accessTokenSecret=yourInputHere

#### b) Update `spark-submit` Commands File

- Open the file `"SparkTwitter/spark_submit_commands.txt"`.  Replace the code `/Users/peterjmyers/Documents/Other/No_Backup_Needed/spark-2.0.1-bin-hadoop2.7/bin/spark-submit` with your absolute file path to `spark-submit`.  All three commands need to be updated with this change.
- If you get an error later on with these commands, try again while removing the quotations around local[4].  The quotations are required if you use a zsh terminal.  I do not know if the quotations can cause an error.

#### 4) Run a Console Command to Build

Go to the SparkTwitter directory in your terminal and run `sbt package`.

In the future, if you make a change to a Spark Scala project and you want to run `spark-submit`, you must first run the command `sbt package`.

#### 5) Run the Programs with `spark-submit`

All commands are found in the `SparkTwitter/spark-submit_commands.txt` file.  Each command runs one of the three applications.

## FAQ

### Can I Use a Different Version of Spark or Scala?

_This project uses Spark 2.0.1 and Scala 2.11_

Sure!  Here are some things to keep in mind if you decide to use a different version of Spark or Scala.  

1. The Scala and Spark versions need to be compatible with each other.
2. The Scala or Spark versions need to be compatible with the two jars `src/lib/twitter4j-core` and `src/lib/twitter4j-stream`.  This project uses version 4.0.4 of these jars, and they appear to work with Spark 2.0.1 and Scala 2.11.
3. Download a new `spark-streaming-twitter` jar.  The one included is `src/lib/spark-streaming-twitter_2.11-2.0.1.jar`.  The 2.11 stands for the Scala version and 2.0.1 is the Spark version.
4. After changing out any jars from point 2 or 3 above, you need to update the  `spark_submit_commands.txt` file.  You will need to update the jars for the spark streaming command.  If you change the Scala version, be sure to also update the 2.11 Scala version number found in all commands.
5. Update the `SparkTwitter/build` file with the Scala version.  Change the 2.0.1 numbers to the Spark version you are using.  The library dependency code can be found by searching the internet for the package (ie. "maven org.apache.spark").  When you find the maven command on the maven repository, look for an SBT tab to get the SBT code.  Once you're done with changes to the `SparkTwitter/build` file, click the prompt to rebuild the project with these configurations.

<center><img src="src/main/resources/sbt_code.png"></center>


### What Is Going on in the `SparkTwitter/build` File?

* **version:** The version is your build version.  If this changes from 0.0.1 you need to update the `spark-streaming-twitter.txt` file to reference the new version instead of 0.0.1.
* **scalaVersion:** The version of Scala.  This project uses Scala version 2.11.
* **2.0.1:** This number shows up in the library dependencies section of this file.  The number corresponds with the Spark version used.  This project uses Spark 2.0.1.

### Why Are There Jars in src/lib Instead of Using the SBT (Simple Build Tool)?

I believe the `spark-submit` command has to reference the jars.  I put them in the src/lib folder so they are easy to reference when running `spark-submit`.

### What Is the Expected Output of Each Application?

1. The HelloWorld application finds the number of a's and b's in a file and prints the results to the console on one line.  Spark's output to the console is verbose, so you have to look over multiple lines before you find this line of output.
2. The MapReduceExample application outputs a file to the `SparkTwitter/data_output` directory.  The result is a list of words sorted by length.  Other text files can be used instead of the `dictionary.txt` file.
3. The FirstStream application outputs text to the console and tweets to the `SparkTwitter/data_output` directory.

### How Do I Turn Off The StreamingContext?

The hotkey should be the same for Windows, Mac, and Linux.

- First you can try `Ctrl + c`.
- If that doesn't work, try `Ctrl + z`.
- Otherwise, close the terminal.