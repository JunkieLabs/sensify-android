package io.sensify.sensor.ui.pages.home

import android.hardware.Sensor
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
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


    private val _uiPagerState = MutableStateFlow(HomeUiState())

    // Backing property to avoid state updates from other classes
    val mUiPagerState: StateFlow<HomeUiState> = _uiPagerState.asStateFlow()


    private val _mSensorsList = mutableStateListOf<ModelHomeSensor>()
    val mSensorsList: SnapshotStateList<ModelHomeSensor> = _mSensorsList


    private val _mActiveSensorStateList = mutableStateListOf<ModelHomeSensor>()
    val mActiveSensorStateList: SnapshotStateList<ModelHomeSensor> = _mActiveSensorStateList


    private val mIsActiveMap = mutableMapOf<Int, Boolean>(Pair(Sensor.TYPE_LIGHT, true))
    private val mSensorPacketsMap = mutableMapOf<Int, ModelSensorPacket>()
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
                Log.d("HomeViewModel", "sensors 1: $mIsActiveMap")

                Log.d("HomeViewModel", "sensors 2: $it")
                if (_mSensorsList.size == 0) {
                    _mSensorsList.addAll(mSensors)
                    var activeSensors = it.filter { modelHomeSensor -> modelHomeSensor.isActive }
                    _mActiveSensorStateList.addAll(activeSensors)
                }
//                mSensorsList.emit(_mSensorsList)

                emitUiState()

            }

        }
        Log.d("HomeViewModel", "viewmodel init 2")
        SensorsProvider.getInstance().listenSensors()


        SensorPacketsProvider.getInstance().mSensorPacketFlow.map { value ->
            mSensorPacketsMap.put(value.type, value)
        }
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
        viewModelScope.launch {
            emitUiState()

        }

    }

    fun updateActiveSensor(sensor: ModelHomeSensor, isChecked: Boolean = false) {
        var index = _mActiveSensorStateList.indexOfFirst { it.type == sensor.type }

        if (!isChecked && index >= 0) {
            _mActiveSensorStateList.removeAt(index)
            var manager = mChartDataManagerMap.remove(sensor.type)
            manager?.destroy()

        } else if (isChecked && index < 0) {
            _mActiveSensorStateList.add(sensor)
        }
    }

    suspend fun emitUiListState(index: Int, sensor: ModelHomeSensor) {


    }

    suspend fun emitUiState() {
        /* if(_mSensorsList.size==0){
             _mSensorsList.addAll(mSensors)
         }
         _uiListState.emit()*/
        _uiState.emit(HomeUiState(sensors = mSensors))
    }

    fun getChartDataManager(type: Int): MpChartDataManager {
        var chartDataManager = mChartDataManagerMap.getOrPut(type, defaultValue = {
            MpChartDataManager(type, onDestroy = {
            })
        })
        return chartDataManager
    }

    override fun onCleared() {
        super.onCleared()


        mChartDataManagerMap.forEach { i, mpChartDataManager -> mpChartDataManager.destroy() }
    }
}