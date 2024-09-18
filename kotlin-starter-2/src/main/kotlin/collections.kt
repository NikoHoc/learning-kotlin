package com.dicoding.kotlin

/*
List, Set, dan Map
 */

// ------------ LIST --------
val numberList : List<Int> = listOf(1, 2, 3, 4, 5)
val numberListOf = listOf(1, 2, 3, 4, 5)
val charList = listOf('a', 'b', 'c')
val anyList = listOf('a', "Kotlin", 3, true)
val anyList2 : List<Any> = listOf("2", 2, "sada")

/*
bedanya array dan list

val array = arrayOf("Kotlin", "Java") -> bisa ubah kontent, tdk bisa tambah
array[0] = "Dart" // no error
array.add("JavaScript") // error

val list = listOf("Kotlin", "Java") -> tdk bisa ubah, tdk bisa tmbh
list[0] = "Dart" // error
list.add("JavaScript") //error

val mutableList = mutableListOf("Kotlin", "Java") -> bisa ubah dan tmbh konten
mutableList[0] = "Dart" // no error
mutableList.add("JavaScript") // no error

val arrayList = arrayListOf("Kotlin", "Java") -> bisa ubah dan tmbh konten
arrayList[0] = "Dart" // no error
arrayList.add("JavaScript") // no error
 */

/*
------------ SET --------------
Intersection -> nilai yang sama dari kedua set.
Union ->  mengambil semua data dari kedua set.
Substracting -> mengambil nilai dri stu set, yg tdk ada di set satunya
Symmetric Difference -> mendapatkan nilai yg dari kedua set (yg sama tidak diambil)
di Kotlin tidak tersedia untuk mencari nilai symmetric difference. perlu mencari secara manual nilai dalam semua set,
tetapi nilai yang sama tidak dimasukkan
 */

/*
-------------- MAP ---------------
format key-value
 */

/*
----------- FOLD ----------
melakukan perhitungan tiap nilai dalam collection
 */

fun main () {
    /* kumpulan array/list
    arrayOf()
    listOf()
    mutableListOf() -> bisa .add()
    arrayListOf() -> bisa .add()
     */

    println(anyList[0])

    //mutable list
    val anyMutableList = mutableListOf('a', "Kotlin", 3, true)

    anyMutableList.add('d') // menambah item di akhir list
    anyMutableList.add(1, "love") // menambah item pada indeks ke-1
    anyMutableList[3] = false // mengubah nilai item pada indeks ke-3
    anyMutableList.removeAt(0) // menghapus item pada indeks ke-0

    for (i in anyMutableList) {
        print("$i ")
    }

    //SET
    //setOf akan ignore data yang nilainya sama
    val integerSet = setOf(1, 2, 4, 2, 1, 5) // -> jika di print: [1, 2, 4, 5]

    val setA = setOf(1, 2, 4, 2, 1, 5)
    val setB = setOf(1, 2, 4, 5)
    println(setA == setB)     //kedua set ini dinilai sama

    print(5 in setA) // -> ngecek apakah nilai ada di set dengan "in"

    val setC = setOf(1, 5, 7)
    val union = setA.union(setC) // -> [1, 2, 4, 5, 7] || gabungan a dan c
    val intersect = setA.intersect(setC) // -> [1, 5] || yg sama dari a dan c

    println(union)
    println(intersect)

    val mutableSet = mutableSetOf(1, 2, 4, 2, 1, 5)
    //mutableSet[2] = 6 // tidak bisa mengubah mutableSet
    mutableSet.add(6) // menambah item di akhir set
    mutableSet.remove(1) //menghapus item yang memiliki nilai 1

    //symmetric difference -> nilai dari kedua set (yg sama tidak termasuk)
    val numbers = setOf("one", "two", "three")
    val numbers2 = setOf("three", "four")

    // merge differences
    println((numbers - numbers2) union (numbers2 - numbers)) //[one, two, four]


    // MAP
    val capital = mapOf(
        "Jakarta" to "Indonesia",
        "London" to "England",
        "New Delhi" to "India"
    )

    //cara akses datanya
    println(capital["Jakarta"]) // jika value null -> maka output akan null
    println(capital.getValue("Jakarta")) // jika value null -> maka akan exception

    val mapKeys = capital.keys // mapKeys: [Jakarta, London, New Delhi]

    val mapValues = capital.values // mapValues: [Indonesia, England, India]

    // agar map kita bisa tambahkan key-value, perlu ubah jdi mutable map
    val mutableCapital = capital.toMutableMap()
    // lalu tambahkan
    mutableCapital.put("Amsterdam", "Netherlands")
    mutableCapital.put("Berlin", "Germany")


    /*
    ------------- Collections Operations
    filter(), filterNot(), map(), count(),
    find(), firstOrNull(), lastOrNull(),
    first(), last()
    sum(), sorted(), sortedDescending()
     */

    val numberList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenList = numberList.filter { it % 2 == 0 } // evenList: [2, 4, 6, 8, 10]
    val notEvenList = numberList.filterNot { it % 2 == 0 } // notEvenList: [1, 3, 5, 7, 9]

    val multipliedBy5 = numberList.map { it * 5 } // multipliedBy5: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50]

    print(numberList.count()) // 10
    print(numberList.count { it % 3 == 0 }) // Output: 3

    val firstOddNumber = numberList.find { it % 2 == 1 } // firstOddNumber: 1
    val firstOrNullNumber = numberList.firstOrNull { it % 2 == 3 } // firstOrNullNumber: null

    val firstNumber = numberList.first()
    val total = numberList.sum()

    val kotlinChar = listOf('k', 'o', 't', 'l', 'i', 'n')
    val ascendingSort = kotlinChar.sorted()
    val descendingSort = kotlinChar.sortedDescending()
    println(descendingSort) //  [t, o, n, l, k, i]
    println(ascendingSort) //  [i, k, l, n, o, t]


    // FOLD
    val numberss = listOf(5, 10, 15)
    val fold = numberss.fold(10) { current, item ->
        //current -. initial number, item -> item di numberss
        println("current $current")
        println("item $item")
        println()
        current + item
    }
    /* output
         current 10
         item 5

         current 15
         item 10

         current 25
         item 15

         Fold result: 40
   */
    //foldRight() -> memulai dri index terakhir dari list
    val foldRight = numberss.foldRight(10) { item, current ->
        println("current $current")
        println("item $item")
        println()
        item + current
    }
    println("Fold result: $fold")


    // -----DROP
    val numbersss = listOf(1, 2, 3, 4, 5, 6)
    val drop = numbersss.drop(3) // -> hapus 3 item dari list
    val dropLast = numbersss.dropLast(3) // -> hapus 3 item dri blkng list

    println(drop) // [4, 5, 6]
    println(dropLast) // [1, 2, 3]


    // ----------- Take
    val totals = listOf(1, 2, 3, 4, 5, 6)
    val take = totals.take(3) // -> ngambil 3 item pertama drii list
    val takeLast = totals.takeLast(3) // -> ngambil 3 item terakhir dri list

    println(take) // [1, 2, 3]
    println(takeLast) // [4, 5, 6]


    // ------- Slice
    val totalss = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val slice = totalss.slice(3..6) // -> ngambil item dari range 3..6

    val sliceStep = totalss.slice(3..6 step 2) // -> menggunakan step
    println(slice) //[4, 6]

    //bisa lebih spesifik
    val index = listOf(2, 3, 5, 8) // -> item berupa index kebrp yg di ambil dri total
    val sliceIndex = totalss.slice(index)

    println(slice) // [3, 4, 6, 9]

    // ---------- Distinct
    val totalDis = listOf(1, 2, 1, 3, 4, 5, 2, 3, 4, 5)
    val distinct = totalDis.distinct() // -> menyaring item yg sama

    println(distinct) // [1, 2, 3, 4, 5]

    // distinct bisa dipakai untuk dataclass
    val items = listOf(
        Item("1", "Kotlin"),
        Item("2", "is"),
        Item("3", "Awesome"),
        Item("3", "as"),
        Item("3", "Programming"),
        Item("3", "Language")
    )

    //disini kita cek berdasarkan key nya, jdi jika ada key yg sama, diambil yg awal
    val distinctItems = items.distinctBy { it.key }
    distinctItems.forEach {
        println("${it.key} with value ${it.value}")
        //output: 1 kotlin, 2 is, 3 awesome
    }

    val text = listOf("A", "B", "CC", "DD", "EEE", "F", "GGGG")
    val distinctText = text.distinctBy {
        it.length
    }
    println(distinctText) // [A, CC, EEE, GGGG]

    //---------- Chunked
    // mecah nilai string jadi array

    val word = "QWERTY"
    val chunked = word.chunked(3)

    println(chunked) // [QWE, RTY]

    val chunkedTransform = word.chunked(3) {
        it.toString().toLowerCase()
    }
    println(chunkedTransform) // [qwe, rty]

    //sebelumnya collection diatas adalah eager evaluation -> mengevaluasi seluruh item pada collection

    // ----------- Sequences
    // lazy evaluation -> evaluasi item jika dibutuhkan

    val list = (1..10000).toList()
    // yg dibwh ini akan filter dlu semua, lalu di map semua, lalu dapatkan first
    //val number = list.filter { it % 5 == 0 }.map { it * 2 }.first() // -> program akan cek semuanya dan makan waktu

    // gunakan .asSequence()
    // dgn asSequence, dia akan filter pertama, lalu di map yg pertama, lalu dapatkan lngsung yg pertama, dan program selesai
    val number = list.asSequence().filter { it % 5 == 0 }.map { it * 2 }.first()
    println(number)

    // generate sequence
    val sequenceNumber = generateSequence(1) { it + 1 } // -> ini infinite
    sequenceNumber.take(5).forEach { print("$it ")} // -> dgn begini, akan diambil 5 saja
}

data class Item(val key: String, val value: Any)