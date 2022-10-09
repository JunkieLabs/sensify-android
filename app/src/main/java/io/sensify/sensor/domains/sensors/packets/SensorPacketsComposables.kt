package io.sensify.sensor.domains.sensors.packets

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.flow.filter

/**
 * Created by Niraj on 19-08-2022.
 */

//@SuppressLint("FlowOperatorInvokedInComposition")
@SuppressLint("FlowOperatorInvokedInComposition")
@Composable
fun rememberSensorPackets(sensorType: Int, sensorDelay: Int): State<ModelSensorPacket> {
//    var sensorManager = sensorManagerProvider()
     var sensorFlow =
        SensorPacketsProvider.getInstance().mSensorPacketFlow
    /*SensorPacketsProvider.getInstance().setSensorManager(sensorManager).attachSensor(
        SensorPacketConfig(sensorType, sensorDelay)
    ).mSensorPacketFlow*/
    val state1 =
        sensorFlow.filter { sensorPacket ->
            var filtered = sensorPacket.type == sensorType
            // sensorPacket.sensorEvent?.values
//            Log.d("rememberSensorPackets", "filtered: $filtered, $sensorType")
        return@filter filtered
         }
            .collectAsState(initial = ModelSensorPacket(null, null, sensorType, sensorDelay, System.currentTimeMillis()))
    val context = LocalContext.current

    LaunchedEffect(key1 = context){

        var sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        Log.d("rememberSensorPackets","LaunchedEffect sensorType: $sensorType")

        SensorPacketsProvider.getInstance().setSensorManager(sensorManager).attachSensor(
            SensorPacketConfig(sensorType, sensorDelay = sensorDelay)
        )
    }
//    filter { sensorPacket -> sensorPacket.type == sensorType }
//            .collectAsState(initial = false)
    return state1
}

