package com.arm.puzzles

import java.io.InputStream

import scala.io.Source

object Day7 {

  private val memoize = scala.collection.mutable.Map[String, Int]()

  implicit class Regex(sc: StringContext) {
    def r = new util.matching.Regex(sc.parts.mkString, sc.parts.tail.map(_ => "x"): _*)
  }

  def AND(x: Int, y: Int) = x & y
  def OR(x: Int, y: Int) = x | y
  def LSHIFT(x: Int, y: Int) = x << y
  def RSHIFT(x: Int, y: Int) = x >> y
  def NOT(x: Int) = ~x & 0xffff

  def init(l: List[String]) = {
    def addToState(state: Map[String, String], line: String) = {
      val l = line.split("->").toList.map(_.trim())
      state + (l.last -> l.head)
    }

    l.foldLeft(Map[String, String]())(addToState)
  }

  def eval(op: String, state: Map[String, String]): Int = {
    memoize.get(op) match {
      case Some(v) => v
      case _ => {
        val calculatedValue = op match {
          case r"(\d+)${num}" => num.toInt
          case r"NOT (\d+)${num}" => NOT(num.toInt)
          case r"(\d+)${n1} AND (\d+)${n2}" => AND(n1.toInt, n2.toInt)
          case r"(\d+)${n1} OR (\d+)${n2}" => OR(n1.toInt, n2.toInt)
          case r"(\w+)${v}" => eval(state.get(v).get, state)
          case r"NOT (\w+)${v}" => NOT(eval(state.get(v).get, state))
          case r"(\w+)${v} LSHIFT (\d+)${n}" => LSHIFT(eval(state.get(v).get, state), n.toInt)
          case r"(\w+)${v} RSHIFT (\d+)${n}" => RSHIFT(eval(state.get(v).get, state), n.toInt)
          case r"(\d+)${n} AND (\w+)${v}" => AND(n.toInt, eval(state.get(v).get, state))
          case r"(\w+)${v} AND (\d+)${n}" => AND(eval(state.get(v).get, state), n.toInt)
          case r"(\w+)${v1} AND (\w+)${v2}" => AND(eval(state.get(v1).get, state), eval(state.get(v2).get, state))
          case r"(\w+)${v} OR (\d+)${n}" => OR(eval(state.get(v).get, state), n.toInt)
          case r"(\d+)${n} OR (\w+)${v}" => OR(n.toInt, eval(state.get(v).get, state))
          case r"(\w+)${v1} OR (\w+)${v2}" => OR(eval(state.get(v1).get, state), eval(state.get(v2).get, state))
          case _ => throw new RuntimeException(s"Unknown op: $op")
        }
        memoize += (op -> calculatedValue)
        calculatedValue
      }
    }
  }

  def part1(input: List[String]) = {
    val map = init(input)
    memoize.clear()
    map.get("a") match {
      case Some(a) => eval(a, map)
      case _ => throw new RuntimeException("No key found for 'a'")
    }
  }

  def part2(input: List[String]) = {
    val map = init(input) + ("b" -> "3176")
    memoize.clear()
    map.get("a") match {
      case Some(a) => eval(a, map)
      case _ => throw new RuntimeException("No key found for 'a'")
    }
  }

  def main(args: Array[String]) = {
    val stream: InputStream = getClass.getResourceAsStream("/day7/input.txt")
    val input = Source.fromInputStream(stream).getLines().toList

    println(s"Part 1 : ${part1(input)}")
    println(s"Part 2 : ${part2(input)}")
  }
}
