package io.sensify.sensor.ui.pages.home.items

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.viewinterop.AndroidView
import io.sensify.sensor.domains.chart.mpchart.MpChartViewManager
import io.sensify.sensor.domains.chart.rememberChartUiUpdateEvent
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResShapes
import io.sensify.sensor.ui.resource.values.JlResTxtStyles

/**
 * Created by Niraj on 30-09-2022.
 */
@Composable
fun HomeSensorChart() {

    var sensorType = Sensor.TYPE_GRAVITY
//    val sensorData = rememberSensorPackets(sensorType = sensorType, sensorDelay = SensorManager.SENSOR_DELAY_NORMAL)


    var mpChartViewManager = MpChartViewManager(sensorType)
    val sensorUiUpdate =
        rememberChartUiUpdateEvent(mpChartViewManager, SensorManager.SENSOR_DELAY_NORMAL)

//    var counter = 0
//    Log.d("DefaultChartTesting", "Linechart isUpdating ${isUpdating.value}")

    var colorSurface = MaterialTheme.colorScheme.surface
    var colorOnSurface = MaterialTheme.colorScheme.onSurface
    Column(
        modifier = Modifier
            .background(color = Color.Transparent)
            .padding(horizontal = JlResDimens.dp12, vertical = JlResDimens.dp12)
//            .height(JlResDimens.dp168)
            .fillMaxSize(),
    ) {

        Text(
            modifier = Modifier.padding(horizontal = JlResDimens.dp12),
            text = "Gyroscope",



            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Start,
            style = JlResTxtStyles.h5,)
        AndroidView(
            modifier = Modifier
                .background(color = Color.Transparent)
//            .height(JlResDimens.dp168)
                .fillMaxSize(),

            factory = { ctx ->
                mpChartViewManager.createChart(ctx, colorSurface, colorOnSurface)
            },
            update = {


                mpChartViewManager.updateData(it, sensorUiUpdate.value)
            }
        )
        Spacer(modifier = JlResShapes.Space.H18)

    }

    DisposableEffect(LocalLifecycleOwner.current) {
        onDispose {
            mpChartViewManager.destroy()

        }
    }
}