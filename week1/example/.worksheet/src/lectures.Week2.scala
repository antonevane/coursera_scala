package lectures

object Week2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala Week 2");$skip(60); 
  
  def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1);System.out.println("""fact: (x: Int)Int""");$skip(215); 
  
  def sumOld(f: Int => Int, a: Int, b: Int): Int = {
    //if a more then b the 0 to summ
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }

    loop(a, 0)
  };System.out.println("""sumOld: (f: Int => Int, a: Int, b: Int)Int""");$skip(217); 
  
  // Returns function
  def sum(f: Int => Int):(Int, Int) => Int = {
    //if a more then b the 0 to summ
    def sumF(a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sumF(a+1, b)
    }

    sumF
  };System.out.println("""sum: (f: Int => Int)(Int, Int) => Int""");$skip(31); 
  
  def sumInts = sum(x => x);System.out.println("""sumInts: => (Int, Int) => Int""");$skip(40); 
  
  def sumCubes = sum(x => x * x * x);System.out.println("""sumCubes: => (Int, Int) => Int""");$skip(33); 

  def sumFactorials = sum(fact);System.out.println("""sumFactorials: => (Int, Int) => Int""");$skip(35); val res$0 = 
  
  sum ((x:Int) => x * x) (3, 5);System.out.println("""res0: Int = """ + $show(res$0));$skip(176); 
  
  
    // Returns function
  def sumS(f: Int => Int)(a: Int, b: Int): Int = {
    //if a more then b the 0 to summ
      if (a > b) 0
      else f(a) + sumS(f)(a+1, b)

  };System.out.println("""sumS: (f: Int => Int)(a: Int, b: Int)Int""")}
}
