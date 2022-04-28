package com.carlosreiakvam.metapi.data

data class Data(
    val time: Time
)

data class Time(
    val from: String,
    val to: String,
    val variables: Variables,
    val reason: Reason
)

data class Variables(
    val AQI: Variable,
    val no2_concentration: Variable,
    val AQI_no2: Variable,
    val no2_nonlocal_fraction: Variable,
    val no2_nonlocal_fraction_seasalt: Variable,
    val no2_local_fraction_traffic_exhaust: Variable,
    val no2_local_fraction_traffic_nonexhaust: Variable,
    val no2_local_fraction_shipping: Variable,
    val no2_local_fraction_heating: Variable,
    val no2_local_fraction_industry: Variable,
    val pm10_concentration: Variable,
    val AQI_pm10: Variable,
    val pm10_nonlocal_fraction: Variable,
    val pm10_nonlocal_fraction_seasalt: Variable,
    val pm10_local_fraction_traffic_exhaust: Variable,
    val pm10_local_fraction_traffic_nonexhaust: Variable,
    val pm10_local_fraction_shipping: Variable,
    val pm10_local_fraction_heating: Variable,
    val pm10_local_fraction_industry: Variable,
    val pm25_concentration: Variable,
    val AQI_pm25: Variable,
    val pm25_nonlocal_fraction: Variable,
    val pm25_nonlocal_fraction_seasalt: Variable,
    val pm25_local_fraction_traffic_exhaust: Variable,
    val pm25_local_fraction_traffic_nonexhaust: Variable,
    val pm25_local_fraction_shipping: Variable,
    val pm25_local_fraction_heating: Variable,
    val pm25_local_fraction_industry: Variable,
    val o3_concentration: Variable,
    val AQI_o3: Variable,
    val o3_nonlocal_fraction: Variable,
    val o3_nonlocal_fraction_seasalt: Variable,
    val o3_local_fraction_traffic_exhaust: Variable,
    val o3_local_fraction_traffic_nonexhaust: Variable,
    val o3_local_fraction_shipping: Variable,
    val o3_local_fraction_heating: Variable,
    val o3_local_fraction_industry: Variable,
)

data class Variable(
    val value: Double,
    val units: String
)

data class Reason(
    val variables: Array<Variable> //TODO : Mulig feilkilde i valg av type
)
