import scala.annotation.tailrec

def infstr(num: Int): Stream[Int] = Stream.cons(num, infstr(num + 1))


@tailrec
def sum(xs: Stream[Int], z: Option[List[Int]]):Int = {
  val example = z.getOrElse(List(0))
  println(example)
  sum(xs.tail, Some(xs.take(4).toList))
}

//sum(infstr(0), None)
