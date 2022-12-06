package day06

import java.io.File

fun main() {

    fun part1(input: String):Int {
        return input.windowed(4).indexOfFirst{
            it.allUnique()
        }
    }

    fun part2(input: String):Int {
        return input.windowed(14).indexOfFirst{
            it.allUnique()
        }
    }

    val testInput = File("src/inputs/Day06_test.txt").readText()
    val input = File("src/inputs/Day06.txt").readText()
    println(testInput)
    println(part1(input))
    println(part2(testInput))
    println(part2(input))
}

fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)