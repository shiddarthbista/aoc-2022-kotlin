package day02

import readInput

fun main() {
    fun part1(input: List<String>): Int =
        input.sumOf {
            calculateScore(it.substringBefore(" "), it.substringAfter(" "))
        }

    fun part2(input: List<String>): Int =
        input.sumOf {
            calculateScorePart2(it.substringBefore(" "), it.substringAfter(" "))
        }

    val testInput = readInput("Day02_test")
    val input = readInput("Day02")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    println(part1(input))
    println(part2(input))
}

fun calculateScore(opponent: String, player: String): Int {
    val pointBook = mapOf(
        "A" to mapOf("X" to 4, "Y" to 8, "Z" to 3),
        "B" to mapOf("X" to 1, "Y" to 5, "Z" to 9),
        "C" to mapOf("X" to 7, "Y" to 2, "Z" to 6)
    )
    return pointBook.getValue(opponent).getValue(player)
}

fun calculateScorePart2(opponent: String, result: String): Int {
    val pointBook = mapOf(
        "A" to mapOf("X" to 3, "Y" to 4, "Z" to 8),
        "B" to mapOf("X" to 1, "Y" to 5, "Z" to 9),
        "C" to mapOf("X" to 2, "Y" to 6, "Z" to 7)
    )

    return pointBook.getValue(opponent).getValue(result)
}