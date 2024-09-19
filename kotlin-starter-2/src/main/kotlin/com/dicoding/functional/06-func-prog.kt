package com.dicoding.functional

/*
Function inside function
 */

fun setWord(message: String) {
    //logic lama
//    fun printMessage(text: String) {
//        println(text)
//    }
//    printMessage(message)

    //inner function hanya bisa diakses setelah fungsi tersebut didefinisikan

    //logic baru -> kita bisa akses apa yg menjadi bagian fungsi terluarnya
    fun printMessage() {
        println(message)
    }

    printMessage()
}

fun sum(valueA: Int, valueB: Int, valueC: Int): Int {
    //terlalu banyak if
//    if (valueA == 0) {
//        throw IllegalArgumentException("valueA must be better than 0")
//    }
//    if (valueB == 0) {
//        throw IllegalArgumentException("valueB must be better than 0")
//    }
//    if (valueC == 0) {
//        throw IllegalArgumentException("valueC must be better than 0")
//    }

    //bisa kita ubah seperti ini
    fun validateNumber(value: Int) {
        if (value == 0) {
            throw IllegalArgumentException("value must be better than 0")
        }
    }
    validateNumber(valueA)
    validateNumber(valueB)
    validateNumber(valueC)

    //cara lain -> buat validateNumber jadi extension function
    fun Int.validateNumber(){
        if (this == 0) {
            throw IllegalArgumentException("value must be better than 0")
        }
    }
    valueA.validateNumber()
    valueB.validateNumber()
    valueC.validateNumber()

    return valueA + valueB + valueC
}


/*
------ RECURSION -------
 */

//fun factorial(n: Int): Int {
//    return if (n == 1) {
//        n
//    } else {
//        var result = 1
//        for (i in 1..n) {
//            result *= i
//        }
//        result
//    }
//}

fun factorialRecursive(n: Int): Int {
    return if (n == 1) {
        n
    } else {
        n * factorialRecursive(n - 1)
    }
}

/*
Tail call recursion
sekumpulan urutan instruksi untuk menjalankan tugas tertentu (subroutine)
yang dijalankan terakhir pada sebuah prosedur.

memastikan proses sebelumnya selesai sebelum lanjut ke pemanggilan berikut
 */

//tambahkan tailrec untuk mengoptimisasikannya (menghindari tumpukan frame)
tailrec fun factorial(n: Int, result: Int = 1): Int {
    val newResult = n * result
    return if (n == 1) {
        newResult
    } else {
        factorial(n - 1, newResult)
    }
}
fun main() {
    println("Factorial 9999 is: ${factorialRecursive(9999)}")
}
