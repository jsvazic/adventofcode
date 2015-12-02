package com.arm.puzzles

import java.io.InputStream
import scala.io.Source

object Day2 {

  private def split(s: String) = s.split("x").map(_.toInt)

  def part1(input: String) = {
    val Array(l, w, h) = split(input)
    val areas = List[Int](l * w, w * h, h * l)
    areas.sum * 2 + areas.min
  }

  def part2(input: String): Int = {
    val Array(l, w, h) = split(input)
    val ribbon = List(l, w, h).sorted.take(2).sum * 2
    val bow = l * w * h
    ribbon + bow
  }

  def main(args: Array[String]) = {
    val stream : InputStream = getClass.getResourceAsStream("/day2/input.txt")
    val input = Source.fromInputStream(stream).getLines().toList

    println(s"Part 1 : ${input.map(part1).sum}")
    println(s"Part 2 : ${input.map(part2).sum}")
  }
}