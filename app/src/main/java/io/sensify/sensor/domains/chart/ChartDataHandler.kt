package io.sensify.sensor.domains.chart

import android.hardware.Sensor
import android.hardware.SensorManager
import android.util.Log
import io.sensify.sensor.domains.chart.entity.ModelChartUiUpdate
import io.sensify.sensor.domains.chart.entity.ModelLineChart
import io.sensify.sensor.domains.sensors.SensorsConstants
import io.sensify.sensor.domains.sensors.packets.ModelSensorPacket
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Created by Niraj on 13-09-2022.
 */
class ChartDataHandler(var sensorType: Int) {

    private var mCurrentPacket: ModelSensorPacket? =null
    private var mVisibleNum = -1
    private var mLengthSample = 100

    private val mLockDataAdd = Any()

    // TODO use this in ui handler
    private var mAddDirection = ChartConstants.DIRECTION_START_END
    var mModelLineChart: ModelLineChart

    var mPre = mutableListOf<ModelSensorPacket>()

    var mUIRefreshDelay = SensorManager.SENSOR_DELAY_UI
    var mDataRefreshDelay = SensorManager.SENSOR_DELAY_UI

    var mDataTypesIndexed = mutableListOf<Int>()

//    var mPre

    var mDataComputationScope = CoroutineScope(Job() + Dispatchers.Default)
    var mDataAddScope = CoroutineScope(Job() + Dispatchers.Default)

    private val _mSensorPacketFlow = MutableSharedFlow<ModelChartUiUpdate>(replay = 0)
    val mSensorPacketFlow = _mSensorPacketFlow.asSharedFlow()


    init {
        mModelLineChart = ModelLineChart(
            mLengthSample, mVisibleNum
        )
    }

    fun destroy() {

        mDataComputationScope.cancel()
        mDataAddScope.cancel()


    }


    fun addDataSet(
        dataType: Int,
        color: Int,
        label: String,
        data: Array<Float>,
        isHidden: Boolean
    ) {
        mDataTypesIndexed.add(dataType)

        // TODO check for data added
        mModelLineChart.addDataType(dataType, color, label, data, isHidden)

    }

    fun addEntry(sensorPacket: ModelSensorPacket) {


        synchronized(mLockDataAdd) {

            mCurrentPacket = sensorPacket.copy()

            // TODO do in periodic place mPre.add(sensorPacket)

        }
//        mModelLineChart.


    }

    fun runPeriodicTask() {

        mDataComputationScope.launch {
            while (mDataComputationScope.isActive) {
                // TODO should I periodic shift

                var items = addPreEntry()
             /*   if(sensorType == Sensor.TYPE_GYROSCOPE){
                    Log.d("MpChartViewManager ", "runPeriodicTask : $sensorType")
                }*/

                _mSensorPacketFlow.emit(
                    ModelChartUiUpdate(
//                    mModelLineChart
                        sensorType,
                        items.size, items
                    )
                )

                delay(SensorsConstants.MAP_DELAY_TYPE_TO_DELAY.get(mUIRefreshDelay).toLong())

//                Log.d("MpChartViewManager ", "runPeriodicTask : ")

            }

        }


        mDataAddScope.launch {
            while (mDataAddScope.isActive) {
                // TODO should I periodic shift

                synchronized(mLockDataAdd) {
                    if(mCurrentPacket!=null){
                        mPre.add(mCurrentPacket!!)
                    }
                }




                delay(SensorsConstants.MAP_DELAY_TYPE_TO_DELAY.get(mDataRefreshDelay).toLong())

//                Log.d("MpChartViewManager ", "runPeriodicTask : ")

            }

        }

    }

    private fun addPreEntry(): MutableList<ModelSensorPacket> {
        var preData: MutableList<ModelSensorPacket>
        synchronized(mLockDataAdd) {
            preData = mPre
            mPre = mutableListOf()
        }

        val needToChangeUi = preData.size > 0

        for (item in preData) {

            for (index in mDataTypesIndexed.indices) {

                if (item.values != null) {
                    if (item.values!!.size > index) {
                        mModelLineChart.addEntry(mDataTypesIndexed[index], item.values!![index]);
                    }
                }
                //loops all indices (performs just as well as two examples above)
            }
        }

        return preData;


//        for
//        preData

    }

    /*private fun shiftData(set: ILineDataSet) {
        if (set.entryCount > mModelLineChart!!.getSampleLength()) {
            set.removeEntry(0) // remove oldest
            // change Indexes - move to beginning by 1
            for (i in 1 until set.entryCount) {
                val entry = set.getEntryForIndex(i)
                entry.x = entry.x - 1
            }
        }
    }*/


}



