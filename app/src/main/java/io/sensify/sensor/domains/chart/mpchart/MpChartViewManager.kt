package io.sensify.sensor.domains.chart.mpchart

import android.content.Context
import android.hardware.SensorManager
import android.util.Log
import androidx.compose.ui.graphics.toArgb
import com.github.mikephil.charting.charts.LineChart
import io.sensify.sensor.domains.chart.ChartDataHandler
import io.sensify.sensor.domains.chart.entity.ModelChartUiUpdate
import io.sensify.sensor.domains.chart.mpchart.MpChartViewCreator
import io.sensify.sensor.domains.sensors.SensorsConstants
import io.sensify.sensor.domains.sensors.packets.SensorPacket
import io.sensify.sensor.ui.resource.values.JlResColors
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Created by Niraj on 13-09-2022.
 */
class MpChartViewManager(
    var sensorType: Int,
    var mSensorDelayType: Int = SensorManager.SENSOR_DELAY_NORMAL
) {

    var mDataComputationScope = CoroutineScope(Job() + Dispatchers.Default)

    var mChartDataHandler: ChartDataHandler

    val mSensorPacketFlow :SharedFlow<ModelChartUiUpdate>

    init {
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
                JlResColors.NotePink.toArgb(),
                SensorsConstants.DATA_AXIS_Z_STRING, emptyArray(), false
            )
            mChartDataHandler.addDataSet(
                SensorsConstants.DATA_AXIS_Z,
                JlResColors.NotePink.toArgb(),
                SensorsConstants.DATA_AXIS_Z_STRING, emptyArray(), false
            )
        }

        mSensorPacketFlow = mChartDataHandler.mSensorPacketFlow

    }

    fun destroy(){
        mChartDataHandler.destroy()
    }

    fun setSensorDelayType(type: Int) {
        mSensorDelayType = type
    }




    fun createChart(context: Context): LineChart {

        var chart = MpChartViewCreator(context).prepareDataSets(mChartDataHandler.mModelLineChart)
            .invalidate()

        mDataComputationScope.launch {
            delay(100)
            Log.d("MpChartViewManager ", "createChart periodic Task: ")
            mChartDataHandler.runPeriodicTask()
        }

        return chart

//        return linechart

    }

    fun updateData(lineChart: LineChart, value: ModelChartUiUpdate) {
//        var lineData: LineData = chart.getData()
        Log.d("MpChartViewManager ", "updateData update: ${value.size} ")

    }

    fun addEntry(sensorPacket: SensorPacket) {
        Log.d("MpChartViewManager ", "addEntry ")

        mChartDataHandler.addEntry(sensorPacket)
    }
}