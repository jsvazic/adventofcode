package com.arm.puzzles

import java.io.InputStream
import scala.io.Source

object Day2 {

  private def split(s: String) = s.split("x").map(_.toInt)

  private def partition(l: List[Int]): List[List[Int]] = {
    def innerPart(l: List[Int], nl: List[List[Int]]): List[List[Int]] = {
      if (l.size < 2) nl
      else innerPart(l.tail, nl ++: (for (x <- l.tail) yield l.head :: x :: Nil))
    }

    innerPart(l, List[List[Int]]())
  }

  def part1(input: String) = {
    val a = partition(split(input).toList).map(l => l.head * l.last)
    a.sum * 2 + a.min
  }

  def part2(input: String): Int = {
    val l = split(input)
    val ribbon = l.sorted.take(2).sum * 2
    val bow = (1 /: l.toList) {_*_}
    ribbon + bow
  }

  def main(args: Array[String]) = {
    val stream : InputStream = getClass.getResourceAsStream("/day2/input.txt")
    val input = Source.fromInputStream(stream).getLines().toList

    println(s"Part 1 : ${input.map(part1).sum}")
    println(s"Part 2 : ${input.map(part2).sum}")
  }
}