package com.dicoding.exam.optionalexam2

// TODO
fun minAndMax(number: Int): Int {
    val digits = number.toString().map {
        it.toString().toInt()
    }
    val largest = digits.maxOrNull() ?: 0
    val smallest = digits.minOrNull() ?: 0

    return largest + smallest
}
