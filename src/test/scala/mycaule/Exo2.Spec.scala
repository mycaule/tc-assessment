package mycaule

import org.scalatest._

class Exo2Spec extends FlatSpec with Matchers {
  "The Exo2 object" should "find missing values" in {
    Exo2.countDistinct(Array(1, 2, 3, 4)) shouldEqual 4

    Exo2.countDistinct(Array(8, 1, 6, 3)) shouldEqual 4


    Exo2Spark.countDistinct(Array(8, 1, 6, 3)) shouldEqual 4
  }
}
