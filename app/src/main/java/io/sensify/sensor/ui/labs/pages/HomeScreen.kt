package io.sensify.sensor.ui.labs.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.sensify.sensor.R
import io.sensify.sensor.ui.pages.home.homewidgets.HomeSensorCard

/**
 * Created by Manish Kumar on 23/07/22.
 */

@Preview(showBackground=true, backgroundColor = 0xFF041B11)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF041B11))
    ) {

        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        ) {

            Row( verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)) {

                Spacer(modifier = modifier.width(12.dp))
                Image(
                    painterResource(id = R.drawable.pic_sensify_logo),
                    contentDescription = null,
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
            
            Spacer(modifier = Modifier.height(199.dp))

            Column(modifier = Modifier
                .padding(start = 32.dp, end = 32.dp)
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                     
                )  {

                    HomeSensorCard(
                        sensorName = "Gyroscope",
                        sensorValue = "340",
                        sensorUnit = "rpm",
                        sensorIcon = R.drawable.ic_sensor_gyroscope
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    HomeSensorCard(
                        sensorName = "Gravity",
                        sensorValue = "9.7",
                        sensorUnit = "m/s2",
                        sensorIcon = R.drawable.ic_sensor_gravity
                    )

                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    
                )  {

                    HomeSensorCard(
                        sensorName = "Gyroscope",
                        sensorValue = "340",
                        sensorUnit = "rpm",
                        sensorIcon = R.drawable.ic_sensor_gyroscope
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    HomeSensorCard(
                        sensorName = "Gravity",
                        sensorValue = "9.7",
                        sensorUnit = "m/s2",
                        sensorIcon = R.drawable.ic_sensor_gravity
                    )

                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                     
                )  {

                    HomeSensorCard(
                        sensorName = "Gyroscope",
                        sensorValue = "340",
                        sensorUnit = "rpm",
                        sensorIcon = R.drawable.ic_sensor_gyroscope
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    HomeSensorCard(
                        sensorName = "Gravity",
                        sensorValue = "9.7",
                        sensorUnit = "m/s2",
                        sensorIcon = R.drawable.ic_sensor_gravity
                    )

                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                     
                )  {

                    HomeSensorCard(
                        sensorName = "Gyroscope",
                        sensorValue = "340",
                        sensorUnit = "rpm",
                        sensorIcon = R.drawable.ic_sensor_gyroscope
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    HomeSensorCard(
                        sensorName = "Gravity",
                        sensorValue = "9.7",
                        sensorUnit = "m/s2",
                        sensorIcon = R.drawable.ic_sensor_gravity
                    )

                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                     
                )  {

                    HomeSensorCard(
                        sensorName = "Gyroscope",
                        sensorValue = "340",
                        sensorUnit = "rpm",
                        sensorIcon = R.drawable.ic_sensor_gyroscope
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    HomeSensorCard(
                        sensorName = "Gravity",
                        sensorValue = "9.7",
                        sensorUnit = "m/s2",
                        sensorIcon = R.drawable.ic_sensor_gravity
                    )

                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                     
                )  {

                    HomeSensorCard(
                        sensorName = "Gyroscope",
                        sensorValue = "340",
                        sensorUnit = "rpm",
                        sensorIcon = R.drawable.ic_sensor_gyroscope
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    HomeSensorCard(
                        sensorName = "Gravity",
                        sensorValue = "9.7",
                        sensorUnit = "m/s2",
                        sensorIcon = R.drawable.ic_sensor_gravity
                    )

                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                     
                )  {

                    HomeSensorCard(
                        sensorName = "Gyroscope",
                        sensorValue = "340",
                        sensorUnit = "rpm",
                        sensorIcon = R.drawable.ic_sensor_gyroscope
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    HomeSensorCard(
                        sensorName = "Gravity",
                        sensorValue = "9.7",
                        sensorUnit = "m/s2",
                        sensorIcon = R.drawable.ic_sensor_gravity
                    )

                }

                Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                     
                )  {

                    HomeSensorCard(
                        sensorName = "Gyroscope",
                        sensorValue = "340",
                        sensorUnit = "rpm",
                        sensorIcon = R.drawable.ic_sensor_gyroscope
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    HomeSensorCard(
                        sensorName = "Gravity",
                        sensorValue = "9.7",
                        sensorUnit = "m/s2",
                        sensorIcon = R.drawable.ic_sensor_gravity
                    )

                }

                Spacer(modifier = Modifier.height(15.dp))

            }


        }
    }

}