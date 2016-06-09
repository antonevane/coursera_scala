package tailrec

object Tailrec {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  println("Welcome Week1");$skip(328); 
  
  def sqrt(x: Double) = {
    def sqrtItter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtItter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      math.abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtItter(1.0)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(13); val res$0 = 
  
  sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(16); val res$1 = 
  
  sqrt(1e60);System.out.println("""res1: Double = """ + $show(res$1));$skip(153); 

  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else loop(acc * n, n - 1)
    }
    loop(1, n)
  };System.out.println("""factorial: (n: Int)Int""");$skip(18); val res$2 = 
  
  factorial(4);System.out.println("""res2: Int = """ + $show(res$2));$skip(55); 

  // Week 2 lecture sample
  println("Welcome Week2");$skip(165); 

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc else loop(a+1, f(a) + acc)
    }

    loop(a, 0)
  };System.out.println("""sum: (f: Int => Int)(a: Int, b: Int)Int""");$skip(24); val res$3 = 
  
  sum(x=> x*x)(3, 5);System.out.println("""res3: Int = """ + $show(res$3));$skip(122); 
  
  //2.2 lection
  
  def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1
  else f(a) * product(f)(a+1, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(30); val res$4 = 
  
  product(x => x* x)(3, 4);System.out.println("""res4: Int = """ + $show(res$4));$skip(44); 
  
  def fact(n: Int) = product(x=>x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(13); val res$5 = 
  
  fact(5);System.out.println("""res5: Int = """ + $show(res$5));$skip(170); 
  
  def mapReduce(f:Int=>Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if(a>b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a+1, b));System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(97); 
  
  def productMr(f: Int => Int)(a: Int, b: Int): Int =
  	mapReduce(f, (x, y) => x*y, 1)(a, b);System.out.println("""productMr: (f: Int => Int)(a: Int, b: Int)Int""");$skip(33); val res$6 = 
  
  
productMr(x => x* x)(3, 4);System.out.println("""res6: Int = """ + $show(res$6))}
}
