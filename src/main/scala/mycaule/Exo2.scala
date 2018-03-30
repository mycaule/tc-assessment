package mycaule

object Exo2 extends Counter {
  def countDistinct(arr: Array[Long]): Long = {
    arr.distinct.size
    // See imperative implementation at https://github.com/scala/scala/blob/2.13.x/src/library/scala/collection/SeqLike.scala#L503-L517

    // Or similarly,
    // arr.toSet.size
  }
}

object Exo2Spark extends Counter {
  import org.apache.spark.{SparkContext, SparkConf}

  var sc: SparkContext = _

  def countDistinct(arr: Array[Long]): Long = {
    val rdd = sc.parallelize(arr)
    rdd.countApproxDistinct()

    // See actual implementation at https://github.com/apache/spark/blob/master/core/src/main/scala/org/apache/spark/rdd/RDD.scala#L1252-L1266
  }
}

trait Counter {
  def countDistinct(arr: Array[Long]): Long
}
