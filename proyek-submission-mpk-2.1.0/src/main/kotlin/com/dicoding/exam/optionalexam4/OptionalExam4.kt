package com.dicoding.exam.optionalexam4

// TODO
fun getMiddleCharacters(string: String): String {
    val length = string.length
    if (length % 2 == 0) {
        //string genap
        return string.substring((length / 2) - 1, (length / 2) + 1)
    } else {
        //string ganjil
        return string[length / 2].toString()
    }
}