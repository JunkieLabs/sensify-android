package io.sensify.sensor.ui.utils

import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.ValueFormatter

/**
 * Created by Manish Kumar on 26/07/22.
 */

class MyXAxisFormatter : ValueFormatter() {
    private val days = arrayOf("Q1", "Q2", "Q3", "Q4")
    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
        return days.getOrNull(value.toInt()) ?: value.toString()
    }
}
