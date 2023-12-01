package day01

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return getCalorieSums(input).maxOrNull() ?: 0
    }

    fun part2(input: List<String>): Int {
        val calorieSums = getCalorieSums(input)
        calorieSums.sortDescending()
        return calorieSums.subList(0, 3).sum()
    }


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("day01")
    println(part1(input))
    println(part2(input))
}
fun convertWordToNumber(input: String): String {
    val wordToNumberMap = mapOf(
            "zero" to "0",
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
    )

    var result = input
    for ((word, number) in wordToNumberMap) {
        result = result.replace(word, number)
    }

    return result
}


fun getCalorieSums(input: List<String>): MutableList<Int> {
    val sums = mutableListOf<Int>()
    for (calories in input) {
        if (calories.isEmpty()) {
            sums += 0
        } else {
            var sum = sums.removeLastOrNull() ?: 0
            sum += calories.toInt()
            sums += sum
        }
    }
    return sums
}
