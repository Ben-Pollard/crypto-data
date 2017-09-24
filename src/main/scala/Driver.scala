import data_processors.{StrategyGenerator, StrategyResolver}
import domain.Domain.{GlobalStatus, PortfolioStatus, TrainingRecord}
import interfaces.StrategyExecutor
import org.joda.time.DateTime
import utils.Time

import scala.annotation.tailrec

object Driver extends App {

  val tickLengthMillis = 500
  val takeLastN = 10

  //Source infinite stream
  def infstr(tickNum: Int): Stream[Int] = Stream.cons(tickNum, infstr(tickNum + 1))

  //Stream of global status
  def ticksToGlobalStatus(stream: Stream[Int]): Stream[GlobalStatus] = infstr(0) map(StrategyResolver(_, tickLengthMillis))

  //Takes a series of global statuses from the stream from which to generate strategy
  @tailrec
  def sum(stream: Stream[GlobalStatus], lastN: Option[Vector[GlobalStatus]]):Int = {
    val strategy = StrategyGenerator(lastN.get)
    StrategyExecutor(strategy)
    sum(stream.tail, Some(stream.take(takeLastN).toVector))
  }

  //Call the stream function
  sum(ticksToGlobalStatus(infstr(0)), None)


}
