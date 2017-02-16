import org.scalatest.FunSuite

class FileOps extends FunSuite {

  // Imports
  import com.rho.file.quickFunc._
  import scala.util.matching.Regex

  // Test vars
  trait testVars {
    val path = "src/test/resources/"
    val path_0 = path + "empty"
    val path_1 = path + "one"
    val path_2 = path + "two"
    val path_3 = path + "three"
    val path_x = path + "doesnotexist"
  }

  // File read test
  test("Reading a file") {
    new testVars {
      val one = ("\\w{1,}".r findFirstIn readIntoString(path_1)).mkString
      val three = ("\\s".r replaceAllIn(readIntoString(path_3),"")).mkString
      assert(one==="one")
      assert(three==="onetwothree")
    }
  }

  // Testing line counting functions
  test("Counting lines") {
    new testVars {
      assert(countLines(path_0)===0)
      assert(countLines(path_1)===1)
      assert(countLines(path_2)===2)
      assert(countLines(path_3)===3)
      assert(countLines(path_x)===0)
    }
  }
 
}
