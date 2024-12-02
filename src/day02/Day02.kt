package day02

import readInput

fun main() {
    val input = readInput("day02/input")
//    val input = readInput("day02/input_test")

    println(part1(input))
    println(part2(input))
}

fun part1(input: List<String>): Int {
    var sum = 0
    input.forEach { line ->
        val numbers = line.split(" ").map { it.toInt() }
        if (checkNumbers(numbers = numbers)) sum++
    }
    return sum
}

fun checkNumbers(numbers: List<Int>): Boolean {
    var previousNumber: Int? = null
    var isIncreasing: Boolean? = null
    numbers.forEachIndexed { index, number ->
        when (index) {
            0 -> previousNumber = number
            1 -> {
                if (number == previousNumber) return false
                isIncreasing = number > previousNumber!!
                when {
                    isIncreasing!! && number <= (previousNumber!! + 3) -> Unit
                    isIncreasing!!.not() && number >= (previousNumber!! - 3) -> Unit
                    else -> return false
                }

                previousNumber = number
            }

            else -> {
                if (number == previousNumber) return false
                when {
                    isIncreasing!! && number in (previousNumber!! + 1..previousNumber!! + 3) -> Unit
                    isIncreasing!!.not() && number in (previousNumber!! - 3..<previousNumber!!) -> Unit
                    else -> return false
                }

                previousNumber = number
            }
        }
    }
    return true
}

fun part2(input: List<String>): Int {
    var sum = 0
    input.forEach { line ->
        val numbers = line.split(" ").map { it.toInt() }

        if (checkNumbers(numbers = numbers)) {
            sum++
            return@forEach
        }

        numbers.indices.forEach inner@{ index ->
            val withoutIndex = numbers.toMutableList().apply { removeAt(index) }
            if (checkNumbers(numbers = withoutIndex)) {
                sum++
                return@forEach
            }
        }
//        numbers.forEachIndexed { index, number ->
//            when (index) {
//                0 -> previousNumber = number
//                1 -> {
//                    isIncreasing = number > previousNumber!!
//
//                    if (number == previousNumber) {
//                        if (joker) {
//                            joker = false
//                            return@forEachIndexed
//                        }
//                        else return@forEach
//                    }
//
//                    when {
//                        isIncreasing!! && number <= (previousNumber!! + 3) -> Unit
//                        isIncreasing!!.not() && number >= (previousNumber!! - 3) -> Unit
//                        else -> {
//                            if (joker) {
//                                joker = false
//                                return@forEachIndexed
//                            }
//                            else return@forEach
//                        }
//                    }
//
//                    previousNumber = number
//                }
//
//                else -> {
//                    if (number == previousNumber) {
//                        if (joker) {
//                            joker = false
//                            return@forEachIndexed
//                        }
//                        else return@forEach
//                    }
//                    when {
//                        isIncreasing!! && number in (previousNumber!! + 1..previousNumber!! + 3) -> Unit
//                        isIncreasing!!.not() && number in (previousNumber!! - 3..<previousNumber!!) -> Unit
//                        else -> {
//                            if (joker) {
//                                joker = false
//                                return@forEachIndexed
//                            }
//                            else return@forEach
//                        }
//                    }
//
//                    if (index == numbers.lastIndex) sum++
//                    previousNumber = number
//                }
//            }
//        }
    }
    return sum
}
