package com.dicoding.kotlin.latihan4

/* Login dengan PIN  Sesuai typeValidation & Menampilkan History Login*/

fun main() {
    val user1 = User("Fariz", 99, "ganjil", mapOf("umur" to 19, "alamat" to "Cirebon"))
    val user2 = User("Koko", 13, "genap" ,mapOf("umur" to 18, "alamat" to "Bandung Barat"))
    val user3 = User("Aziz", 22, "genap" ,mapOf("umur" to 20, "alamat" to "Garut"))
    val tryLogin = mutableListOf<User>(user1, user2, user3)

    val loginTrue = mutableListOf<String>()
    val loginFalse = mutableListOf<String>()

    tryLogin.forEachIndexed { index, user ->
        if (validationPin(user.pin, user.typeValidation)) {
            println("//BERHASIL LOGIN!!")
            println("Data Login: "+user.getBiodata()+"\n")
            loginTrue.add(user.nama)
        }else {
            println("//GAGAL LOGIN, PIN tidak cocok dengan typeValidation\n")
            loginFalse.add(user.nama)
        }
    }

    //Report Hasil Login
    println("\nLaporan login hari ini:\n-Berhasil Login: ${loginTrue.size} ($loginTrue)\n-Gagal Login: ${loginFalse.size} ($loginFalse)")
}

fun validationPin(pin: Int, validation: String): Boolean {
    var validate = false
    if (validation == "ganjil" && pin % 2 == 1) {
        validate = true
    }else if (validation == "genap" && pin % 2 == 0) {
        validate = true
    }
    return validate
}

data class User(val nama: String, val pin: Int, val typeValidation: String, val dataLengkap: Map<String, Any>) {
    fun getBiodata(): String {
        return "Nama saya $nama, umur saya ${dataLengkap["umur"]} tahun & alamat saya di ${dataLengkap["alamat"]}"
    }
}