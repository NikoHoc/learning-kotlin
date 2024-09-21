package com.dicoding.exam.exam4

// TODO
fun vehicle(): Map<String, Any> {
    return mapOf(
        "type" to "motorcycle",
        "maxSpeed" to 230.toString() + "Km/s",
        "maxTank" to 100L.toString() + "Ltr"
    )
}