package io.sensify.sensor.ui.labs.pages.homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.sensify.sensor.R
import io.sensify.sensor.ui.labs.pages.homepage.homewidgets.HomePageHeader
import io.sensify.sensor.ui.labs.pages.homepage.homewidgets.HomeSensorCard

/**
 * Created by Manish Kumar on 09/08/22.
 */

@Preview(showBackground=true, backgroundColor = 0xFF041B11)
@Composable
fun HomePage(
    modifier: Modifier = Modifier
){

    val numberOfItemsByRow = LocalConfiguration.current.screenWidthDp / 200

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF041B11))
    ) {

        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        ) {


            // AppBar
            Row( verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(32.dp)) {


                Image(
                    painterResource(id = R.drawable.pic_sensify_logo),
                    modifier = Modifier
                        .width(30.dp)
                        .height(37.dp),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = "Sensify",
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight(400),
                    modifier = modifier.fillMaxWidth(),
                )

            }

            HomePageHeader()

            Spacer(modifier = Modifier.height(350.dp))

//            Sensor Cards
            Column(modifier = Modifier
                .padding(start = 32.dp, end = 32.dp, top = 28.dp)
            ) {

                Box(
                    modifier = Modifier
                        .padding(bottom = 11.dp)
                ) {
                    Text(
                        text = "Available Sensors",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {

                    Box(modifier = Modifier
                        .weight(1f)
                    ){
                        HomeSensorCard(
                            sensorName = "Gyroscope",
                            sensorValue = "340",
                            sensorUnit = "rpm",
                            sensorIcon = R.drawable.ic_sensor_gyroscope
                        )
                    }

                    Box(modifier = Modifier
                        .weight(1f)
                    ) {
                        HomeSensorCard(
                            sensorName = "Gravity",
                            sensorValue = "9.7",
                            sensorUnit = "m/s\u00B2",
                            sensorIcon = R.drawable.ic_sensor_gravity
                        )
                    }

                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                    ) {

                        HomeSensorCard(
                            sensorName = "Brightness",
                            sensorValue = "340",
                            sensorUnit = "cd",
                            sensorIcon = R.drawable.ic_sensor_brightness
                        )
                    }

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                    ) {
                        HomeSensorCard(
                            sensorName = "Magnetic Field",
                            sensorValue = "9.7",
                            sensorUnit = "amp/m",
                            sensorIcon = R.drawable.ic_sensor_magnet
                        )
                    }

                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {

                    Box(modifier = Modifier
                        .weight(0.5f)
                    ) {
                        HomeSensorCard(
                            sensorName = "Temperature",
                            sensorValue = "340",
                            sensorUnit = "\u2103",
                            sensorIcon = R.drawable.ic_sensor_temprature
                        )
                    }

                    Box(modifier = Modifier
                        .weight(0.5f)
                    ) {
                        HomeSensorCard(
                            sensorName = "Proximity",
                            sensorValue = "9.7",
                            sensorUnit = "cm",
                            sensorIcon = R.drawable.ic_sensor_proximity
                        )
                    }

                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {

                    Box(modifier = Modifier
                        .weight(0.5f)
                    ) {
                        HomeSensorCard(
                            sensorName = "Pressure",
                            sensorValue = "340",
                            sensorUnit = "mbar",
                            sensorIcon = R.drawable.ic_sensor_pressure
                        )
                    }

                    Box(modifier = Modifier
                        .weight(0.5f)
                    ) {
                        HomeSensorCard(
                            sensorName = "Humidity",
                            sensorValue = "9.7",
                            sensorUnit = "%",
                            sensorIcon = R.drawable.ic_sensor_humidity
                        )
                    }

                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {

                    Box(modifier = Modifier
                        .weight(0.5f)
                    ) {
                        HomeSensorCard(
                            sensorName = "Rotation",
                            sensorValue = "340",
                            sensorUnit = "unknown",
                            sensorIcon = R.drawable.ic_sensor_rotation
                        )
                    }

                    Box(modifier = Modifier
                        .weight(0.5f)
                    ) {
                        HomeSensorCard(
                            sensorName = "Accelerometer",
                            sensorValue = "9.7",
                            sensorUnit = "m/s2",
                            sensorIcon = R.drawable.ic_sensor_linear_acceleration
                        )
                    }

                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {

                    Box(modifier = Modifier
                        .weight(0.5f)
                    ) {
                        HomeSensorCard(
                            sensorName = "Brightness",
                            sensorValue = "340",
                            sensorUnit = "cd",
                            sensorIcon = R.drawable.ic_sensor_brightness
                        )
                    }

                    Box(modifier = Modifier
                        .weight(0.5f)
                    ) {
                        HomeSensorCard(
                            sensorName = "Compass",
                            sensorValue = "9.7",
                            sensorUnit = "Unknown",
                            sensorIcon = R.drawable.ic_sensor_compass
                        )
                    }

                }
            }

//            LazyColumn(modifier = modifier) {
//
//                items(items = trendingGameList.chunked(numberOfItemsByRow)) { rowItems ->
//                    Row(
//                        horizontalArrangement = Arrangement.spacedBy(14.dp),
//                        modifier = Modifier.padding(horizontal = 16.dp),
//                    ) {
//                        for (game in rowItems) {
//                            GameCard(game = game, onClick = { }, modifier = Modifier.weight(1F))
//                        }
//                    }
//                    Spacer(Modifier.height(14.dp))
//                }
//            }
        }
    }

}