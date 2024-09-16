package com.dicoding.kotlin

// class dengan primary constructor
class Animals(val name: String, val weight: Double, val age: Int = 0, val isMammal: Boolean)

// init block
class Animall(pName: String, pWeight: Double, pAge: Int, pIsMammal: Boolean){
    val name: String
    val weight: Double
    val age: Int
    val isMammal: Boolean

    init {
        // bisa gunakan this.bla3
        weight = if(pWeight < 0) 0.1 else pWeight
        age = if(pAge < 0) 0 else pAge
        this.name = pName
        this.isMammal = pIsMammal
    }
}

//class with secondary constructor
private class AnimalSecond(name: String, weight: Double, age: Int) {
    val name: String
    val weight: Double
    internal val age: Int
    var isMammal: Boolean

    init {
        this.weight = if(weight < 0) 0.1 else weight
        this.age = if(age < 0) 0  else age
        this.name = name
        this.isMammal = false
    }

    constructor(name: String, weight: Double, age: Int, isMammal: Boolean) : this(name, weight, age) {
        this.isMammal = isMammal
    }
}

//default constructor -> valuenya diisi semua langsung
//class Animal{
//    val name: String = "Dicoding Miaw"
//    val weight: Double = 4.2
//    val age: Int = 2
//    val isMammal: Boolean = true
//}

//overloading
class Calculator {
    //nama fungsi sama, parameternya beda
    fun add(value1: Int, value2: Int) = value1 + value2
    fun add(value1: Int, value2: Int, value3: Int) = value1 + value2 + value3
    fun add(value1: Double, value2: Double) = value1 + value2
    fun add(value1: Float, value2: Float) = value1 + value2

    fun min(value1: Int, value2: Int) = if (value1 < value2) value1 else value2
    fun min(value1: Double, value2: Double) = if (value1 < value2) value1 else value2
}

fun main(){
    //class animals
    val dicodingCat = Animals("Dicoding Miaw", 4.2, 2, true)
    println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, mamalia: ${dicodingCat.isMammal}" )
    val dicodingCats = Animals("Dicoding Miaw", 4.2, isMammal =  true)

    //class animall -> init block
    val dicodingCatt = Animall("Dicoding Miaw", -1.0, -1, true)
    println("Nama: ${dicodingCatt.name}, Berat: ${dicodingCatt.weight}, Umur: ${dicodingCatt.age}, mamalia: ${dicodingCatt.isMammal}")

    //class AnimalSecond
    val catSecond = AnimalSecond("Dicoding Miaw", 2.5, 2, true)
    println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, mamalia: ${dicodingCat.isMammal}")

    //dengan ada second constructor bisa kita atur parameter apa aja yang disimpan
    val dicodingBird = AnimalSecond("Dicoding tweet", 0.5, 1)
    println("Nama: ${dicodingBird.name}, Berat: ${dicodingBird.weight}, Umur: ${dicodingBird.age}, mamalia: ${dicodingBird.isMammal}")

    // contoh manggil class yang ada overloading function
    val calc = Calculator()

    println(calc.add(2, 4))
    println(calc.add(2.5, 2.2))
    println(calc.add(6f, 7f))
    println(calc.add(1, 2, 3))

    println(calc.min(9, 2))
    println(calc.min(17.2, 18.3))
}

// ---- VISIBILITY MODIFIERS
//Public: dapat diakses dari manapun.

//Private: hanya dapat diakses pada scope yang sama.
// contoh private: -> dipakai di parameter
//class Animal(private var name: String, private val weight: Double, private val age: Int, private val isMammal: Boolean = true) {
//
//    fun getName() : String {
//        return name
//    }
//
//    fun setName(newName: String) {
//        name = newName
//    }
//
//}


//Protected: Anggota hanya dapat diakses pada kelas turunannya atau kelas itu sendiri.
open class Animalss(val name: String, protected val weight: Double)

class Cat(pName: String, pWeight: Double) : Animalss(pName, pWeight)
//cat weight tidak bisa diakses jika dari main
//di class cat hrus tmbhkan function untuk mendapatkan nilai weightnya


//Internal: tidak dapat diakses diluar dari modulnya tersebut.