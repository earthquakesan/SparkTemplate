package example

import org.apache.spark.rdd.RDD

case class WordCount(word: String, count: Int)

object WordCount {
  def count(lines: RDD[String], stopWords: Set[String]): RDD[WordCount] = {
    val words = lines.flatMap(_.split("\\s"))
      .map(_.replaceAll("[,\\.]", "").toLowerCase)
      .filter(!stopWords.contains(_)).filter(!_.isEmpty)

    val wordCounts = words.map(word => (word, 1)).reduceByKey(_ + _).map {
      case (word: String, count: Int) => WordCount(word, count)
    }

    val sortedWordCounts = wordCounts.sortBy(_.word)

    sortedWordCounts
  }
}
