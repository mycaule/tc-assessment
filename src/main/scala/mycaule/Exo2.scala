package mycaule

object Exo2 extends Counter with App {
  def countDistinct(arr: Array[Long]): Long = {
    arr.distinct.size

    // arr.toSet.size
  }
}

object Exo2Spark extends Counter {
  import org.apache.spark.SparkContext
  import org.apache.spark.rdd.RDD
  import org.apache.spark.SparkContext._
  import org.apache.spark.SparkConf

  val conf = new SparkConf().setAppName("Exo2Spark")
  val sc = new SparkContext(conf)

  def countDistinct(arr: Array[Long]): Long = {
    val rdd: RDD[Long] = sc.parallelize(arr)
    val count = rdd.distinct().count()

    sc.stop()
    count
  }
}

trait Counter {
  def countDistinct(arr: Array[Long]): Long
}
