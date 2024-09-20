package com.dicoding.coroutines
import kotlinx.coroutines.*

/*
-------------- Job and Deferred --------------
fungsi async pada coroutines dibagi 2:
1. fungsi yg return hasil -> digunakan jika ingin sebuah data ketika fungsi selesai (deferred)
2. fungsi yg tidak return hasil -> untuk mengirim analitik, entry log, dll (job)
 */

/*
-------------- Job --------------
sebuah hasil dari perintah asynchronous yg dijalankan
objek Job akan merepresentasikan coroutine yg asli
Properti Job:
1. isActive
2. isCompleted
3. isCancelled

job akan segera dijalankan setelah dibuat, namun bisa tidak

State Job:
1. New -> Job baru diinisialisasi tapi blm pernah dijalankan
2. Active -> ketika ia sedang berjalan. Job yg di suspend juga termasuk Active
3. Completed -> ketika job sudah tidak berjalan
4. Canceling -> kondisi ketika cancel() dipanggil pada job yg aktif dan perlu waktu untuk proses cancel
5. Cancelled -> kondisi job sudah berhasil di cancel, job yg cancelled bisa dianggap Completed
 */

//menggunakan launch():
//fun main() = runBlocking {
//    val job = launch {
//        // Do background task here
//    }
//}

//menggunakan Job():
//fun main() = runBlocking {
//    val job = Job()
//}

//job setelah inisialisasi akan lngsung state New dan akan dijalankan
//bisa pakai CoroutineStart.LAZY agar tidak lngsung dijalankan

//untuk jalankan, pakai .start() ATAU .join()

//tambahkan @InternalCoroutinesApi jika mau getCancellationException
@InternalCoroutinesApi
fun main() = runBlocking {
    //CoroutineStart.LAZY -> bikin job tdk lngsung dijalankan
//    val job = launch(start = CoroutineStart.LAZY) {
//        delay(1000L)
//        println("Start new job!")
//    }
    //.start() -> akan mulai job tanpa menunggu job tersebut selesai
    //.join() -> akan menunda eksekusi sampai job selesai

    //job.start()
    //job.join()

    //println("Other task")

    //jika start, output -> other task baru start new job
    //jika join, output -> start new job baru other task

    // cancelling job

    //disini job2 akan jalan setelah 5 detik, namun karna ada delay 2 detik dibawah
    //.cancel akan jalan, dan cancel job2
    val job2 = launch {
        delay(5000)
        println("Start new job!")
    }

    delay(2000)
    //job2.cancel()
    job2.cancel(cause = CancellationException("time is up!"))
    println("Cancelling job...")
    if (job2.isCancelled){
        //println("Job is cancelled")
        println("Job is cancelled because ${job2.getCancellationException().message}")
    }
}