package com.dicoding.kotlin.com.dicoding.spco

//Singleton Object, Companion Object, & Anonymous Class

/*
Singleton object -> pattern untuk memastikan object hanya punya 1 instance
dengan menggunakan keyword object
 */
object CentralLibrary {
    fun borrowBookById(id: Int) {
        print("Book with $id has been borrowed")
    }
}

/*
Companion object -> untuk membuat inner object secara langsung dalam class
membuat static (konstanta) object di dalam class
 */
class Library {
    companion object{
        fun borrowBookById(id: Int) {
            println("Book with $id has been borrowed")
        }
    }
}
class MyLibrary {
    // Const 'val' are only allowed on top level, in named objects, or in companion objects
    // const val LIBRARY_NAME = "Dicoding Library"

    //companion jga bisa digunakan untuk konstanta
    //namun untuk konstanta hanya bisa di buat di dalam object
    companion object{
        // jika buat constanta, buat huruf kapital semua
        const val LIBRARY_NAME = "Dicoding Library"
    }

    fun totalBook() {
        print("Total book in $LIBRARY_NAME is unlimited")
    }
}
/*
bedanya val dan const val
val -> didefinisikan saat runtime
const val -> didefinisikan saat compile time
conclusion: const val harus di deklarasikan langsung, bukan dalam/saat manggil fungsi

contoh:
const val LIBRARY_NAME = "Dicoding Library" // OK
const val LIBRARY_NAME_A = LIBRARY_NAME.lowercase() // Const 'val' initializer should be a constant value
val LIBRARY_NAME_B = LIBRARY_NAME.lowercase() // OK
 */
//


/*
ANONYMOUS CLASS
*/
interface IFlyy {
    fun fly()
}

fun flyWithWings(bird: IFlyy) {
    bird.fly()
}

//class sebelum pakai anonymous, hrus buat class
//class Birdd : IFlyy {
//    override fun fly() {
//        println("The Bird flying")
//    }
//}

// function interface (Single Abstract Method -> SAM)
// tambahkan "fun" sebelum interface
fun interface IFlys {
    fun fly()
}

fun flyWithWings(bird: IFlys) {
    bird.fly()
}



fun main() {
    //singleton
    // dengan menggunakan singleton -> object, maka saat manggil functionnya
    // kita tidak perlu inisialisasi objectnya seperti jika kita makai class biasa
    CentralLibrary.borrowBookById(21)


    //companion -> .Companion opsional, bisa lngsung nama function
    Library.borrowBookById(21)
    Library.borrowBookById(21)

    //jika ingin akses seperti ini, maka functionay pindahkan ke companion object
    //MyLibrary.totalBook()

    val name = MyLibrary.LIBRARY_NAME
    println("$name")

    // ANONYMOUS CLASS
    //manggil class sebelumnya
    //flyWithWings(Birdd())

    // dengan anonymous bisa langsung
    flyWithWings(object : IFlyy {
        override fun fly() {
            println("The Bird flying")
        }
    })

    // setelah gunakan SAM / function interface
    // manggilnya jadi seperti ini
    flyWithWings {
        println("The Bird flying")
    }

}