package io.sensify.sensor.domains.sensors.provider

import android.hardware.Sensor
import io.sensify.sensor.domains.sensors.SensorsConstants

/**
 * Created by Niraj on 05-10-2022.
 */
class ModelSensor(
    var type: Int = -1,
    var sensor: Sensor? = null,
    var info: Map<String, Any> = mutableMapOf(),
   var name: String =  ""

) {

    init {
        if (sensor != null) {
            name = SensorsConstants.MAP_TYPE_TO_NAME.get( type,sensor?.name?:"")
            if (info is MutableMap<String, Any>) {
                /*sensorType =  sensor.getType();*/

                (info as MutableMap<String, Any>)[SensorsConstants.DETAIL_KEY_NAME] = sensor!!.name
                (info as MutableMap<String, Any>)[SensorsConstants.DETAIL_KEY_VENDOR] =
                    sensor!!.vendor
                (info as MutableMap<String, Any>)[SensorsConstants.DETAIL_KEY_VERSION] =
                    sensor!!.version
                (info as MutableMap<String, Any>)[SensorsConstants.DETAIL_KEY_POWER] =
                    sensor!!.power
                (info as MutableMap<String, Any>)[SensorsConstants.DETAIL_KEY_Resolution] =
                    sensor!!.resolution
                (info as MutableMap<String, Any>)[SensorsConstants.DETAIL_KEY_Range] =
                    sensor!!.maximumRange

                /*name=  sensor.getName();
            vendorName = sensor.getVendor();
            version = sensor.getVersion();
            power = sensor.getPower();
            resolution = sensor.getResolution();
            maxRange = sensor.getMaximumRange();*/
            }
        }
    }
}