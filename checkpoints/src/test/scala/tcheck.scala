import org.scalatest.FunSuite
class CheckTest extends FunSuite {

  import com.rho.file.RhoCheck
  import com.rho.file.quickFunc.writeToFile

  test("Doing an action, then try again (inside data/)") {
    val file  = "data/run.chk"
    val event = "I did a thing"
    val other = "I did something else"
    // Make a new checkpoint file every run
    writeToFile("data/run.chk","# HEADER")
    // Check that no events have been recorded. then record event
    val check = new RhoCheck(file)
    val bool1 = check.checkEvent(event)
    if (bool1) assert(1===0)
    else assert(1===1)
    check.recordEvent(event)
    // Check that the event was recorded
    val check2 = new RhoCheck(file)
    val bool2 = check2.checkEvent(event)
    println(check2.events)
    if (!bool2) assert(1===0)
    else assert(1===1)
  }

}
