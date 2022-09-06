package io.sensify.sensor.domains.sensors.provider

import android.hardware.Sensor
import android.util.Log
import androidx.compose.runtime.Composable
import io.sensify.sensor.domains.sensors.sensorManagerProvider
import io.sensify.sensor.domains.sensors.sensorTypeToName

/**
 * Created by Manish Kumar on 23/08/22.
 */

@Composable
fun sensorListProvider(): List<String?> {
    val sensorManager = sensorManagerProvider()
    val sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL).sortedBy { it.type }
    sensorList.forEach {
        Log.d("sensorlist : ", "${it.type} -> ${it.name}")
    }
    return sensorList.map { sensorTypeToName[(it.type)] }
}