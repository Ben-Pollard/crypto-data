package Domain

object Domain {

  class Coin (
    val name: String,
    val symbol: String,
    val publicKey: String)

  case class Pair(toSell: Coin, toBuy:Coin)

  val Bitcoin = new Coin(
    name = "Bitcoin",
    symbol = "BTC",
    publicKey = "")

  val Litecoin = new Coin(
    name = "Litecoin",
    symbol = "LTC",
    publicKey = "")
}
