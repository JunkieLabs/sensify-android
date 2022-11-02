package io.sensify.sensor.ui.labs.charts.line

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import io.sensify.sensor.domains.chart.mpchart.MpChartDataManager
import io.sensify.sensor.domains.chart.mpchart.MpChartViewBinder
import io.sensify.sensor.domains.chart.mpchart.MpChartViewManager
import io.sensify.sensor.domains.chart.mpchart.MpChartViewUpdater
import io.sensify.sensor.domains.chart.mpchart.view.MpChartLineView
import io.sensify.sensor.domains.chart.rememberChartUiUpdateEvent
import io.sensify.sensor.ui.resource.values.JlResDimens

/**
 * Created by Niraj on 18-09-2022.
 */


@Composable
fun LabsLineChartRealtimeTesting(
    mpChartViewUpdater: MpChartViewUpdater = MpChartViewUpdater(),) {

    var sensorType = Sensor.TYPE_GRAVITY
//    val sensorData = rememberSensorPackets(sensorType = sensorType, sensorDelay = SensorManager.SENSOR_DELAY_NORMAL)

    var mpChartDataManager = MpChartDataManager(sensorType)
    val sensorUiUpdate = rememberChartUiUpdateEvent(mpChartDataManager, SensorManager.SENSOR_DELAY_NORMAL)

    var colorSurface = MaterialTheme.colorScheme.surface
    var colorOnSurface = MaterialTheme.colorScheme.onSurface
//    var counter = 0
//    Log.d("DefaultChartTesting", "Linechart isUpdating ${isUpdating.value}")
    AndroidView(
        modifier = Modifier
            .background(color = Color.LightGray)
            .height(JlResDimens.dp168)
            .fillMaxWidth(),

        factory = { ctx ->
            var view = MpChartLineView(sensorType);
            val lineChart = MpChartViewBinder(ctx, view).prepareDataSets(mpChartDataManager.getModel())
                .invalidate()
            return@AndroidView lineChart
        },
        update = {
            mpChartViewUpdater.update(it, sensorUiUpdate.value, mpChartDataManager.getModel())
        }
    )


    DisposableEffect(LocalLifecycleOwner.current) {
        onDispose {
            mpChartDataManager.destroy()

        }
    }
}
