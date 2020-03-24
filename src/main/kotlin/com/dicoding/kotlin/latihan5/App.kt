package com.dicoding.kotlin.latihan5

/* Aplikasi kasir simple */

fun main() {
//  Tambahkan 0 lagi di belakang untuk transaksi yang sukses
    var saldoSaya = 100000

    var totalHarga = 0
    var barang1 = mapOf<String, Any>("namaBarang" to "SilverQueen", "hargaBarang" to intArrayOf(20000, 30000))
    var barang2 = mapOf<String, Any>("namaBarang" to "Pulpen", "hargaBarang" to  intArrayOf(3000, 2000))
    var listBarang = ArrayList<Map<String, Any>>()
    listBarang.add(barang1)
    listBarang.add(barang2)

    var arrHarga: IntArray
    listBarang.forEachIndexed { index, barang ->
        totalHarga += sumHarga(*barang["hargaBarang"] as IntArray)
    }

    bayar(totalBayar = saldoSaya, totalHarga = totalHarga) {
        it?.let {
            println("Pembayaran BERHASIL dilakukan, kembalian anda: $it")
        } ?: println("Pembayaran GAGAL dilakukan!!, uang anda kurang")
        printStruk(mapOf("title" to "Total Bayar", "harga" to saldoSaya), mapOf("title" to "Total harga", "harga" to totalHarga), mapOf("title" to "Kembalian", "harga" to it))
    }
}

fun printStruk(vararg kategori: Map<String, Any?>) {
    var message = "\nDetail Transaksi:\n"
    kategori.forEach {
        if (it["harga"] != null) {
            message += it["harga"]?.printKalimat(it["title"] as String)
        }
    }
    println(message)
}
fun Any.printKalimat(kategori: String): String {
    return "$kategori: $this\n"
}
fun sumHarga(vararg number: Int): Int {
    return number.sum()
}
fun bayar(totalHarga: Int, totalBayar: Int, kembalian: (Int?) -> Unit) {
    totalHarga.let {
        val _kembalian = totalBayar - it
        if (_kembalian >= 0) {
            kembalian(_kembalian)
        }else {
            kembalian(null)
        }
    }
}