package com.dicoding.functional

fun getFullAddress(streetName: String, number: Int): String {
    return "I live in $streetName No. $number"
}
fun main( ) {
    println(getFullAddress(number = 5, streetName = "sada"))
    for (i in 10.rangeTo(11)) {
        print("$i ")
    }

    val tim = arrayOf("andi", "budi", "cindy")
    tim.map { nama ->
        println("Nama: $nama")
    }
    println()
    tim.forEach { nama ->
        println("Nama: $nama")
    }

    println()
    with(tim) {
        forEach { nama ->
            println("Nama: $nama")
        }
    }
    println()
    tim.apply {
        forEach { nama ->
            println("Nama: $nama")
        }
    }
}