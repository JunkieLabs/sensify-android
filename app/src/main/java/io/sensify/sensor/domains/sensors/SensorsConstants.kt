package io.sensify.sensor.domains.sensors

import android.hardware.SensorManager
import android.util.SparseIntArray

/**
 * Created by Niraj on 13-09-2022.
 */
object SensorsConstants {
    val MAP_SAMPLE_TYPE_TO_DELAY: SparseIntArray = object : SparseIntArray() {
        init {
            put(SensorManager.SENSOR_DELAY_NORMAL, 200)
            put(SensorManager.SENSOR_DELAY_UI, 60)
            put(SensorManager.SENSOR_DELAY_GAME, 20)
            put(SensorManager.SENSOR_DELAY_FASTEST, 10)
        }
    }

    const val DATA_AXIS_VALUE = 10
    const val DATA_AXIS_X = 11
    const val DATA_AXIS_Y = 12
    const val DATA_AXIS_Z = 13
    const val DATA_AXIS_VALUE_STRING = "val"
    const val DATA_AXIS_X_STRING = "x"
    const val DATA_AXIS_Y_STRING = "y"
    const val DATA_AXIS_Z_STRING = "z"



}