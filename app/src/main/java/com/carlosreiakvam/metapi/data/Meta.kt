package com.carlosreiakvam.metapi.data

// basert på spørring med url
// http://10.239.120.166/weatherapi/airqualityforecast/0.1/?lat=60&lon=10&areaclass=grunnkrets
data class Meta(
    val reftime: String,
    val location: Location,
    val superlocation: Location
)

data class Location(
    val name: String,
    val path: String,
    val areacode: Int,
    val longitude: Double,
    val laitude: Double,
    val areaclass: String,
    val superareacode: Int
)
