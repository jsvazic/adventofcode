package com.arm.puzzles

class Day7Spec extends UnitSpec {
  "Given the sample input, the circut" should "return known values" in {
    val input = List("123 -> x",  "456 -> y", "x AND y -> d", "x OR y -> e", "x LSHIFT 2 -> f", "y RSHIFT 2 -> g", "NOT x -> h", "NOT y -> i")
    val map = Day7.init(input)

    Day7.eval(map.get("d").get, map) should equal (72)
    Day7.eval(map.get("e").get, map) should equal (507)
    Day7.eval(map.get("f").get, map) should equal (492)
    Day7.eval(map.get("g").get, map) should equal (114)
    Day7.eval(map.get("h").get, map) should equal (65412)
    Day7.eval(map.get("i").get, map) should equal (65079)
    Day7.eval(map.get("x").get, map) should equal (123)
    Day7.eval(map.get("y").get, map) should equal (456)
  }
}