package com.example.belajar_apk.networking

import com.example.belajar_apk.model.SurahApiModel
import retrofit2.Call
import retrofit2.http.GET

//memanggil data dari database (GET)

interface ApiService {
    @GET("data")
    fun getAlldataSurah(): Call<ArrayList<SurahApiModel>>
}