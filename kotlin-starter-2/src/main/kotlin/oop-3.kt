package com.dicoding.kotlin

//-------- Inheritances
//parent class Animalll
abstract class Animalll(val name: String, val weight: Double, val age: Int, val isCarnivore: Boolean){

    open fun eat(){
        println("$name sedang makan!")
    }

    open fun sleep(){
        println("$name sedang tidur!")
    }
}

// child class Catt pakai : Animalll
class Catt(pName: String, pWeight: Double, pAge: Int, pIsCarnivore: Boolean, val furColor: String, val numberOfFeet: Int)
    : Animalll(pName, pWeight, pAge, pIsCarnivore) {

    fun playWithHuman() {
        println("$name bermain bersama Manusia !")
    }

    //override menandakan kita merubah isi function dari parent
    // jika ingin mengambil isi dri function parent, gunakan super
    override fun eat(){
        super.eat() // -> akan manggil function eat di parent lalu jalankan bawahnya
        println("$name sedang memakan ikan !")
    }

    override fun sleep() {
        println("$name sedang tidur di bantal !")
    }
}


// Abstract -> membuat sebuah class tidak dapat di inisialisasikan sebagai objek
// sehingga class abstract dibuat untuk mewarisi sifatnya ke child classnya
// diawal bikin class, tinggal tambahkan abstract

// bedanya open dengan abstract ->
// open parent bisa di inisialisasi sebagai objek, child tidak wajib override
fun main () {
    val dicodingCat = Catt("Dicoding Miaw", 3.2, 2, true, "Brown", 4)

    dicodingCat.playWithHuman()
    dicodingCat.eat()
    dicodingCat.sleep()
}