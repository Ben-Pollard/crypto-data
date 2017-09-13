package interfaces

import domain.Domain.Wallet

import scala.collection.mutable

abstract class WalletWatcher(coinName: String) {
  val coin = domain.Domain.coins.get(coinName).get
  val wallet = Wallet(coin, mutable.Map())
  def getAddressValue(address: String): Float
  def getWalletValue(): Wallet
  def sendPayment(toAddress:String): Boolean
}

//cryptoID.info
object Bitcoin extends WalletWatcher("BTC") {
  def getAddressValue(address: String) = 0.toFloat
  def getWalletValue() = wallet
  def sendPayment(toAddress:String) = true
}

//cryptoID.info
object LiteCoin extends WalletWatcher("LTC") {
  def getAddressValue(address: String) = 0.toFloat
  def getWalletValue() = wallet
  def sendPayment(toAddress:String) = true
}

//https://etherscan.io/apis
object Ether extends WalletWatcher("ETH") {
  def getAddressValue(address: String) = 0.toFloat
  def getWalletValue() = wallet
  def sendPayment(toAddress:String) = true
}

