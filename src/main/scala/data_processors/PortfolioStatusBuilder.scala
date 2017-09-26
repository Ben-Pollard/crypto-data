package data_processors

import domain.Config
import domain.Domain.{Coin, PortfolioStatus}
import interfaces.{coinsAmountService, usdExchangeRateService}

import scala.collection.immutable
import scala.concurrent.Future

object PortfolioStatusBuilder {

  //Resolve any futures coming from the API calls here
  def apply(): (PortfolioStatus, Int) = {
    val maxResolutionTime = Config.maxEnvironmentResolutionTime
    val coinsAmount = coinsAmountService()
    val usdValue = coinsAmount.map(c => usdExchangeRateService(c._1)).sum
    val actualResolutionTimeMillis: Int = null
    (PortfolioStatus(usdValue, coinsAmount), actualResolutionTimeMillis)
  }

}
