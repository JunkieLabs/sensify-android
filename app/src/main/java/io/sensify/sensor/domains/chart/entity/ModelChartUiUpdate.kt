package io.sensify.sensor.domains.chart.entity

import io.sensify.sensor.domains.sensors.packets.SensorPacket

/**
 * Created by Niraj on 18-09-2022.
 */
data class ModelChartUiUpdate(
    var sensorType: Int,
    var size: Int,
    var packets: List<SensorPacket> = listOf(),
    var timestamp: Long = System.currentTimeMillis()
) {
}