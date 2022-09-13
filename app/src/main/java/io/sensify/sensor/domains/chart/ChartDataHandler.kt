package io.sensify.sensor.domains.chart

import android.hardware.SensorManager
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import io.sensify.sensor.domains.chart.entity.ModelLineChart
import io.sensify.sensor.domains.sensors.SensorsConstants
import io.sensify.sensor.domains.sensors.packets.SensorPacket
import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

/**
 * Created by Niraj on 13-09-2022.
 */
class ChartDataHandler {

    private var VISIBLE_NUM = -1
    private var LENGTH_SAMPLE = 100

    private val mLockDataAdd = Any()

    // TODO use this in ui handler
    private var mAddDirection = ChartConstants.DIRECTION_START_END
    var mModelLineChart: ModelLineChart? = null

    var mPre = mutableListOf<SensorPacket>()

    var mUIRefreshDelay = SensorManager.SENSOR_DELAY_UI

    var mDataTypesIndexed = mutableListOf<Int>()

//    var mPre

    var mDataComputationScope = CoroutineScope(Job() + Dispatchers.Default)

    fun destroy() {

        mDataComputationScope.cancel()

    }

    fun addEntry(sensorPacket: SensorPacket) {

        synchronized(mLockDataAdd) {
            mPre.add(sensorPacket)

        }
//        mModelLineChart.


    }

    fun runPeriodicTask() {

        mDataComputationScope.launch {
            while (mDataComputationScope.isActive) {
                // TODO periodic shift

                addPreEntry()
                delay(SensorsConstants.MAP_SAMPLE_TYPE_TO_DELAY.get(mUIRefreshDelay).seconds)


            }

        }


    }

    fun addPreEntry() {
        var preData: MutableList<SensorPacket>
        synchronized(mLockDataAdd) {
            preData = mPre
            mPre = mutableListOf()
        }

        var needToChangeUi = preData.size > 0

        for (item in preData) {

            for (index in mDataTypesIndexed) {

                if (item.values != null) {
                    if (item.values!!.size > index) {
                        mModelLineChart?.addEntry(mDataTypesIndexed[index], item.values!![index]);
                    }
                }
                //loops all indices (performs just as well as two examples above)
            }
        }


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



