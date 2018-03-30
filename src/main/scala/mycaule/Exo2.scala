package mycaule

object Exo2 extends Counter {
  def countDistinct(arr: Array[Long]): Long = {
    arr.distinct.size
    // Or similarly,
    // arr.toSet.size
  }
}

object Exo2Spark extends Counter {
  import org.apache.spark.{SparkContext, SparkConf}

  var sc: SparkContext = _

  def countDistinct(arr: Array[Long]): Long = {
    val rdd = sc.parallelize(arr)
    rdd.distinct.count
  }
}

trait Counter {
  def countDistinct(arr: Array[Long]): Long
}
