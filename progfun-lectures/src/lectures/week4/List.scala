package lectures.week4

import java.util.NoSuchElementException

trait List[T] {
 def isEmpty: Boolean
 def head: T
 def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty =  false
}

class Nil[T] extends List[T] {
  def isEmpty =  true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
}

// Task create a List(), List(1), List(1,2)

/**
 * @author novopa
 */
object List {
  // List(1, 2)
  def apply[T](x1: T, x2:T): List[T] = new Cons(x1, new Cons(x2, new Nil))
  
  def apply[T](): List[T] = new Nil
}


