package repos

import domain.Domain.GlobalStatus
import org.apache.spark.sql.Dataset
import org.json4s.jackson.Json


//stream raw data into s3
abstract class exchange {

  def read

  def write

}

//batch process for storing result of training parser
object TrainingData {

  def read() = null

  def write(globalStatus: GlobalStatus): Unit = {
    val trainingRecords: Dataset[Json] = null
  }

}