package com.arm.puzzles

class Day10Spec extends UnitSpec {
  "1" should "become 11" in {
    Day10.process("1") should equal ("11")
  }

  "11" should "become 21" in {
    Day10.process("11") should equal ("21")
  }

  "21" should "become 21" in {
    Day10.process("21") should equal ("1211")
  }

  "1211" should "become 111221" in {
    Day10.process("1211") should equal ("111221")
  }

  "111221" should "become 312211" in {
    Day10.process("111221") should equal ("312211")
  }
}
