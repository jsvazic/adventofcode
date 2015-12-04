package com.arm.puzzles

class Day4Spec extends UnitSpec {

  "The AdventCode hash for abcdef" should "be 609043" in {
    Day4.part1("abcdef") should equal (609043)
  }

  "The AdventCode hash for pqrstuv" should "be 1048970" in {
    Day4.part1("pqrstuv") should equal (1048970)
  }
}