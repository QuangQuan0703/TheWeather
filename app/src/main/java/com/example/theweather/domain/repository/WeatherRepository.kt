package com.example.theweather.domain.repository

import android.location.Location
import com.example.theweather.data.remote.WeatherCurrentDataDto
import com.example.theweather.data.remote.WeatherForecastDataDto
import com.example.theweather.domain.util.Resource
import com.example.theweather.domain.weather.WeatherData
import com.example.theweather.domain.weather.WeatherDayInfor
import com.example.theweather.domain.weather.WeatherFiveDayInfor

interface WeatherRepository {
    suspend fun getWeatherDataCurrent(lat:Double?, lon:Double?): Resource<WeatherData>
    suspend fun getWeatherDayForecast(lat:Double?, lon:Double?, locationNow: Location?): Resource<WeatherDayInfor>
    suspend fun getWeatherFiveDayForecast(lat:Double?, lon:Double?, locationNow: Location? ): Resource<WeatherFiveDayInfor>
}