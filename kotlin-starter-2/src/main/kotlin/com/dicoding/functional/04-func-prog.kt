package com.dicoding.functional

/*
Scope Function - Lambda Receiver
pakai this
--------- RUN ----------
mengembalikan nilai berdasarkan expression yang berada di dalam blok lambda
menggunakan this

-------- WITH ------
Konteks objeknya disematkan sebagai argumen dan dari blok lambda diakses sebagai receiver.
nilai berdasarkan expression di dalam lambda

------ APPLY ---------
nilai yang dikembalikan dari fungsi apply adalah nilai dari konteks objeknya
 */


/*
Scope Function - Lambda Argument
pakai it
-------- LET -----------
akan bnyk ditemukan di objek tipe nullable


-------- Also ----------
mirip apply, namun pakai it
 */

fun main() {
    //  RUN
    val text = "Hello"
    val resultRun = text.run {
        val from = this

        val to = this.replace("Hello", "Kotlin")
        "replace text from $from to $to"
    }
    println("result : $resultRun")

    // WITH
    val message = "Hello Kotlin!"
    val resultWith = with(message) {
        "First character is ${this[0]}" +
                " and last character is ${this[this.length - 1]}"
    }
    println(resultWith)

    //Apply
    //sebelum
    val builder = StringBuilder()
    builder.append("Hello ")
    builder.append("Kotlin!")

    println(builder.toString())

    //sesudah
    val messageApply = StringBuilder().apply {
        append("Hello ")
        append("Kotlin!")
    }

    println(messageApply.toString())

    //LET
    //pakai it
    val messageLet: String? = null
    messageLet?.let {
        val length = it.length * 2
        val text = "text length $length"
        println(text)
    }
    //jika objek null, bisa digabung dengan run
    messageLet?.let {
        val length = it.length * 2
        val text = "text length $length"
        println(text)
    } ?: run {
        val text = "message is null"
        println(text)
    }

    // also
    //dipakai jga mau pakai konteks dri objek sebagai argumen tanpa ubah nilainya
    val textt = "Hello Kotlin"
    val resultAlso = textt.also {
        println("value length -> ${it.length}")
    }

    println("text -> $resultAlso")
}