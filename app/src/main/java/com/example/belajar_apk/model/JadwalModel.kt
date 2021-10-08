package com.example.belajar_apk.model

import com.google.gson.annotations.SerializedName

data class JadwalModel(
    @field:SerializedName("jadwal")
    val jadwal: String,
    @field:SerializedName("data")
    val data: String

)