package tailrec

object Tailrec {
  println("Welcome Week1")                        //> Welcome Week1
  
  def sqrt(x: Double) = {
    def sqrtItter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtItter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      math.abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtItter(1.0)
  }                                               //> sqrt: (x: Double)Double
  
  sqrt(2)                                         //> res0: Double = 1.4142156862745097
  
  sqrt(1e60)                                      //> res1: Double = 1.0000788456669446E30

  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else loop(acc * n, n - 1)
    }
    loop(1, n)
  }                                               //> factorial: (n: Int)Int
  
  factorial(4)                                    //> res2: Int = 24

  // Week 2 lecture sample
  println("Welcome Week2")                        //> Welcome Week2

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc else loop(a+1, f(a) + acc)
    }

    loop(a, 0)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int
  
  sum(x=> x*x)(3, 5)                              //> res3: Int = 50
  
  //2.2 lection
  
  def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1
  else f(a) * product(f)(a+1, b)                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  product(x => x* x)(3, 4)                        //> res4: Int = 144
  
  def fact(n: Int) = product(x=>x)(1, n)          //> fact: (n: Int)Int
  
  fact(5)                                         //> res5: Int = 120
  
  def mapReduce(f:Int=>Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if(a>b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b
                                                  //| : Int)Int
  
  def productMr(f: Int => Int)(a: Int, b: Int): Int =
  	mapReduce(f, (x, y) => x*y, 1)(a, b)      //> productMr: (f: Int => Int)(a: Int, b: Int)Int
  
  
productMr(x => x* x)(3, 4)                        //> res6: Int = 144
}