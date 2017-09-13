package data_processors

import domain.Domain.{ExchangeStatus, GlobalStatus, PortfolioStatus, TrainingRecord}

//Creates mini-batches of time series of global status (including y) + strategy
object TensorBuilder {
  def apply() : GlobalStatus = {
    null
  }

  def buildTrainingRecord(): TrainingRecord = null

  def buildGlobalStatus(portfolioStatus: PortfolioStatus, exchangeStatus: ExchangeStatus) : GlobalStatus = {
    GlobalStatus(portfolioStatus: PortfolioStatus, exchangeStatus: ExchangeStatus)
  }

}
