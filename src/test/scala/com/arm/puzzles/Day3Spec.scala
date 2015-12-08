package com.arm.puzzles

class Day3Spec extends UnitSpec {

  "A Point at (0,0)" should "move up one point with a ^" in {
    Day3.movePoint(Point(0,0), '^') should equal (Point(0, 1))
  }

  it should "move right one point with a >" in {
    Day3.movePoint(Point(0,0), '>') should equal (Point(1, 0))
  }

  it should "move down one point with a v" in {
    Day3.movePoint(Point(0,0), 'v') should equal (Point(0, -1))
  }

  it should "move left one point with a <" in {
    Day3.movePoint(Point(0,0), '<') should equal (Point(-1, 0))
  }

  "Santa's delivery instructions" should "result in delivering presents to 2 houses" in {
    Day3.part1(">") should equal (2)
  }

  it should "result in delivering presents to 4 houses" in {
    Day3.part1("^>v<") should equal (4)
  }

  it should "result in delivering presents to 2 houses with bad directions" in {
    Day3.part1("^v^v^v^v^v") should equal (2)
  }

  "Santa and Robo-Santa's delivery instructions" should "result in delivering presents to 3 houses" in {
    Day3.part2("^v") should equal (3)
    Day3.part2("^>v<") should equal (3)
  }

  it should "result in delivering presents to 11 houses with bad directions" in {
    Day3.part2("^v^v^v^v^v") should equal (11)
  }
}