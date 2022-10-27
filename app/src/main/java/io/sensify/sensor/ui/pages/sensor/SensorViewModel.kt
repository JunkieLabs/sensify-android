package io.sensify.sensor.ui.pages.sensor

import android.content.Context
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.sensify.sensor.domains.chart.entity.ModelChartUiUpdate
import io.sensify.sensor.domains.chart.mpchart.MpChartDataManager
import io.sensify.sensor.domains.sensors.packets.ModelSensorPacket
import io.sensify.sensor.domains.sensors.packets.SensorPacketConfig
import io.sensify.sensor.domains.sensors.packets.SensorPacketsProvider
import io.sensify.sensor.domains.sensors.provider.SensorsProvider
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch

/**
 * Created by Niraj on 16-10-2022.
 */
class SensorViewModel(var mSensorType: Int) : ViewModel() {

    private var mLogTimestamp: Long = 0
    private var mSensorPacket: ModelSensorPacket? = null
    private var mChartDataManager : MpChartDataManager? = null
    private val _mSensorPacketFlow = MutableSharedFlow<ModelChartUiUpdate>(replay = 0)
    val mSensorPacketFlow = _mSensorPacketFlow.asSharedFlow()

    /*val mSensorPacketFlow : SharedFlow<ModelChartUiUpdate>
        get() {
            TODO()
        }*/
//    private var mSensorType: Int = -1

/*    init {
        SensorsProvider.getInstance().getSensor(sensorType = )
        viewModelScope.launch {
//            SensorPacketsProvider.getInstance().mSensorPacketFlow
        }
    }*/

    /*fun setSensorType(sensorType: Int){
        mSensorType = sensorType;

    }
*/
    init {
        getChartDataManager(mSensorType)
        initializeFlow()
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

    private fun initializeFlow(){

        var sensorPacketFlow =
            SensorPacketsProvider.getInstance().mSensorPacketFlow
        val sensorPacketFilteredFlow =
            sensorPacketFlow.filter { sensorPacket ->
                var filtered = sensorPacket.type == mSensorType
                // sensorPacket.sensorEvent?.values
//            Log.d("rememberChartUiUpdateEvent", "filtered: $filtered, ${mpChartViewManager.sensorType}")
                return@filter filtered
            }

              SensorPacketsProvider.getInstance().attachSensor(
                SensorPacketConfig(mSensorType, SensorManager.SENSOR_DELAY_NORMAL)
            )
            viewModelScope.launch {
                sensorPacketFilteredFlow.collect {
//                    Log.d("SensorViewModel", "init mSensorPacketFlow 2: ")
//                    Log.d("SensorViewModel", "addEntry: ${it.timestamp}")

                    if( it.timestamp - mLogTimestamp < 50){
                        Log.d("SensorViewModel", "addEntry: ${it.timestamp} ${it.type}")

                    }

                    mLogTimestamp = it.timestamp
                    mChartDataManager?.addEntry(it)
                }
            }

        viewModelScope.launch {
            mChartDataManager?.runPeriodically()

            mChartDataManager?.mSensorPacketFlow?.collect{

//                Log.d("SensorViewModel", "init mSensorPacketFlow: ${it.timestamp} ${it.size} ")
                _mSensorPacketFlow.emit(it)
            }
        }
    }

}