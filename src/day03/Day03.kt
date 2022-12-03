package day03

import readInput

fun main() {
    fun priorityScore(commonChar: Char): Int {
        return when {
            commonChar.isLowerCase() -> {
                commonChar.code - 96
            }
            commonChar.isUpperCase() -> {
                commonChar.code - 38
            }
            else -> error("Invalid character")
        }
    }

    fun calculatePriority(input: String): Int {
        val ruckSackOne = input.substring(0,(input.length/2)).toList()
        val ruckSackTwo = input.substring(input.length/2,input.length).toList()

        val commonChar = ruckSackOne.intersect(ruckSackTwo).first()
        return priorityScore(commonChar)
    }

    fun calculatePriority(input: List<String>): Int {
        val commonChar = (input.first().toList().intersect(input.last().toList())).intersect(input[1].toList()).first()
        return priorityScore(commonChar)
    }

    fun part1(input: List<String>): Int {
        return input.sumOf {
            calculatePriority(it)
        }
    }

    fun part2(input:List<String>):Int {
        return input.windowed(3,3).sumOf {
            calculatePriority(it)
        }
    }

    val testInput = readInput("Day03_test")
    val input = readInput("Day03")

    check(part1(testInput) == 157)
    check(part2(testInput) == 70)
    println(part1(testInput))
    println(part2(testInput))
    println(part1(input))
    println(part2(input))
}