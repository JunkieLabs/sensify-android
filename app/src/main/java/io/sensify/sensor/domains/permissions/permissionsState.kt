@file:OptIn(ExperimentalPermissionsApi::class)

package io.sensify.sensor.domains.permissions

import android.util.Log
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.isGranted

/**
 * Created by Niraj on 12-08-2022.
 */

interface PermissionsState {
    val isGranted: Boolean
    fun requestManually(): Unit

}

class MutablePermissionState(
    private val permissionsRequest: PermissionsRequest, private val multiplePermissionsState: MultiplePermissionsState?

): PermissionsState {
    override val isGranted: Boolean by derivedStateOf {
        multiplePermissionsState?.allPermissionsGranted ?: false
    }


//        multiplePermissionsState?.allPermissionsGranted ?: false




    override fun requestManually() {
        if(multiplePermissionsState == null){
            Log.d("MutablePermissionState: ", "requestManually 2")

        }
        multiplePermissionsState?.launchMultiplePermissionRequest()
    }

}
