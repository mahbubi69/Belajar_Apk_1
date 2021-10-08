package com.example.belajar_apk.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.belajar_apk.model.DaftarKotaObj
import com.example.belajar_apk.networking.ApiAdd
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataKotaViewModel : ViewModel() {
    private val listKota = MutableLiveData<ArrayList<DaftarKotaObj>>()

    fun setDataKota() {
        val dataServiceKota = ApiAdd.getApiKota()
        dataServiceKota.getAllDataKota().enqueue(
            object : Callback<ArrayList<DaftarKotaObj>> {
                override fun onResponse(
                    call: Call<ArrayList<DaftarKotaObj>>,
                    response: Response<ArrayList<DaftarKotaObj>>
                ) {
                    if (response.isSuccessful) {
                        listKota.postValue(response.body())
                    } else {
                        Log.d("data not succes", "data failed")
                    }
                }
                override fun onFailure(call: Call<ArrayList<DaftarKotaObj>>, t: Throwable) {
                    t.message?.let { Log.e("error", it) }
                }
            }
        )
    }

    fun getDatalistKota(): LiveData<ArrayList<DaftarKotaObj>> {
        return listKota
    }

}