package interfaces

import domain.Domain.Coin

//Calls all exchanges and wallets to build up a portfolio view
object ServicePortfolioStatus {
  def apply(): Map[Coin, Float] = null
}
