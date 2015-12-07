package com.arm.puzzles

class Day5Spec extends UnitSpec {

  "The string 'ugknbfddgicrmopn'" should "be considered nice" in {
    Day5.part1("ugknbfddgicrmopn") should equal (true)
  }

  "The string 'aaa'" should "be considered nice" in {
    Day5.part1("aaa") should equal (true)
  }

  "The string 'jchzalrnumimnmhp'" should "be considered naughty since it doesn't have a double letter" in {
    Day5.part1("jchzalrnumimnmhp") should equal (false)
  }

  "The string 'haegwjzuvuyypxyu'" should "be considered naughty since it contains 'xy'" in {
    Day5.part1("haegwjzuvuyypxyu") should equal (false)
  }

  "The string 'dvszwmarrgswjxmb'" should "be considered naughty since it contains only one vowel" in {
    Day5.part1("dvszwmarrgswjxmb") should equal (false)
  }

  "Santa's new naught/nice list algorithm" should "find the string 'qjhvhtzxzqqjkmpb' nice" in {
    Day5.part2("qjhvhtzxzqqjkmpb") should equal (true)
  }

  it should "find the string 'xxyxx' nice" in {
    Day5.part2("xxyxx") should equal (true)
  }

  it should "find the string 'uurcxstgmygtbstg' naughty" in {
    Day5.part2("uurcxstgmygtbstg") should equal (false)
  }

  it should "find the string 'ieodomkazucvgmuy' naughty" in {
    Day5.part2("ieodomkazucvgmuy") should equal (false)
  }
}