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


    print("Hello my name is $name2")
    println(name2)
    println(if (false) "Always true" else "Always false")

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
}