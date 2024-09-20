package com.dicoding.coroutines

import kotlinx.coroutines.*

/*
--------- Coroutine Dispatcher ----------
coroutine berjalan diatas thread, untuk tau di thread mana gunakan CoroutineDispatcher
 */

/*
Dispatchers.Default -> dasar dari semua standard builders seperti launch, async,dll

sebelumnya
launch {
    // TODO: Implement suspending lambda here
}

jika ingin pakai dispatcher default
launch(Dispatchers.Default){
    // TODO: Implement suspending lambda here
}
 */


/*
Dispatchers.IO -. untuk membongkar pemblokiran operasi I/O
menggunakan thread yg dibuat berdasarkan request

launch(Dispatcher.IO){
    // TODO: Implement algorithm here
}
 */


/*
Dispatchers.Unconfined -> menjalankan coroutines pada thread yg sedang jalan sampai titik delay
setelah itu akan lnjut pada thread yg komputasi delay yang dipanggil
misal:
ketika fungsi a memanggil fungsi b, yang dijalankan dengan dispatcher dalam thread tertentu,
fungsi a akan dilanjutkan dalam thread yang sama dengan fungsi b dijalankan.
 */



/*
--------- Single Thread Context ---------
menjamin tiap coroutine dijalankan pada thread yg kita tentukan
 */


/*
--------- Thread Pool ---------
dispatcher yg punya kumpulan thread
akan mulai coroutine di salah 1 thread, runtime akan menentukan thread mana yg tersedia
 */
fun main() = runBlocking<Unit> {
    //dispatchers unconfined
    launch(Dispatchers.Unconfined) {
        println("Starting in ${Thread.currentThread().name}")
        delay(1000)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()
    //output:
    // Starting in main
    //Resuming in kotlinx.coroutines.DefaultExecutor
    // -> coroutine dimulai dri main thread, delay, lalu lanjut pada thread DefaultExecutor


    //single thread context
    //beda dgn dispatcher unconfined, setelah delay, thread akan tetap pada myThread
    val dispatcher = newSingleThreadContext("myThread")
    launch(dispatcher) {
        println("Starting in ${Thread.currentThread().name}")
        delay(1000)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()


    //thread pool
    //disini punya sebanyak 3 pool
    val dispatcherThreadPool = newFixedThreadPoolContext(3, "myPool")

    launch(dispatcherThreadPool) {
        //nama threadnya akan: myPool-1, myPool-2
        println("Starting in ${Thread.currentThread().name}")
        delay(1000)
        println("Resuming in ${Thread.currentThread().name}")
    }.start()
}