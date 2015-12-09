package com.arm.puzzles

class Day8Spec extends UnitSpec {

  "\\x27" should "result in '" in {
    Day8.cleanString("\\x27") should equal("k")
  }

  "'\"\"'" should "result in 2" in {
    Day8.part1("\"\"") should equal(2)
  }

  "'\"abc\"'" should "result in 2" in {
    Day8.part1("\"abc\"") should equal(2)
  }

  "'\"aaa\\\"aaa\"'" should "result in 3" in {
    Day8.part1("\"aaa\\\"aaa\"") should equal(3)
  }

  "'\"\\x27\"'" should "result in 5" in {
    Day8.part1("\"\\x27\"") should equal(5)
  }

  "Encoding \"\"" should "result in a string of length 6" in {
    ("\"" + Day8.encodeString("\"\"") + "\"").length should equal(6)
  }

  "Encoding \"abc\"" should "result in a string of length 9" in {
    ("\"" + Day8.encodeString("\"abc\"") + "\"").length should equal(9)
  }

  "Encoding \"aaa\\\"aaa\"" should "result in a string of length 16" in {
    ("\"" + Day8.encodeString("\"aaa\\\"aaa\"") + "\"").length should equal(16)
  }

  "Encoding \"\\x27\"" should "result in a string of length 11" in {
    ("\"" + Day8.encodeString("\"\\x27\"") + "\"").length should equal(11)
  }
}