package com.example.belajar_apk.networking

import com.example.belajar_apk.model.DaftarKotaObj
import retrofit2.Call
import retrofit2.http.GET


interface ApiServiceKota {
    @GET("kota")
    fun getAllDataKota(): Call<ArrayList<DaftarKotaObj>>
}