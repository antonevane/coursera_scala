package lectures

object Week2Lesson7 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
//Rational numbers x/y (nominator/denominator)
  val x = new RationalA(1, 3)                     //> x  : lectures.RationalA = 1/3
  val y = new RationalA(5, 7)                     //> y  : lectures.RationalA = 5/7
  val z = new RationalA(3, 2)                     //> z  : lectures.RationalA = 3/2
  
  x + y + z                                       //> res0: lectures.RationalA = 107/42

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