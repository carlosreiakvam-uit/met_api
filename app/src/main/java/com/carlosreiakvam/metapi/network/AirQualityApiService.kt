package com.carlosreiakvam.metapi.network


import com.carlosreiakvam.metapi.Stations
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://10.239.120.166/weatherapi/airqualityforecast/0.1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface AirQualityApiService {
    @GET("stations")
    suspend fun getStations(): List<Stations>

}

object AirQualityApi {
    val retrofitService: AirQualityApiService by lazy {
        retrofit.create(AirQualityApiService::class.java)
    }
}