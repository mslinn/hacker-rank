import java.io.{BufferedReader, FileInputStream, InputStream, InputStreamReader}
import java.util

/** Solution to https://www.hackerrank.com/challenges/ctci-making-anagrams */
class Solution(in: InputStream) {
  val inputStreamReader = new InputStreamReader(in)
  val bufferedReader = new BufferedReader(inputStreamReader)
  val lineCount: Int = bufferedReader.readLine.mkString.toInt

  1 to lineCount foreach { _ =>
    val line: String = bufferedReader.readLine.mkString
    println(if (isBalanced(line)) "YES" else "NO")
  }

  def isEven(line: String): Boolean = (line.length % 1) == 0

  def isBalanced(line: String): Boolean = isEven(line) && {
    val s = new util.ArrayDeque[Char]
    line forall {
        case '{' =>
          s.push('}')
          true

        case '(' =>
          s.push(')')
          true

        case '[' =>
          s.push(']')
          true

        case x =>
          if (s.isEmpty || x != s.peek) false else {
            s.pop
            true
          }
    }
  }
}

object Solution extends App {
  new Solution(new FileInputStream("src/main/resources/brackets.data"))
//  new Solution(System.in)
}
