name := "SparkTwitter"

version := "0.0.1"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-streaming" % "2.0.1",
  "org.apache.bahir" %% "spark-streaming-twitter" % "2.0.1"
)