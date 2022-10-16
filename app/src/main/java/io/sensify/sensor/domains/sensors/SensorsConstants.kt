package io.sensify.sensor.domains.sensors

import android.hardware.Sensor
import android.hardware.SensorManager
import android.util.SparseArray
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

    const val DETAIL_KEY_NAME = "Name"
    const val DETAIL_KEY_VENDOR = "Vendor"
    const val DETAIL_KEY_VERSION = "Version"
    const val DETAIL_KEY_POWER = "Power"
    const val DETAIL_KEY_Resolution = "Resolution"
    const val DETAIL_KEY_Range = "Range"


   /* val MAP_DETAIL_TYPE_TO_Key: SparseIntArray = object : SparseIntArray() {
        init {
            put(SensorManager.SENSOR_DELAY_NORMAL, 200)
            put(SensorManager.SENSOR_DELAY_UI, 60)
            put(SensorManager.SENSOR_DELAY_GAME, 20)
            put(SensorManager.SENSOR_DELAY_FASTEST, 10)
        }
    }*/

    val SENSORS = arrayOf(Sensor.TYPE_ACCELEROMETER,
        Sensor.TYPE_MAGNETIC_FIELD,
        Sensor.TYPE_ORIENTATION,
        Sensor.TYPE_GYROSCOPE,
        Sensor.TYPE_LIGHT,
        Sensor.TYPE_PRESSURE,
        Sensor.TYPE_TEMPERATURE,
        Sensor.TYPE_PROXIMITY,
        Sensor.TYPE_GRAVITY,
        Sensor.TYPE_LINEAR_ACCELERATION,
        Sensor.TYPE_ROTATION_VECTOR,
        Sensor.TYPE_RELATIVE_HUMIDITY,
        Sensor.TYPE_AMBIENT_TEMPERATURE,
        Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED,
        Sensor.TYPE_GAME_ROTATION_VECTOR,
        Sensor.TYPE_GYROSCOPE_UNCALIBRATED,
//        Sensor.TYPE_SIGNIFICANT_MOTION,
//        Sensor.TYPE_STEP_DETECTOR,
//        Sensor.TYPE_STEP_COUNTER,
        Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR,
        Sensor.TYPE_HEART_RATE)

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

    val MAP_TYPE_TO_NAME: SparseArray<String> = object : SparseArray<String>() {
        init {
            put(Sensor.TYPE_ACCELEROMETER, "Accelerometer") //1
            put(Sensor.TYPE_MAGNETIC_FIELD, "Magnetic") //2
            put(Sensor.TYPE_ORIENTATION, "Orientation") //3
            put(Sensor.TYPE_GYROSCOPE, "Gyroscope") //4
            put(Sensor.TYPE_LIGHT, "Light") //5
            put(Sensor.TYPE_PRESSURE, "Pressure") //6
            put(Sensor.TYPE_TEMPERATURE, "Temperature") //7
            put(Sensor.TYPE_PROXIMITY, "Proximity") //8
            put(Sensor.TYPE_GRAVITY, "Gravity") //9
            put(Sensor.TYPE_LINEAR_ACCELERATION, "Linear Acce.") //10
            put(Sensor.TYPE_ROTATION_VECTOR, "Rotation") //11
            put(Sensor.TYPE_RELATIVE_HUMIDITY, "humidity") //12
            put(Sensor.TYPE_AMBIENT_TEMPERATURE, "Temperature") //13
            put(Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED, "Magnetic") //14
            put(Sensor.TYPE_GAME_ROTATION_VECTOR, "Game Rotation") //15
            put(Sensor.TYPE_GYROSCOPE_UNCALIBRATED, "Gyroscope") //16
            put(Sensor.TYPE_SIGNIFICANT_MOTION, "Motion") //17
            put(Sensor.TYPE_STEP_DETECTOR, "Step detector") //18
            put(Sensor.TYPE_STEP_COUNTER, "Step counter") //19
            put(Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR, "Compass") //20
            put(Sensor.TYPE_HEART_RATE, "Heart rate") //21

//            put(Sensor.TYPE_STATIONARY_DETECT, R.color.md_amber_500);//29
//            put(Sensor.TYPE_MOTION_DETECT, R.color.md_amber_500);//30
//            put(Sensor.TYPE_HEART_BEAT, R.color.md_amber_500);//31
        }
    }


}