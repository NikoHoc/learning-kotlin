package com.dicoding.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

/*
----------- Channels -----------

1 program punya bnyk thread, dalam thread terdapat jutaan coroutines
jika ada 2 coroutines yg ingin berinteraksi -> pakai Channels

adalah nilai deferred,
menyediakan cara mudah untuk mentransfer nilai tunggal antara coroutine.

mirip BlockingQueue
 */

fun main() = runBlocking(CoroutineName("main")) {
    val channel = Channel<Int>()
    launch(CoroutineName("v1coroutine")){
        println("Sending from ${Thread.currentThread().name}")
        for (x in 1..5) channel.send(x * x)
    }

    repeat(5) { println(channel.receive()) }
    println("received in ${Thread.currentThread().name}")
}