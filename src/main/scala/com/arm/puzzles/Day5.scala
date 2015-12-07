package com.arm.puzzles

import java.io.InputStream

import scala.io.Source

object Day5 {

  def part1(input: String): Boolean = {
    val threeVowels = "(.*[aeiou]){3}".r.findFirstIn(input).isDefined
    val doubleLetter = "(.)\\1".r.findFirstIn(input).isDefined
    val invalidChars = "(ab|cd|pq|xy)+".r.findFirstIn(input).isEmpty

    threeVowels && doubleLetter && invalidChars
  }

  def part2(input: String) = {
    val hasMultiplePairs = "(..).*\\1".r.findFirstIn(input).isDefined
    val hasRepeatWithDistinctMiddle = "(.).\\1".r.findFirstIn(input).isDefined

    hasMultiplePairs && hasRepeatWithDistinctMiddle
  }

  def main(args: Array[String]) = {
    val stream: InputStream = getClass.getResourceAsStream("/day5/input.txt")
    val input = Source.fromInputStream(stream).getLines().toList

    println(s"Part 1 : ${input.map(s => part1(s)).count(b => b)}")
    println(s"Part 2 : ${input.map(s => part2(s)).count(b => b)}")
  }
}
