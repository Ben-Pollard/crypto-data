package utils

import org.joda.time
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat


object Time {

  private val zone = time.DateTimeZone.UTC
  private val formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")

  def now():DateTime = time.DateTime.now(zone)

  def toString(dateTime: DateTime):String = formatter.print(dateTime)

  def tick(millis: Int): DateTime = {
    Thread.sleep(millis)
    now()
  }

  val ticks: Stream[time.DateTime] = Stream.continually(tick(1000))

}
