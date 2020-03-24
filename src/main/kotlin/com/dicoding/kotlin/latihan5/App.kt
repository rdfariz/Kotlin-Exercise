package com.dicoding.kotlin.latihan5

/* Aplikasi Penghitung sampah diwilayah tertentu */

fun main() {
    val angka: IntArray = intArrayOf(2,3,4,5)
    println(sum(*angka))
    println(messageLength("koko"))
    println(2.printInt())

    checkdata("koko"){
        println(it)
    }
}

val messageLength = { message: String -> message.length }
fun Int.printInt(): Int {
    return this + 2
}

//HOF
fun checkdata(data: String, callback: (String) -> Unit) {
    callback(data + " Armada")
}

fun sum(vararg number: Int): Int {
    return number.sum()
}