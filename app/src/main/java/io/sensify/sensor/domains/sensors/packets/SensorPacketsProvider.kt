package io.sensify.sensor.domains.sensors.packets

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import android.util.SparseArray
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.util.*

/**
 * Created by Niraj on 18-08-2022.
 */
class SensorPacketsProvider : SensorEventListener {


    companion object {
        private var sSensorPacketsProvider: SensorPacketsProvider? = null

        private val lock = Any()

        fun getInstance(): SensorPacketsProvider {
            synchronized(lock) {
                if (sSensorPacketsProvider == null) {
                    sSensorPacketsProvider = SensorPacketsProvider()
                }
                return sSensorPacketsProvider!!
            }
        }

    }


    var mDefaultScope = CoroutineScope(Job() + Dispatchers.Default)

    private var mSensorManager: SensorManager? = null

    private var mSensorConfigs = SparseArray<SensorPacketConfig>()


    private val _mSensorPacketFlow = MutableSharedFlow<SensorPacket>(replay = 0)
    val mSensorPacketFlow = _mSensorPacketFlow.asSharedFlow()


//    private

//    var keys: ds

    fun setSensorManager(manager: SensorManager): SensorPacketsProvider {
        mSensorManager = manager
        return this
    }


    fun attachSensor(config: SensorPacketConfig): SensorPacketsProvider {

        var prevConfig = mSensorConfigs.get(config.sensorType)
        var shouldRegister = true
        if (prevConfig != null) {
            if (prevConfig.sensorType != config.sensorType) {
                unregisterSensor(config)
            } else {
                shouldRegister = false
            }
        }
        if (shouldRegister) {
            mSensorConfigs.set(config.sensorType, config)
            registerSensor(config)
        }
        return this
    }


    fun detachSensor(sensorType: Int): SensorPacketsProvider {
        var sensorConfig = mSensorConfigs.get(sensorType)
        if (sensorConfig != null) {

            unregisterSensor(sensorConfig)

        }
        return this
    }


    private fun unregisterSensor(config: SensorPacketConfig) {
        if (mSensorManager == null) return
        mSensorManager?.unregisterListener(
            this,
            mSensorManager!!.getDefaultSensor(config.sensorType)
        )
    }

    private fun registerSensor(config: SensorPacketConfig) {
        if (mSensorManager == null) return
        mSensorManager?.registerListener(
            this,
            mSensorManager!!.getDefaultSensor(config.sensorType),
            config.sensorDelay
        )
    }

    override fun onSensorChanged(p0: SensorEvent?) {
/*        //TODO("Not yet implemented")*/

/*
        val sensorId: Int = event.sensor.getType()
        val time: Long = Calendar.getInstance().getTimeInMillis()
        val value: Float = event.values.get(0)
        */
/*LOGV(TAG, "service event  id: " + Integer.toString(sensorId)
                + ",| time: " + Long.toString(time)
                + ", | values: " + Float.toString(value));*//*

        */
/*LOGV(TAG, "service event  id: " + Integer.toString(sensorId)
                + ",| time: " + Long.toString(time)
                + ", | values: " + Float.toString(value));*//*
mSensorEvents.put(
            event.sensor.getType(),
            event
        )
*/
        if (p0 != null) {
            mDefaultScope.launch {
                onSensorEvent(p0)
            }

        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        //TODO("Not yet implemented")
    }

    private suspend fun onSensorEvent(sensorEvent: SensorEvent) {

        synchronized(this) {
            val sensorType = sensorEvent.sensor.type
            var sensorConfig = mSensorConfigs.get(sensorType)


            if (sensorConfig != null) {
                var sensorPacket = SensorPacket(
                    sensorEvent,
                    sensorType,
                    sensorConfig.sensorDelay,
                    System.currentTimeMillis()
                )
                mDefaultScope.launch {
                    Log.d("SensorPacketsProvider", "sa: ${Arrays.toString(sensorEvent.values)}")
                    _mSensorPacketFlow.emit(
                        sensorPacket
                    )

                }
            }


        }

    }


}


