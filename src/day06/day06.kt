package day06

import java.io.File

fun main() {
    fun String.findMarker(distinctCount: Int) = windowed(distinctCount).indexOfFirst{
        it.toSet().size == distinctCount
    } + distinctCount

    fun part1(input: String):Int = input.findMarker(4)
    fun part2(input: String):Int = input.findMarker(14)

    val input = File("src/inputs/Day06.txt").readText()
    println(part1(input))
    println(part2(input))
}