package com.example.belajar_apk.model

import com.google.gson.annotations.SerializedName

data class DaftarKotaObj(
    @field:SerializedName("status")
    val status: String,
    @field:SerializedName("query")
    val query: String,
    @field:SerializedName("kota")
    val kota: ArrayList<DaftarKota>
)