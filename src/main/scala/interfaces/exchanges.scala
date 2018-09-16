package interfaces

import java.sql.Timestamp

import domain.Domain._
import interfaces.ApiReturnTypes.{GetMarketInfo, GetRecentTransaction}

import scala.concurrent.Future

//An exchange instance has:
//  defined API return types
//  mappings to output types defined in Domain
//  getexchangestatus function
//  getaccountstatus function
//  getusdexchangerate function
//  execute trade function
//  constructor of iterable of pairs

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

