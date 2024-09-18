package com.dicoding.kotlin.com.dicoding.fundamentals

import kotlin.random.Random

enum class Color (val value: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}
fun main() {
    /*
    When Expression
    Expression & Statement
    While and Do While
    Range and For Loop
    Break and Continue Labels
    */

    // --------- ENUMERATION -------
    val colorRed = Color.RED
    val colorGreen = Color.GREEN
    val colorBlue = Color.BLUE

    val color = Color.GREEN
    when(color) {
        Color.RED -> print("Color is red")
        Color.GREEN -> print("Color is green")
        Color.BLUE -> print("Color is blue")
    }

    // ----- IF STATEMENT
//    if (now > openOffice) {
//        print("Office already open")
//    } else {
//        print("Office close")
//    }

    // ------ IF EXPRESSION
    // bisa disimpan langsung dalam suatu variable hasilnya
//    val office = if (now > openOffice) "Office already open" else "Office close"
//    print(office)


    // ------ WHEN
    val value = 7

    when(value){
        6 -> println("value is 6")
        7 -> println("value is 7")
        8 -> println("value is 8")
        else -> println("value cannot be reached")
    }

    // sama seperti if, bisa di buat atau disimpan langsung dalam variable
    val stringOfValue = when (value) {
        // data atau hasilnya juga bisa dibuat 2 baris, pakai {}
        6 -> {
            println("Six")
            "value is 6"
        }
        7 -> "value is 7"
        8 -> "value is 8"
        else -> "value cannot be reached"
    }

    println(stringOfValue)

    // contoh lain when, bisa makai is atau !is
    val anyType : Any = 100L
    when(anyType){
        is Long -> println("the value has a Long type")
        is String -> println("the value has a String type")
        else -> println("undefined")
    }

    // range (lngsung inisialisasi dengan ..)
    val valuee =  27
    val ranges = 10..50

    when(valuee){
        // memakai in
        in ranges -> println("value is in the range")
        !in ranges -> println("value is outside the range")
    }

    val registerNumber = when(val regis = getRegisterNumber()){
        in 1..50 -> 50 * regis
        in 51..100 -> 100 * regis
        else -> regis
    }

    // ------ WHILE
    var counter = 1
    while (counter <= 5){
        println("Hello, World!")
        counter++
    }

    // DO WHILE -> jalanin dulu baru cek kondisi
    do {
        println("Hello, World!")
        counter++
    } while (counter <= 5)

    // ---- RANGE
    val rangeInt = 1..10 // stepnya 1
    print("step: ")
    println(rangeInt.step)    // .step untuk hitung jarak dari 2 value
    val rangeInt2 = 1..10 step 2
    rangeInt2.forEach {
        print("$it")
    }
    println(rangeInt2.step) // stepnya 2


    // bisa buat dengan rangeTo
    val rangeInt3 = 1.rangeTo(10)
    val downInt = 10.downTo(1) // .downTo bikin urutan terbalik
    // mengecek jika value dalam range
    if (7 in downInt) {
        println("Value 7 available")
    }

    //bisa juga untuk char
    val rangeChar = 'A'.rangeTo('F')
    //val char = 'A'..'b'

    // ---------- For Loop
    for (i in ranges){
        //value dari ranges jga bisa diberikan step
        println("value is $i!")
    }

    // bisa kita dapatkan jga index valuenya
    for ((index, value) in ranges.withIndex()) {
        println("value $value with index $index")
    }

    // for each
    ranges.forEach { value ->
        println("value is $value!")
    }

    // -------- BREAK AND CONTINUE
    // jika break, ia akan keluar dari loop
    // jika continue, ia akan skip iterasi tersebut lalu lanjutkan iterasi

    val listOfInt = listOf(1, 2, 3, null, 5, null, 7)

    for (i in listOfInt) {
        if (i == null) continue
        //if (i == null) break
        print(i)
    }

    //Break continue label
    loop@ for (i in 1..10) {
        println("Outside Loop")

        for (j in 1..10) {
            println("Inside Loop")
            if ( j > 5) break@loop
        }
    }

}

fun getRegisterNumber() = Random.nextInt(100)