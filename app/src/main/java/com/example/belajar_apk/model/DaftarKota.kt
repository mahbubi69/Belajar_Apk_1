package com.example.belajar_apk.model

import com.google.gson.annotations.SerializedName

data class DaftarKota(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("nama")
    val nama: String
)