package com.arm.puzzles

class Day9Spec extends UnitSpec {
  "The sample graph" should "result in a known distance" in {
    val l = List("London to Dublin = 464", "London to Belfast = 518", "Dublin to Belfast = 141")
    Day9.part1(l) should equal (605)
  }
}
