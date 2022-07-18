package io.sensify.sensor.ui

/**
 * Created by Manish Kumar on 15/07/22.
 */
sealed class Screen(val route: String){
    object SensorHomeScreen: Screen("sensor_home_screen")
    object SensorGravity: Screen("sensor_gravity_screen")
    object SensorGyroscope: Screen("sensor_gyroscope_screen")
    object SensorLight: Screen("sensor_light_screen")
    object SensorLinear: Screen("sensor_linear_screen")
    object SensorMagnetic: Screen("sensor_magnetic_screen")
    object SensorOrientation: Screen("sensor_orientation_screen")
    object SensorPressure: Screen("sensor_pressure_screen")
    object SensorProximity: Screen("sensor_proximity_screen")
    object SensorRelative: Screen("sensor_relative_screen")
    object SensorRotation: Screen("sensor_rotation_screen")
    object SensorTemperature: Screen("sensor_temperature_screen")

}