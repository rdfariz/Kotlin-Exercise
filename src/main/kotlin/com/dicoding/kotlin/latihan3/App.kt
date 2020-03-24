package com.dicoding.kotlin.latihan3

/*APLIKASI MENAMPILKAN JADWAL MAHASISWA HARIAN*/

fun main() {
    var day = 1
    do {
        printJadwal(day)
        day++
    } while (day <= 7)
}

fun printJadwal(day: Int) {
    var data: Jadwal? = null
    var message: String? = null
    when(day){
        1-> {
            data = Jadwal.SENIN
            message = "Hari $data, ${printMatkul(data.matakuliah)}"
        }
        2-> {
            data = Jadwal.SELASA
            message = "Hari $data, ${printMatkul(data.matakuliah)}"
        }
        3-> {
            data = Jadwal.RABU
            message = "Hari $data, ${printMatkul(data.matakuliah)}"
        }
        4-> {
            data = Jadwal.KAMIS
            message = "Hari $data, ${printMatkul(data.matakuliah)}"
        }
        5-> {
            data = Jadwal.JUMAT
            message = "Hari $data, ${printMatkul(data.matakuliah)}"
        }
        6-> {
            data = Jadwal.SABTU
            message = "Hari $data, ${printMatkul(data.matakuliah)}"
        }
        7-> {
            data = Jadwal.MINGGU
            message = "Hari $data, ${printMatkul(data.matakuliah)}"
        }
        else -> {
            message = "Hari yang anda maksud tidak terdaftar"
        }
    }

    println(message)
}
fun printMatkul(arr: ArrayList<String?>?): String {
    var data = ""
    if (arr != null) {
        data = "Jadwal anda: "
        for (matkul in arr) {
            if (matkul == null) continue
            data += "$matkul, "
        }
    }else {
        data = "Anda libur"
    }
    return data
}

enum class Jadwal(val matakuliah: ArrayList<String?>?) {
    SENIN(arrayListOf("Logika Matematika", null, "Pemrograman Game")),
    SELASA(arrayListOf("Kewirausahaan", null)),
    RABU(arrayListOf("Algoritma Dasar", "UI/UX", "RPL")),
    KAMIS(arrayListOf("Mobile Programming", "Kewarganegaraan")),
    JUMAT(arrayListOf("Pemrograman Website")),
    SABTU(null),
    MINGGU(null)
}