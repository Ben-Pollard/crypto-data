package api_readers

import java.sql.Timestamp

import Domain.Domain._
import api_readers.ApiReturnTypes.{GetMarketInfo, GetRecentTransaction}

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

object block_explorers {

}