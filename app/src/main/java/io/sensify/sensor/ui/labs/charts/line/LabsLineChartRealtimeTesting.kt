package io.sensify.sensor.ui.labs.charts.line

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import io.sensify.sensor.domains.sensors.packets.rememberSensorPackets
import io.sensify.sensor.domains.chart.mpchart.MpChartViewManager
import io.sensify.sensor.domains.chart.rememberChartUiUpdateEvent
import io.sensify.sensor.ui.resource.values.JlResDimens

/**
 * Created by Niraj on 18-09-2022.
 */


@Composable
fun LabsLineChartRealtimeTesting() {

    var sensorType = Sensor.TYPE_GRAVITY
//    val sensorData = rememberSensorPackets(sensorType = sensorType, sensorDelay = SensorManager.SENSOR_DELAY_NORMAL)



    var mpChartViewManager = MpChartViewManager(sensorType)
    val sensorUiUpdate = rememberChartUiUpdateEvent(mpChartViewManager, SensorManager.SENSOR_DELAY_NORMAL)

//    var counter = 0
//    Log.d("DefaultChartTesting", "Linechart isUpdating ${isUpdating.value}")
    AndroidView(
        modifier = Modifier
            .background(color = Color.LightGray)
            .height(JlResDimens.dp168)
            .fillMaxWidth(),

        factory = { ctx ->
            mpChartViewManager.createChart(ctx)
        },
        update = {


            mpChartViewManager.updateData(it, sensorUiUpdate.value)
        }
    )


    DisposableEffect(LocalLifecycleOwner.current) {
        onDispose {
            mpChartViewManager.destroy()

        }
    }
}
