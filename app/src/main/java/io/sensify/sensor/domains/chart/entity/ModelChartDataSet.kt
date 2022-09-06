package io.sensify.sensor.domains.chart.entity

import io.sensify.util.QueueFixedLength

/**
 * Created by Niraj on 31-08-2022.
 */
class ModelChartDataSet(dataType: Int, LENGTH_SAMPLE: Int) {

//    private val TAG: String = makeLogTag(io.sensify.lib.charting.ModelChartDataSet::class.java)

    private var label: String? = null
    private var isDataHidden = false
    private var color = 0
    private var data: QueueFixedLength<Float?>? = null
    private var dataType = 0

    init {
        this.dataType = dataType
        data = QueueFixedLength(LENGTH_SAMPLE, null)
    }

    fun setColor(color: Int) {
        this.color = color
    }

    fun setDataHidden(dataHidden: Boolean) {
        isDataHidden = dataHidden
    }

    fun setLabel(label: String?) {
        this.label = label
    }

    fun setData(pData: QueueFixedLength<Float?>) {
        data = pData
    }

    fun getDataType(): Int {
        return dataType
    }

    fun getColor(): Int {
        return color
    }

    fun getLabel(): String? {
        return label
    }

    fun getData(): QueueFixedLength<Float?>? {
        return data
    }

    fun addEntry(entry: Float) {
        data?.add(entry)
//        if (data != null) {

            //LOGV(TAG,"addentry: type: "+ dataType + "size:"+ data.size());
//        }
    }

    fun resize(size: Int) {
        data?.resize(size)
    }

    fun isDataHidden(): Boolean {
        return isDataHidden
    }

    fun setData(length_sample: Int, pData: Array<Float?>?) {
        if (pData != null) {
            data = QueueFixedLength(length_sample, pData)
        } else {
            data?.resize(length_sample)
        }
    }
}