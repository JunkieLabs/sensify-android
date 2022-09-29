package io.sensify.sensor.ui.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode
import io.sensify.sensor.R
import io.sensify.sensor.ui.labs.models.SensorCardModel
import io.sensify.sensor.ui.labs.navigations.NavDirectionsLabs
import io.sensify.sensor.ui.pages.home.items.HomeSensorItem
import io.sensify.sensor.ui.pages.home.sections.HomeHeader
import io.sensify.sensor.ui.pages.home.sections.HomeSensorGraphPager
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
            colors = if (lazyListState.firstVisibleItemIndex > 0) TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f), //Add your own color here, just to clarify.
            ) else TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Transparent //Add your own color here, just to clarify.
            ),


            navigationIcon = {
                Box(Modifier.padding(horizontal = JlResDimens.dp20)) {
                    Image(
                        painterResource(id = R.drawable.pic_sensify_logo),
                        modifier = Modifier
                            .width(JlResDimens.dp32)
                            .height(JlResDimens.dp36),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                }

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
            },
            actions = {
                Box(Modifier.padding(horizontal = JlResDimens.dp20)) {
                    Image(

                        painterResource(id = R.drawable.pic_sensify_logo),
                        modifier = Modifier
                            .alpha(0f)
                            .width(JlResDimens.dp32)
                            .height(JlResDimens.dp36),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds
                    )
                }
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
                ),
//                .fillMaxSize()
//                .background(JLThemeBase.colorPrimary10)
//                .consumedWindowInsets ,
            contentPadding = it,
            state = lazyListState
        ) {

            item {
                Spacer(modifier = JlResShapes.Space.H24)

            }
            // Header
            item {
                Box(
                    modifier = Modifier.padding(
                        start = JlResDimens.dp32,
                        end = JlResDimens.dp32
                    ),
                ) {
                    HomeHeader()
                }
            }

            // Plotting area
            item {
//                Spacer(modifier = Modifier.height(JlResDimens.dp350))

                HomeSensorGraphPager()

            }

            // Available Sensors
            item {
                Box(
                    modifier = Modifier
                        .padding(
                            start = JlResDimens.dp40, end = JlResDimens.dp32,
                            top = JlResDimens.dp12, bottom = JlResDimens.dp16
                        ),
                ) {
                    Text(
                        text = "Available Sensors",
                        fontSize = JlResDimens.sp16,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }


            /*item {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = JlResDimens.dp32, end = JlResDimens.dp32),) {

                }
            }*/


            /*item {

                val itemSize = ((LocalConfiguration.current.screenWidthDp.dp - 80.dp) / 2)
                Box(
                    modifier = Modifier.padding(horizontal = JlResDimens.dp32)
                ) {

                    FlowRow(
                        mainAxisSize = SizeMode.Expand,

                        mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
                        crossAxisSpacing = JlResDimens.dp8,
                        mainAxisSpacing = JlResDimens.dp8


                    ) {
                        sensorList.forEach {
                            Box(
                                modifier = Modifier
                                    .defaultMinSize(minWidth = itemSize)
                                    .fillMaxWidth(0.5f)


//                                .defaultMinSize(minWidth =  itemSize)

//                                .padding(bottom = JlResDimens.dp8)
                                    .clickable(
                                        enabled = true,
                                        onClickLabel = "Card Click",
                                        onClick = {
                                            navController?.navigate(NavDirectionsLabs.DetailPage.route)
                                        })

                            ) {
                                HomeSensorItem(
                                    sensorName = it.sensorName,
                                    sensorValue = it.sensorValue,
                                    sensorUnit = it.sensorUnit,
                                    sensorIcon = it.sensorIcon
                                )

                            }
                        }
                    }
                }
            }*/

            /*LazyVerticalGrid(
                modifier = Modifier,
                columns  = GridCells.Adaptive(minSize = 120.dp)
            ) {
               *//* items(sensorList){ item: SensorCardModel ->
                        Box(
                            modifier = Modifier
                                .fillParentMaxWidth(0.5f)
                                .padding(bottom = JlResDimens.dp8)
                            .clickable(
                                enabled = true,
                                onClickLabel = "Card Click",
                                onClick = {
                                    navController?.navigate(NavDirectionsLabs.DetailPage.route)
                                })

                        ) {
                            HomeSensorItem(
                                sensorName = item.sensorName,
                                sensorValue = item.sensorValue,
                                sensorUnit = item.sensorUnit,
                                sensorIcon = item.sensorIcon
                            )

                        }
                    }*//*
                }
            }*/

            items(sensorList.windowed(2, 2, true)) { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = JlResDimens.dp32)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,


                        ) {

                        for (i in item.indices) {
                            Box(
                                modifier = Modifier
                                    .weight(1f)
//                                    .fillParentMaxWidth(0.5f)
//                                    .padding(bottom = JlResDimens.dp8)
                                /*.clickable(
                                enabled = true,
                        onClickLabel = "Card Click",
                        onClick = {
                            navController?.navigate(NavDirectionsLabs.DetailPage.route)
                        })*/

                            ) {
                                HomeSensorItem(
                                    sensorName = item[i].sensorName,
                                    sensorValue = item[i].sensorValue,
                                    sensorUnit = item[i].sensorUnit,
                                    sensorIcon = item[i].sensorIcon
                                )

                            }

                            if (i < item.size - 1) {
                                Spacer(modifier = Modifier.width(JlResDimens.dp8))
                            }
                        }
                        if (item.size % 2 != 0) {
                            Spacer(modifier = Modifier.width(JlResDimens.dp8))

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                            )
                        }

                        /* item.forEach {
                             Box(
                                 modifier = Modifier
                                     .weight(1f)
 //                                    .fillParentMaxWidth(0.5f)
 //                                    .padding(bottom = JlResDimens.dp8)
                             ) {
                                 HomeSensorItem(
                                     sensorName = it.sensorName,
                                     sensorValue = it.sensorValue,
                                     sensorUnit = it.sensorUnit,
                                     sensorIcon = it.sensorIcon
                                 )

                             }

                         }*/
                    }
                }
                Spacer(modifier = Modifier.height(JlResDimens.dp8))

            }
            // Sensor's card grid
            /* items(sensorList.windowed(2, 2, true)) { item ->
                 Row(
                     modifier = Modifier
                         .fillMaxWidth()

                     ) {

                     item.forEach {
                         Box(
                             modifier = Modifier
                                 .fillParentMaxWidth(0.5f)
                                 .padding(bottom = JlResDimens.dp8)
                             *//*.clickable(
                                enabled = true,
                                onClickLabel = "Card Click",
                                onClick = {
                                    navController?.navigate(NavDirectionsLabs.DetailPage.route)
                                })*//*

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
            }*/

            item { Spacer(modifier = Modifier.height(JlResDimens.dp16)) }
//            }
        }
    }


}