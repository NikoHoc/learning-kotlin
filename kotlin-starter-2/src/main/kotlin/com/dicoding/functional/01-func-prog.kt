package com.dicoding.functional

/*
FUNCTION TYPE
 */
// typealias -> 1 fungsi yg punya function dengan type yg sama
//typealias Arithmetic = (Int, Int) -> Int // bisa dipakai beberapa kali dgn nama function beda
//bisa kita ubah type jdi nullable

typealias Arithmetic = ((Int, Int) -> Int)?

/*
LAMBDA
disebut anonymous function / function literal
Fungsi biasa:
fun getMessage(name: String): String {
   return "Hello $name"
}

fungsi lambda: (ga butuh "fun")
val message :(String) -> String = { name: String ->
   "Hello $name"
}
 */
// lambda expression
val message = { println("Hello From Lambda") }

val printMessage = { message: String -> println(message) }

val messageLength = { message: String -> message.length }

fun main() {
    //----- function type
    val sum: Arithmetic = { valueA, valueB -> valueA + valueB }

    val multiply: Arithmetic = { valueA, valueB -> valueA * valueB }

    //.invoke() -> untuk panggil function
    //jika nullable, tambahkan jga safe call operator ?.invoke()
    val sumResult = sum?.invoke(10, 10)
    val multiplyResult = multiply?.invoke(20, 20)

    // invoke tidak harus ditulis
//    val sumResult = sum(10, 10)
//    val multiplyResult = multiply(20, 20)

    // ------ Lambda Expression
    //yg sebelumnya seperti ini
//    val comparator = object :Runnable{
//        override fun run() {
//            // TODO:
//        }
//    }

    // jadi seperti ini
    val comparator = Runnable {
        // TODO:
    }

    message()
    printMessage("Hello From Lambda")

    val length = messageLength("Hello From lambda")
    println("Message length $length")

    val ranges = 1.rangeTo(10) step 3
    ranges.forEach { value ->
        println("value is $value!")
    }
    //forEachIndexed -> bisa tau value tersebut di indx ke berapa
    ranges.forEachIndexed { index, value ->
        println("value $value with index $index")
    }
    //parameter forEachIndexed -> index, value || jika tdk perlu value, ubah jadi _
    ranges.forEachIndexed { index, _ ->
        println("index $index")
    }
}