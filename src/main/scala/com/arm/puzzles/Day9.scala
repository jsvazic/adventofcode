package com.arm.puzzles

import java.io.InputStream

import scala.io.Source


object Day9 {

  val pattern = "([A-Za-z]+) to ([A-Za-z]+) = ([0-9]+)".r

  private def getResults(input: List[String]) = {
    val distanceMap = input.map { case pattern(from, to, amount) => (from, to) -> amount.toInt }.toMap
    val permutations = distanceMap.keys.flatMap(s => List(s._1, s._2)).toSet.toList.permutations
    permutations.map(perm => {
      perm.sliding(2, 1).map(l => (l(0), l(1))).map(names => distanceMap.getOrElse(names, distanceMap(names.swap))).sum
    }).toSet
  }

  def part1(input: List[String]) = getResults(input).min

  def part2(input: List[String]) = getResults(input).max

  def main(args: Array[String]) = {
    val stream: InputStream = getClass.getResourceAsStream("/day9/input.txt")
    val input = Source.fromInputStream(stream).getLines().toList

    println(s"Part 1 : ${part1(input)}")
    println(s"Part 2 : ${part2(input)}")
  }
}
