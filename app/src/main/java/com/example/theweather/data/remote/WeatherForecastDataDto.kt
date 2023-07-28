package com.example.theweather.data.remote

import com.google.gson.annotations.SerializedName

data class WeatherForecastDataDto(
    @SerializedName("list")
    val list: List<Hournly>
)