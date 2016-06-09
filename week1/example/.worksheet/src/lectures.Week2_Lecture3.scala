package lectures

import math.abs

object Week2_Lecture3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(109); 
  println("Welcome to the Scala Weec 2 Lecture 3");$skip(329); 
  
  def sqrt1(x: Double) = {
    def sqrtItter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtItter(improve(guess))

    def isGoodEnough(guess: Double): Boolean =
      math.abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtItter(1.0)
  };System.out.println("""sqrt1: (x: Double)Double""");$skip(48); 

  // Lecture example
  val tolerance = 0.0001;System.out.println("""tolerance  : Double = """ + $show(tolerance ));$skip(81); 
  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance;System.out.println("""isCloseEnough: (x: Double, y: Double)Boolean""");$skip(233); 
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  };System.out.println("""fixedPoint: (f: Double => Double)(firstGuess: Double)Double""");$skip(34); val res$0 = 

  fixedPoint(x => 1 + x / 2)(1);System.out.println("""res0: Double = """ + $show(res$0));$skip(64); 

  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0);System.out.println("""sqrt: (x: Double)Double""");$skip(12); val res$1 = 

  sqrt(2);System.out.println("""res1: Double = """ + $show(res$1));$skip(92); 

  //stabilizing values
  def averageDump(f: Double => Double)(x: Double) = (x + f(x)) / 2;System.out.println("""averageDump: (f: Double => Double)(x: Double)Double""");$skip(65); 
  
  def sqrtAD(x: Double) = fixedPoint(averageDump(y=> x/y))(1);System.out.println("""sqrtAD: (x: Double)Double""");$skip(15); val res$2 = 
  
  sqrtAD(2);System.out.println("""res2: Double = """ + $show(res$2))}
}
