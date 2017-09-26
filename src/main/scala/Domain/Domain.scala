package domain

import scala.collection.mutable

object Domain {

  //Trading primitives
  case class Coin (val name: String, val symbol: String)

  val coins = Map(
    "BTC" -> Coin(name = "Bitcoin",symbol = "BTC"),
    "LTC" -> Coin(name = "Litecoin", symbol = "LTC"),
    "ETH" -> Coin(name = "Ether", symbol = "ETH")
  )

  case class Pair(toSell: Coin, toBuy:Coin)
  case class Trade(pair: Pair, amountToSell:Float) //amount can be negative - each pair exists once
  case class ExchangeRate(pair: Pair, amountToBuyPerOneSoldBeforeFee: Float, fee:Float)

  //Tensor components
  case class ExchangeStatus(exchangeRates: List[ExchangeRate]) //order of exchange rates must be immutable
  case class PortfolioStatus(usdValue: Float, coinsAmount: Map[Coin, Float]) //order of coins must be immutable
  case class Strategy(trades: List[Trade]) //order of trades must be immutable
  case class Environment(portfolioStatus: PortfolioStatus, exchangeStatus: ExchangeStatus)

  val timeStepLengths: List[Int] = List(0) // time-steps can be different lengths so we can search different scales for information advantage
  case class TrainingRecord(timeStepLength: Int, timeSeries: Vector[Environment])

  //Wallet management
  case class Address(publicKey:String, privateKey:Option[String], everSentFrom:Boolean)
  case class Wallet(coin:Coin, addressValues: mutable.Map[Address, Float])
}
