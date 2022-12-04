package day04

import readInput

fun main() {
    fun getElfRoomList(roomInfo: String): Pair<MutableList<Int>, MutableList<Int>> {
        val firstElf = roomInfo.substringBefore(",")
        val secondElf = roomInfo.substringAfter(",")

        val firstElfRoomList = mutableListOf<Int>()
        val secondElfRoomList = mutableListOf<Int>()
        for (i in firstElf.substringBefore("-").toInt()..firstElf.substringAfter("-").toInt()) {
            firstElfRoomList.add(i)
        }
        for (i in secondElf.substringBefore("-").toInt()..secondElf.substringAfter("-").toInt()) {
            secondElfRoomList.add(i)
        }
        return Pair(firstElfRoomList, secondElfRoomList)
    }

    fun part1(input: List<String>): Int {
        return input.count {
            val (firstElfRoomList, secondElfRoomList) = getElfRoomList(it)
            firstElfRoomList.containsAll(secondElfRoomList) || secondElfRoomList.containsAll(firstElfRoomList)
        }
    }

    fun part2(input: List<String>): Int {
        return input.count { it ->
            val (firstElfRoomList, secondElfRoomList) = getElfRoomList(it)
            firstElfRoomList.any { it in secondElfRoomList }
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