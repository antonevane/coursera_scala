package lectures

import math.abs

object Week2_Lecture3 {
  println("Welcome to the Scala Weec 2 Lecture 3")//> Welcome to the Scala Weec 2 Lecture 3
  
  def sqrt1(x: Double) = {
    def sqrtItter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtItter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      math.abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtItter(1.0)
  }                                               //> sqrt1: (x: Double)Double

  // Lecture example
  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance              //> isCloseEnough: (x: Double, y: Double)Boolean
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double

  fixedPoint(x => 1 + x / 2)(1)                   //> res0: Double = 1.999755859375

  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0)
                                                  //> sqrt: (x: Double)Double

  sqrt(2)                                         //> res1: Double = 1.4142135623746899

  //stabilizing values
  def averageDump(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> averageDump: (f: Double => Double)(x: Double)Double
  
  def sqrtAD(x: Double) = fixedPoint(averageDump(y=> x/y))(1)
                                                  //> sqrtAD: (x: Double)Double
  
  sqrtAD(2)                                       //> res2: Double = 1.4142135623746899
}