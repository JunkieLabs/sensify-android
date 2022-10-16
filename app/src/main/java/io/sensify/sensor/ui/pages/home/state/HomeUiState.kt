package io.sensify.sensor.ui.pages.home.state

import io.sensify.sensor.ui.pages.home.model.ModelHomeSensor

/**
 * Created by Niraj on 09-10-2022.
 */
data class HomeUiState(var currentSensor: ModelHomeSensor? = null, var activeSensorCounts: Int = 1) {


}