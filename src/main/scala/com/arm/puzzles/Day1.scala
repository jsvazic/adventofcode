package com.arm.puzzles

import java.io.InputStream

import scala.annotation.tailrec
import scala.io.Source

object Day1 {

  def part1(input: String) = {
    val left = input.filter(c => c == '(').length
    left - (input.length - left)
  }

  def part2(input: String): Int = {
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
    val stream : InputStream = getClass.getResourceAsStream("/day1/1_1.txt")
    val input = Source.fromInputStream(stream).getLines().toList.head // Read just the first line.
    println(s"Part 1 : ${part1(input)}")
    println(s"Part 2 : ${part2(input)}")
  }
}