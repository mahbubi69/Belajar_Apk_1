package com.example.belajar_apk.networking

import com.example.belajar_apk.model.JadwalModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceJadwal {
    @GET("tanggal")
    fun getAllDataJAdwal(): Call<ArrayList<JadwalModel>>
}