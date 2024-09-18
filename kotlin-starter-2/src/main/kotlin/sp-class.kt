package com.dicoding.kotlin

/*
------------- class --------------
Data Class: dirancang khusus untuk menyimpan data. Otomatis terdapat fungsi equals(), hashCode(), toString(), dan copy().
Nested Class: membuat Class di dalam Class tanpa akses ke kelas induk.
Inner Class: membuat Class di dalam Class dengan akses ke kelas induk.
Enum Class: tipe data dengan sekumpulan nilai konstan yang telah ditentukan.
Sealed Class: digunakan untuk pembatasan hierarki class.
 */

/*
----------- Collection ------------
List: untuk menyimpan nilai bebas dengan index (boleh sama).
Set: untuk menyimpan nilai yang unik (tidak boleh sama).
Map: untuk menyimpan dengan format key to value (key tidak boleh sama).
 */


// --------- data class
/*
Konstruktor utama pada kelas tersebut harus memiliki setidaknya satu parameter;
Semua konstruktor utama perlu dideklarasikan sebagai val atau var;
Modifier dari sebuah data class tidak bisa abstract, open, sealed, atau inner.
 */
class User(val name : String, val age : Int)  {
    // -> com.dicoding.kotlin.User@12edcd21
    // karna class biasa, perlu buat function to string agar valuenya bisa di akses
    override fun toString(): String {
        return "User(name=$name, age=$age)"
    }

    // beda dengan class biasa, hrus buat fungsi sendiri untuk equal
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }
}

//data class akan secara otomatis menghasilkan fungsi toString()
data class DataUser(val name : String, val age : Int) // -> DataUser(name=nrohmen, age=17)

fun main(){
    val user = User("nrohmen", 17)
    val dataUser = DataUser("nrohmen", 17)

    println(user)
    println(dataUser)

    //data class ada equals
    val dataUser1 = DataUser("nrohmen", 17)
    val dataUser2 = DataUser("nrohmen", 17)
    val dataUser3 = DataUser("dimas", 24)
    // dataclass ada fitur copy()
    val dataUser4 = dataUser.copy()
    val dataUser5 = dataUser.copy(age = 18) // bisa ubah jga valuenya

    println(dataUser1.equals(dataUser2))
    println(dataUser1.equals(dataUser3))
}