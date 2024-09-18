package com.dicoding.pbo

import kotlin.NumberFormatException

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

    /*
    --------- EXCEPTION ---------
    ArithmeticException -> bilangan dibagi nol
    NumberFormatException -> format valuenya tidak sesuai
    NullPointerException -> valuenya null
     */

    /*
    -------- EXCEPTION HANDLING -------
    try {
    // Block try, menyimpan kode yang membangkitkan exception
    } catch (e: SomeException) {
        // Block catch akan terpanggil ketika exception bangkit.
    } finally {
    }
     */
    val someNullValue: String? = null
    lateinit var someMustNotNullValue: String

    try {
        someMustNotNullValue = someNullValue!!
        println(someMustNotNullValue)
    } catch (e: Exception) {
        someMustNotNullValue = "Nilai String Null"
        //println(someMustNotNullValue) -> dipindah ke finally
    } finally {
        println(someMustNotNullValue)
    }

    /*
    ------------------------------------
        Bisa juga multiple catch
     */

    val someStringValue: String? = null
    var someIntValue: Int = 0

    try {
        someIntValue = someStringValue!!.toInt()
    } catch (e: NullPointerException) {
        someIntValue = 0
    } catch (e: NumberFormatException) {
        someIntValue = -1
    } finally {
        when(someIntValue){
            0 -> println("Catch block NullPointerException terpanggil !")
            -1 -> println("Catch block NumberFormatException terpanggil !")
            else -> println(someIntValue)
        }
    }
}