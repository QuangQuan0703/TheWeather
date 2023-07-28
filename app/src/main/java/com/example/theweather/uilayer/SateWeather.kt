package com.example.theweather.uilayer

import com.example.theweather.domain.util.Resource
import com.example.theweather.domain.weather.WeatherData
import com.example.theweather.domain.weather.WeatherDayInfor
import com.example.theweather.domain.weather.WeatherFiveDayInfor

data class SateWeather(
    val load :Boolean = true,
    val weatherDayInfor: Resource<WeatherDayInfor> = Resource.Error("disconnect", data = null),
    val timeLocation: Resource<String> = Resource.Error("disconnect", data = null ),
    val weatherDataCurrent: Resource<WeatherData> = Resource.Error("disconnect", data = null),
    val weatherFiveDayInfor: Resource<WeatherFiveDayInfor> = Resource.Error("disconnect", data = null)
)