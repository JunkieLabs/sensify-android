package io.sensify.sensor.domains.chart.mpchart

import android.util.Log
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import io.sensify.sensor.domains.chart.entity.ModelChartDataSet
import io.sensify.sensor.domains.chart.entity.ModelChartUiUpdate
import io.sensify.sensor.domains.chart.entity.ModelLineChart

/**
 * Created by Niraj on 20-09-2022.
 */
class MpChartViewUpdater {


    fun update(chart: LineChart, value: ModelChartUiUpdate, modelLineChart: ModelLineChart) : Boolean {
        if (value.size == 0) return false;
        var lineData: LineData? = chart.data

        if(lineData==null){
//            Log.v("MpChartViewUpdater", "update no line data ")
            return false
        }

        //        value.packets[0].
//        modelLineChart.
        var datasets = modelLineChart.getDataSets()
//        Log.d("MpChartViewManager ", "update status 1: size: ${value.size} ${datasets.size} ")

        for (i in datasets.indices) {
            lineData = updateDataSet(i, value, datasets[i], lineData!!)

        }
//        Log.d("MpChartViewManager ", "update status 2: size: ${value.size}")

        notifyDataChange(chart)

        //

        /*for (dataSet in datasets){
        }*/

        return true

    }

    private fun updateDataSet(
        index: Int, value: ModelChartUiUpdate,
        modelDataSet: ModelChartDataSet,
        pLineData: LineData
    ): LineData {
        var chartLineData = pLineData

        if (index >= pLineData.dataSets.size) return pLineData;

        var dataset = pLineData.getDataSetByIndex(index)
//        modelDataSet

        var totalShift = 0

        var extraEntry = dataset.entryCount - modelDataSet.getSampleLength();
//        Log.d("MpChartViewManager ", "updateDataSet status 1: index: ${index}  entryCount: ${dataset.entryCount} ")

        if (extraEntry > 0) {
            for (j in 0 until extraEntry) {
                dataset.removeEntry(0) // remove oldest
                totalShift++;


            }
        }

        for (j in 0 until value.size) {
            dataset.removeEntry(0) // remove oldest
            totalShift++;

        }
/*        while(dataset.entryCount > modelDataSet.getSampleLength()){
            totalShift++;
        }*/

        // change Indexes - move to beginning by 1
        for (i in totalShift until dataset.entryCount) {
            val entry: Entry = dataset.getEntryForIndex(i)
            entry.x = entry.x - totalShift
        }

        var entrySize = dataset.entryCount
        for (j in 0 until value.size) {
            chartLineData.addEntry(
                Entry(
                    (entrySize + j).toFloat(),
                    value.packets[j].values?.get(index) ?: 0f
                ), index
            ); // remove oldest

        }
//        Log.d("MpChartViewManager ", "updateDataSet status 2: index: ${index}  entryCount: ${dataset.entryCount} ")

        /*for (packet in value.packets) {
            dataset.addEntry()
        }*/

//        set


        /* open fun shiftData(set: ILineDataSet) {
             if (set.entryCount > mModelLineChart.getSampleLength()) {
                 set.removeEntry(0) // remove oldest
                 // change Indexes - move to beginning by 1
                 for (i in 1 until set.entryCount) {
                     val entry = set.getEntryForIndex(i)
                     entry.x = entry.x - 1
                 }
             }
         }*/


/*
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
        }*/

        return chartLineData;
    }


    fun notifyDataChange(chart: LineChart) {
        val data: LineData = chart.getData()
//        data.notifyDataChanged()
        chart.notifyDataSetChanged()
        chart.invalidate()
    }



}