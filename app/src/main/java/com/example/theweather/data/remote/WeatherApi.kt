package com.example.theweather.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/forecast?appid=d8fe669186845b4b86a0554ce4bf630b")
    suspend fun getWeatherApiForecast(
        @Query("lat") lat:Double,
        @Query("lon") lon:Double
    ):WeatherForecastDataDto
    @GET("data/2.5/weather?appid=d8fe669186845b4b86a0554ce4bf630b")
    suspend fun getWeatherApiCurrent(
        @Query("lat") lat:Double?,
        @Query("lon") lon:Double?
    ):WeatherCurrentDataDto

}