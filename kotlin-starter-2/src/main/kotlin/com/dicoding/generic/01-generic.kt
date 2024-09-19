package com.dicoding.generic

/*
----------- Generic ------------
memungkinkan suatu kelas / interface jadi tiper parameter
digunakan untuk menentukan tipe data yang akan kita gunakan.
 */

//tipe parameter: String
//<String> bisa kita hapus, karena kompiler sudah tau, kecuali blm ada data listnya
//val contributor = listOf<String>()
val contributor = listOf<String>("jasoet", "alfian","nrohmen","dimas","widy")

//bisa lebih dri 1 param, contoh: Map
val points = mapOf<String, Int>( "alfian" to 10 , "dimas" to 20 )
//dan lagi bisa disimpan seperti ini
//val points = mapOf("alfian" to 10, "dimas" to 20)

/*
------ GENERIC CLASS ----------
contoh:

class Box<T>(val item: T) {
    fun getItem(): T {
        return item
    }
}

fun main() {
    val intBox = Box(123)
    val stringBox = Box("Hello")

    println(intBox.getItem())    // Output: 123
    println(stringBox.getItem()) // Output: Hello
}
 */
// T ini nantinya hrus diisi dengan tipe data, saat implementasinya
interface List<T> {
    operator fun get(index: Int) : T
}

//tipe data long
class LongList : List<Long>{
    override fun get(index: Int): Long {
        return this[index]
    }
}

//tipe data generic
class ArrayList<T> : List<T>{
    private val items = mutableListOf<T>() // List internal untuk menyimpan data

    fun add(item: T) {
        items.add(item)
    }

    override fun get(index: Int): T {
        return items[index] // Mengambil item dari list
    }
}

/*
------- Fungsi Generic ------
jika kita butuh fungsi yg berhubungan dgn list
contoh:

fun <T> printItem(item: T) {
    println(item)
}

fun main() {
    printItem(123)      // Output: 123
    printItem("Hello")  // Output: Hello
}

 */
//fun <T> run(): T {
//    /*...*/
//}

//extension func
//public fun <T> List<T>.slice(indices: Iterable<Int>): List<T> {
//    /*...*/
//}


/*
------ Constraint Type Parameter --------
tambah : setelah tipe parameter
 */
//contoh: -> Number sebagai batasan tipe argumen, sehingga hanya bisa masukan tipe number (int, long, double)
//class ListNumber<T : Number> : List<T>{
//    override fun get(index: Int): T {
//        /* .. */
//    }
//}

//contoh lain
//fun <T : Number> List<T>.sumNumber() : T {
//    /* .. */
//}


/*
------- Variance -------
konsep menggambarkan tipe yg punya subtipe yg sma dan tipe argumen yg berkaitan
perlu ketika ingin buat kelas/fungsi generic dgn batasan yg tdk mengganggu penggunaannya
 */

abstract class Vehicle(wheel: Int)
class Car(speed: Int) : Vehicle(4)
class MotorCycle(speed: Int) : Vehicle(2)


/*
--------- Covariant -----------
menggunakan keyword out || hanya sebagai output (return value)
nilai dri tipe parameter tersebut hanya bisa diproduksi seperti jadikan ia return type
ibarat: ada kandang hewan -> Kandang<Binatang>. Ingin simpan subjenis binatang

open class Binatang
class Kucing : Binatang

class Kandang<out T : Binatang>(private val hewan: T) {
  fun dapatkanHewan(): T {
    return hewan
  }
}

val kandangKucing: Kandang<Kucing> = Kandang(Kucing())
val kandangBinatang: Kandang<Binatang> = kandangKucing // Covariant, dapat di-substitute
 */
interface Listt<out E> : Collection<E> {
    operator fun get(index: Int): E
    }

/*
------- Contravariant --------
menggunakan keyword in || hanya sebagai input (parameter)
nilai dari tipe parameter bisa dikonsumsi dengan jadikan sebagai tipe argumen untuk tiap fungsi dalam kelas
tidak untuk di produksi
ibarat: PenjagaKandang<Binatang>, ingin mengurus kandang2 yg berisi subjenis bintang

open class Binatang
class Kucing : Binatang

class PenjagaKandang<in T : Binatang> {
  fun urusKandang(hewan: T) {
    // Melakukan sesuatu dengan kandang yang berisi hewan
  }
}

val penjagaBinatang: PenjagaKandang<Binatang> = PenjagaKandang<Binatang>()
val penjagaKucing: PenjagaKandang<Kucing> = penjagaBinatang // Contravariant, dapat di-substitute
 */
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun main() {
    //generic class
    val longArrayList = ArrayList<Long>()
    longArrayList.add(100)
    val firstLong = longArrayList.get(0)
    println("first long: $firstLong")

    //generic function
    val numbers = (1..100).toList()
    print(numbers.slice<Int>(1..10))
    println()
    //jika nilai dalam list tipenya sama, tdk perlu buat <Int>
    print(numbers.slice(1..10))

    //Constraint Type
//    val numbers1 = ListNumber<Long>()
//    val numbers2 = ListNumber<Int>()
    //val numbers3 = ListNumber<String>() // error : Type argument is not within its bounds

    val numbers5 = listOf(1, 2, 3, 4, 5)
    //numbers5.sumNumber()
//    val names = listOf("dicoding", "academy")
//    names.sumNumber() // error : inferred type String is not a subtype of Number

    // Variance
    val car = Car(200)
    val motorCycle = MotorCycle(100)
    // car dan motorCycle merupakan subtipe dari vehicle
    var vehicle: Vehicle = car
    vehicle = motorCycle

    val carList = listOf(Car(100) , Car(120))
    val vehicleList = carList
}