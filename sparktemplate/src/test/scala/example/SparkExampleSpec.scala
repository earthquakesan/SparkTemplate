package example

import org.scalatest._
import org.apache.spark.{SparkContext, SparkConf}

class SparkExampleSpec extends FlatSpec with BeforeAndAfter {
  private val master = "local[2]"
  private val appName = "example-spark"

  private var sc: SparkContext = _

  before {
    val conf = new SparkConf()
      .setMaster(master)
      .setAppName(appName)

    sc = new SparkContext(conf)
  }

  after {
    if (sc != null) {
      sc.stop()
    }
  }

  "First element of the set" should "have value of 1" in {
    val xs = (1 to 10000).toList
    val rdd = sc.parallelize(xs)
    val one = rdd.take(1)
    assert(one.deep == Array(1).deep)
  }
}
