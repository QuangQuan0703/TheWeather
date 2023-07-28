package com.example.theweather.domain.weather

data class WeatherData (
    val time: String,
    val temp: Double,
    val tempFeel: Double,
    val tempMax: Double,
    val tempMin: Double,
    val clouds: Int,
    val wind: Double,
    val visibility: Int,
    val humidity: Int,
    val icon: WeatherIcon,
    val country: String = ""
)