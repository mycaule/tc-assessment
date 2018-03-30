package mycaule

object Exo1 extends Finder with App {
  // Using only Sets
  private def missingSets(s: Set[Long]): Set[Long] = {
    (s.min to s.max).toSet diff s
  }

  def findMissing(arr: Array[Long]): Array[Long] = {
    val s = missingSets(arr.toSet)
    s.toArray
    // Using only arrays
    // (arr.min to arr.max).filterNot(arr.contains).toArray
  }
}

trait Finder {
  def findMissing(arr: Array[Long]): Array[Long]
}
