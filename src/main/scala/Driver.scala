import data_processors.{EnvironmentProvider, StrategyGeneratorAgent}
import domain.Config
import domain.Domain.Environment
import interfaces.StrategyExecutor

import scala.annotation.tailrec
import scala.concurrent.Future

object Driver extends App {

  //Source infinite stream
  def infstr(tickNum: Int): Stream[Int] = Stream.cons(tickNum, infstr(tickNum + 1))

  //Stream of global status
  def ticksToGlobalStatus(stream: Stream[Int]): Stream[Environment] = infstr(0) map(EnvironmentProvider(_))

  //Takes a series of environments at previous time steps from which to generate strategy for next step
  @tailrec
  def sum(stream: Stream[Environment], lastN: Option[Vector[Environment]]):Int = {
    val strategy = StrategyGeneratorAgent(lastN.get)
    Future(StrategyExecutor(strategy))
    sum(stream.tail, Some(stream.take(Config.takeLastN).toVector))
  }

  //Call the stream function
  sum(ticksToGlobalStatus(infstr(0)), None)


}
