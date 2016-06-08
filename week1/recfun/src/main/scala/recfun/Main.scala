package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    
    println("Balance")
    val test1 = "(if (zero? x) max (/ 1 x))"
    val testFail = "())("
    val testFail2 = ":-)"
    val test2 = "()"
    println("Result is " + balance(testFail2.toList)) 
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def processListOfChars(data: List[Char], par: List[Char]): Boolean = {
      if (data.isEmpty) {
        par.isEmpty
      } else {
        if (data.head == '(') {
          processListOfChars(data.tail, par.::(data.head))
        } else if (data.head == ')') {
          if (par.isEmpty) false
          else processListOfChars(data.tail, par.tail)
        } else
          processListOfChars(data.tail, par)
      }
    }

    processListOfChars(chars, List())
  }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
