package mycaule

import org.scalatest._

class Exo2Spec extends FlatSpec with Matchers {
  "The Exo2 object" should "count distinct values" in {
    Exo2.countDistinct(Array(1, 1, 3, 4)) shouldEqual 3

    Exo2.countDistinct(Array(8, 1, 6, 3)) shouldEqual 4
  }
}

class Exo2SparkSpec extends FlatSpec with Matchers with BeforeAndAfter {
  import org.apache.spark.{SparkContext, SparkConf}
  import org.apache.spark.SparkContext._

  private var sc: SparkContext = _

  before {
    val conf = new SparkConf().setMaster("local").setAppName("assessment")
    sc = new SparkContext(conf)
  }

  after {
    if (sc != null) {
      sc.stop()
    }
  }

  "The Exo2Spark object" should "count distinct values using RDDs" in {
    Exo2Spark.sc = sc
    Exo2Spark.countDistinct(Array(1, 1, 3, 4)) shouldEqual 3
    Exo2Spark.countDistinct(Array(8, 1, 6, 3)) shouldEqual 4
  }
}
