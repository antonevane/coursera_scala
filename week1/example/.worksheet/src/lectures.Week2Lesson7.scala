package lectures

object Week2Lesson7 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(83); 
  println("Welcome to the Scala worksheet");$skip(77); 
//Rational numbers x/y (nominator/denominator)
  val x = new RationalA(1, 3);System.out.println("""x  : lectures.RationalA = """ + $show(x ));$skip(30); 
  val y = new RationalA(5, 7);System.out.println("""y  : lectures.RationalA = """ + $show(y ));$skip(30); 
  val z = new RationalA(3, 2);System.out.println("""z  : lectures.RationalA = """ + $show(z ));$skip(15); val res$0 = 
  
  x + y + z;System.out.println("""res0: lectures.RationalA = """ + $show(res$0))}

}

class RationalA(x: Int, y: Int) {
  require(y > 0, "denominatior must be nonzero")

  // Constructor
  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def numer = x
  def denom = y

  def + (that: RationalA): RationalA =
    new RationalA(numer * that.denom + that.numer * denom,
      denom * that.denom)

  def unary_- : RationalA = new RationalA(-numer, denom)

  def - (that: RationalA) = this + -that

  def < (that: RationalA) = numer * that.denom < that.numer * denom

  def max(that: RationalA) = if (this < that) that else this

  override def toString = {
    // lost precession
    val g = gcd(x, y)
    numer / g + "/" + denom / g
  }
}
