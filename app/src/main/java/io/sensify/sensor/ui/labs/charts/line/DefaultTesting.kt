package io.sensify.sensor.ui.labs.charts.line

import android.util.Log
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.utils.MyXAxisFormatter

/**
 * Created by Niraj on 31-08-2022.
 */

@Composable
fun DefaultChartTesting(){

    AndroidView(


        modifier = Modifier
            .background(color = Color.LightGray)
            .height(JlResDimens.dp168)
            .fillMaxWidth(),

        factory = { ctx ->
            var linechart = LineChart(ctx).apply {
                // set properties until it looks like you want it to look like
//                layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)

//                val lineChart = LineChart(context)
                var entrieOne =
                    mutableListOf(
                        Entry(0f, 10f),
                        Entry(1f, 14f),
                        Entry(2f, 12f),
                        Entry(3f, 14f)
                    )
                var entrieTwo =
                    mutableListOf(Entry(0f, 13f), Entry(1f, 11f), Entry(2f, 9f), Entry(3f, 10f))

                val dataSetOne =
                    LineDataSet(entrieOne, "Company 1").apply { color = Color.Red.toArgb() }
                dataSetOne.axisDependency = YAxis.AxisDependency.LEFT
                dataSetOne.setDrawValues(true)

                val dataSetTwo =
                    LineDataSet(entrieTwo, "Company 2").apply { color = Color.Green.toArgb() }
                dataSetTwo.axisDependency = YAxis.AxisDependency.LEFT
                dataSetTwo.setDrawValues(true)

                val dataSets = mutableListOf<ILineDataSet>(dataSetOne, dataSetTwo)
                val lineData = LineData(dataSets)
//
//            lineChart.axisLeft.mAxisMaximum = 1f
//            lineChart.axisLeft.mAxisMinimum = -1f
//            lineChart.axisLeft.mAxisRange = 2f

                //Set shadow
                setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                renderer.paintRender.setShadowLayer(3F, 5F, 3F, Color.Gray.toArgb());

                //Formatting
                xAxis.valueFormatter = MyXAxisFormatter()
                xAxis.granularity = 1f
                xAxis.setDrawAxisLine(false)
                xAxis.setDrawGridLines(false)
//            lineChart.xAxis.setDrawLabels(false)
                xAxis.position = XAxis.XAxisPosition.BOTTOM

                legend.isEnabled = true
                legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
                legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
                legend.orientation = Legend.LegendOrientation.HORIZONTAL
                legend.setDrawInside(false)


                setDrawGridBackground(false)
                setDrawBorders(false)


                axisLeft.setDrawZeroLine(false)
                axisRight.setDrawZeroLine(false)
                axisLeft.isEnabled = true
                axisRight.isEnabled = false
                axisLeft.setDrawAxisLine(false)
//           axisRight.setDrawAxisLine(false)
                axisLeft.setDrawLabels(false)
//           axisRight.setDrawLabels(false)
                axisLeft.setDrawGridLines(false)
//           axisRight.setDrawGridLines(false)
                axisLeft.axisMinimum = 8f

                description.isEnabled = false


                data = lineData
                invalidate()


            }
            Log.i("LineChart Log: ", "factory ")
            linechart
        },
        update = {
//                    ChartUpdate(chart = it, bool1 = isUpdating.value, counter = counter)
            /*if (isUpdating.value) {
                try {
                    Log.d(
                        "TAG",
                        "MyLineChart: Update --- Current thread id: ${Thread.currentThread()}"
                    )

                    it.data.dataSets[0].addEntry(Entry(counter.value, 0f))
                    it.lineData.notifyDataChanged()
                    it.notifyDataSetChanged()
                    it.invalidate()
                    counter.value += 1f
                } catch (ex: Exception) {
                    Log.d("TAG", "MyLineChart: $ex")
                }
            }*/
            /*key(isUpdating.value){
//                    Log.i("LineChart Log: ", "h update ${isUpdating.value}")
            }*/
            Log.i("LineChart Log: ", "h update ")

/*                if(isUpdating.value){
                }*/

        })
}