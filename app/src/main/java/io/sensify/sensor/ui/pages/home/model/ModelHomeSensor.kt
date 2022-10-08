package io.sensify.sensor.ui.pages.home.model

import android.hardware.Sensor

/**
 * Created by Niraj on 08-10-2022.
 */
data class ModelHomeSensor(
    var type: Int = -1,
    var sensor: Sensor? = null,
    var info: MutableMap<String, Any> = mutableMapOf(),
    var valueRms: Float? = 0.0f,
    var isActive:  Boolean =  false
) {
}