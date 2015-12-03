package com.arm.puzzles

import java.io.InputStream

import scala.io.Source

case class Point(x: Int, y: Int) {
  def move(d: Char): Point = d.toLower match {
    case '^' => Point(x, y + 1)
    case '>' => Point(x + 1, y)
    case 'v' => Point(x, y - 1)
    case '<' => Point(x - 1, y)
    case _ => throw new RuntimeException(s"Unknown movement character: $d")
  }
}

case class SantaState(h: Point, m: Map[Point, Int])

object Day3 {

  private def move(ss: SantaState, d: Char) = {
    val house = ss.h.move(d)
    SantaState(house, ss.m + (house -> (ss.m.getOrElse(house, 0) + 1)))
  }

  def part1(input: String) = {
    val startingPoint = Point(0, 0)
    val map = Map[Point, Int](startingPoint -> 1)
    input.foldLeft(SantaState(startingPoint, map))((s, d) => move(s, d)).m.size
  }

  def part2(input: String) = {
    val startingPoint = Point(0, 0)
    val map = Map[Point, Int](startingPoint -> 2)
    val santa = input.sliding(1, 2).map(_.charAt(0)).foldLeft(SantaState(startingPoint, map))((s, d) => move(s, d))

    // Now move Robo-Santa, but use the same map that Santa used
    input.tail.sliding(1, 2).map(_.charAt(0)).foldLeft(SantaState(startingPoint, santa.m))((s, d) => move(s, d)).m.size
  }

  def main(args: Array[String]) = {
    val stream: InputStream = getClass.getResourceAsStream("/day3/input.txt")
    val input = Source.fromInputStream(stream).getLines().toList.head

    println(s"Part 1 : ${part1(input)}")
    println(s"Part 2 : ${part2(input)}")
  }
}