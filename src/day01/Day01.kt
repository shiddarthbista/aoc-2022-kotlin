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
