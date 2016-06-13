package lectures

object Week2 {
  println("Welcome to the Scala Week 2")          //> Welcome to the Scala Week 2
  
  def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)
                                                  //> fact: (x: Int)Int
  
  def sumOld(f: Int => Int, a: Int, b: Int): Int = {
    //if a more then b the 0 to summ
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }

    loop(a, 0)
  }                                               //> sumOld: (f: Int => Int, a: Int, b: Int)Int
  
  // Returns function
  def sum(f: Int => Int):(Int, Int) => Int = {
    //if a more then b the 0 to summ
    def sumF(a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sumF(a+1, b)
    }

    sumF
  }                                               //> sum: (f: Int => Int)(Int, Int) => Int
  
  def sumInts = sum(x => x)                       //> sumInts: => (Int, Int) => Int
  
  def sumCubes = sum(x => x * x * x)              //> sumCubes: => (Int, Int) => Int

  def sumFactorials = sum(fact)                   //> sumFactorials: => (Int, Int) => Int
  
  sum ((x:Int) => x * x) (3, 5)                   //> res0: Int = 50
  
  
    // Returns function
  def sumS(f: Int => Int)(a: Int, b: Int): Int = {
    //if a more then b the 0 to summ
      if (a > b) 0
      else f(a) + sumS(f)(a+1, b)

  }                                               //> sumS: (f: Int => Int)(a: Int, b: Int)Int
}