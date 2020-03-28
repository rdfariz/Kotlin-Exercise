package com.dicoding.kotlin.latihan6

import com.dicoding.kotlin.latihan6.utils.printListBelanjaan

abstract class Barang(val namaBarang: String, val typeBarang: String, val hargaBarang: Int) {
    fun getDataBarang(): String {
        return "Nama: $namaBarang, Type: $typeBarang, Harga: $hargaBarang"
    }
}
class Makanan(val mNamaBarang: String, val mType: String="Makanan", mHarga: Int): Barang(mNamaBarang, mType, mHarga)
class Minuman(val mNamaBarang: String, val mType: String="Minuman", mHarga: Int): Barang(mNamaBarang, mType, mHarga)

interface IListBelanjaan {
    fun add(brng: Barang)
    fun clear()
    fun getAll(): ArrayList<Barang>
}
class ListBelanjaan(): IListBelanjaan {
    private val arrListBelanjaan: ArrayList<Barang>

    init {
        arrListBelanjaan = ArrayList<Barang>()
    }

    override fun add(brng: Barang) {
        arrListBelanjaan.add(brng)
    }

    override fun clear() {
        arrListBelanjaan.clear()
        println("\n== List belanjaan berhasil dikosongkan ==\n")
    }

    override fun getAll(): ArrayList<Barang> {
        return arrListBelanjaan
    }
}

fun main() {
    //Inisialisasi Keranjang belanja
    val listBelanjaan = ListBelanjaan()

    //Tambah Barang belanjaan
    listBelanjaan.add(Makanan(mNamaBarang = "Coklat", mHarga = 20000))
    listBelanjaan.add(Minuman(mNamaBarang = "Es buah", mHarga = 19000))

    //Print list belanjaan
    printListBelanjaan(listBelanjaan.getAll())

    //Clear List Belanjaan
    listBelanjaan.clear()

    //Print kembali untuk memastikan list barang sudah kosong
    printListBelanjaan(listBelanjaan.getAll())
}