package com.arm.puzzles

import java.io.InputStream

import scala.io.Source

object Day8 {

  def cleanString(s: String) = s.replaceAll("\\\\\\\\", "i").replaceAll("\\\\\"", "j").replaceAll("\\\\x([0-9A-Fa-f]{2})", "k")
  def encodeString(s: String) = s.replaceAll("\\\\","\\\\\\\\").replaceAll("\\\"", "\\\\\"")

  def part1(s: String) = s.length - cleanString(s.substring(1, s.length() - 1)).length
  def part2(s: String) = ("\"" + encodeString(s) + "\"").length - s.length

  def main(args: Array[String]) = {
    val stream: InputStream = getClass.getResourceAsStream("/day8/input.txt")
    val input = Source.fromInputStream(stream).getLines().toList

    println(s"Part 1 : ${input.map(part1).sum}")
    println(s"Part 2 : ${input.map(part2).sum}")
  }
}
