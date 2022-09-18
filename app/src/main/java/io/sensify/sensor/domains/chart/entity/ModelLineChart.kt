package io.sensify.sensor.domains.chart.entity

import io.sensify.util.QueueFixedLength

/**
 * Created by Niraj on 31-08-2022.
 */
// TODO under development
class ModelLineChart(var mSampleLength: Int = 100, var mVisibleNum: Int =  -1) {


    //private SparseIntArray mMapIndex;
    /*private var VISIBLE_NUM = -1
    private var LENGTH_SAMPLE = 100*/

    private var mTs = 0.1f

    private var mModelChartDataSets: MutableList<ModelChartDataSet>

    init {

        mModelChartDataSets = mutableListOf() //ArrayList(5)

    }

    init {
      /*  LENGTH_SAMPLE = mSampleLength
        VISIBLE_NUM = mVisibleNum*/
    }


    fun sampleSize(sampleSize: Int) {
        mSampleLength = sampleSize
        mVisibleNum = if (mVisibleNum == -1) sampleSize else mVisibleNum
        for (i in mModelChartDataSets.indices) {
            val modelChartDataSet = mModelChartDataSets[i]
            modelChartDataSet.resize(mSampleLength)
        }

    }

    fun visibleNumber(visibleNum: Int) {
        mVisibleNum = if (visibleNum <= mSampleLength) visibleNum else mSampleLength
    }

    fun getSampleLength(): Int {
        return mSampleLength
    }


    fun addDataType(
        pDataType: Int,
        color: Int,
        pLabel: String?,
        pData: Array<Float>?,
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
            modelChartDataSet = ModelChartDataSet(pDataType, mSampleLength)
            mModelChartDataSets.add(modelChartDataSet)
        }
        modelChartDataSet.setColor(color)
        if (pLabel == null) {
            modelChartDataSet.setLabel("data_$pDataType")
        } else {
            modelChartDataSet.setLabel(pLabel)
        }



        //LOGV(TAG, "addDta: type: "+ pDataType +" || array :  "+ Arrays.toString(pData));
        modelChartDataSet.setData(mSampleLength, pData)
        modelChartDataSet.setDataHidden(isHidden)
    }


    fun getData(index: Int): QueueFixedLength<Float>? {
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
            if (mModelChartDataSets[i].getDataType() == datatype) {
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

    fun getDataSets(): List<ModelChartDataSet> {
        return mModelChartDataSets
    }
}