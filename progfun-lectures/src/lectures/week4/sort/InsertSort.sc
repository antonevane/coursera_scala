package lectures.week4

import List._

object InsertSort {

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List()  => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }                                               //> insert: (x: Int, xs: lectures.week4.List[Int])lectures.week4.List[Int]

  def isort(xs: List[Int]): List[Int] = xs match {
    case List()  => List()
    case y :: ys => insert(y, isort(ys))
  }                                               //> isort: (xs: lectures.week4.List[Int])lectures.week4.List[Int]

  isort(List(2, 6, 1))                            //> res0: <error> = List(1, 2, 6)
}