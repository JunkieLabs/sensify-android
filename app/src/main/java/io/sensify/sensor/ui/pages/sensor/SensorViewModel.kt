package io.sensify.sensor.ui.pages.sensor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.sensify.sensor.domains.chart.mpchart.MpChartDataManager
import io.sensify.sensor.domains.sensors.packets.ModelSensorPacket
import io.sensify.sensor.domains.sensors.packets.SensorPacketsProvider
import io.sensify.sensor.domains.sensors.provider.SensorsProvider
import kotlinx.coroutines.launch

/**
 * Created by Niraj on 16-10-2022.
 */
class SensorViewModel(var mSensorType: Int) : ViewModel() {

    private var mSensorPacket: ModelSensorPacket? = null
    private var mChartDataManager : MpChartDataManager? = null

//    private var mSensorType: Int = -1

/*    init {
        SensorsProvider.getInstance().getSensor(sensorType = )
        viewModelScope.launch {
//            SensorPacketsProvider.getInstance().mSensorPacketFlow
        }
    }*/

    fun setSensorType(sensorType: Int){
        mSensorType = sensorType;

    }



    fun getChartDataManager(type: Int): MpChartDataManager {

        if(mChartDataManager?.sensorType == type){
            return  mChartDataManager!!
        }else{
            mChartDataManager =  MpChartDataManager(type, onDestroy = {
            })
        }

        return mChartDataManager!!
    }

}