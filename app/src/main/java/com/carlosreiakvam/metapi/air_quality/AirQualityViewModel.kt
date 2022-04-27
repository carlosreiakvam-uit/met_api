package com.carlosreiakvam.metapi.air_quality

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosreiakvam.metapi.Stations
import com.carlosreiakvam.metapi.network.AirQualityApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class AirQualityViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    init {
        getAirQualityResponse()
    }

    private fun getAirQualityResponse() {
        viewModelScope.launch {
            try {
                val stationResult = AirQualityApi.retrofitService.getStations()
                _response.value = "Success! ${stationResult.size} stations found!"
            } catch (e: Exception) {

            }
        }
    }
}