package com.example.theweather.data.remote

import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("country")
    val country: String
)