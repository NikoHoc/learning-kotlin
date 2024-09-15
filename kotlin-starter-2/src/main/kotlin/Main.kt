package com.dicoding.kotlin

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    for (i in 1..5) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        println("i = $i")
    }

    // ----------- DATA TYPE -----------
    //val tidak bisa diubah
    var name2:String = "Alfian"
    name2 = "Niko"

    // SAFE CALL OPERATOR
    // karna null jika mau cari panjang textnya, tambah tanda tanya juga
    val text:String? = null
    val textLength = text?.length

    //Elvis Operator
    //default value dari objek jika null
    val textt:String? = null
    val texttLength = textt?.length?:0

    //String tempalte -> bisa ketik $var untuk dijadikan satu dalam string
    print("Hello my name is $name2")
    println(name2)
    println(if (false) "Always true" else "Always false")
    // bisa juga ada operation di dalamnya
    val hour = 7
    println("Office ${if (hour > 7) "already close" else "is open"}")

    //ARRAY COLLECTION
    //listOf -> value bisa sama
    val integerList =  listOf(4,23,12, 23,1) // output: 4, 23, 12, 23, 1
    //setOf -> value harus unik
    val integerSet = setOf(4,3,32,3, 2) // output: 4, 3, 32, 2
    //mapOf
    val capital = mapOf(
        "jakarta" to "indonesia",
        "London" to "England",
        "New Delhi" to "India",
    ) // memanggil: capital['jakarta'] ATAU capital.getValue("jakarta")

    //MUTABLE VS LIST
    // mutableListOf -> bisa di tambah (dinamik)
    val anyList = mutableListOf('a', "kotlin", 3, true)
    anyList.add('d') //nambah item di akhir list
    anyList.add(1, "niko") //nambah item di list sesuai index
    anyList[3] = false // mengubah value pada index tertentu
    anyList.removeAt(1) // hapus value

    /*
    * ESCAPED STRING
    * \t -> tab (spasi tab) di string
    * \n -> bikin baris baru di string
    * \'  \' -> nambah petik 1 di string
    * \"  \" ->nambah petik dua di string
    * \\ -> nambah 1 backslash di string
    */
    val statement = "Kotlin is \"Awesome!\""
    val statement2 = "Kotlin is \\Awesome"
    println(statement2)


    // raw string
    /*
    // cara lama di java
    val line = "Line 1\n" +
            "Line 2\n" +
            "Line 3\n" +
            "Line 4\n"
     */

    // cara di kotlin pakai triple quote """ """ lalu pakai trimIndent()
    val line = """
        Line 1
        Line 2
        Line 3
        Line 4
    """.trimIndent()
    println(line)



    //------- IF STATEMENT ----------
    val openHours = 7
    val now = 20
    val office: String
    //if biasa
//    if (now > openHours) {
//        office = "Office already open"
//    } else {
//        office = "Office is closed"
//    }

    // cara lain if, bisa di simpan lngsung dalam variabel
    office = if (now > 7) {
        "Office already open"
    } else if (now == openHours){
        "Wait a minute, office will be open"
    } else {
        "Office is closed"
    }
    print(office)

    // ------- BOOLEAN ------
    val officeOpen = 7
    val officeClosed = 16
//    val isOpen = if (now >= officeOpen && now <= officeClosed){
//        true
//    } else {
//        false
//    }
    // sederhananya
    val isOpen = now >= officeOpen && now <= officeClosed

    println("Office is open : $isOpen")

    val isClose = now < officeOpen || now > officeClosed

    println("Office is closed : $isClose")

    if (!isOpen) {
        println("Office is closed")
    } else {
        println("Office is open")
    }

    //--------- Number ------
    val intNumber = 100
    val longNumber: Long = 100
    val longNumber2 = 100L
    val shortNumber: Short = 10
    val byteNumber = 0b11010010
    val doubleNumber: Double = 1.3
    val floatNumber: Float = 0.123456789f    // yang terbaca hanya 0.1234567

    val maxInt = Int.MAX_VALUE // 2147483647
    val minInt = Int.MIN_VALUE // -2147483648


    //Konversi angka
    /*
    toByte(): Byte
    toShort(): Short
    toInt(): Int
    toLong(): Long
    toFloat(): Float
    toDouble(): Double
    toChar(): Char
    */
    val byteNumber2: Byte = 10
    val intNumber2: Int = byteNumber2.toInt() // ready to go

    val stringNumber = "23"
    println(intNumber + stringNumber.toInt())

    // --------- ARRAY -------
    val array = arrayOf(1, 3, 5, 7)
    /*
    intArrayOf() : IntArray   -> val intArray = intArrayOf(1, 3, 5, 7)
    booleanArrayOf() : BooleanArray
    charArrayOf() : CharArray
    longArrayOf() : LongArray
    shortArrayOf() : ShortArray
    byteArrayOf() : ByteArray
    */


    // --------- NULLABLE ----------
    // berikan ? setelah type val
    val texttt: String? = null // ready to go

    // mengakses val yang null
    var string: String? = "Dicoding"
    if(string != null) { // smart cast
        print(string.length) // It works now!
    }

    // menggunakan is
    var obj: Any = "Dicoding"

    if(obj is String) {
        // Tidak membutuhkan casting secara eksplisit.
        println("String length is ${obj.length}")
    }


    // Safe calls operator
    // saat mengakses variable yang null, maka berikan ? jga saat mengaksesnya
    val texts: String? = null
    texts?.length

    // Elvis operator -> buat value default jika objek null
    val textsLength = texts?.length ?: 7
    // sama seperti dibawah ini
    //val textLength = if (text != null) text.length else 7


    //------ Functions ------
    // : String -> maksudnya adalah tipe value yang akan di return
    // namun dri kompiler biasanya bisa deteksi lngsung, maka kita tidak wajib untuk membuatnya
//    fun setUser(name: String, age: Int): String {
//        return "Your name is $name, and you $age years old"
//    }
    // jika hanya 1 baris bisa dibuat function seperti ini
    fun setUser(name: String, age: Int): String = "Your name is $name, and you $age years old"

    // jika membuat function yg tidak return apa2
    // ketik : Unit
    // namun sekali lgi, kompiler bisa deteksi, jdi tidak wajib ketik : Unit
    fun printUser(name: String): Unit {
        println("Your name is $name")
    }

    val user = setUser("Alfian", 19)
    println(user)

    printUser("Alfian")

    // ------------ NAMED ARGUMENT ------------
    // peletakan parameter bisa diubah urutannya, asal key(first, middle, last) nya benar
    val fullName = getFullName(first = "Kotlin" , middle = " is ", last = "Awesome")
    println(fullName)

    // ------------ DEFAULT ARGUMENT ------------
    // default argument, meski sudah kita tetapkan defaultnya di function,
    // bisa kita ubah dgn mengisi parameter saat memanggil function

    // ------------ VARIABLE ARGUMENT ------------
    // VARANG
    val number = sumNumbers(10, 20, 30, 40)
    println("number sum: %number")

    val numberSize = getNumberSize(10, 20, 30, 40, 50)
    print("number size: $numberSize")
}

// ------------ NAMED ARGUMENT ------------
fun getFullName(first: String, middle: String, last: String): String {
    return "$first $middle $last"
}

// ------------ DEFAULT ARGUMENT ------------
fun getDefaultFullName(
    first: String = "Kotlin",
    middle: String = " is ",
    last: String = "Awesome"): String {
    return "$first $middle $last"
}

// ------------ VARIABLE ARGUMENT ------------
// VARANG

fun sumNumbers(vararg number: Int): Int {
    return number.sum()
}
fun getNumberSize(vararg number: Int): Int {
    return number.size
}
// tidak boleh ada 2 parameter
// jika ingin 2 paramter atau lebih, bisa letakan param varang di akhir
//fun sets(name: String, vararg number: Int): Int {
//    ...
//}
// jika ingin varang di pertama, saat memanggilnya kita perlu menggunakan named argument
// saat memanggil fungsinya || contoh:
//fun main() {
//    sets(10, 10, name = "Kotlin")
//}
//
//fun sets(vararg number: Int, name: String): Int {
//    ...
//}

// contoh bisa gunakan array sebagai param dalam varang
//fun main() {
//    val number = intArrayOf(10, 20, 30, 40)
//    sets(10, 20, 20, *number , 10)
//}
//
//fun sets(vararg number: Int): Int {
//    ...
//}
