package io.sensify.sensor.ui.pages.sensor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Niraj on 26-10-2022.
 */
@Suppress("UNCHECKED_CAST")
class SensorViewModelFactory(private val sensorType: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SensorViewModel(sensorType) as T
    }

/*    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SensorViewModel(sensorType) as T
    }*/


}