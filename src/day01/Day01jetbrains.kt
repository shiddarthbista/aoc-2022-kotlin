package day01

import java.io.File

fun main() {
    fun parseInput(input: String) = input.split("\n\n").map { elf ->
        elf.lines().map { it.toInt() }
    }

    fun part1(input: String): Int {
        val calories = parseInput(input)
        return calories.maxOf{ it.sum() }
    }

    fun part2(input: String): Int {
        val data = parseInput(input)
        return data
            .map { it.sum() }
            .sortedDescending()
            .take(3)
            .sum()
    }

    val testInput = File("src/Day01.txt").readText()
    check(part1(testInput) == 24000)

    println(part2(testInput))
}