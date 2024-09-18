package com.dicoding.kotlin

// ---------- Nested Class
class House {
    // outer class
    // Properti outer class
    val buildingArea = 100
    val totalRooms = 4

    inner class Room {
        // member class, tidak dapat akases properti di outer class
        // maka perlu inner class, tmbhkan "inner" di dpn class Room
        // dgn inner class, bisa akses properti outer classnya
        val totalRooms = 4
        fun measureRoomArea() {
            // Inner class dapat mengakses properti pada outer class

            //jika ada properti yg sama di inner dan outer
            //  bisa pakai this@class.
            //this@House.totalRooms -> merefer pada totalRooms di class House
            //bisa this@Room
            print(buildingArea/this@House.totalRooms)
        }
    }
}

fun main() {
    val house = House()
    val room = house.Room()
    room.measureRoomArea()
}