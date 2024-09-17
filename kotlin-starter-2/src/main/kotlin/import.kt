package com.dicoding.kotlin

// ----- IMPORT
/*
import packagename.ClassName
import packagename.functionName
import packagename.propertyName
 */

// import packagename.ClassName.tes -> sehingga saat manggil tinggal ketik tes
import kotlin.random.Random

//val someInt = Random(0).nextInt(1, 10)

// bisa gunakan as sebagai sebutan nya
import kotlin.math.PI
import kotlin.math.cos as cosinus
import kotlin.math.sqrt as akar

//bisa import semua nya pakai *
import kotlin.math.*

fun main(){
    println(PI)
    //cara manggil sebelum menggunakan as
    //println(cos(120.0))
    //cara manggil dengan as
    println(cosinus(120.0))

    //println(sqrt(9.0))
    println(akar(9.0))
}