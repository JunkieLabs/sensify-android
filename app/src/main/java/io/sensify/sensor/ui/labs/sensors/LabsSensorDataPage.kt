package io.sensify.sensor.ui.labs.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.sensify.sensor.domains.sensors.SensorsProviderComposable
import io.sensify.sensor.domains.sensors.packets.SensorPacketConfig
import io.sensify.sensor.domains.sensors.packets.SensorPacketsProvider
import io.sensify.sensor.domains.sensors.packets.rememberSensorPackets
import io.sensify.sensor.domains.sensors.provider.SensorsProvider
import io.sensify.sensor.domains.sensors.sensorManagerProvider
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*

/**
 * Created by Niraj on 18-08-2022.
 */


@Composable
fun LabsSensorDataPage(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()

    val sensors =  SensorsProviderComposable()

    val _tickFlow = MutableSharedFlow<Boolean>(replay = 0)
    val tickFlow = _tickFlow.asSharedFlow()

    val dsd = tickFlow.collectAsState(initial = false)
    val dse = tickFlow.collectAsState(initial = false)

    var visible1 by remember { mutableStateOf(true) }

    val sensor1 = rememberSensorPackets(sensorType = Sensor.TYPE_GRAVITY, sensorDelay = SensorManager.SENSOR_DELAY_NORMAL)
//    val sensor1Value = remember { sensor1 }

    val sensor2 = rememberSensorPackets(sensorType = Sensor.TYPE_GYROSCOPE, sensorDelay = SensorManager.SENSOR_DELAY_NORMAL)
//    val sensor2 = tickFlow.collectAsState(initial = false)


    sensors.value
//    val sensor11 = sensor1.

    val count: MutableState<Int> = remember { mutableStateOf(0) }


   /* val context = LocalContext.current
    LaunchedEffect(key1 = context){

        var sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        SensorPacketsProvider.getInstance().setSensorManager(sensorManager).attachSensor(
            SensorPacketConfig(Sensor.TYPE_GRAVITY, sensorDelay = SensorManager.SENSOR_DELAY_NORMAL)
        )
    }*/

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {

        Spacer(modifier = Modifier.height(20.dp))
        Divider(color = Color.White, thickness = 1.dp)

        Text("You've had ${count.value} glasses.")
        Button(onClick = { count.value++ }, Modifier.padding(top = 8.dp)) {
            Text("Add one")
        }
        Text(
            text = "Data", modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp),
            fontSize = 16.sp
        )
        Divider(color = Color.White, thickness = 1.dp)

        Button(
            onClick = {

                      visible1 = !visible1
                coroutineScope.launch {

                    _tickFlow.emit(!visible1)
                }


            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "S1")
        }

        if(dse.value){
            Text(
                text = "Data check1", modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(0.dp),

                fontSize = 16.sp
            )
        }

        if(dsd.value){
            Text(
                text = "Data check2", modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(0.dp),

                fontSize = 16.sp
            )
        }

        Button(
            onClick = {

                coroutineScope.launch {
                    SensorPacketsProvider.getInstance().detachSensor(Sensor.TYPE_GRAVITY)
 }


            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "Sensor 1  stop")
        }

        Button(
            onClick = {

                coroutineScope.launch {
                    SensorPacketsProvider.getInstance().detachSensor(Sensor.TYPE_GYROSCOPE)
                }


            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "Sensor 2 stop")
        }
      /*  Text(
            text = sensor1Value.value.toString(), modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp),

            fontSize = 16.sp
        )*/
        Text(
            text = "Data sensor1: ${Arrays.toString(sensor1.value.sensorEvent?.values)}", modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp),

            fontSize = 16.sp
        )
        Text(
            text = "Data sensor2: ${Arrays.toString(sensor2.value.sensorEvent?.values)}", modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp),

            fontSize = 16.sp
        )


        Button(
            onClick = {
                Log.d("LabsSensorDataPage", "listenSensor 1:click")

                /* coroutineScope.launch {
                     SensorPacketsProvider.getInstance().detachSensor(Sensor.TYPE_GYROSCOPE)
                 }*/
                coroutineScope.launch {
                    SensorsProvider.getInstance().listenSensor(Sensor.TYPE_ACCELEROMETER)
                        .collectLatest {
                            Log.d("LabsSensorDataPage", "listenSensor 1: ${it}")
                        }
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "Sensors Accelerometer")
        }


        Button(
            onClick = {
                Log.d("LabsSensorDataPage", "listenSensor 2:click")

                /* coroutineScope.launch {
                     SensorPacketsProvider.getInstance().detachSensor(Sensor.TYPE_GYROSCOPE)
                 }*/
                coroutineScope.launch {
                    SensorsProvider.getInstance().listenSensor(Sensor.TYPE_GYROSCOPE)
                        .collectLatest {
                            Log.d("LabsSensorDataPage", "listenSensor 2: ${it}")
                        }
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "Sensors Gyroscope")
        }

        Spacer(modifier = Modifier.height(16.dp))


        /*if(sensors.value.size>0){
            Log.d("LabsSensorDataPage", "sensors: ${sensors.value}")
        }*/

    }
}