package io.sensify.sensor.domains.sensors.provider

import android.hardware.Sensor
import io.sensify.sensor.domains.sensors.SensorsConstants

/**
 * Created by Niraj on 05-10-2022.
 */
class ModelSensor(var type: Int = -1, var sensor: Sensor? = null, var info: MutableMap<String, Any> = mutableMapOf()) {

    init {
        if(sensor!=null){
            /*sensorType =  sensor.getType();*/

            info[SensorsConstants.DETAIL_KEY_NAME] = sensor!!.name
            info[SensorsConstants.DETAIL_KEY_VENDOR] = sensor!!.vendor
            info[SensorsConstants.DETAIL_KEY_VERSION] = sensor!!.version
            info[SensorsConstants.DETAIL_KEY_POWER] = sensor!!.power
            info[SensorsConstants.DETAIL_KEY_Resolution] = sensor!!.resolution
            info[SensorsConstants.DETAIL_KEY_Range] = sensor!!.maximumRange

            /*name=  sensor.getName();
            vendorName = sensor.getVendor();
            version = sensor.getVersion();
            power = sensor.getPower();
            resolution = sensor.getResolution();
            maxRange = sensor.getMaximumRange();*/
        }
    }
}