package io.sensify.sensor.domains.sensors

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import io.sensify.sensor.domains.sensors.provider.ModelSensor
import io.sensify.sensor.domains.sensors.provider.SensorsProvider

/**
 * Created by Niraj on 05-10-2022.
 */
@Composable
fun  SensorsProviderComposable(): State<List<ModelSensor>> {
    var sensorManager = sensorManagerProvider()
    var sensorsProvider =
        SensorsProvider.getInstance().setSensorManager(sensorManager).listenSensors()

    val sensorsFlow = sensorsProvider.mSensorsFlow
    val state1 =
        sensorsFlow
            .collectAsState(initial = listOf<ModelSensor>(ModelSensor(-1, null)) )
    return state1
}