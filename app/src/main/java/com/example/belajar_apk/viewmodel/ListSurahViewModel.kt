package com.example.belajar_apk.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.belajar_apk.model.SurahApiModel
import com.example.belajar_apk.networking.ApiAdd
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListSurahViewModel() : ViewModel() {

    private val list = MutableLiveData<ArrayList<SurahApiModel>>()

    fun setDataApi() {
        val dataService = ApiAdd.getApiService()
        dataService.getAlldataSurah().enqueue(
            object : Callback<ArrayList<SurahApiModel>> {
                override fun onResponse(
                    call: Call<ArrayList<SurahApiModel>>,
                    response: Response<ArrayList<SurahApiModel>>
                ) {
                    if (response.isSuccessful) {
                        Log.d("data", "${response.body()}")
                        list.postValue(response.body())
                    } else {
                        Log.d("data not succes", "tidak suces")
                    }
                }

                override fun onFailure(call: Call<ArrayList<SurahApiModel>>, t: Throwable) {
                    t.message?.let { Log.e("error", it) }
                }
            }
        )
    }

    fun getDataList(): LiveData<ArrayList<SurahApiModel>> {
        return list
    }
}