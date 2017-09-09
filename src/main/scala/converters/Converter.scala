package converters

import org.apache.spark.sql.Dataset
import org.json4s.jackson.Json

trait Converter {
  def apply(datasets: Map[String, Dataset[Json]]) : Dataset[Json]
}

object RawToTraining {
  //Join training sources
  //augment with phantom trades
  def apply(datasets: Map[String, Dataset[Json]]) : Dataset[Json] = {
    null
  }

  def augment(joinedTrainingData: Dataset[Json]) : Dataset[Json] = {
    null
  }
}