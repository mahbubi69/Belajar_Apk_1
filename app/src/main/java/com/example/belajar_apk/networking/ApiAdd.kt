package com.example.belajar_apk.networking


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiAdd {
    private const val BASE_URL = "https://api.npoint.io/99c279bb173a6e28359c/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiService(): ApiService {
        return retrofit.create(ApiService::class.java)

    }

    private const val BASE_URL_JADWAL =
        "https://api.banghasan.com/sholat/format/json/jadwal/kota/"
    private val retrofitJ = Retrofit.Builder()
        .baseUrl(BASE_URL_JADWAL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiJadwal() {

    }

    private const val BASE_URL_KOTA = "https://api.banghasan.com/sholat/format/json/"
    private val retrofitKota = Retrofit.Builder()
        .baseUrl(BASE_URL_KOTA)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiKota(): ApiServiceKota {
        return retrofitKota.create(ApiServiceKota::class.java)
    }

}
