package com.dicoding.functional

/*
Kotlin Standard Library
 */

/*
Scope function
let, run, with, apply, also
 */

/*
Context Object
Lambda receiver (this) || run, with, apply
lambda argumen (it) || let, also

let || object.let { block }   ->  mengembalikan hasil blok (atau Unit)
run || object.run { block }  ->  mengembalikan objek
with || with(object) { block }  -> mengembalikan hasil blok.
apply || object.apply { block }  -> mengembalikan objek yang dimodifikasi.
also || object.also { block }  -> mengembalikan objek asli.

apply dan also akan mengembalikan sebuah context object.
let, run, dan with akan mengembalikan sebuah hasil berupa lambda.
 */

/*
----- LET ----
Kelebihan:
Menggunakan let memungkinkan penggunaan variabel dengan cakupan yang terbatas pada blok kode tertentu (block-scoping).
Dapat digunakan untuk mendeklarasikan variabel yang hanya akan digunakan di dalam blok tertentu.

Kekurangan:
Variabel yang dideklarasikan dengan let dapat di-reassign yang dapat menyebabkan perubahan tak terduga dalam program.
 */

/*
----- RUN -----
Kelebihan:
Menjalankan blok kode tertentu dan mengembalikan hasil eksekusi.
Berguna untuk mengeksekusi kode dengan lingkup (scope) yang terisolasi.

Kekurangan:
Pada beberapa kasus, penggunaan run mungkin membuat kode menjadi sulit dipahami karena blok kode dijalankan di luar konteks utama.
 */

/*
----- WITH ----
Kelebihan:
Dapat mempersingkat penulisan kode dengan memberikan blok kode akses langsung ke propertinya.
Berguna untuk menghindari penulisan berulang-ulang dari variabel tertentu.

Kekurangan:
Penggunaan yang tidak hati-hati dari with dapat menyebabkan ambiguitas dan kesalahan, terutama jika ada nama variabel yang sama di luar blok with.
 */

/*
---- Apply ----
Kelebihan:
Digunakan untuk memanggil fungsi dengan argumen yang diambil dari koleksi (biasanya array atau list).
Berguna untuk menjalankan fungsi dengan sejumlah argumen yang dinamis.

Kekurangan:
Dalam beberapa kasus, akan sulit untuk memahami kode yang menggunakan apply jika tidak jelas mengenai jenis dan jumlah argumen yang diharapkan.
 */

/*
----- Also ------
Kelebihan:
Berguna untuk melakukan beberapa operasi di dalam blok kode dan mengembalikan objek itu sendiri.
Meningkatkan pembacaan dan pemahaman kode.

Kekurangan:
Pemahaman yang kurang baik tentang penggunaan also dapat menyebabkan kesalahan atau membuat kode sulit dibaca.
 */
//Lambda receiver (this)
//penulisan this opsional
val buildString = StringBuilder().apply {
    append("Hello ")
    append("Kotlin ")
}

//lambda argumen (it)
//nilai dari argumen dapat diinisialisasikan



fun main () {
    // ---- lambda argumen
    val text = "Hello"
    //nama argumen default -> it
    text.let {
        val message = "$it Kotlin"
        println(message)
    }
    // bisa ubah nama argumennya
    text.let { value ->
        val message = "$value Kotlin"
        println(message)
    }

//    // apply: Menginisialisasi objek dan mengatur propertinya, kemudian mengembalikan objek tersebut
//    val personApply = Person("John", 25).apply {
//        println("apply: Initializing $name, age $age")
//    }
//
//// also: Melakukan tindakan tambahan pada objek dan mengembalikan objek tersebut
//    val personAlso = Person("Jane", 30).also {
//        println("also: Initializing ${it.name}, age ${it.age}")
//    }
//
//// let: Melakukan operasi pada objek dan mengembalikan hasil operasi tersebut
//    val personLet = Person("Bob", 22).let {
//        println("let: Initializing ${it.name}, age ${it.age}")
//        "Result: ${it.name} is ${it.age} years old" // return value
//    }
//    println("let result: $personLet")
//
//// run: Menjalankan blok kode pada objek dan mengembalikan hasil blok kode tersebut
//    val personRun = Person("Alice", 28).run {
//        println("run: Initializing $name, age $age")
//        "Result: $name is $age years old" // return value
//    }
//    println("run result: $personRun")
//
//// with: Menggunakan objek sebagai receiver untuk blok kode dan mengembalikan hasil blok kode tersebut
//    val personWithResult = with(Person("Charlie", 35)) {
//        println("with: Initializing $name, age $age")
//        "Result: $name is $age years old" // return value
//    }
}

