package com.arm.puzzles

import java.io.InputStream

import scala.io.Source

sealed trait LightState
case object On extends LightState
case object Off extends LightState
case object Toggle extends LightState

case class Command(state: LightState, fromX: Int, fromY: Int, toX: Int, toY: Int)

object Day6 {

  def getState(action: String) = action match {
    case "turn on" => On
    case "turn off" => Off
    case "toggle" => Toggle
    case _ => throw new RuntimeException(s"Unknown action: $action")
  }

  def getCommand(input: String): Option[Command] = {
    val regex = """(turn on|turn off|toggle)\s(\d+){1,3},(\d+){1,3}\sthrough\s(\d+){1,3},(\d+){1,3}""".r
    regex.findFirstMatchIn(input) match {
      case Some(m) => {
        val l = m.subgroups
        Some(Command(getState(l.head), l(1).toInt, l(2).toInt, l(3).toInt, l(4).toInt))
      }
      case _ => None
    }
  }

  def countLights(lights: Array[Array[Boolean]]): Int = {
    var count = 0
    for (x <- lights.indices; y <- lights(0).indices) {
      if (lights(x)(y)) count += 1
    }

    count
  }

  def countBrightness(lights: Array[Array[Int]]): Int = {
    var count = 0
    for (x <- lights.indices; y <- lights(0).indices) {
      count += lights(x)(y)
    }

    count
  }

  def update(lights: Array[Array[Boolean]], cmd: Command): Array[Array[Boolean]] = {
    def setLight(x: Int, y: Int, state: LightState) {
      state match {
        case On => lights(x)(y) = true
        case Off => lights(x)(y) = false
        case Toggle => lights(x)(y) = !lights(x)(y)
      }
    }

    for (x <- cmd.fromX to cmd.toX; y <- cmd.fromY to cmd.toY) {
      setLight(x, y, cmd.state)
    }

    lights
  }

  def update(lights: Array[Array[Int]], cmd: Command): Array[Array[Int]] = {
    def setLight(x: Int, y: Int, state: LightState) {
      state match {
        case On => lights(x)(y) += 1
        case Off => lights(x)(y) = Math.max(0, lights(x)(y) - 1)
        case Toggle => lights(x)(y) += 2
      }
    }

    for (x <- cmd.fromX to cmd.toX; y <- cmd.fromY to cmd.toY) {
      setLight(x, y, cmd.state)
    }

    lights
  }

  def part1(input: List[String]): Int = {
    val lights = Array.ofDim[Boolean](1000, 1000)

    for (s <- input) {
      getCommand(s) match {
        case Some(cmd) => update(lights, cmd)
        case _ => // Do nothing
      }
    }

    countLights(lights)
  }

  def part2(input: List[String]): Int = {
    val lights = Array.ofDim[Int](1000, 1000)

    for (s <- input) {
      getCommand(s) match {
        case Some(cmd) => update(lights, cmd)
        case _ => // Do nothing
      }
    }

    countBrightness(lights)
  }

  def main(args: Array[String]) = {
    val stream: InputStream = getClass.getResourceAsStream("/day6/input.txt")
    val input = Source.fromInputStream(stream).getLines().toList

    println(s"Part 1 : ${part1(input)}")
    println(s"Part 2 : ${part2(input)}")
  }
}
