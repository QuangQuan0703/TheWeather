package com.example.theweather.data.remote

import com.google.gson.annotations.SerializedName

data class Hournly(
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("dt_txt")
    val hounlyTimes: String,
    @SerializedName("main")
    val weatherInfor: WeatherInfor,
    @SerializedName("visibility")
    val visibility: Int,
    @SerializedName("weather")
    val weatherIcon: List<WeatherIconInfor>,
    @SerializedName("wind")
    val wind: Wind
)