package com.dicoding.exam.optionalexam3

// TODO
fun manipulateString(str: String, int: Int): String {
    // \\D -> char non digit
    // \\d -> digit(0-9)
    val polaRegex = "(\\D+)(\\d+)?".toRegex()

    val cekString = polaRegex.matchEntire(str)

    return if (cekString != null) {
        val (text, number) = cekString.destructured // pecah cekString

        if (number.isNotEmpty()) {
            text + (number.toInt() * int)
        } else {
            text + int
        }
    } else {
        str + int
    }
}
