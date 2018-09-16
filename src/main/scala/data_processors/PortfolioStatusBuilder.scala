package data_processors

import domain.Config
import domain.Domain.{Coin, PortfolioStatus}
import interfaces.{ServiceGetUsdExchangeRate, ServicePortfolioStatus}

import scala.collection.immutable
import scala.concurrent.Future

object PortfolioStatusBuilder {

  //Resolve any futures coming from the API calls here
  def apply(): (PortfolioStatus, Int) = {
    val maxResolutionTime = Config.maxEnvironmentResolutionTime
    val coinsAmount = ServicePortfolioStatus()
    val usdValue = coinsAmount.map(c => ServiceGetUsdExchangeRate(c._1)).sum
    val actualResolutionTimeMillis: Int = 0
    (PortfolioStatus(usdValue, coinsAmount), actualResolutionTimeMillis)
  }

}
