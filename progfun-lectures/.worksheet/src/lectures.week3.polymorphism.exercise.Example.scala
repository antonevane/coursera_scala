package lectures.week3.polymorphism.exercise


object Example {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(84); 
  val l = List(1, 2);System.out.println("""l  : List[Int] = """ + $show(l ));$skip(143); 
  
  def nth(n: Int, elements: List[Int]): Int = {
  	if(n > elements.size) throw new IndexOutOfBoundsException("n > list.size")
  	else 0
  };System.out.println("""nth: (n: Int, elements: List[Int])Int""")}
}
