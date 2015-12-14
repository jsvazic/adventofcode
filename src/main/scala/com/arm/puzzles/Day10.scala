package com.arm.puzzles

import java.io.InputStream

import scala.io.Source


object Day10 {

  def process(s: String) = "(.)\\1*".r.replaceAllIn(s, m => m.group(0).length + m.group(1))

  def part1(input: String) = (1 to 40).foldLeft(input) { (n, j) => process(n) }.length

  def part2(input: String) = (1 to 50).foldLeft(input) { (n, j) => process(n) }.length

  def main(args: Array[String]) = {
    val stream: InputStream = getClass.getResourceAsStream("/day10/input.txt")
    val input = Source.fromInputStream(stream).getLines().toList.head

    println(s"Part 1 : ${part1(input)}")
    println(s"Part 2 : ${part2(input)}")
  }
}
