package data_processors

import domain.Config
import domain.Domain._
import utils.Time

import scala.concurrent.Future

object EnvironmentProvider {

  //number -> tick -> status -> strategy
  //store status as training data
  def apply(tickNum: Int) : Environment = {
    Time.tick(Config.tickLenMillis)
    val (exchangeStatus, exchangeResolutionTimeMillis) = ExchangeStatusBuilder()
    val (portfolioStatus, portfolioResolutionTimeMillis) = PortfolioStatusBuilder()
    val environmentResolutionTime = Vector(exchangeResolutionTimeMillis, portfolioResolutionTimeMillis).max
    val environment = Environment(portfolioStatus, exchangeStatus)
    repos.TrainingData.write(environment)
    environment
  }

}
