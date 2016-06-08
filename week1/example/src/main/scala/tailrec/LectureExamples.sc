package tailrec

object Tailrec {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else loop(acc * n, n - 1)
    }
    loop(1, n)
  }                                               //> factorial: (n: Int)Int
  
  factorial(4)                                    //> res0: Int = 24

  // Week 2 lecture sample

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc else loop(a+1, f(a) + acc)
    }

    loop(a, 0)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int
  
  sum(x=> x*x)(3, 5)                              //> res1: Int = 50
  
  //2.2 lection
  
  def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 1
  else f(a) * product(f)(a+1, b)                  //> product: (f: Int => Int)(a: Int, b: Int)Int
  
  product(x => x* x)(3, 4)                        //> res2: Int = 144
  
  def fact(n: Int) = product(x=>x)(1, n)          //> fact: (n: Int)Int
  
  fact(5)                                         //> res3: Int = 120
  
  def mapReduce(f:Int=>Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
    if(a>b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a+1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
  
  def productMr(f: Int => Int)(a: Int, b: Int): Int =
  	mapReduce(f, (x, y) => x*y, 1)(a, b)      //> productMr: (f: Int => Int)(a: Int, b: Int)Int
  
  
productMr(x => x* x)(3, 4)                        //> res4: Int = 144
}