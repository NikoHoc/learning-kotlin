package com.dicoding.functional

/*
HIGH ORDER FUNCTION
fungsi yang makai fungsi lain sebagai parameter
lalu menjadikan tipe return
 */
// contoh lambda 1 parameter
var sum: (Int) -> Int = { value -> value + value }

fun printResult(value: Int, sum: (Int) -> Int) {
    val result = sum(value)
    println(result)
}

/*
Inline function
jika mengunakan high order function, maka saat dijalankan, function tersebut
akan dipanggil sesuai dgn yg di panggil di main
jika manggil 100 kali, maka akan di proses 100 kali jga

solusi -> inline || mempercepat waktu eksekusi program
 */
inline fun printResult2(value: Int, sum: (Int) -> Int) {
    val result = sum(value)
    println(result)
}

/*
Lambda with receiver
DSL -> domain specific languages
mirip extension functions
 */

// tanpa dsl
//fun buildString(): String {
//    val stringBuilder = StringBuilder()
//    stringBuilder.append("Hello ")
//    stringBuilder.append("from ")
//    stringBuilder.append("lambda")
//    return stringBuilder.toString()
//}

// dengan dsl
// StringBuilder dijadikan receiver untuk param action
//di main dibawah, actionya -> append
fun buildString(action: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.action()
    return stringBuilder.toString()
}

fun main() {
    //----- High Order Function
    //cara 1
    //printResult(10 ,sum)

    //cara2 -> bisa panggil isi dari lambada nya di main seperti dibawah ini
    printResult(10, { value ->
        value + value
    })

    //jika parameter terakhir berupa fungsi, bisa dibuat seperti ini
    printResult(10){ value ->
        value + value
    }

    // lambda receiver
    val message = buildString {
        append("Hello ")
        append("from ")
        append("lambda ")
    }

    println(message)
}