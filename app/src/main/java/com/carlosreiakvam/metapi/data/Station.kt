package com.carlosreiakvam.metapi

data class Station(
    val name: String,
    val eoi: String,
    val height: Double,
    val longitude: Double,
    val latitude: Double,
    val grunnkrets: Grunnkrets,
    val delomrade: Delomrade,
    val kommune: Kommune
)

data class Grunnkrets(
    val name: String,
    val areacode: String
)

data class Delomrade(
    val name: String,
    val areacode: String
)

data class Kommune(
    val name: String,
    val areacode: String
)
