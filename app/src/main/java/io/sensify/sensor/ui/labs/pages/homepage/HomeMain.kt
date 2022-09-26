package io.sensify.sensor.ui.pages.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import io.sensify.sensor.R
import io.sensify.sensor.ui.labs.models.SensorCardModel
import io.sensify.sensor.ui.labs.navigations.NavDirectionsLabs
import io.sensify.sensor.ui.labs.pages.homepage.homewidgets.HomePageHeader
import io.sensify.sensor.ui.labs.pages.homepage.homewidgets.HomeSensorCard
import io.sensify.sensor.ui.pages.home.items.HomeSensorItem
import io.sensify.sensor.ui.resource.themes.JLThemeBase
import io.sensify.sensor.ui.resource.themes.JlThemeM3
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResShapes
import io.sensify.sensor.ui.resource.values.JlResTxtStyles

/**
 * Created by Manish Kumar on 09/08/22.
 */

@Preview(showBackground=true, backgroundColor = 0xFF041B11)
@Composable
fun HomeMain(modifier: Modifier = Modifier, navController: NavController? = null){

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

    Column(modifier = Modifier
        .fillMaxSize()
        .background(JLThemeBase.colorPrimary10)
        .padding(start = JlResDimens.dp32, end = JlResDimens.dp32)
    ) {
        // AppBar
        Row( verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(JlResDimens.dp32)) {
            Image(
                painterResource(id = R.drawable.pic_sensify_logo),
                modifier = Modifier
                    .width(JlResDimens.dp32)
                    .height(JlResDimens.dp36),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = "Sensify",
                color = JlThemeM3.md_theme_dark_onPrimary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight(400),
                modifier = modifier.fillMaxWidth(),
            )

        }

        LazyColumn(modifier = Modifier
            .fillMaxSize()
        ){

            // Header
            item{
                HomePageHeader()
            }

            // Plotting area
            item {
                Spacer(modifier = Modifier.height(JlResDimens.dp350))
            }

            // Available Sensors
            item{
                Box(
                    modifier = Modifier
                        .padding(bottom = JlResDimens.dp10)
                ) {
                    Text(
                        text = "Available Sensors",
                        fontSize = JlResDimens.sp16,
                        color = Color.White
                    )
                }
            }

            // Sensor's card grid
            items(sensorList.windowed(2, 2, true)){ item ->
                Row(modifier = Modifier
                    .fillMaxWidth()

                ) {

                    item.forEach {
                        Box(modifier = Modifier
                            .fillParentMaxWidth(0.5f)
                            .padding(bottom = JlResDimens.dp8)
                            .clickable(enabled = true, onClickLabel = "Card Click", onClick = {
                                navController?.navigate(NavDirectionsLabs.DetailPage.route)
                            })

                        ) {
                            HomeSensorCard(
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

            item{ Spacer(modifier = Modifier.height(JlResDimens.dp16))}
        }
    }
}
//fun Modifier.clickable(
//    enabled: Boolean = true,
//    onClickLabel: String? = null,
//    role: Role? = null,
//    onClick: () -> Unit
//) = composed(
//    inspectorInfo = debugInspectorInfo {
//        name = "clickable"
//        properties["enabled"] = enabled
//        properties["onClickLabel"] = onClickLabel
//        properties["role"] = role
//        properties["onClick"] = onClick
//    },
//
//)