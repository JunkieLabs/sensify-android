package io.sensify.sensor.domains.chart.mpchart

import android.content.Context
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.github.mikephil.charting.charts.LineChart
import io.sensify.sensor.domains.chart.ChartDataHandler
import io.sensify.sensor.domains.chart.entity.ModelChartUiUpdate
import io.sensify.sensor.domains.chart.entity.ModelLineChart
import io.sensify.sensor.domains.chart.mpchart.view.IMpChartLineView
import io.sensify.sensor.domains.chart.mpchart.view.MpChartLineView
import io.sensify.sensor.domains.sensors.SensorsConstants
import io.sensify.sensor.domains.sensors.packets.ModelSensorPacket
import io.sensify.sensor.ui.resource.values.JlResColors
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.SharedFlow

/**
 * Created by Niraj on 13-09-2022.
 */
class MpChartDataManager(
    var sensorType: Int,
    var mSensorDelayType: Int = SensorManager.SENSOR_DELAY_NORMAL,
    var onDestroy: (type: Int) -> Unit = {}
) {

    private var mIsRunningPeriod: Boolean =  false
    var mDataComputationScope = CoroutineScope(Job() + Dispatchers.Default)

    var mChartDataHandler: ChartDataHandler

//    var mMpChartViewUpdater: MpChartViewUpdater = MpChartViewUpdater()

    val mSensorPacketFlow :SharedFlow<ModelChartUiUpdate>

    init {
       /*
       TODO remove in future
       mChartDataHandler = ChartDataHandler(sensorType)
*/
        mChartDataHandler = ChartDataHandler(sensorType)
        var axisCount = SensorsConstants.MAP_TYPE_TO_AXIS_COUNT.get(sensorType)

        if (axisCount == 1) {
            mChartDataHandler.addDataSet(
                SensorsConstants.DATA_AXIS_VALUE,
                JlResColors.NotePink.toArgb(),
                SensorsConstants.DATA_AXIS_VALUE_STRING, emptyArray(), false
            )

        } else if (axisCount == 3) {
            mChartDataHandler.addDataSet(
                SensorsConstants.DATA_AXIS_X,
                JlResColors.NotePink.toArgb(),
                SensorsConstants.DATA_AXIS_X_STRING, emptyArray(), false
            )
            mChartDataHandler.addDataSet(
                SensorsConstants.DATA_AXIS_Y,
                JlResColors.NoteGreen.toArgb(),
                SensorsConstants.DATA_AXIS_Y_STRING, emptyArray(), false
            )
            mChartDataHandler.addDataSet(
                SensorsConstants.DATA_AXIS_Z,
                JlResColors.NoteBlue.toArgb(),
                SensorsConstants.DATA_AXIS_Z_STRING, emptyArray(), false
            )
        }

        mSensorPacketFlow = mChartDataHandler.mSensorPacketFlow

    }

    fun destroy(){
        Log.d("MpChartDataManager","destroy $sensorType")
        mChartDataHandler.destroy()
        onDestroy.invoke(sensorType)
    }

    fun setSensorDelayType(type: Int) {
        mSensorDelayType = type
    }

    fun runPeriodically(){


        if(mIsRunningPeriod){
            return
        }
        mIsRunningPeriod = true

        mDataComputationScope.launch {
            delay(100)
            Log.d("MpChartViewManager ", "createChart periodic Task: ")
            mChartDataHandler.runPeriodicTask()
        }

//        return lineChart

//        return linechart

    }



    fun addEntry(sensorPacket: ModelSensorPacket) {
//        Log.d("MpChartViewManager ", "addEntry ")

        mChartDataHandler.addEntry(sensorPacket)
    }


    /*
    TODO remvoe this
    fun updateData(lineChart: LineChart, value: ModelChartUiUpdate) {
//        var lineData: LineData = chart.getData()
//        Log.d("MpChartViewManager ", "updateData update: ${value.size} ")
        mMpChartViewUpdater.update(lineChart, value, mChartDataHandler.mModelLineChart)
    }*/

    fun getModel(): ModelLineChart {
        return mChartDataHandler.mModelLineChart
    }
}