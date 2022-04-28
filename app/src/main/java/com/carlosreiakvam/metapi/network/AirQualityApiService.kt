package com.carlosreiakvam.metapi.network


import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "http://10.239.120.166/weatherapi/airqualityforecast/0.1/"
//private const val BASE_URL = "http://10.239.120.166/weatherapi/airqualityforecast/"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface AirQualityApiService {
    @GET(".")
    suspend fun getQueryTest(
        @Query("areaclass") areaclass: String,
        @Query("show") show: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): String

}

object AirQualityApi {
    val retrofitService: AirQualityApiService by lazy {
        retrofit.create(AirQualityApiService::class.java)
    }
}