package day01

import readInput
import kotlin.math.abs

fun main() {
    val input = readInput("day01/input")
//    val input = readInput("day01/input_test")

    println(part1(input))
    println(part2(input))
}

fun part1(input: List<String>): Int {
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    input.forEach { line ->
        val numberStrings = line.split("   ")
        val numbers = numberStrings.map { it.toInt() }
        list1.add(numbers[0])
        list2.add(numbers[1])
    }
    list1.sort()
    list2.sort()

    var sum = 0
    list1.zip(list2).forEach { (first, second) ->
        sum += abs(first - second)
    }

    return sum
}

fun part2(input: List<String>): Int {
    val list1 = mutableListOf<Int>()
    val mapList2 = mutableMapOf<Int, Int>()
    input.forEach { line ->
        val numberStrings = line.split("   ")
        val numbers = numberStrings.map { it.toInt() }
        list1.add(numbers[0])

        mapList2[numbers[1]] = mapList2.getOrDefault(numbers[1], 0) + 1
    }

    var sum = 0
    list1.forEach { number ->
        sum += mapList2.getOrDefault(number, 0) * number
    }
    return sum
}
