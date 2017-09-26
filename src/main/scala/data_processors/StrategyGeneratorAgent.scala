package data_processors

import domain.Domain.{Environment, Strategy}

//Neural net
//takes in exchange + portfolio time series and returns iterable of strategies
//strategies have an implement flag indicating whether to call the strategy executor
//non-executed strategies trigger the data augmenter to create further examples to
  //return as input to this strategy generator
object StrategyGeneratorAgent {

  //This is intended to be tensorflow network in scoring mode
  //Training to be carried out by a separate Python codebase
  private val neuralNet: () => Strategy = null

  //This function the maps the input/output formats to/from the neural network
  def apply(lastNGlobalStatus: Vector[Environment]) : Strategy = {
    neuralNet()
  }

}
