package com.example.theweather.uilayer

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.theweather.domain.location.LocationCheck
import com.example.theweather.ui.theme.AppColor
import com.example.theweather.ui.theme.TheWeatherTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var locationCheck: LocationCheck
    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var permissionLaunch: ActivityResultLauncher<Array<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionLaunch = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            viewModel.loadData()
        }
        permissionLaunch.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
        setContent {
            TheWeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = AppColor().DeepBlue
                ) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Surface(modifier = Modifier.padding(10.dp)) {
                            WeatherCard(
                                sate = viewModel.sate,
                                backGroundColor = AppColor().DarkBlue
                            )
                        }
                        Surface(modifier = Modifier.padding(10.dp)) {
                            Card(
                                backgroundColor = AppColor().DarkBlue,
                                shape = MaterialTheme.shapes.medium,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .wrapContentHeight()
                                    .height(150.dp)
                                    .fillMaxWidth(),
                            ) {
                                Column {
                                    Text(
                                        text = "Weather Day Forecast",
                                        style = MaterialTheme.typography.bodyLarge,
                                        modifier = Modifier.padding(15.dp)
                                    )
                                    if (viewModel.sate.load == false) {
                                        LazyRow(modifier = Modifier.fillMaxWidth()) {
                                            items(viewModel.sate.weatherDayInfor.data!!.hournlyDay) { item ->
                                                ItemWeather(
                                                    modifier = Modifier,
                                                    backGroundColor = AppColor().DarkBlue,
                                                    itemSate = item
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        Surface(modifier = Modifier.padding(10.dp)) {
                            Card(
                                backgroundColor = AppColor().DarkBlue,
                                shape = MaterialTheme.shapes.medium,
                                modifier = Modifier
                                    .padding(5.dp)
                                    .wrapContentHeight()
                                    .height(150.dp)
                                    .fillMaxWidth(),
                            ) {
                                Column {
                                    Text(
                                        text = "Weather Day Forecast",
                                        style = MaterialTheme.typography.bodyLarge,
                                        modifier = Modifier.padding(15.dp)
                                    )
                                    if (viewModel.sate.load == false) {
                                        LazyRow(modifier = Modifier.fillMaxWidth()) {
                                            items(viewModel.sate.weatherFiveDayInfor.data!!.weatherDay) { item ->
                                                ItemWeather(
                                                    modifier = Modifier,
                                                    backGroundColor = AppColor().DarkBlue,
                                                    itemSate = item
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }

                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        locationCheck.requestUpdate()
    }
}

@Composable
fun Greeting(name: Unit, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheWeatherTheme {
    }
}