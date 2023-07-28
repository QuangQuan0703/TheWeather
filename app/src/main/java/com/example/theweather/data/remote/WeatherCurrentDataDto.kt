package com.example.theweather.data.remote

import com.google.gson.annotations.SerializedName

data class WeatherCurrentDataDto(
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("main")
    val weatherInfor: WeatherInfor,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weatherIconInfor: List<WeatherIconInfor>,
    @SerializedName("wind")
    val wind: Wind,
    @SerializedName("sys")
    val sys: Sys
)
