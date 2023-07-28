package com.example.theweather.uilayer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun WeatherCard(
    sate: SateWeather,
    backGroundColor: Color,
    modifier: Modifier = Modifier
) {
    sate.weatherDataCurrent.data?.let { data ->

        Card(
            backgroundColor = backGroundColor,
            shape = MaterialTheme.shapes.medium,
            modifier = modifier
                .padding(5.dp)
                .wrapContentHeight()
                .height(150.dp)
                .fillMaxWidth(),
        ) {
            Row(
                horizontalArrangement  =  Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                Column(
                    modifier = modifier
                        .padding(10.dp)
                        .fillMaxWidth(0.5f),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = data.country,
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "${data.temp.toString()}°C",
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 40.sp)
                    )
                    Text(
                        text = "${data.tempMin}°C - ${data.tempMax}°C",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            Column(
                modifier = modifier
                    .padding(5.dp)
                    .wrapContentWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Image(
                    rememberAsyncImagePainter(model = data.icon.linkIcon),
                    contentDescription = data.icon.weatherDescription,
                    contentScale = ContentScale.Fit,
                    modifier = modifier.size(60.dp)
                )
                Text(
                    text = data.icon.weatherDescription,
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
        }
    }

}