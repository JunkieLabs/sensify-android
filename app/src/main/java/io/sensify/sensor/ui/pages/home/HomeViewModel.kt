package io.sensify.sensor.ui.pages.home

import android.hardware.Sensor
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import io.sensify.sensor.domains.chart.mpchart.MpChartDataManager
import io.sensify.sensor.domains.sensors.packets.ModelSensorPacket
import io.sensify.sensor.domains.sensors.packets.SensorPacketsProvider
import io.sensify.sensor.domains.sensors.provider.SensorsProvider
import io.sensify.sensor.ui.pages.home.model.ModelHomeSensor
import io.sensify.sensor.ui.pages.home.state.HomeUiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * Created by Niraj on 08-10-2022.
 */
class HomeViewModel : ViewModel() {


    private var mSensors: MutableList<ModelHomeSensor> = mutableListOf()

    // Game UI state
    private val _uiState = MutableStateFlow(HomeUiState())

    // Backing property to avoid state updates from other classes
    val mUiState: StateFlow<HomeUiState> = _uiState.asStateFlow()


   /* private val _uiPagerState = MutableStateFlow(HomeUiState())
    // Backing property to avoid state updates from other classes
    val mUiPagerState: StateFlow<HomeUiState> = _uiPagerState.asStateFlow()
*/

    private val _mSensorsList = mutableStateListOf<ModelHomeSensor>()
    val mSensorsList: SnapshotStateList<ModelHomeSensor> = _mSensorsList

    private val _mUiCurrentSensorState = MutableStateFlow<ModelHomeSensor?>(null)
    val mUiCurrentSensorState: StateFlow<ModelHomeSensor?> = _mUiCurrentSensorState.asStateFlow()


    /*
    TODO remove not consistent
    private val _mActiveSensorStateList = mutableStateListOf<ModelHomeSensor>()
     val mActiveSensorStateList: SnapshotStateList<ModelHomeSensor> = _mActiveSensorStateList
 */

    private val _mActiveSensorListFlow = MutableStateFlow<MutableList<ModelHomeSensor>>(
        mutableListOf())
    val mActiveSensorListFlow: StateFlow<MutableList<ModelHomeSensor>> = _mActiveSensorListFlow
    private val _mActiveSensorList = mutableListOf<ModelHomeSensor>()

        private val mIsActiveMap = mutableMapOf<Int, Boolean>(Pair(Sensor.TYPE_GYROSCOPE, true), Pair(Sensor.TYPE_ACCELEROMETER, true))
//    TODO use this in future private val mSensorPacketsMap = mutableMapOf<Int, ModelSensorPacket>()
    private val mChartDataManagerMap = mutableMapOf<Int, MpChartDataManager>()



    init {
        Log.d("HomeViewModel", "viewmodel init")

        viewModelScope.launch {
            SensorsProvider.getInstance().mSensorsFlow.map { value ->
                value.map {
                    ModelHomeSensor(
                        it.type,
                        it.sensor,
                        it.info,
                        0f,
                        mIsActiveMap.getOrDefault(it.type, false)
                    )
                }.toMutableList()
            }.collectLatest {
                mSensors = it
                Log.d("HomeViewModel", "${this@HomeViewModel} init sensors active  1: $mIsActiveMap")

//                Log.d("HomeViewModel", "sensors 2: $it")
                if (_mSensorsList.size == 0) {
                    _mSensorsList.addAll(mSensors)
                    var activeSensors = it.filter { modelHomeSensor -> modelHomeSensor.isActive }
//                     _mActiveSensorStateList.addAll(activeSensors)
                    _mActiveSensorList.addAll(activeSensors)
                    _mActiveSensorListFlow.emit(_mActiveSensorList)
                }
//                mSensorsList.emit(_mSensorsList)

               /* emitUiState()*/

            }

        }
        Log.d("HomeViewModel", "viewmodel init 2")
        SensorsProvider.getInstance().listenSensors()


        /*
        TODO use this for packets
        SensorPacketsProvider.getInstance().mSensorPacketFlow.map { value ->
            mSensorPacketsMap.put(value.type, value)
        }*/
    }

    fun onSensorChecked(type: Int, isChecked: Boolean) {
        var isCheckedPrev = mIsActiveMap.getOrDefault(type, false)

        if (isCheckedPrev != isChecked) {
            mIsActiveMap[type] = isChecked
        }

        var index = mSensors.indexOfFirst { it.type == type }
        if (index >= 0) {
            Log.d("HomeViewModel", "onSensorChecked: Index: $index $isChecked")
            var sensor = mSensors[index]
            var updatedSensor =
                ModelHomeSensor(sensor.type, sensor.sensor, sensor.info, sensor.valueRms, isChecked)
            mSensors[index] = updatedSensor

            mSensorsList[index] = updatedSensor
            updateActiveSensor(updatedSensor, isChecked)

        }
        /*viewModelScope.launch {
            emitUiState()

        }*/

    }

    fun updateActiveSensor(sensor: ModelHomeSensor, isChecked: Boolean = false) {
        var index = _mActiveSensorList.indexOfFirst { it.type == sensor.type }

        if (!isChecked && index >= 0) {
             var manager = mChartDataManagerMap.remove(sensor.type)
            manager?.destroy()
//            _mActiveSensorStateList.removeAt(index)

            _mActiveSensorList.removeAt(index)
            viewModelScope.launch {

                _mActiveSensorListFlow.emit(_mActiveSensorList)
            }

        } else if (isChecked && index < 0) {
//            _mActiveSensorStateList.add(sensor)

            _mActiveSensorList.add(sensor)
            viewModelScope.launch {

                _mActiveSensorListFlow.emit(_mActiveSensorList)
            }
        }
    }

    suspend fun emitUiListState(index: Int, sensor: ModelHomeSensor) {


    }

    /*suspend fun emitUiState() {
        *//* if(_mSensorsList.size==0){
             _mSensorsList.addAll(mSensors)
         }
         _uiListState.emit()*//*
        _uiState.emit(HomeUiState(sensors = mSensors))
    }*/

    fun getChartDataManager(type: Int): MpChartDataManager {
        var chartDataManager = mChartDataManagerMap.getOrPut(type, defaultValue = {
            MpChartDataManager(type, onDestroy = {
            })
        })
        return chartDataManager
    }

    fun setActivePage(page: Int?) {

        viewModelScope.launch {
            Log.d("HomeViewModel", "page: $page")
            if(page!=null && _mActiveSensorList.size > 0){
                var sensor = _mActiveSensorList[page]
                _mUiCurrentSensorState.emit(sensor)
                _uiState.emit(_uiState.value.copy(currentSensor = sensor, activeSensorCounts = _mActiveSensorList.size))
            }else{
                _mUiCurrentSensorState.emit(null)
                _uiState.emit(_uiState.value.copy(currentSensor = null, activeSensorCounts = _mActiveSensorList.size))

            }
        }

    }

    override fun onCleared() {
        super.onCleared()

        Log.d("HomeViewModel", "onCleared")


        mChartDataManagerMap.forEach { i, mpChartDataManager -> mpChartDataManager.destroy() }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory() : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel() as T
        }
    }


}