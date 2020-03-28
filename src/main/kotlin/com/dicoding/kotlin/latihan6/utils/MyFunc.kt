package com.dicoding.kotlin.latihan6.utils

import com.dicoding.kotlin.latihan6.Barang

fun printListBelanjaan(arr: ArrayList<Barang>) {
    if (arr.size == 0) {
        println("Maaf, list barang kosong")
    }else {
        arr.forEachIndexed { index, barang ->
            println("${index+1}. ${barang.getDataBarang()}")
        }
    }
}