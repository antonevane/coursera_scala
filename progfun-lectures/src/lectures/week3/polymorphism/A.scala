package lectures.week3.polymorphism

object A {
  def nth[T](n: Int, elements: List[T]): T = {
    if (elements.isEmpty) throw new IndexOutOfBoundsException("n > list.size")
    else if (n == 0) elements.head
    else nth(n - 1, elements.tail)

  }

  def main(args: Array[String]): Unit = {
    val l1 = new Cons(1, new Cons(2, new Cons(3, new Nil)))

    println(nth(0, l1))
    println(nth(1, l1))
    println(nth(2, l1))
  }
}