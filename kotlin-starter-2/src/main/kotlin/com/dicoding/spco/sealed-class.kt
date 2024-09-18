package com.dicoding.kotlin.com.dicoding.spco

/*
SEALED CLASS
mirip dengan enum namun lebih fleksibel
 */

// dengan enum class
//enum class Result {
//    SUCCESS,
//    ERROR,
//    LOADING
//}

// dengan sealed class
sealed class Result {
    // kalau enum, objeknya harus sama tipenya
    // sealed, objeknya bisa berbeda2 tipe
    //sealed class Success(val data: Any) : Result()
    // jika ingin aksed objek success yg sealed class, perlu definisikan lagi
    //karna sealed class ga bisa di akses lngsung
    sealed class Success(val data: Any) : Result() {
        // Misalkan kita buat subclass untuk tipe data yang spesifik
        data class DataSuccess(val specificData: String) : Success(specificData)
    }
    data class Error(val message: String) : Result()
    object Loading : Result()
}

fun main() {
    val result: Result = Result.Error("Oops!")
    when (result) {
        //jika salah satu kondisi dihapus, kode akan error
        is Result.Success -> {
            println("Success: ${result.data}")
        }
        is Result.Error -> {
            println("Error: ${result.message}")
        }
        is Result.Loading -> {
            println("Loading...")
        }
    }

    //manggil data success dari sealed classnya
    val result1: Result = Result.Success.DataSuccess("Data berhasil dimuat!")

    when (result1) {
        is Result.Success.DataSuccess -> {
            println("Success: ${result1.specificData}")
        }
        is Result.Error -> {
            println("Error: ${result1.message}")
        }
        is Result.Loading -> {
            println("Loading...")
        }
    }
}