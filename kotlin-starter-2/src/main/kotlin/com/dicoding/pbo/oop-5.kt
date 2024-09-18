package com.dicoding.kotlin.com.dicoding.pbo
// ------- Extension


//Extension functions
// receiver type.
fun Int.printInt() {
    print("value $this")
}

fun Int.plusThree(): Int {
    return this + 3
}

//Extension properties
val Int.slice: Int
    get() = this / 2

// ---------------- Infix function
/*
cara lain dalam memanggil function -> tambahkan infix di depan function

Infix function harus merupakan sebuah member function atau extension function.
Harus memiliki satu parameter saja.
Parameter tidak boleh berupa generic dan tidak memiliki nilai default.
 */
infix fun Int.sum(value: Int): Int {
    return this + value
}

// ----- Nullable receiver
// extension ini bisa digabung dgn nullable receiver
val Int?.slice: Int
    //if biasa
    //get() = if (this == null) 0 else this.div(2)
    // dengan elvis operator
    get() = this?.div(2) ?: 0

fun main() {
    //manggil extension functions
    10.printInt()
    println(3.plusThree())

    // manggil extension properties
    println(10.slice)

    //manggil function biasa
    //val result = 5.sum(3)
    val result = 5 sum 3 // Menggunakan Infix Function

    val value: Int? = null
    val value1: Int? = null

    println(value?.slice)
    println(value1?.slice)
}

// contoh infix function
class MyHero {
    infix fun addHero(s: String) { /*...*/ }

    fun build() {
        this addHero "Superman"   // Correct
        addHero("Spidermen")       // Correct
        //  addHero "Ironman"        // Incorrect: the receiver must be specified
    }
}