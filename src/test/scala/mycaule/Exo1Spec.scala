package mycaule

import org.scalatest._

class Exo1Spec extends FlatSpec with Matchers {
  "The Exo1 object" should "find missing values" in {
    Exo1.findMissing(Array(1, 2, 3, 4)) shouldEqual Array()

    Exo1.findMissing(Array(8, 1, 6, 3)).toSet shouldEqual Array(7, 2, 5, 4).toSet
  }
}
