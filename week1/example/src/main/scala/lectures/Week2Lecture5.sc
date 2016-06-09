package lectures

object Week2Lecture5 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  //Rational numbers x/y (nominator/denominator)
  val x = new Rational(1, 3)                      //> x  : lectures.Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : lectures.Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : lectures.Rational = 3/2
  
  x.add(y)                                        //> res0: lectures.Rational = 22/21
  
  y.add(y)                                        //> res1: lectures.Rational = 10/7
  x.less(y)                                       //> res2: Boolean = true
  x.max(y)                                        //> res3: lectures.Rational = 5/7
  
  new Rational(3)                                 //> res4: lectures.Rational = 3/1
  // Common devisor lecture 2.6
}

class Rational(x: Int, y: Int) {
  require(y > 0, "denominatior must be nonzero")
  
  // Constructor
  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
 
  def numer = x
  def denom = y

  def add(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom,
      denom * that.denom)

  def neg = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)
  
  def less(that: Rational) = numer * that.denom < that.numer * denom
  
  def max(that: Rational) = if(this.less(that)) that else this

  override def toString = {
    // lost precession
    val g = gcd(x, y)
    numer / g + "/" + denom / g
  }
}