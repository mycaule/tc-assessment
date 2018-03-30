package mycaule

object Exo1 extends Finder with App {
  // Using only Sets
  private def missingSets(s: Set[Long]): Set[Long] = {
    (s.min to s.max).toSet diff s
    // See imperative implementation at https://github.com/scala/scala/blob/2.13.x/src/library/scala/collection/SeqLike.scala#L448-L457
  }

  def findMissing(arr: Array[Long]): Array[Long] = {
    val s = missingSets(arr.toSet)
    // See imperative implementation at https://github.com/scala/scala/blob/2.13.x/src/library/scala/collection/immutable/Set.scala#L46-L51
    s.toArray
    // Using only arrays
    // (arr.min to arr.max).filterNot(arr.contains).toArray
  }
}

trait Finder {
  def findMissing(arr: Array[Long]): Array[Long]
}
