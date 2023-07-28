package com.example.theweather.uilayer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.theweather.domain.weather.WeatherData

@Composable
fun ItemWeather(
    modifier: Modifier,
    backGroundColor: Color,
    itemSate: WeatherData
) {
    Card(
        backgroundColor = backGroundColor,
        modifier = modifier,
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = modifier.padding(10.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = itemSate.time,
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp)
            )
            Image(rememberAsyncImagePainter(
                model = itemSate.icon.linkIcon),
                contentDescription = null,
                modifier = modifier.size(30.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = itemSate.temp.toString(),
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 15.sp)
            )
        }
    }
}