package com.rho.file
import com.rho.file.quickFunc.{readIntoList,writeToFile}
import java.io.File

class RhoCheck(checkfile: String = "data/run.chk") {

  // List of events
  val events = readIntoList(checkfile)

  // File checks if event has passed
  def checkEvent(event: String): Boolean = {
    def aux(list: List[String]): Boolean = {
      if (list.isEmpty) false
      else if (list.head==event) true
      else aux(list.tail)
    }
    aux(events)
  }

  // Write into 
  def recordEvent(event: String): Int = {
    val exists = (new File(checkfile)).exists
    writeToFile(checkfile,event,exists)
  }

}
