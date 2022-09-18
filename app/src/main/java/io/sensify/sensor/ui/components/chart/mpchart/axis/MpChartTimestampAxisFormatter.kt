package io.sensify.sensor.ui.components.chart.mpchart.axis

import android.hardware.SensorManager
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.ValueFormatter
import io.sensify.sensor.domains.sensors.SensorsConstants.MAP_DELAY_TYPE_TO_DELAY

/**
 * Created by Niraj on 18-09-2022.
 */
class MpChartTimestampAxisFormatter(var sensorDelay: Int = SensorManager.SENSOR_DELAY_NORMAL) : ValueFormatter() {



    fun setDelay(delay: Int){
        sensorDelay = delay;
    }
    override fun getAxisLabel(value: Float, axis: AxisBase?): String {

       /* val LENGTH_SAMPLE: Int = mModelLineChart.getSampleLength()
        val labels = arrayOfNulls<String>(LENGTH_SAMPLE)
        val timePreiod: Float = mModelLineChart.getTimePeriod()
        for (i in labels.indices) {
            val `val` = i.toFloat() * timePreiod
            labels[i] = java.lang.Float.toString(`val`) + "s"
        }*/
        var delay  = MAP_DELAY_TYPE_TO_DELAY.get(sensorDelay)
        var totalDelay = value*delay;
        return  "${totalDelay/1000}s"
//        return super.getAxisLabel(value, axis)
    }

}