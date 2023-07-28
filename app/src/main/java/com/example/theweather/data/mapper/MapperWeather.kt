package com.example.theweather.data.mapper

import android.location.Location
import com.example.theweather.data.remote.Hournly
import com.example.theweather.data.remote.WeatherCurrentDataDto
import com.example.theweather.data.remote.WeatherForecastDataDto
import com.example.theweather.domain.weather.WeatherData
import com.example.theweather.domain.weather.WeatherDayInfor
import com.example.theweather.domain.weather.WeatherFiveDayInfor
import com.example.theweather.domain.weather.WeatherIcon
import java.text.SimpleDateFormat
import java.util.Date

 fun WeatherForecastDataDto.toWeatherDayInfor (locationNow: Location): WeatherDayInfor {
     val changeKtoC = 270
    val weatherDataDay: MutableList<WeatherData> = mutableListOf()
    val timeLocation= SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date(locationNow.time.toLong())).toString()

    val fillDay: List<Hournly> = list.filter {
        it.hounlyTimes.subSequence(0,10).toString() == timeLocation.subSequence(0,10).toString()
    }
    for (it in fillDay){
        weatherDataDay.add(WeatherData(
            time = it.hounlyTimes.subSequence(11,13).toString(),
            temp=  Math.round((it.weatherInfor.temp - changeKtoC) * 10.0) / 10.0,
            tempFeel = Math.round((it.weatherInfor.tempFeel - changeKtoC) * 10.0) / 10.0,
            tempMax = Math.round((it.weatherInfor.tempMax - changeKtoC) * 10.0) / 10.0,
            tempMin = Math.round((it.weatherInfor.tempMin - changeKtoC) * 10.0) / 10.0,
            clouds = it.clouds.all,
            wind = it.wind.speed,
            visibility = it.visibility,
            humidity = it.weatherInfor.humidity,
            icon= WeatherIcon(weatherDescription = it.weatherIcon[0].description
                ,"https://openweathermap.org/img/wn/${it.weatherIcon[0].icon}@2x.png"  )))
    }
    return  WeatherDayInfor(weatherDataDay)
}
fun WeatherForecastDataDto.toWeatherFiveDayInfor(locationNow: Location): WeatherFiveDayInfor{
    val changeKtoC = 270
    val mutableList: MutableList<WeatherData> = mutableListOf()
    val timeLocation = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date(locationNow.time.toLong())).toString()
    val filterDay = list.filter {
        it.hounlyTimes.subSequence(0,10).toString() != timeLocation.subSequence(0,10)
    }
    for (it in filterDay){
        mutableList.add(WeatherData(
            time = it.hounlyTimes.subSequence(11,13).toString(),
            temp=  Math.round((it.weatherInfor.temp - changeKtoC) * 10.0) / 10.0,
            tempFeel = Math.round((it.weatherInfor.tempFeel - changeKtoC) * 10.0) / 10.0,
            tempMax = Math.round((it.weatherInfor.tempMax - changeKtoC) * 10.0) / 10.0,
            tempMin = Math.round((it.weatherInfor.tempMin - changeKtoC) * 10.0) / 10.0,
            clouds = it.clouds.all,
            wind = it.wind.speed,
            visibility = it.visibility,
            humidity = it.weatherInfor.humidity,
            icon= WeatherIcon(weatherDescription = it.weatherIcon[0].description
                ,"https://openweathermap.org/img/wn/${it.weatherIcon[0].icon}@2x.png"  )))
    }
    return  WeatherFiveDayInfor(mutableList)
}

fun WeatherCurrentDataDto.toWeatherCurrent(): WeatherData{
    val changeKtoC = 270
    return (
            WeatherData(
                country = sys.country,
                time = "",
                temp=  Math.round((weatherInfor.temp - changeKtoC) * 10.0) / 10.0,
                tempFeel = Math.round((weatherInfor.tempFeel - changeKtoC) * 10.0) / 10.0,
                tempMax = Math.round((weatherInfor.tempMax - changeKtoC) * 10.0) / 10.0,
                tempMin = Math.round((weatherInfor.tempMin - changeKtoC) * 10.0) / 10.0,
                clouds = clouds.all,
                wind = wind.speed,
                visibility = visibility,
                humidity = weatherInfor.humidity,
                icon = WeatherIcon(weatherDescription = weatherIconInfor[0].description,
                    "https://openweathermap.org/img/wn/${weatherIconInfor[0].icon}@2x.png"  ))
            )
}