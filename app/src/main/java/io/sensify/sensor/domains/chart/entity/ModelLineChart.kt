package io.sensify.sensor.domains.chart.entity

import io.sensify.util.QueueFixedLength

/**
 * Created by Niraj on 31-08-2022.
 */
// TODO under development
class ModelLineChart(sampleLength: Int, visibleNum: Int) {


    //private SparseIntArray mMapIndex;
    private var VISIBLE_NUM = -1
    private var LENGTH_SAMPLE = 100

    private var mTs = 0.1f

    private var mModelChartDataSets: MutableList<ModelChartDataSet>

    init {

        mModelChartDataSets = mutableListOf() //ArrayList(5)

    }

    init {
        LENGTH_SAMPLE = sampleLength
        VISIBLE_NUM = visibleNum
    }


    fun sampleSize(sampleSize: Int) {
        LENGTH_SAMPLE = sampleSize
        VISIBLE_NUM = if (VISIBLE_NUM == -1) sampleSize else VISIBLE_NUM
        for (i in mModelChartDataSets.indices) {
            val modelChartDataSet = mModelChartDataSets[i]
            modelChartDataSet.resize(LENGTH_SAMPLE)
        }

    }

    fun visibleNumber(visibleNum: Int) {
        VISIBLE_NUM = if (visibleNum <= LENGTH_SAMPLE) visibleNum else LENGTH_SAMPLE
    }

    fun getSampleLength(): Int {
        return LENGTH_SAMPLE
    }


    fun addDataType(
        pDataType: Int,
        color: Int,
        pLabel: String?,
        pData: Array<Float?>?,
        isHidden: Boolean
    ) {


        var modelChartDataSet: ModelChartDataSet? = null
        for (i in mModelChartDataSets.indices) {
            val type = mModelChartDataSets[i].getDataType()
            if (type == pDataType) {
                modelChartDataSet = mModelChartDataSets[i]
            }
        }
        if (modelChartDataSet == null) {
            modelChartDataSet = ModelChartDataSet(pDataType, LENGTH_SAMPLE)
            mModelChartDataSets.add(modelChartDataSet)
        }
        modelChartDataSet.setColor(color)
        if (pLabel == null) {
            modelChartDataSet.setLabel("data_$pDataType")
        } else {
            modelChartDataSet.setLabel(pLabel)
        }



        //LOGV(TAG, "addDta: type: "+ pDataType +" || array :  "+ Arrays.toString(pData));
        modelChartDataSet.setData(LENGTH_SAMPLE, pData)
        modelChartDataSet.setDataHidden(isHidden)
    }


    fun getData(index: Int): QueueFixedLength<Float?>? {
        return if (index < mModelChartDataSets.size) {
            mModelChartDataSets[index].getData()
        } else null
        //return mMapData.get(dataType);
    }


    fun getLabel(index: Int): String? {
        return if (index < mModelChartDataSets.size) {
            mModelChartDataSets[index].getLabel()
        } else ""
    }


    fun getColor(index: Int): Int {
        return if (index < mModelChartDataSets.size) {
            mModelChartDataSets[index].getColor()
        } else -1
    }

    /**
     *
     * @param datatype
     * @return index if available otherwise -1
     */
    fun getIndex(datatype: Int): Int {
        for (i in mModelChartDataSets.indices) {
            if (mModelChartDataSets[i].getDataType() === datatype) {
                return i
            }
        }
        return -1
    }

    fun isHidden(index: Int): Boolean {
        return mModelChartDataSets[index].isDataHidden()
    }

    fun addEntry(dataType: Int, `val`: Float) {
        //LOGV(TAG,"addentry:");
        val index = getIndex(dataType)
        if (index >= 0) {
            mModelChartDataSets[index].addEntry(`val`)
        }

    }

    fun setHidden(index: Int, isHidden: Boolean) {
        if (index < mModelChartDataSets.size) {
            mModelChartDataSets[index].setDataHidden(isHidden)
        }
    }

    fun getTimePeriod(): Float {
        return mTs
    }

    fun setTimePeriod(millisecond: Int) {
        mTs = millisecond.toFloat() / 1000f
        mTs = Math.round(mTs * 100f) / 100f
    }
}