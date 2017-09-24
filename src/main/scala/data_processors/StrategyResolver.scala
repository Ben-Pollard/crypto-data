package data_processors

import domain.Domain.{GlobalStatus, Strategy, TrainingRecord}
import utils.Time

object StrategyResolver {

  //number -> tick -> status -> strategy
  //store status as training data
  def apply(tickNum: Int, tickLenMillis: Int) : GlobalStatus = {
    val tick = Time.tick(tickLenMillis)
    val exchangeStatus = null
    val portfolioStatus = null
    val strategy = null
    val globalStatus: GlobalStatus = null
    repos.TrainingData.write(globalStatus)
    globalStatus
  }

}
