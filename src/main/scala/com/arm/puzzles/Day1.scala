package com.arm.puzzles

import java.io.InputStream

import scala.annotation.tailrec
import scala.io.Source

/**
  * Created by john on 01/12/15.
  */
object Day1 {

  private def getInput() = {
    // Open a stream for the file and read the content.
    val stream : InputStream = getClass.getResourceAsStream("/day1/1_1.txt")
    val input = Source.fromInputStream(stream).getLines().toList.head // Read just the first line.
    input
  }

  def quiz1() = {
    val input = getInput()
    val left = input.filter(c => c == '(').length
    left - (input.length - left)
  }

  def quiz2(): Int = {
    val input = getInput()

    @tailrec
    def recurse(idx: Int, count: Int, s: String): Int = {
      if (count < 0) idx
      else {
        s.head match {
          case '(' => recurse(idx + 1, count + 1, s.tail)
          case ')' => recurse(idx + 1, count - 1, s.tail)
        }
      }
    }

    recurse(0, 0, input)
  }

  def main(args: Array[String]) = {
    println(s"Quiz 1 : $quiz1")
    println(s"Quiz 2 : $quiz2")
  }
}