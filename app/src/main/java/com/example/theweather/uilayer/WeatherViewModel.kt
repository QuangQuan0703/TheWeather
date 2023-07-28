package com.example.theweather.uilayer

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.theweather.domain.location.LocationCheck
import com.example.theweather.domain.repository.WeatherRepository
import com.example.theweather.domain.util.Resource
import com.example.theweather.domain.weather.WeatherData
import com.example.theweather.domain.weather.WeatherDayInfor
import com.example.theweather.domain.weather.WeatherFiveDayInfor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationDevice: LocationCheck
) : ViewModel() {
    var sate by mutableStateOf(SateWeather())
        private set


    fun loadData() {
        viewModelScope.launch {
            sate = sate.copy(
                weatherDataCurrent = loadCurrentData(),
                weatherFiveDayInfor = loadFiveDayData(),
                weatherDayInfor = loadDayData(),
                timeLocation = loadTimeLocation()
            )
            sate = sate.copy(load = false)
        }
    }

    suspend fun loadTimeLocation(): Resource<String> {
        val location = locationDevice.getCurrentLocationDevice()
        if (location != null) {
            return Resource.Success(
                "Success",
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date(location.time.toLong()))
                    .toString()
            )
        } else return Resource.Error("disconnect", data = null)
    }

    suspend fun loadCurrentData(): Resource<WeatherData> {
        val location = locationDevice.getCurrentLocationDevice()
        return repository.getWeatherDataCurrent(location?.latitude, location?.longitude)
    }

    suspend fun loadDayData(): Resource<WeatherDayInfor> {
        val location = locationDevice.getCurrentLocationDevice()
        return repository.getWeatherDayForecast(
            locationNow = location,
            lat = location?.latitude,
            lon = location?.longitude
        )
    }

    suspend fun loadFiveDayData(): Resource<WeatherFiveDayInfor> {
        val location = locationDevice.getCurrentLocationDevice()
        return repository.getWeatherFiveDayForecast(
            locationNow = location,
            lat = location?.latitude,
            lon = location?.longitude
        )
    }
}
