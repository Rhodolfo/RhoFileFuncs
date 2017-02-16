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

  // count lines of a file
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

}
