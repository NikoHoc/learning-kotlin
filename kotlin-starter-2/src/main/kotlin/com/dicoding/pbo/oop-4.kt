package com.dicoding.kotlin.com.dicoding.pbo

// ------- INTERFACE
// sama dengan abstract, namun dalam inisialisasi interface
// tdk ada properti yg di deklarasi & fungsi kosong

interface IFly {
    val numberOfWings: Int
    fun fly()
}

// jika interface ada propertinya, jga hrus di implement
class Bird(override val numberOfWings: Int) : IFly {
    // karena impelemen interface, maka hrus ada override function dari interface
    override fun fly() {
        if(numberOfWings > 0) println("Flying with $numberOfWings wings")
        else println("I'm Flying without wings")
    }
}

// Perbedaan abstract dan interface

/*
Abstract bisa ada default value, tiap properti tidak harus di override
agar bisa di override, gunakan abstract atau open di inisialisasi nya
 */
abstract class Animalsss {
    //default value not allowed
    abstract val age: Int //must be overridden

    //default value allowed
    open val isEating = true //optional to be overridden
    val isRespire = true //can not be overridden
}

/*
Interface tidak bisa default value, dan setiap properti harus di override
 */
interface IWalk {
    //default value not allowed
    val numberOfLeg: Int //must be overridden
    fun walk() //must be overridden
}

interface IDrink {
}

class Camel : Animalsss(), IWalk, IDrink {
    override val age: Int = 7   // this property must exist, try to remove it
    override val isEating = true // this property optional, try to remove it
    override val numberOfLeg = 2 // this property must exist, try to remove it
    override fun walk() { // this method  must exist, try to remove it
        println("Camel can walk")
    }
}

fun main(){
    val camel = Camel()
    camel.walk()
}