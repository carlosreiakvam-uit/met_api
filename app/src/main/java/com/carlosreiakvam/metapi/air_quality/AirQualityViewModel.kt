package com.carlosreiakvam.metapi.air_quality

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carlosreiakvam.metapi.network.AirQualityApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AirQualityViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getAirQualityResponse()
    }

    private fun getAirQualityResponse() {
        AirQualityApi.retrofitService.getArea().enqueue(
            object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    _response.value = response.body()
//                    _response.value = "Success!"
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    _response.value = "It's a fail!:" + t.message
                }
            }
        )
    }
}