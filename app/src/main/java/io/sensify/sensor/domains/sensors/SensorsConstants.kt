package io.sensify.sensor.domains.sensors

import android.hardware.Sensor
import android.hardware.SensorManager
import android.util.SparseIntArray

/**
 * Created by Niraj on 13-09-2022.
 */
object SensorsConstants {


    const val DATA_AXIS_VALUE = 10
    const val DATA_AXIS_X = 11
    const val DATA_AXIS_Y = 12
    const val DATA_AXIS_Z = 13
    const val DATA_AXIS_VALUE_STRING = "val"
    const val DATA_AXIS_X_STRING = "x"
    const val DATA_AXIS_Y_STRING = "y"
    const val DATA_AXIS_Z_STRING = "z"


    val MAP_DELAY_TYPE_TO_DELAY: SparseIntArray = object : SparseIntArray() {
        init {
            put(SensorManager.SENSOR_DELAY_NORMAL, 200)
            put(SensorManager.SENSOR_DELAY_UI, 60)
            put(SensorManager.SENSOR_DELAY_GAME, 20)
            put(SensorManager.SENSOR_DELAY_FASTEST, 10)
        }
    }

    val MAP_TYPE_TO_AXIS_COUNT: SparseIntArray = object : SparseIntArray() {
        init {
            put(Sensor.TYPE_ACCELEROMETER, 3) //1
            put(Sensor.TYPE_MAGNETIC_FIELD, 3) //2
            put(Sensor.TYPE_ORIENTATION, 3) //3
            put(Sensor.TYPE_GYROSCOPE, 3) //4
            put(Sensor.TYPE_LIGHT, 1) //5
            put(Sensor.TYPE_PRESSURE, 1) //6
            put(Sensor.TYPE_TEMPERATURE, 1) //7
            put(Sensor.TYPE_PROXIMITY, 1) //8
            put(Sensor.TYPE_GRAVITY, 3) //9
            put(Sensor.TYPE_LINEAR_ACCELERATION, 3) //10
            put(Sensor.TYPE_ROTATION_VECTOR, 3) //11
            put(Sensor.TYPE_RELATIVE_HUMIDITY, 1) //12
            put(Sensor.TYPE_AMBIENT_TEMPERATURE, 1) //13
            put(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED, 3) //14
            put(Sensor.TYPE_GAME_ROTATION_VECTOR, 3) //15
            put(Sensor.TYPE_GYROSCOPE_UNCALIBRATED, 3) //16
            put(Sensor.TYPE_SIGNIFICANT_MOTION, 3) //17
            put(Sensor.TYPE_STEP_DETECTOR, 1) //18
            put(Sensor.TYPE_STEP_COUNTER, 1) //19
            put(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR, 3) //20
            put(Sensor.TYPE_HEART_RATE, 1) //21

        }
    }

}