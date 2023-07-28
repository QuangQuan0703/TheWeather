package com.example.theweather.data.repository

import android.location.Location
import android.util.Log
import com.example.theweather.data.mapper.toWeatherCurrent
import com.example.theweather.data.mapper.toWeatherDayInfor
import com.example.theweather.data.mapper.toWeatherFiveDayInfor
import com.example.theweather.data.remote.WeatherApi
import com.example.theweather.data.remote.WeatherCurrentDataDto
import com.example.theweather.data.remote.WeatherForecastDataDto
import com.example.theweather.domain.repository.WeatherRepository
import com.example.theweather.domain.util.Resource
import com.example.theweather.domain.weather.WeatherData
import com.example.theweather.domain.weather.WeatherDayInfor
import com.example.theweather.domain.weather.WeatherFiveDayInfor
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherApi: WeatherApi) :WeatherRepository {
    override suspend fun getWeatherDataCurrent(lat:Double?, lon:Double?): Resource<WeatherData> {
        if(lat != null && lon != null){
            return try {
                val coutry = weatherApi.getWeatherApiCurrent(lat = lat, lon = lon).sys.country
                Resource.Success(
                    "Success $coutry",
                    weatherApi.getWeatherApiCurrent(lat = lat, lon = lon).toWeatherCurrent()

                )
            }
            catch (e: Exception){
                return Resource.Error(
                    e.toString(), null
                )
            }
        }
        else{
            return Resource.Error(
                "disconnect", data = null
            )
        }

    }
    override suspend fun getWeatherDayForecast(lat:Double?, lon:Double?, locationNow: Location? ): Resource<WeatherDayInfor> {
        if(lat != null && lon!= null && locationNow != null){
            return try {
                Resource.Success(
                    "Success",
                    weatherApi.getWeatherApiForecast(lat = lat, lon = lon).toWeatherDayInfor(locationNow)
                )
            }
            catch (e: Exception){
                Log.d("loi", e.toString())
                return Resource.Error(
                    e.toString(), null
                )

            }
        }
        else {
            return Resource.Error(
                "disconnect", data = null
            )
        }
    }
    override suspend fun getWeatherFiveDayForecast(lat:Double?, lon:Double?, locationNow: Location? ): Resource<WeatherFiveDayInfor> {
        if (lat != null && lon != null && locationNow != null){
            return try {
                Resource.Success(
                    "Success",
                    weatherApi.getWeatherApiForecast(lat = lat, lon = lon).toWeatherFiveDayInfor(locationNow)
                )
            }
            catch (e: Exception){
                Log.d("loi", e.toString())
                return Resource.Error(
                    e.toString(), null
                )

            }
        }
        else{
            return Resource.Error(
            "disconnect", data = null
            )
        }

    }
}