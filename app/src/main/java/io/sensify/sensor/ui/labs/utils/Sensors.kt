package io.sensify.sensor.ui.labs.utils.Sensors

import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * Created by Manish Kumar on 29/07/22.
 */

@Composable
fun GravitySensor() {

    val gravitySensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
            // method to check accuracy changed in sensor.
        }

        // on below line we are creating a sensor on sensor changed
        override fun onSensorChanged(event: SensorEvent) {
            // check if the sensor type is proximity sensor.
            if (event.sensor.type == Sensor.TYPE_GRAVITY) {
                val values = event.values
                Log.i("SensorGravity", "x: ${values[0]} m/s², y: ${values[1]} m/s², z: ${values[2]} m/s²")
            }
        }
    }

    val sensorManager = LocalContext.current.getSystemService(SENSOR_SERVICE) as SensorManager

    val gravitySensor: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_GRAVITY); //Type Sensor
    if (gravitySensor.isNotEmpty()) {
        sensorManager.registerListener(gravitySensorEventListener, gravitySensor[0], SensorManager.SENSOR_DELAY_NORMAL);
    } else {
        Toast.makeText(LocalContext.current, "Sorry, sensor not available for this device.", Toast.LENGTH_LONG).show();
    }

}


@Composable
fun ProximitySensor(){
    val sensorManager = LocalContext.current.getSystemService(SENSOR_SERVICE) as SensorManager

    val proximitySensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
            // method to check accuracy changed in sensor.
        }

        // on below line we are creating a sensor on sensor changed
        override fun onSensorChanged(event: SensorEvent) {
            // check if the sensor type is proximity sensor.
            if (event.sensor.type == Sensor.TYPE_PROXIMITY) {
                val values = event.values
                Log.i("SensorProximity", "x: ${values[0]}")
            }
        }
    }

    val proximitySensor: List<Sensor> = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY); //Type Sensor
    if (proximitySensor.isNotEmpty()) {
        sensorManager.registerListener(proximitySensorEventListener, proximitySensor[0], SensorManager.SENSOR_DELAY_NORMAL);
    } else {
        Toast.makeText(LocalContext.current, "Sorry, proximity sensor not available for this device.", Toast.LENGTH_LONG).show();
    }
}











//
//@Composable
//fun ProximitySensor() {
//    // on below line we are creating
//    // a variable for a context
//    val ctx = LocalContext.current
//
//    // on below line we are creating a variable for sensor manager and initializing it.
//    val sensorManager: SensorManager = ctx.getSystemService(Context.SENSOR_SERVICE) as SensorManager
//
//    // on below line we are creating a variable for proximity sensor and initializing it.
//    val proximitySensor: Sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
//
//    // on below line we are creating a string variable for
//    // sensor status to set our sensor status.
//    val sensorStatus = remember {
//        mutableStateOf("")
//    }
//    // on below line we are creating a variable
//    // for sensor event listener and initializing it.
//    val proximitySensorEventListener = object : SensorEventListener {
//        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
//            // method to check accuracy changed in sensor.
//        }
//
//        // on below line we are creating a sensor on sensor changed
//        override fun onSensorChanged(event: SensorEvent) {
//            // check if the sensor type is proximity sensor.
//            if (event.sensor.type == Sensor.TYPE_PROXIMITY) {
//                // on below line we are checking if the
//                // object is near or away from the sensor.
//                if (event.values[0] == 0f) {
//                    // if sensor event return 0 then
//                    // object is near to the sensor
//                    sensorStatus.value = "Near"
//                } else {
//                    // to sensor else object is away from sensor.
//                    sensorStatus.value = "Away"
//                }
//            }
//        }
//    }
//
//    // on below line we are registering listener for our sensor manager.
//    sensorManager.registerListener(
//        // on below line we are passing
//        // proximity sensor event listener
//        proximitySensorEventListener,
//
//        // on below line we are
//        // setting proximity sensor.
//        proximitySensor,
//
//        // on below line we are specifying
//        // sensor manager as delay normal
//        SensorManager.SENSOR_DELAY_NORMAL
//    )
////    // on below line we are creating a column
////    Column(
////        // on below line we are specifying modifier
////        // and setting max height and max width for our column
////        modifier = Modifier
////            .fillMaxSize()
////            .fillMaxHeight()
////            .fillMaxWidth()
////            // on below line we are
////            // adding padding for our column
////            .padding(5.dp),
////        // on below line we are specifying horizontal
////        // and vertical alignment for our column
////        horizontalAlignment = Alignment.CenterHorizontally,
////        verticalArrangement = Arrangement.Center
////    ) {
////        // on below line we are creating a simple text
////        // in which we are displaying a text as Object is
////        Text(
////            text = "Object is",
////            // on below line we are setting text color
////            color = Color.Black,
////
////            // on below line we are specifying font weight
////            fontWeight = FontWeight.Bold,
////
////            // on below line we are specifying font family.
////            fontFamily = FontFamily.Default,
////
////            // on below line we are specifying
////            // font size and padding from all sides.
////            fontSize = 40.sp, modifier = Modifier.padding(5.dp)
////        )
////        // on below line we are creating a text for displaying
////        // sensor status weather object is near or away
////        Text(
////            text = sensorStatus.value,
////            // on below line we are setting color for our text
////            color = Color.Black,
////
////            // on below line we are setting font weight as bold
////            fontWeight = FontWeight.Bold,
////
////            // on below line we are setting font family
////            fontFamily = FontFamily.Default,
////
////            // on below line we are setting font family and padding
////            fontSize = 40.sp, modifier = Modifier.padding(5.dp)
////        )
////        // on below line we are creating a text for displaying a sensor.
////        Text(
////            text = "Sensor",
////            // on below line we are displaying a text color
////            color = Color.Black,
////
////            // on below line we are setting font weight
////            fontWeight = FontWeight.Bold,
////
////            // on below line we are setting font family
////            fontFamily = FontFamily.Default,
////
////            // on below line we are setting font size and padding.
////            fontSize = 40.sp, modifier = Modifier.padding(5.dp)
////        )
////    }
//}