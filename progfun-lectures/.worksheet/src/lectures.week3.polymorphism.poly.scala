package lectures.week3.polymorphism

import List._

object poly {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(128); 
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T]());System.out.println("""singleton: [T](elem: T)lectures.week3.polymorphism.Cons[T]""");$skip(189); 
  def nth(n: Int, elements: List[Int]): Int = {
    if (n > 0) nth(n - 1, elements.tail)
    else if(n == 0) elements.head
    else throw new IndexOutOfBoundsException("n > list.size")
  };System.out.println("""nth: (n: Int, elements: lectures.week3.polymorphism.List[Int])Int""");$skip(32); 
  val l1 = new Cons(3, new Nil);System.out.println("""l1  : lectures.week3.polymorphism.Cons[Int] = """ + $show(l1 ));$skip(25); 
val l2 = new Cons(5, l1);System.out.println("""l2  : lectures.week3.polymorphism.Cons[Int] = """ + $show(l2 ));$skip(25); 
val l3 = new Cons(4, l2);System.out.println("""l3  : lectures.week3.polymorphism.Cons[Int] = """ + $show(l3 ));$skip(12); val res$0 = 

nth(3, l3);System.out.println("""res0: Int = """ + $show(res$0))}
}
