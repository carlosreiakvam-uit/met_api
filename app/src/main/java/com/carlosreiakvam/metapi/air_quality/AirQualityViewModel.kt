package com.carlosreiakvam.metapi.air_quality

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosreiakvam.metapi.Station
import com.carlosreiakvam.metapi.network.AirQualityApi
import kotlinx.coroutines.launch
import java.lang.Exception

class AirQualityViewModel : ViewModel() {


    private val _stations = MutableLiveData<List<Station>>()
    val stations: LiveData<List<Station>>
        get() = _stations

    init {
        getStations()
    }


    private fun getStations() {
        viewModelScope.launch {
            try {
                _stations.value = AirQualityApi.retrofitService.getStations()
                Log.d("cre032", "Success")

            } catch (e: Exception) {
                Log.e("cre032", e.toString())
            }
        }
    }
}