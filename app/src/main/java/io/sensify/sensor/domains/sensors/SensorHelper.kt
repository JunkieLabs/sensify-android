package io.sensify.sensor.domains.sensors

import android.content.Context
import android.hardware.SensorManager
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * Created by Niraj on 19-08-2022.
 */

@Composable
fun sensorManagerProvider(): SensorManager {
    return LocalContext.current.getSystemService(Context.SENSOR_SERVICE) as SensorManager
}