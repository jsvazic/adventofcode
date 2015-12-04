package com.arm.puzzles

import org.apache.commons.codec.digest.DigestUtils

import scala.annotation.tailrec

object Day4 {

  @tailrec
  private def recurse(i: Int, s: String, t: String): Int = {
    if (DigestUtils.md5Hex(s + i.toString).startsWith(t)) i
    else recurse(i + 1, s, t)
  }

  def part1(input: String) = {
    recurse(0, input, "00000")
  }

  def part2(input: String) = {
    recurse(0, input, "000000")
  }

  def main(args: Array[String]) = {
    val input = "yzbqklnj"
    println(s"Part 1 : ${part1(input)}")
    println(s"Part 2 : ${part2(input)}")
  }
}
