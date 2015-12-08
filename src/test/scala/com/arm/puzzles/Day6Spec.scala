package com.arm.puzzles

class Day6Spec extends UnitSpec {

  "Parsing an action" should "return known value" in {
    Day6.getState("turn on") should equal (On)
    Day6.getState("turn off") should equal (Off)
    Day6.getState("toggle") should equal (Toggle)
  }

  "Parsing a command string" should "return known values" in {
    val s1 = "turn on 0,0 through 999,999"
    val cmd = Day6.getCommand(s1)
    cmd match {
      case Some(c) => {
        c.fromX should be (0)
        c.fromY should be (0)
        c.toX should be (999)
        c.toY should be (999)
        c.state should equal (On)
      }
      case _ => fail("Cmd was not defined.")
    }

    val s2 = "turn on 499,499 through 500,500"
    val cmd2 = Day6.getCommand(s2)
    cmd2 match {
      case Some(c) => {
        c.fromX should be (499)
        c.fromY should be (499)
        c.toX should be (500)
        c.toY should be (500)
        c.state should equal (On)
      }
      case _ => fail("Cmd2 was not defined.")
    }

  }

  "The christmas lights" should "turn on all the lights with the command 'turn on 0,0 through 999,999'" in {
    Day6.part1(List("turn on 0,0 through 999,999")) should equal (1000000)
  }

  it should "turn off the first row with the command 'toggle 0,0 through 999,0'" in {
    Day6.part1(List("turn on 0,0 through 999,999", "toggle 0,0 through 999,0")) should equal (1000000 - 1000)
  }

  it should "only turn on 4 lights for 'turn on 499,499 through 500,500" in {
    Day6.part1(List("turn on 499,499 through 500,500")) should equal (4)
  }

  it should "turn off the middle 4 lights with the command 'turn off 499,499 through 500,500'" in {
    Day6.part1(List("turn on 0,0 through 999,999", "turn off 499,499 through 500,500")) should equal (1000000 - 4)
  }
}