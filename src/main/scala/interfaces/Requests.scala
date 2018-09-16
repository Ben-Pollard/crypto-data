package interfaces

import play.api.libs.ws.ning.NingWSClient
import scala.concurrent.ExecutionContext.Implicits.global

object Requests {
  private val wsClient = NingWSClient()

  def request(uRL: String,
              params: Option[Map[String, String]] = None,
              headers: Option[Map[String, String]]=None) = {
    var request = wsClient
      .url(uRL)
      .withHeaders(Array("Cache-Control" -> "no-cache") ++ headers.getOrElse(Map()).toArray:_*)

    if(params.isDefined) {
        request = request.withQueryString(params.get.toArray:_*)
      }

    val result = request.get()
      .map { wsResponse =>
        if (! (200 to 299).contains(wsResponse.status)) {
          sys.error(s"Received unexpected status ${wsResponse.status} : ${wsResponse.body}")
        }
        wsResponse.json
      }
    result
  }
}
