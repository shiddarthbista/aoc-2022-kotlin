package day02

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var totalScore = 0
        input.forEach {
            totalScore += calculateScore(it.substringBefore(" "), it.substringAfter(" "))
        }
        return totalScore
    }

    fun part2(input: List<String>): Int {
        var totalScore = 0
        input.forEach {
            totalScore += calculateScorePart2(it.substringBefore(" "), it.substringAfter(" "))
        }
        return totalScore
    }

    val testInput = readInput("Day02_test")
    val input = readInput("Day02")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    println(part1(testInput))
    println(part2(testInput))
    println(part1(input))
    println(part2(input))
}

fun calculateScore(opponent: String, player: String): Int {
    val score: Int

    val pointBook = mapOf(
        "A" to mapOf("X" to 4, "Y" to 8, "Z" to 3),
        "B" to mapOf("X" to 1, "Y" to 5, "Z" to 9),
        "C" to mapOf("X" to 7, "Y" to 2, "Z" to 6)
    )

    score = pointBook[opponent]?.get(player) ?: 0
    return score
}

fun calculateScorePart2(opponent: String, result: String): Int {
    val score: Int

    val pointBook = mapOf(
        "A" to mapOf("X" to 0+3, "Y" to 3+1, "Z" to 6+2),
        "B" to mapOf("X" to 0+1, "Y" to 3+2, "Z" to 6+3),
        "C" to mapOf("X" to 0+2, "Y" to 3+3, "Z" to 6+1)
    )

    score = pointBook[opponent]?.get(result) ?: 0
    return score
}