package com.dicoding.coroutines
import kotlinx.coroutines.*

/*
---------- Deferred ----------
merupakan nilai yg dikembalikan dari fungsi async
berupa hasil atau exception

nilai tangguhan yang dihasilkan dari proses coroutines

memberikan hasil ketika proses komputasi sukses, ia juga bisa memberikan hasil saat proses tersebut gagal.

hasil deferred akan tersedia saat state completed, diakses dengan await
jika gagal, bisa akses nilai gagalnya dgn getCompletionExceptionOrNull

 */

suspend fun getCapitall(): Int {
    //delay ibarat waktu untuk operasi
    delay(1000L)
    return 50000
}

suspend fun getIncomee(): Int {
    //delay ibarat waktu untuk operasi
    delay(1000L)
    return 75000
}

fun main() = runBlocking {
    val capital = async { getCapitall() }
    val income = async { getIncomee() }
    println("Your profit is ${income.await() - capital.await()}")

    val deferred: Deferred<Int> = async {
        delay(1000L)
        return@async 42  // Mengembalikan hasil berupa nilai integer
    }
    println("Result: ${deferred.await()}")
}
