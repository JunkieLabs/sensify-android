package io.sensify.sensor.ui.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import io.sensify.sensor.R
import io.sensify.sensor.ui.labs.models.SensorCardModel
import io.sensify.sensor.ui.labs.navigations.NavDirectionsLabs
import io.sensify.sensor.ui.pages.home.items.HomeSensorItem
import io.sensify.sensor.ui.pages.home.sections.HomeHeader
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResShapes
import io.sensify.sensor.ui.resource.values.JlResTxtStyles

/**
 * Created by Niraj on 26-09-2022.
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class, ExperimentalTextApi::class)
@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController? = null) {

    val lazyListState = rememberLazyListState()
    val sensorList = listOf(
        SensorCardModel("Gyroscope", "rpm", "340", R.drawable.ic_sensor_gyroscope),
        SensorCardModel("Gravity", "m/s\u00B2", "340", R.drawable.ic_sensor_gravity),
        SensorCardModel("Brightness", "cd", "340", R.drawable.ic_sensor_brightness),
        SensorCardModel("Magnetic Field", "amp/m", "340", R.drawable.ic_sensor_magnet),
        SensorCardModel("Temperature", "\u2103", "340", R.drawable.ic_sensor_temprature),
        SensorCardModel("Proximity", "cm", "340", R.drawable.ic_sensor_proximity),
        SensorCardModel("Pressure", "mbar", "340", R.drawable.ic_sensor_pressure),
        SensorCardModel("Humidity", "%", "340", R.drawable.ic_sensor_humidity),
        SensorCardModel("Rotation", "unknown", "340", R.drawable.ic_sensor_rotation),
        SensorCardModel("Acceleration", "m/s²", "340", R.drawable.ic_sensor_linear_acceleration),
        SensorCardModel("Compass", "Unknown", "340", R.drawable.ic_sensor_compass),

        )
    Scaffold(topBar = {

        SmallTopAppBar(

//            backgroundColor = Color.Transparent,
            colors =  if(lazyListState.firstVisibleItemIndex > 0) TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f), //Add your own color here, just to clarify.
            ) else TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Transparent //Add your own color here, just to clarify.
            ),

            modifier = Modifier.padding(horizontal = JlResDimens.dp16),

            navigationIcon = {
                Image(
                    painterResource(id = R.drawable.pic_sensify_logo),
                    modifier = Modifier
                        .width(JlResDimens.dp32)
                        .height(JlResDimens.dp36),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            },
            title = {
                Text(
                    text = "Sensify",
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    style = JlResTxtStyles.h4,
                    fontWeight = FontWeight(400),
                    modifier = modifier.fillMaxWidth(),
                )
            }
        )
    }) {
        LazyColumn(

            modifier = Modifier
                .consumedWindowInsets(it)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f),

                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.02f),
                        )
                    )
                )
//                .fillMaxSize()
//                .background(JLThemeBase.colorPrimary10)
//                .consumedWindowInsets

                .padding(start = JlResDimens.dp32, end = JlResDimens.dp32),
            contentPadding = it,
            state = lazyListState
        ) {

            item {
                Spacer(modifier = JlResShapes.Space.H24)

            }
            // Header
            item {
                HomeHeader()
            }

            // Plotting area
            item {
                Spacer(modifier = Modifier.height(JlResDimens.dp350))
            }

            // Available Sensors
            item {
                Box(
                    modifier = Modifier
                        .padding(bottom = JlResDimens.dp10)
                ) {
                    Text(
                        text = "Available Sensors",
                        fontSize = JlResDimens.sp16,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }



            // Sensor's card grid
            items(sensorList.windowed(2, 2, true)) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {

                    item.forEach {
                        Box(
                            modifier = Modifier
                                .fillParentMaxWidth(0.5f)
                                .padding(bottom = JlResDimens.dp8)
                                /*.clickable(
                                    enabled = true,
                                    onClickLabel = "Card Click",
                                    onClick = {
                                        navController?.navigate(NavDirectionsLabs.DetailPage.route)
                                    })*/

                        ) {
                            HomeSensorItem(
                                sensorName = it.sensorName,
                                sensorValue = it.sensorValue,
                                sensorUnit = it.sensorUnit,
                                sensorIcon = it.sensorIcon
                            )

                        }
                        Spacer(modifier = Modifier.width(JlResDimens.dp8))
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(JlResDimens.dp16)) }
//            }
        }
    }


}