package io.sensify.sensor.ui.labs.viewpager.Screens


import android.util.Log
import android.view.View
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import io.sensify.sensor.R
import io.sensify.sensor.ui.utils.MyXAxisFormatter
import kotlin.random.Random

/**
 * Created by Manish Kumar on 24/07/22.
 */


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun HomeScreenHeader(modifier: Modifier = Modifier){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(
            start = 30.dp,
            end = 30.dp,
        )
        .background(Color(0xB200752F)),
    containerColor = Color.Transparent) {
        Row(modifier = modifier
            .padding(all = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Card(modifier = modifier

            ) {
                Text(
                    text = "4 Active",
                    modifier = Modifier
                        .padding(
                            start = 13.dp,
                            top = 16.dp,
                            end = 18.dp,
                            bottom = 17.dp,
                        )
                )
            }

            Spacer(modifier = Modifier.width(18.dp))

            Image(
                painterResource(id = R.drawable.ic_round_keyboard_arrow_left_24),
                contentDescription = "slide to left",
            )

            Image(
                painterResource(id = R.drawable.ic_gyroscope),
                contentDescription = "Gyroscope",
                modifier = Modifier
                    .width(24.dp)
                    .height(18.dp)
            )
        }
    }
}

@Preview(showBackground= true, backgroundColor = 0xFFFFFFFF)
@Composable
fun MyLineChart() {

    AndroidView(modifier = Modifier.fillMaxWidth().height(250.dp).padding(16.dp),
        factory = { context ->

            val lineChart = LineChart(context)
            var entrieOne = mutableListOf(Entry(0f,10f), Entry(1f,14f), Entry(2f, 12f), Entry(3f, 14f))
            var entrieTwo = mutableListOf(Entry(0f,13f), Entry(1f,11f), Entry(2f, 9f), Entry(3f, 10f))

            val dataSetOne = LineDataSet(entrieOne, "Company 1").apply { color = Color.Red.toArgb() }
            dataSetOne.axisDependency = YAxis.AxisDependency.LEFT
            dataSetOne.setDrawValues(true)

            val dataSetTwo = LineDataSet(entrieTwo, "Company 2").apply { color = Color.Green.toArgb() }
            dataSetTwo.axisDependency = YAxis.AxisDependency.LEFT
            dataSetTwo.setDrawValues(true)

            val dataSets = mutableListOf<ILineDataSet>(dataSetOne, dataSetTwo)
            val lineData = LineData(dataSets)
//
//            lineChart.axisLeft.mAxisMaximum = 1f
//            lineChart.axisLeft.mAxisMinimum = -1f
//            lineChart.axisLeft.mAxisRange = 2f

            //Set shadow
            lineChart.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            lineChart.renderer.paintRender.setShadowLayer(3F, 5F, 3F, Color.Gray.toArgb());

            //Formatting
            lineChart.xAxis.valueFormatter = MyXAxisFormatter()
            lineChart.xAxis.granularity = 1f
            lineChart.xAxis.setDrawAxisLine(false)
            lineChart.xAxis.setDrawGridLines(false)
//            lineChart.xAxis.setDrawLabels(false)
            lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM

            lineChart.legend.isEnabled = true
            lineChart.legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
            lineChart.legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
            lineChart.legend.orientation = Legend.LegendOrientation.HORIZONTAL
            lineChart.legend.setDrawInside(false)


            lineChart.setDrawGridBackground(false)
            lineChart.setDrawBorders(false)


            lineChart.axisLeft.setDrawZeroLine(false)
            lineChart.axisRight.setDrawZeroLine(false)
            lineChart.axisLeft.isEnabled = true
            lineChart.axisRight.isEnabled = false
            lineChart.axisLeft.setDrawAxisLine(false)
//            lineChart.axisRight.setDrawAxisLine(false)
            lineChart.axisLeft.setDrawLabels(false)
//            lineChart.axisRight.setDrawLabels(false)
            lineChart.axisLeft.setDrawGridLines(false)
//            lineChart.axisRight.setDrawGridLines(false)
            lineChart.axisLeft.axisMinimum =  8f

            lineChart.description.isEnabled = false


            lineChart.data = lineData
            lineChart.invalidate()

            lineChart
        }){

        try {
            Log.d("TAG", "MyLineChart: Update --- Current thread id: ${Thread.currentThread()}")

            it.data.dataSets[0].addEntry(Entry(0f, 0f))
            it.lineData.notifyDataChanged()
            it.notifyDataSetChanged()
            it.invalidate()
        } catch(ex: Exception) {
            Log.d("TAG", "MyLineChart: $ex")
        }
    }
}