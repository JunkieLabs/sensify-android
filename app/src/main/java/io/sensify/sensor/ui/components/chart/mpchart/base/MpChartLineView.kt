package io.sensify.sensor.ui.components.chart.mpchart.base

import android.content.Context
import android.view.View
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import io.sensify.sensor.domains.chart.mpchart.axis.MpChartTimestampAxisFormatter

/**
 * Created by Niraj on 30-09-2022.
 */
open class MpChartLineView(var mKey: Int) : IMpChartLineView {
    var mLineChart: LineChart? = null
    override fun create(context: Context, colorSurface: Color, colorOnSurface: Color): LineChart {
        mLineChart = LineChart(context).apply {

            //Set shadow
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//            renderer.paintRender.setShadowLayer(3F, 5F, 3F, Color.Gray.toArgb());
//            setViewPortOffsets(0f, 0f, 0f, 0f);


            applyAxis(this, colorSurface, colorOnSurface)
            legend.isEnabled = true
            legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
            legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
            legend.orientation = Legend.LegendOrientation.HORIZONTAL
            legend.setDrawInside(false)
            legend.textColor = colorOnSurface.toArgb()

            setBackgroundColor(colorSurface.toArgb())
            setDrawGridBackground(false)
            setDrawBorders(false)
//            setDrawMarkers(true)


            description.isEnabled = false
            tag = mKey

        }
        return mLineChart!!
    }

    private fun applyAxis(lineChart: LineChart, colorSurface: Color, colorOnSurface: Color) {
        lineChart.apply {
            //Formatting

            xAxis.valueFormatter = MpChartTimestampAxisFormatter()
            xAxis.granularity = 1f
            xAxis.setDrawAxisLine(true)
            xAxis.setDrawGridLines(false)
            xAxis.setDrawLabels(false)
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.textColor = colorOnSurface.toArgb()

            axisRight.setDrawZeroLine(false)
            axisRight.isEnabled = false
            axisRight.textColor = colorOnSurface.toArgb()

            axisLeft.setDrawZeroLine(false)
            axisLeft.isEnabled = true
            axisLeft.setDrawAxisLine(true)
//           axisRight.setDrawAxisLine(false)
            axisLeft.setDrawLabels(false)
//           axisRight.setDrawLabels(false)
            axisLeft.setDrawGridLines(false)
//           axisRight.setDrawGridLines(false)
//            axisLeft.axisMinimum = 0f
            axisLeft.textColor = colorOnSurface.toArgb()
        }

    }

}