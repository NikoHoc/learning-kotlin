package com.dicoding.kotlin

/*
------------- ENUM CLASS
untuk menyimpan objek yg tipe datanya konstanta
*/
enum class Colorr(val value: Int) {
    /*
    // Inisialisasi biasa
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
    */

    //bisa tambahkan abstract function & anonymous class tiap objek
    RED(0xFF0000){
        override fun printValue() {
            println("value of RED is $value")
        }
    },
    GREEN(0x00FF00){
        override fun printValue() {
            println("value of GREEN is $value")
        }
    },
    BLUE(0x0000FF){
        override fun printValue() {
            println("value of BLUE is $value")
        }
    };

    abstract fun printValue()
}

fun main() {
    val colorRed = Colorr.RED
    val colorGreen = Colorr.GREEN
    val colorBlue = Colorr.BLUE

    // cara akses data di enum class
    //val color : Colorr = Colorr.RED

    // enum class yg ada sintetik method bisa kita buat objek enum
    //.values() -> untuk mengambil semua value objek enum
    val colors: Array<Color> = Color.values()
    colors.forEach { color ->
        print("$color ")
    }

    // .valueOf() -> untuk dapatkan 1 objek value
    val color: Color = Color.valueOf("RED")
    println("Color is $color")
    println("Color value is ${color.value.toString(16)}")


    // cara lain ngambil enum
    //enumValues()
    val colorss: Array<Color> = enumValues()
    colors.forEach {color ->
        println(color)
    }
    //enumValueOf()
    val colorRedd: Color = enumValueOf("RED")
    println("Color is $color")

    //ordinal -> untuk dapat posisi objek di enum (mirip index di array)
    val colorGreenn: Color = Color.GREEN

    print("Position GREEN is ${colorGreenn.ordinal}")

    //ngecek instace dari objek enum
    when(color){
        Color.RED -> print("Color is Red")
        Color.BLUE -> print("Color is Blue")
        Color.GREEN -> print("Color is Green")
    }
}
