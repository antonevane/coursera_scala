package lectures.week4

import List._

object InsertSort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(217); 

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List()  => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  };System.out.println("""insert: (x: Int, xs: lectures.week4.List[Int])lectures.week4.List[Int]""");$skip(125); 

  def isort(xs: List[Int]): List[Int] = xs match {
    case List()  => List()
    case y :: ys => insert(y, isort(ys))
  };System.out.println("""isort: (xs: lectures.week4.List[Int])lectures.week4.List[Int]""");$skip(25); val res$0 = 

  isort(List(2, 6, 1));System.out.println("""res0: <error> = """ + $show(res$0))}
}
