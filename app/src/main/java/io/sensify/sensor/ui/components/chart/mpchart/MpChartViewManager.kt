package io.sensify.sensor.ui.components.chart.mpchart

import android.content.Context
import android.hardware.SensorManager
import android.view.View
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import io.sensify.sensor.R
import io.sensify.sensor.domains.chart.ChartDataHandler
import io.sensify.sensor.domains.sensors.SensorsConstants
import io.sensify.sensor.ui.components.chart.mpchart.axis.MpChartTimestampAxisFormatter
import io.sensify.sensor.ui.resource.values.JlResColors
import io.sensify.sensor.ui.utils.MyXAxisFormatter

/**
 * Created by Niraj on 13-09-2022.
 */
class MpChartViewManager(
    var sensorType: Int,
    var mSensorDelayType: Int = SensorManager.SENSOR_DELAY_NORMAL
) {


    var mChartDataHandler: ChartDataHandler;

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


    }

    fun setSensorDelayType(type: Int) {
        mSensorDelayType = type
    }




    fun createChart(context: Context): LineChart {

        var chart = MpChartViewCreator(context).prepareDataSets(mChartDataHandler.mModelLineChart)
            .invalidate()

        return chart

//        return linechart

    }

    fun updateData(lineChart: LineChart) {
//        var lineData: LineData = chart.getData()

    }
}