package lectures.week3.polymorphism

import List._

object poly {
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T]())
                                                  //> singleton: [T](elem: T)lectures.week3.polymorphism.Cons[T]
  def nth(n: Int, elements: List[Int]): Int = {
    if (n > 0) nth(n - 1, elements.tail)
    else if(n == 0) elements.head
    else throw new IndexOutOfBoundsException("n > list.size")
  }                                               //> nth: (n: Int, elements: lectures.week3.polymorphism.List[Int])Int
  val l1 = new Cons(3, new Nil)                   //> l1  : lectures.week3.polymorphism.Cons[Int] = lectures.week3.polymorphism.Co
                                                  //| ns@3b6eb2ec
val l2 = new Cons(5, l1)                          //> l2  : lectures.week3.polymorphism.Cons[Int] = lectures.week3.polymorphism.Co
                                                  //| ns@1e643faf
val l3 = new Cons(4, l2)                          //> l3  : lectures.week3.polymorphism.Cons[Int] = lectures.week3.polymorphism.Co
                                                  //| ns@6e8dacdf

nth(3, l3)                                        //> java.util.NoSuchElementException: Nil.head
                                                  //| 	at lectures.week3.polymorphism.Nil.head(List.scala:17)
                                                  //| 	at lectures.week3.polymorphism.Nil.head(List.scala:15)
                                                  //| 	at lectures.week3.polymorphism.poly$$anonfun$main$1.nth$1(lectures.week3
                                                  //| .polymorphism.poly.scala:9)
                                                  //| 	at lectures.week3.polymorphism.poly$$anonfun$main$1.apply$mcV$sp(lecture
                                                  //| s.week3.polymorphism.poly.scala:16)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at lectures.week3.polymorphism.poly$.main(lectures.week3.polymorphism.po
                                                  //| ly.scala:5)
                                                  //| 	at lectures.week3.polymorphism.poly.main(lectures.week3.polymorphism.pol
                                                  //| y.scala)
}