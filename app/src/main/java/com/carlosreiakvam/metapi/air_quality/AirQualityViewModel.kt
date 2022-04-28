package com.carlosreiakvam.metapi.air_quality

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosreiakvam.metapi.Station
import com.carlosreiakvam.metapi.data.PositionalData
import com.carlosreiakvam.metapi.network.AirQualityApi
import kotlinx.coroutines.launch
import java.lang.Exception

class AirQualityViewModel : ViewModel() {

    private val _stations = MutableLiveData<List<Station>>()
    val stations: LiveData<List<Station>>
        get() = _stations

    private val _positionalData = MutableLiveData<PositionalData>()
    val positionalData: LiveData<PositionalData>
        get() = _positionalData

    init {
//        getAllStations()
        getPositionalData()
    }

    private fun getAllStations() {
        viewModelScope.launch {
            try {
                _stations.value = AirQualityApi.retrofitService.getStations()
            } catch (e: Exception) {
                Log.d("cre032", e.message.toString())
            }
        }
    }

    private fun getPositionalData() {
        viewModelScope.launch {
            try {
                _positionalData.value = AirQualityApi.retrofitService
                    .getPositionalData(60.0, 10.0)
                Log.d("cre032", positionalData.toString())
            } catch (e: Exception) {
                Log.d("cre032", e.message.toString())
            }
        }
    }
}