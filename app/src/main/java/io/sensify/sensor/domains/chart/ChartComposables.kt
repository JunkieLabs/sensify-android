package io.sensify.sensor.domains.chart

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import io.sensify.sensor.domains.chart.entity.ModelChartUiUpdate
import io.sensify.sensor.domains.chart.mpchart.MpChartViewManager
import io.sensify.sensor.domains.sensors.packets.SensorPacket
import io.sensify.sensor.domains.sensors.packets.SensorPacketConfig
import io.sensify.sensor.domains.sensors.packets.SensorPacketsProvider
import io.sensify.sensor.domains.sensors.sensorManagerProvider
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

/**
 * Created by Niraj on 19-09-2022.
 */
@Composable
fun rememberChartUiUpdateEvent(
    mpChartViewManager: MpChartViewManager,
    sensorDelay: Int
): State<ModelChartUiUpdate> {
    val coroutineScope = rememberCoroutineScope()

    var sensorManager = sensorManagerProvider()

    var sensorFlow =
        SensorPacketsProvider.getInstance().setSensorManager(sensorManager).attachSensor(
            SensorPacketConfig(mpChartViewManager.sensorType, sensorDelay)
        ).mSensorPacketFlow
    val flow =
        sensorFlow.filter { sensorPacket ->
            var filtered = sensorPacket.type == mpChartViewManager.sensorType
            // sensorPacket.sensorEvent?.values
//            Log.d("rememberChartUiUpdateEvent", "filtered: $filtered, ${mpChartViewManager.sensorType}")
            return@filter filtered
        }

    coroutineScope.launch {
        flow.collect {
            mpChartViewManager.addEntry(it)
        }
    }

    var state1 =  mpChartViewManager.mSensorPacketFlow.collectAsState(
        initial = ModelChartUiUpdate(
            sensorType = mpChartViewManager.sensorType,
            0,
            listOf()
        )
    );

    return  state1;


}

