package day03

import readInput

fun main() {
    fun priorityScore(commonChar: Char): Int =
         when {
            commonChar.isLowerCase() -> {
                commonChar.code - 'a'.code + 1
            }
            commonChar.isUpperCase() -> {
                commonChar.code - 'A'.code + 27
            }
            else -> error("Invalid character")
        }

    fun part1(input: List<String>): Int {
        return input.sumOf {rucksack->
            val ruckSackOne =  rucksack.substring(0,(rucksack.length/2)).toList()
            val ruckSackTwo = rucksack.substring(rucksack.length/2).toList()
            priorityScore((ruckSackOne intersect ruckSackTwo).first())
        }
    }

    fun part2(input:List<String>):Int {
        return input.chunked(3).sumOf { rucksacks ->
            val(rucksackOne,rucksackTwo,rucksackThree) = rucksacks.map {  it.toList() }
            val commonChar = rucksackOne intersect rucksackTwo intersect rucksackThree
            priorityScore(commonChar.first())
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