package io.sensify.sensor.domains.sensors.provider

import android.hardware.Sensor
import android.hardware.SensorManager
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


/**
 * Created by Niraj on 05-10-2022.
 */
class SensorsProvider {

    companion object {
        private var sSensorsProvider: SensorsProvider? = null

        private val lock = Any()

        fun getInstance(): SensorsProvider {
            synchronized(lock) {
                if (sSensorsProvider == null) {
                    sSensorsProvider = SensorsProvider()
                }
                return sSensorsProvider!!
            }
        }

    }

    private var mSensors: List<ModelSensor> = mutableListOf()
    private var mSensorManager: SensorManager? = null
    private val _mSensorsFlow = MutableSharedFlow<List<ModelSensor>>(replay = 0)

    val mSensorsFlow = _mSensorsFlow.asSharedFlow()

    var mDefaultScope = CoroutineScope(Job() + Dispatchers.Default)

    fun setSensorManager(manager: SensorManager): SensorsProvider {
        mSensorManager = manager
        return this
    }


    fun listenSensors(): SensorsProvider {


        Log.d("SensorsProvider","listenSensors: ")
        if(mSensors.size<=0){
            val sensorList = mSensorManager!!.getSensorList(Sensor.TYPE_ALL)
            mSensors = sensorList.map { ModelSensor(it.type, it) }.toList()

        }

        mDefaultScope.launch {
            _mSensorsFlow.emit(mSensors)

        }
        return this
//        sensorList[0].
    }

    fun listenSensor(sensorType: Int): Flow<ModelSensor?> {

        return mSensorsFlow.map { sensors -> return@map sensors.singleOrNull { modelSensor ->
            modelSensor.type == sensorType }  }

    }







}