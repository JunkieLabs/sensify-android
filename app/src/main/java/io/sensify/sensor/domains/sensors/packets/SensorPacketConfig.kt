package io.sensify.sensor.domains.sensors.packets

import android.hardware.SensorManager

/**
 * Created by Niraj on 19-08-2022.
 */
data class SensorPacketConfig(
    var sensorType: Int,
    var sensorDelay: Int = SensorManager.SENSOR_DELAY_NORMAL
) {
}