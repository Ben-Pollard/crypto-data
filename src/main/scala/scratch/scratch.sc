import scala.annotation.tailrec

def infstr(num: Int): Stream[Int] = Stream.cons(num, infstr(num + 1))


@tailrec
def sum(xs: Stream[Int], z:List[Int]=List(0)):Int = {
  println(z)
  sum(xs.tail, xs.take(4).toList)
}

sum(infstr(0))
