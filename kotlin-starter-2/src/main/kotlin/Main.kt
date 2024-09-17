package com.dicoding.kotlin

//cara lain -> import packagenya agar efisien
//import com.dicoding.oop.utils.sayHello
//import com.dicoding.oop.utils.PI
//import com.dicoding.oop.utils.factorial
//import com.dicoding.oop.utils.pow

// bisa kita import saja semua pakai *
import com.dicoding.oop.utils.*

fun main(){
    // cara manggil biasa, harus ketik nama package
    //com.dicoding.oop.utils.sayHello()

    //karna suda di import, makanya tinggal ketik sesuai yg kita import
    sayHello()
    println(factorial(4.0))
    println(pow(3.0, 2.0))
    println(PI)
    println(areaOfCircle(13.0))
}