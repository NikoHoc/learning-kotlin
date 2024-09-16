package com.dicoding.kotlin
import kotlin.reflect.KProperty

class DelegateName {
    // ini setter getter untuk string
    private var value: String = "Default"

    operator fun getValue(classRef: Any?, property: KProperty<*>) : String {
        println("Fungsi ini sama seperti getter untuk properti ${property.name} pada class $classRef")
        return value
    }

    operator fun setValue(classRef: Any?, property: KProperty<*>, newValue: String){
        println("Fungsi ini sama seperti setter untuk properti ${property.name} pada class $classRef")
        println("Nilai ${property.name} dari: $value akan berubah menjadi $newValue")
        value = newValue
    }
}

class DelegateGenericClass {
    private var value: Any = "Default"

    operator fun getValue(classRef: Any, property: KProperty<*>): Any {
        println("Fungsi ini sama seperti getter untuk properti ${property.name} pada class $classRef")
        return value
    }

    operator fun setValue(classRef: Any, property: KProperty<*>, newValue: Any) {
        println("Nilai ${property.name} dari: $value akan berubah menjadi $newValue")
        value = newValue
    }
}

class Animal () {
    var name: String = "Kucing"
        //  bisa buat getter dan setter manual dibawah variablenya
        get(){
            println("Fungsi Getter name terpanggil")
            return field
        }
        set(value){
            println("Fungsi Setter terpanggil")
            field = value
        }
        // namun hal ini tidak efisien
    //solusinya -> delegate || buat class baru (lihat diatas)
    //contoh manggilnya
    var names: String by DelegateName()

    // contoh manggil delegate any
    var weights: Any by DelegateGenericClass()
    var ages: Any by DelegateGenericClass()

    var weight: Double = 3.2
    var age: Int = 2
    var isMammal: Boolean = true

    fun eat(){
        println("$name makan!")
    }

    fun sleep() {
        println("$name tidur!")
    }


}
// ------- LATEINIT
//var names: String? = null -> cara buat variable null sementara
// Lateinit -> pemakaiannya harus benar (tdk bisa val) -> lateinit var ...
lateinit var names: String

// -------- LAZY PROPERTY
// lazy untuk membuat properti yg bukan null dan menunda inisialisasi
//kalau lazy, harus menggunakan val
val name2: String by lazy {
    "Dicoding Miaw"
}

fun main () {
    val dicodingCat = Animal()
    println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, mamalia: ${dicodingCat.isMammal}" )
    dicodingCat.eat()
    dicodingCat.sleep()

    // Mengubah Properti dari class dicodingCat
    //dicodingCat.name = "Kucing Oren"
    dicodingCat.weight = 6.0
    dicodingCat.age = 3
    println("Nama: ${dicodingCat.name}, Berat: ${dicodingCat.weight}, Umur: ${dicodingCat.age}, mamalia: ${dicodingCat.isMammal}" )
    dicodingCat.eat()
    dicodingCat.sleep()

    // PENGECEKAN LATE INIT
    names = "Dicoding Miaw"
    if (::names.isInitialized)
        println(names.length)
    else
        println("Not Initialized")

    val animal = Animal()
    animal.names = "Dicoding Miaw"
    println("Nama Hewan: ${animal.names}")

    animal.weights = 6.2
    animal.ages = 1
    println("Berat: ${animal.weights}")
    println("Umur: ${animal.ages} Tahun")
}