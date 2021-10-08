package com.example.belajar_apk.model

import com.google.gson.annotations.SerializedName

data class SurahApiModel(
    //data yg mw di panggil dari data api
    @field:SerializedName("nomor")
    val nomor: Int,
    @field:SerializedName("nama")
    val nama: String,
    @field:SerializedName("asma")
    val asma: String,
    @field:SerializedName("type")
    val type: String,
    @field:SerializedName("ayat")
    val ayat: Int,
//    //detail
    @field:SerializedName("audio")
    val audio: String

)
