package lectures.week4

class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat = new Succ(this)
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}

object Zero extends Nat {
  def isZero: Boolean = true

  def predecessor: Nat = throw new Error("0.predecessor")
  
  def +(that: Nat): Nat = that
  def -(that: Nat): Nat = if(that.isZero) that else throw new Error("negative number")
  
}
object One extends Nat

class Succ(n: Nat) extends Nat {
  def isZero: Boolean = false

  def predecessor: Nat = n
  
  def +(that: Nat): Nat = new Succ(n + that)
  
  def -(that: Nat): Nat = if(that.isZero) n else n - that.predecessor
  
}
