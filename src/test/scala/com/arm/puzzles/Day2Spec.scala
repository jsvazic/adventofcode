package com.arm.puzzles

class Day2Spec extends UnitSpec {
  "Total surface area for a present" should "be known for pre-defined values" in {
    Day2.part1("2x3x4") should equal (58)
    Day2.part1("1x1x10") should equal (43)
  }

  "Total amount of ribbon for a present" should "be known for pre-defined values" in {
    Day2.part2("2x3x4") should equal (34)
    Day2.part2("1x1x10") should equal (14)
  }
}
