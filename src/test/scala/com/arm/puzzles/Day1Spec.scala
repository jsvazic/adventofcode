package com.arm.puzzles

class Day1Spec extends UnitSpec {
  "The floor algorithm" should "return 0 for known input" in {
    Day1.part1("(())") should equal (0)
    Day1.part1("()()") should equal (0)
  }

  it should "return 3 for known input" in {
    Day1.part1("(((") should equal (3)
    Day1.part1("(()(()(") should equal (3)
    Day1.part1("))(((((") should equal (3)
  }

  it should "return -1 for known input" in {
    Day1.part1("())") should equal (-1)
    Day1.part1("))(") should equal (-1)
  }

  it should "return -3 for known input" in {
    Day1.part1(")))") should equal (-3)
    Day1.part1(")())())") should equal (-3)
  }

  "The floor algorithm" should "put Santa in the basement at position 1" in {
    Day1.part2(")") should equal (1)
  }

  it should "put Santa in the basement at position 5" in {
    Day1.part2("()())") should equal (5)
  }
}