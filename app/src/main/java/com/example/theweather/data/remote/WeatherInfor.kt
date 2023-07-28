package com.example.theweather.data.remote

import com.google.gson.annotations.SerializedName

data class WeatherInfor(
    @SerializedName("feels_like")
    val tempFeel: Double,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("temp")
    val temp: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    @SerializedName("temp_min")
    val tempMin: Double
)