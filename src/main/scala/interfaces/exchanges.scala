package interfaces

import java.sql.Timestamp

import domain.Domain._
import interfaces.ApiReturnTypes.{GetMarketInfo, GetRecentTransaction}

import scala.concurrent.Future

object ApiReturnTypes {
  case class GetRate(pair:Pair, rate:Float)
  case class GetDepositLimit(pair:Pair, limit:Float)
  case class GetMarketInfo(pair:Pair, rate:Float, limit:Float, min:Float, minerFee:Float)
  case class GetRecentTransaction(curIn:Coin, curOut:Coin, amount:Float, timestamp:Timestamp)
}

object Shapeshift {
  def getMarketInfo(pair: Pair): GetMarketInfo = null
  def GetRecentTransactionList(): List[GetRecentTransaction] = null
}

object usdExchangeRateService {
  def apply(coin: Coin): Float = 0
}

object coinsAmountService {
  def apply(): Map[Coin, Float] = null
}

object block_explorers {

}