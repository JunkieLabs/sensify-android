package io.sensify.sensor.domains.chart.mpchart

import android.content.Context
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
import io.sensify.sensor.domains.chart.entity.ModelChartDataSet
import io.sensify.sensor.domains.chart.entity.ModelLineChart
import io.sensify.sensor.domains.chart.mpchart.axis.MpChartTimestampAxisFormatter
import io.sensify.util.QueueFixedLength

/**
 * Created by Niraj on 18-09-2022.
 */
class MpChartViewCreator (var context: Context){

    companion object{

//        const val DATA_SET_TYPE_SINGLE = 1
//        const val DATA_SET_TYPE_3D = 3
    }

    private val chart : LineChart by lazy {
        LineChart(context).apply {
            // set properties until it looks like you want it to look like
//                layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)

//                val lineChart = LineChart(context)
           /* var entrieOne =
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
            val lineData = LineData(dataSets)*/
//
//            lineChart.axisLeft.mAxisMaximum = 1f
//            lineChart.axisLeft.mAxisMinimum = -1f
//            lineChart.axisLeft.mAxisRange = 2f

            //Set shadow
            setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            renderer.paintRender.setShadowLayer(3F, 5F, 3F, Color.Gray.toArgb());

            //Formatting
            xAxis.valueFormatter = MpChartTimestampAxisFormatter()
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

        }
    }

    /*fun attachLineChart(modelLineChart: ModelLineChart){
//        var dataType
    }*/

    fun prepareDataSets(modelLineChart: ModelLineChart): MpChartViewCreator {

        //LOGV(TAG, "addDataSet: dataType: "+ dataType +", color: "+ color + ", label: "+ label +"index: "+ index);
        var lineData: LineData? = chart.data

        var datasets = modelLineChart.getDataSets()

        for (dataSet in datasets){
            lineData = prepareDataSet(dataSet,  lineData)
        }

        return this

      /*  if(dataSetType == DATA_SET_TYPE_SINGLE){
            lineData = prepareDataSet(modelLineChart, SensorsConstants.DATA_AXIS_VALUE, lineData)
        }else{
            lineData = prepareDataSet(modelLineChart, SensorsConstants.DATA_AXIS_X, lineData)
            lineData = prepareDataSet(modelLineChart, SensorsConstants.DATA_AXIS_Y, lineData)
            lineData = prepareDataSet(modelLineChart, SensorsConstants.DATA_AXIS_Z, lineData)
        }*/
    }

    private fun prepareDataSet(modelDataSet: ModelChartDataSet,  pLineData: LineData?): LineData? {
       /* val index = modelLineChart.getIndex(dataType)



        if (index != -1) {
            chartLineData?.removeDataSet(index)
        }*/
        var chartLineData = pLineData

        var dataSet = createDataSet(modelDataSet)
        //TODO hide and show dataSet
        if (pLineData == null) {
            val sets = java.util.ArrayList<ILineDataSet>()
            sets.add(dataSet)
            chartLineData = LineData(sets)
            chart.setData(pLineData)
        } else {
            val sets: MutableList<ILineDataSet> = pLineData.getDataSets()
            sets.add(dataSet)

            //LOGV(TAG, "addDataSet: size:"+ sets.size());
            //lineData.getDataSets().add(dataSet);
            chart.setData(pLineData)
            //lineData.addDataSet(dataSet);
            //lineData.notifyDataChanged();
        }

        return chartLineData;

    }


    private fun createDataSet(dataSet: ModelChartDataSet): ILineDataSet {
       /* val index: Int = modelLineChart.getIndex(dataType)*/
        val label: String? = dataSet.getLabel()
        val data: QueueFixedLength<Float>? = dataSet.getData()
        val entries: MutableList<Entry>
        if (data == null) {
            entries = ArrayList<Entry>(dataSet.getSampleLength())
            for (i in 0 until dataSet.getSampleLength()) {
                entries.add(Entry(i.toFloat(), 0.0f))
            }
        } else {
            var emptySize: Int = dataSet.getSampleLength() - data.size()
            entries = ArrayList<Entry>(dataSet.getSampleLength())
            for (i in 0 until emptySize) {
                entries.add(Entry(i.toFloat(), 0.0f))
            }
            val iterator: Iterator<Float> = data.getValues()
            while (iterator.hasNext()) {
                if (emptySize < dataSet.getSampleLength()) {
                    entries.add(Entry(emptySize.toFloat(), iterator.next()))
                    emptySize++
                }
            }
        }
        val ds = LineDataSet(entries, label)
        ds.lineWidth = 1.4f
        ds.axisDependency = YAxis.AxisDependency.RIGHT
        ds.setDrawCircles(false)
        ds.setDrawValues(false)
        ds.color = dataSet.getColor()
        //LOGV(TAG, "create: dataType: "+ dataTypes+", color: "+ mModelLineChart.getColor(dataTypes));
        return ds
    }

    fun invalidate(): LineChart {
        chart.invalidate()
        return chart
    }
}