package com.carlosreiakvam.metapi.air_quality

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosreiakvam.metapi.network.AirQualityApi
import kotlinx.coroutines.launch
import java.lang.Exception

class AirQualityViewModel : ViewModel() {

    private val _stringQuery = MutableLiveData<String>()
    val stringQuery: LiveData<String>
        get() = _stringQuery

    init {
        getStations()
    }


    private fun getStations() {
        viewModelScope.launch {
            try {
                _stringQuery.value = AirQualityApi.retrofitService
                    .getQueryTest("grunnkrets", "metadata", 60.0, 10.0)
                Log.d("cre032", "Success")

            } catch (e: Exception) {
                Log.e("cre032", e.toString())
            }
        }
    }

}