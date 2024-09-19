package com.dicoding.functional

/*
Member References
 */

//sebelumnya
//val sum: (Int, Int) -> Int = { valueA, valueB -> valueA + valueB }

//bisa kita pisah fungsinya -> Reflection
val summ: (Int, Int) -> Int = ::count
fun count(valueA: Int, valueB: Int): Int {
    return valueA + valueB
}

/*
Function references
 */
//referensikan function
fun isEvenNumber1(number: Int) = number % 2 == 0
//referensi kan extension function
fun Int.isEvenNumber2() = this % 2 == 0

/*
Property References
:: -> jg bisa mereferensikan properti, kita jadi bisa akses bagian dri properti tersebut
 */
var message2 = "Kotlin"
//kalau objeknya val (tidak bisa diubah)
//hanya tersedia .name dan .get(), karena tidak bisa set atau ubah

fun main() {
    // function reference
    val numbers = 1.rangeTo(10)
    val evenNumbers1 = numbers.filter(::isEvenNumber1) // dengan ::
    println(evenNumbers1)

    // bisa mereferensikan extension function juga
    val evenNumbers2 = numbers.filter(Int::isEvenNumber2)
    println(evenNumbers2)

    //property reference
    println(::message2.name) // -> nama variabelnya
    println(::message2.get())

    ::message2.set("Kotlin Academy")

    println(::message2.get())
}