package com.dicoding.coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


/*
-------------- Coroutines Builder --------------
launch -> untuk memulai sebuah coroutines yg tdk mengembalikan hasil
launch menghasilkan job yg bisa kita gunakan untuk batalkan eksekusi

runBlocking -> jembatan blocking code dgn kode yg dpt ditangguhkan
ini akan memblokir sebuah thread yg sedang berjalan hingga eksekusi coroutine selesai
bisa pada main() dan bisa pada unit test


async -> untuk memulai coroutine yg akan mengembalikan sebuah hasil
ia akan menangkap exception yg terjadi dalam coroutine.
async akan mengembalikan Deferred yg berisi hasil/exception.
 */

suspend fun getCapital(): Int {
    //delay ibarat waktu untuk operasi
    delay(1000L)
    return 50000
}

suspend fun getIncome(): Int {
    //delay ibarat waktu untuk operasi
    delay(1000L)
    return 75000
}
fun main() = runBlocking{
    //runBlocking dan launch
//    // pertama launch -> delay 1 detik -> "Hello" terprint -> coroutines terprint -> delay 2detik -> program selesai
//    launch {
//        delay(1000L)
//        println("Coroutines!")
//    }
//    println("Hello,")
//    delay(2000L)

    //async
    //jika tidak ada ketergantungan antara getCapital dan getIncome
    // dan kita ingin menjalankan keduanya secara bersamaan? pakai async
    // tambahkan async {function}
//    val capital = async {getCapital()}
//    val income = async {getIncome()}
    // sebelum pakai async -> ${income - capital}
    //sesudahnya harus pakai .await()
//    println("Your profit is ${income.await() - capital.await()}")

    //Dengan async seolah-olah kedua fungsi tersebut berjalan bersamaan
    // waktunya jg lebih singkat dari kode sebelumnya.

    //timeOne -> tidak async
    val timeOne = measureTimeMillis {
        val capital = getCapital()
        val income = getIncome()
        println("Your profit is ${income - capital}")
    }

    //timeTwo -> dengan async
    val timeTwo = measureTimeMillis {
        val capital = async { getCapital() }
        val income = async { getIncome() }
        println("Your profit is ${income.await() - capital.await()}")
    }

    //output: yg async lebih cepat, karna fungsi getCapital dan income bersamaan
    println("Timeone: $timeOne ms \nTimeTow: $timeTwo ms")
}