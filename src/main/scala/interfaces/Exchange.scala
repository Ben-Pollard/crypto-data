package interfaces

import java.sql.Timestamp

import domain.Domain
import domain.Domain.{Coin, Pair}


//An exchange instance has:
//  defined API return types
//  mappings to output types defined in Domain
//  getexchangestatus function
//  getaccountstatus function
//  getusdexchangerate function
//  execute trade function
//  constructor of iterable of pairs

//abstract class Exchange(pairs: Vector[Domain.Pair]) {
//  object APIReturnTypes
//  object DomainMappings
//  def getExchangestatus
//  def getAccountStatus
//  def getUsdExchangeRate
//  def executeTrade
//}
//
//
//class ShapeShift(pairs: Vector[Domain.Pair]) extends Exchange(pairs) {
//  object ApiReturnTypes {
//    case class GetRate(pair:Pair, rate:Float)
//    case class GetDepositLimit(pair:Pair, limit:Float)
//    case class GetMarketInfo(pair:Pair, rate:Float, limit:Float, min:Float, minerFee:Float)
//    case class GetRecentTransaction(curIn:Coin, curOut:Coin, amount:Float, timestamp:Timestamp)
//  }
//}

import Requests.request

object Bittrex {

  def getMarkets = request("https://bittrex.com/api/v1.1/public/getmarkets")
  def getCurrencies = request("https://bittrex.com/api/v1.1/public/getcurrencies")
  def getMarketSummaries = request("https://bittrex.com/api/v1.1/public/getmarketsummaries")

  def getMarketHistory(pair: Pair) = {
    request("https://bittrex.com/api/v1.1/public/getmarkethistory", Some(Map("market" -> pair.toString)))
  }

  def getOrderBook(pair: Pair) = {
    request("https://bittrex.com/api/v1.1/public/getorderbook", Some(Map("market" -> pair.toString)))
  }

  def getMarketSummary(pair: Pair) = {
    request("https://bittrex.com/api/v1.1/public/getmarketsummary", Some(Map("market" -> pair.toString)))
  }

  def getTicker(pair: Pair) = {
    request("https://bittrex.com/api/v1.1/public/getticker", Some(Map("market" -> pair.toString)))
  }

}

object BetFair {
  def login() = {
    request("https://identitysso.betfair.com/api/certlogin",
      headers = Some(Map("X-Application" -> sys.env.get("BF_DEV_APP_KEY").get)))
  }
}