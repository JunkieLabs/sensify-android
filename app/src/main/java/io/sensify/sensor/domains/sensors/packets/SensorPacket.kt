package io.sensify.sensor.domains.sensors.packets

import android.hardware.SensorEvent
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * Created by Niraj on 19-08-2022.
 */
data class SensorPacket(var sensorEvent: SensorEvent? = null, var type: Int, var delay: Int, var timestamp: Long) {

}