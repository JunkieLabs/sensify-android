package io.sensify.sensor.domains.chart.mpchart.view

import android.content.Context
import androidx.compose.ui.graphics.Color
import com.github.mikephil.charting.charts.LineChart

/**
 * Created by Niraj on 30-09-2022.
 */
interface IMpChartLineView {
    fun create(
        context: Context,
        colorSurface: Color = Color.Transparent,
        colorOnSurface: Color = Color.DarkGray
    ): LineChart;
}