package example

import org.apache.spark.{SparkContext, SparkConf}

object WordCountMain extends App {
  val sparkMaster = scala.util.Properties.envOrElse("SPARK_MASTER", "local[4]")
  val hdfsUri = scala.util.Properties.envOrElse("HDFS_URI", "hdfs://localhost:8020")

  if (args.length == 0) {
    println("Usage: /input_path")
  }

  val inputPath = args(0)

  val config = new SparkConf().setMaster(sparkMaster).setAppName("Word Count")
  val sc = new SparkContext(config)

  val stopWords = Set("the")
  val wordCounts = WordCount.count(sc.textFile(hdfsUri + inputPath), stopWords).collect()
  wordCounts.foreach(println)
}
