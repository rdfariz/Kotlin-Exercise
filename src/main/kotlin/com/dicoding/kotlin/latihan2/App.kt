package com.dicoding.kotlin.latihan2

/* APLIKASI PENYEDIA DATA MAHASISWA */

fun main() {
    //["nama", "nilai"]
    val mahasiswa1 = arrayOf("Raden Fariz Insan P", 3)
    val mahasiswa2 = arrayOf("Kokom", 8)
    val mahasiswa3 = arrayOf("Arul", 6)

    val dataMahasiswa: Array<Any> = arrayOf(mahasiswa1, mahasiswa2, mahasiswa3)

    dataMahasiswa.forEach {
        printIdentitas(it as Array<Any>)
    }
}

//Functon return
fun getIndexNilai(nilai: Int): Char? {
    var index: Char?
    if (nilai > 7 && nilai <= 10) {
        index = 'A'
    }else if (nilai > 4 && nilai <= 7) {
        index = 'B'
    }else if (nilai > 0 && nilai <= 4) {
        index = 'C'
    }else {
        index = null
    }
    return index
}
fun getKelulusan(nilai: Int): Boolean {
    val lulus = if (nilai > 5) true else false
    return lulus
}

//Function Unit
fun printIdentitas(mahasiswa: Array<Any>) {
    printIdentitas(mahasiswa[0] as String, mahasiswa[1] as Int)
}
fun printIdentitas(nama: String, nilai: Int) {
    val index = getIndexNilai(nilai)
    val lulus = getKelulusan(nilai)
    var message = "Nama kamu $nama, Nilai Index kamu ${getIndexNilai(nilai)}"
    if (index == null) {
        return println("Nilai tidak valid")
    }else {
        if (!lulus) {
            message += ", Tapi maaf kamu TIDAK LULUS"
        }else {
            message += ", Yeyy selamat kamu LULUS"
        }
        println(message)
    }
}