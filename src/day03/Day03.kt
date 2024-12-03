package day03

import readInput

fun main() {
    val input = readInput("day03/input")
//    val input = readInput("day03/input_test")

    println(part1(input))
    println(part2(input))
}

fun part1(input: List<String>): Int {
    var sum = 0
    input.forEach { line ->
        val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
        val matches = regex.findAll(line)
        for (match in matches) {
            sum += match.groupValues[1].toInt() * match.groupValues[2].toInt()
        }
    }

    return sum
}

fun part2(input: List<String>): Int {
    var sum = 0
    var enabled = true
    input.forEach { line ->
        val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)|do\(\)|don't\(\)""")
        val matches = regex.findAll(line)
        for (match in matches) {
            val item = match.groupValues.first()
            when (item) {
                "do()" -> enabled = true
                "don't()" -> enabled = false
                else -> if (enabled) sum += match.groupValues[1].toInt() * match.groupValues[2].toInt()
            }
        }
    }
    return sum
}
