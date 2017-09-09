package repos

import org.apache.spark.SparkConf
import org.apache.spark.sql.Dataset
import org.json4s.jackson.Json

object spark {
  val conf = new SparkConf()
}

//stream raw data into s3
abstract class exchange {

  def read

  def write

}

//batch process for storing result of training parser
abstract class TrainingData {

  def read

  def write(trainingDataset: Dataset[Json])

}