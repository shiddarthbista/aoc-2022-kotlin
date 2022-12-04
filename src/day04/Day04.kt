package day04

import readInput

fun main() {

    fun calculateOverlap(firstElfRooms: MutableList<Int>, secondElfRooms: MutableList<Int>): Int =
        when {
            firstElfRooms.containsAll(secondElfRooms) -> {
                1
            }
            secondElfRooms.containsAll(firstElfRooms) -> {
                1
            }
            else -> 0
        }

    fun calculateAnyOverlap(firstElfRooms: MutableList<Int>, secondElfRooms: MutableList<Int>): Int =
        when {
            firstElfRooms.any {it in secondElfRooms} -> 1
            secondElfRooms.any {it in firstElfRooms} -> 1
            else -> 0
        }


    fun part1(input: List<String>): Int {
        return input.sumOf {
            val firstElf = it.substringBefore(",")
            val secondElf = it.substringAfter(",")

            val firstElfRoomList = mutableListOf<Int>()
            val secondElfRoomList = mutableListOf<Int>()
            for (i in firstElf.substringBefore("-").toInt() .. firstElf.substringAfter("-").toInt()) {
                firstElfRoomList.add(i)
            }
            for (i in secondElf.substringBefore("-").toInt() .. secondElf.substringAfter("-").toInt()) {
                secondElfRoomList.add(i)
            }
            calculateOverlap(firstElfRoomList,secondElfRoomList)
        }
    }

    fun part2(input: List<String>):Int {
        return input.sumOf {
            val firstElf = it.substringBefore(",")
            val secondElf = it.substringAfter(",")

            val firstElfRoomList = mutableListOf<Int>()
            val secondElfRoomList = mutableListOf<Int>()
            for (i in firstElf.substringBefore("-").toInt() .. firstElf.substringAfter("-").toInt()) {
                firstElfRoomList.add(i)
            }
            for (i in secondElf.substringBefore("-").toInt() .. secondElf.substringAfter("-").toInt()) {
                secondElfRoomList.add(i)
            }
            calculateAnyOverlap(firstElfRoomList,secondElfRoomList)
        }
    }


    val testInput = readInput("Day04_test")
    val input = readInput("Day04")

    check(part1(testInput) == 2)
    check(part2(testInput) == 4)
    println(part1(testInput))
    println(part2(testInput))
    println(part1(input))
    println(part2(input))
}