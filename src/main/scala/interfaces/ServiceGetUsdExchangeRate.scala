package interfaces

import domain.Domain.Coin

//Retrieves usd exchange rate from an exchange instance
object ServiceGetUsdExchangeRate {
  def apply(coin: Coin): Float = 0
}
