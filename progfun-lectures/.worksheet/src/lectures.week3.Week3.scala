package lectures.week3

object Week3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(82); 
  println("Welcome to the Scala worksheet");$skip(44); 
  
  val t1 = new NonEmpty(3, Empty, Empty);System.out.println("""t1  : lectures.week3.NonEmpty = """ + $show(t1 ));$skip(24); 
  
  val t2 = t1 incl 4;System.out.println("""t2  : lectures.week3.IntSet = """ + $show(t2 ))}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  def union(other: IntSet): IntSet = {
    other
  }

  override def toString: String = "."
}

class NonEmpty(elem: Int, right: IntSet, left: IntSet) extends IntSet {

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  def union(other: IntSet): IntSet = {
  	// Gives set without initial element
  	// include starting element back
    ((left union right) union other) incl elem
  }

  override def toString: String = "{" + left + elem + right + "}"
}
