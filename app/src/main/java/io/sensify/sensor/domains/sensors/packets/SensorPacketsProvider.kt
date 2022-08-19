package io.sensify.sensor.domains.sensors.packets

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.SparseArray

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

    private var mSensorManager: SensorManager? = null

    private var mSensorConfigs = SparseArray<SensorPacketConfig>()

//    var keys: ds

    fun setSensorManager(manager: SensorManager) {
        mSensorManager = manager
    }


    fun attachSensor(config: SensorPacketConfig) {

        var prevConfig = mSensorConfigs.get(config.sensorType)
        var shouldRegister = true
        if (prevConfig != null) {
            if (prevConfig.sensorType != config.sensorType) {
                unregisterSensor(config)
            } else {
                shouldRegister = false
            }
        }
        if(shouldRegister){
            mSensorConfigs.set(config.sensorType, config)
            registerSensor(config)
        }

    }


    fun detachSensor(sensorType: Int) {
        var sensorConfig = mSensorConfigs.get(sensorType)
        if (sensorConfig != null) {

            unregisterSensor(sensorConfig)

        }
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

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        //TODO("Not yet implemented")
    }


}


