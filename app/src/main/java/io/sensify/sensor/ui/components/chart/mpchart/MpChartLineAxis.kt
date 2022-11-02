package io.sensify.sensor.ui.components.chart.mpchart

import android.content.Context
import androidx.compose.ui.graphics.Color
import com.github.mikephil.charting.charts.LineChart
import io.sensify.sensor.ui.components.chart.mpchart.base.MpChartLineView

/**
 * Created by Niraj on 30-09-2022.
 */
class MpChartLineAxis(key: Int) : MpChartLineView(key) {

    override fun create(context: Context, colorSurface: Color, colorOnSurface: Color): LineChart {
        var lineChart  = super.create(context, colorSurface, colorOnSurface)

        lineChart.apply {
            axisLeft.setDrawLabels(true)
//           axisRight.setDrawLabels(false)
            axisLeft.setDrawGridLines(true)
        }

        return lineChart
    }




}