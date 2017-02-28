// Auxiliary functions for reading and writting files

package com.rho.file

object quickFunc {

// Global imports
import java.io._

  // Put contents of a file in a string
  def readIntoString(file: String, encoding: String ="ISO-8859-1"): String = {
    val exists = (new File(file)).exists
    def write(): String = {
      if (exists) {
        val source = scala.io.Source.fromFile(file,encoding)
        val result = try source.mkString finally source.close()
        result
      } else ""
    }
    write()
  }

  // Put contents of a file in a string
  def readIntoList(file: String, encoding: String ="ISO-8859-1"): List[String] = {
    val exists = (new File(file)).exists
    def write(): List[String] = {
      if (exists) {
        val source = scala.io.Source.fromFile(file,encoding)
        val result = try source.getLines.toList finally source.close()
        result
      } else List()
    }
    write()
  }


  // Count lines of a file
  def countLines(file: String, encoding: String = "ISO-8859-1"): Int = {
    val exists = (new File(file)).exists
    def count(): Int = {
      if (exists) {
        val source = scala.io.Source.fromFile(file,encoding)
        val result = try source.getLines.size finally source.close()
        result
      } else 0
    }
    count()
  }

  // Parse file full path for path
  def getPath(file:String): String = {
    import scala.util.matching.Regex
    ("^.+/".r findFirstIn file) match {
      case Some(x) => x
      case None => "."
    }
  }
 
  // Makes direcory, returns 1 if succesful, 0 if not
  def makeDirectory(directory:String): Int = { 
    if (directory=="." || directory=="./") 1
    else if ((new File(directory)).mkdir()) 1
    else 0
  }

  // Dumps string into file
  def writeToFile(file: String = "",string: String, append: Boolean = false, encoding: String = "ISO-8859-1"): Int = {
    import java.io.{BufferedWriter,FileOutputStream,OutputStreamWriter}
    if (!append) {makeDirectory(getPath(file))}
    val stream = new OutputStreamWriter(new FileOutputStream(file,append),encoding)
    val writer = new BufferedWriter(stream)
    if (append) writer.write("\n"+string) 
    else writer.write(string)
    writer.close()
    1
  }

  // Dumps list into file, each list entry as a line
  def writeListToFile(file: String = "", list: List[String], append: Boolean = false, encoding: String = "ISO-8859-1"): Int = {
    def concat(a: String, b: String): String = if (a.isEmpty) b else a + "\n" + b
    writeToFile(file,list.foldLeft[String]("")(concat),append,encoding)
  }



}
