package com.dicoding.kotlin.latihan7

/* Pengurangan nilai dengan 50 dengan aturan type generic(numeric)
* Pengecualian untuk float tidak diperbolehkan */

class ListNilaiMhs<T: Number> : List<T> {
    private val listNilaiMhs = ArrayList<T>()

    override fun getAll(): ArrayList<T> {
        return listNilaiMhs
    }
    override fun remove(index: Int) {
        listNilaiMhs.removeAt(index)
    }
    override fun add(data: Number) {
        listNilaiMhs.add(data as T)
    }
    override fun get(index: Int): T {
        return listNilaiMhs.get(index)
    }
}

interface List<T> {
    fun getAll(): ArrayList<T>
    fun get(index: Int): T
    fun remove(index: Int)
    fun add(data: Number)
}

operator fun Number.minus(numberMinus: Number): Number {
    return when (this) {
        is Int    -> this.toInt()  - numberMinus.toInt()
        is Double -> this.toDouble() - numberMinus.toDouble()
        is Float -> throw RuntimeException("Float tidak diperbolehkan")
        else      -> throw RuntimeException("Numeric Type tidak terdaftar")
    }
}

fun main() {
    //  Inisialisasi Object
    val listData = ListNilaiMhs<Number>()
    //  val listData2 = ListNilaiMhs<String>() // error : Type argument is not within its bounds

    listData.add(90)
    listData.add(75.5)
    listData.add(50.75)
//  Throw float
    listData.add(4.75F)

    // Get data
    listData.getAll().forEachIndexed { index, number ->
        println("$number - 50 = ${number.minus(50)}")
    }
}
