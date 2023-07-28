package com.example.theweather.data.remote

import com.google.gson.annotations.SerializedName

data class WeatherIconInfor(
    @SerializedName("description")
    val description: String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("main")
    val main: String
)