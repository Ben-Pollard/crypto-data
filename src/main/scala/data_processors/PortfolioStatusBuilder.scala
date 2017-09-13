package data_processors

import domain.Domain.{Coin, PortfolioStatus}
import interfaces.{coinsAmountService, usdExchangeRateService}

import scala.collection.immutable
import scala.concurrent.Future

object PortfolioStatusBuilder {

  def apply(): PortfolioStatus = {
    val coinsAmount = coinsAmountService()
    val usdValue = coinsAmount.map(c => usdExchangeRateService(c._1)).sum
    PortfolioStatus(usdValue, coinsAmount)
  }

}
