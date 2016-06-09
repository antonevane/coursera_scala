package lectures

object Week2Lecture5 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  println("Welcome to the Scala worksheet");$skip(81); 
  
  //Rational numbers x/y (nominator/denominator)
  val x = new Rational(1, 3);System.out.println("""x  : lectures.Rational = """ + $show(x ));$skip(29); 
  val y = new Rational(5, 7);System.out.println("""y  : lectures.Rational = """ + $show(y ));$skip(29); 
  val z = new Rational(3, 2);System.out.println("""z  : lectures.Rational = """ + $show(z ));$skip(14); val res$0 = 
  
  x.add(y);System.out.println("""res0: lectures.Rational = """ + $show(res$0));$skip(14); val res$1 = 
  
  y.add(y);System.out.println("""res1: lectures.Rational = """ + $show(res$1));$skip(12); val res$2 = 
  x.less(y);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(11); val res$3 = 
  x.max(y);System.out.println("""res3: lectures.Rational = """ + $show(res$3));$skip(21); val res$4 = 
  
  new Rational(3);System.out.println("""res4: lectures.Rational = """ + $show(res$4))}
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
