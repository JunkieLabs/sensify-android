package io.sensify.sensor.ui.pages.home.model

import android.hardware.Sensor
import io.sensify.sensor.domains.sensors.SensorsConstants

/**
 * Created by Niraj on 08-10-2022.
 */
data class ModelHomeSensor(
    var type: Int = -1,
    var sensor: Sensor? = null,
    var info: Map<String, Any> = mutableMapOf(),
    var valueRms: Float? = 0.0f,
    var isActive:  Boolean =  false,
var name: String = ""
) {

    init {

        name = SensorsConstants.MAP_TYPE_TO_NAME.get( type,sensor?.name?:"")
    }
}