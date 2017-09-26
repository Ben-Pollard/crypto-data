package data_processors

import domain.Config
import domain.Domain.ExchangeStatus


object ExchangeStatusBuilder {

  //Resolve any futures coming from the API calls here
  //Use a maximum resolution time
  //Provide the actual resolution time as a result
  def apply(): (ExchangeStatus, Int) = {
    val maxResolutionTime = Config.maxEnvironmentResolutionTime
    val actualResolutionTimeMillis: Int = null
    val exchangeStatus: ExchangeStatus = null
    (exchangeStatus, actualResolutionTimeMillis)
  }

}
