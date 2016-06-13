package lectures.week3.polymorphism.exercise


object Example {
  val l = List(1, 2)                              //> l  : List[Int] = List(1, 2)
  
  def nth(n: Int, elements: List[Int]): Int = {
  	if(n > elements.size) throw new IndexOutOfBoundsException("n > list.size")
  	else 0
  }                                               //> nth: (n: Int, elements: List[Int])Int
}