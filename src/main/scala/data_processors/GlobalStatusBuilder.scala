package data_processors

import domain.Domain.{ExchangeStatus, GlobalStatus, PortfolioStatus}

//Concatenates statuses of different elements into a global status
//this forms one record in the time-series
object GlobalStatusBuilder {

  def apply(portfolioStatus: PortfolioStatus, exchangeStatus: ExchangeStatus) : GlobalStatus = {
    GlobalStatus(portfolioStatus: PortfolioStatus, exchangeStatus: ExchangeStatus)
  }


}
