package io.sensify.sensor.ui.labs.permissions

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.permissions.*
import io.sensify.sensor.domains.permissions.PermissionsRequest
import io.sensify.sensor.domains.permissions.RememberPermissionManager
import io.sensify.sensor.domains.permissions.forPurpose
import io.sensify.sensor.domains.permissions.runAtStart

/**
 * Created by Niraj on 11-08-2022.
 */

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LabsPermissionsPage(navController: NavController) {

//   TODO undo this part rememberPermissionState(permission = )


//    PermissionsQuery.
//    val cameraPermissionState = featureThatRequiresCameraPermission()
//    requestMultiplePermissionsSample()

    val permissionManager = RememberPermissionManager(
        PermissionsRequest.forPurpose(PermissionsRequest.PURPOSE_DETAIL).runAtStart(true),
        callbackResult = {
            Log.d("LabsPermissionsPage: ", "permissionManager $it")

        }
    )

    if (permissionManager.isGranted) {
        Text("Camera permission Granted")
    } else {
        Text("Camera permission Not Granted")
    }

//    PermissionsQuery.asw

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {

        Spacer(modifier = Modifier.height(20.dp))


        Spacer(modifier = Modifier.height(20.dp))
        Divider(color = Color.White, thickness = 1.dp)
        Text(
            text = "Core", modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp),
            fontSize = 16.sp
        )
        Divider(color = Color.White, thickness = 1.dp)


        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
//                      cameraPermissionState.launchPermissionRequest()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "S1")
        }

        Spacer(modifier = Modifier.height(16.dp))


    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun featureThatRequiresCameraPermission(): PermissionState {


    // Camera permission state
    val cameraPermissionState: PermissionState = rememberPermissionState(
        android.Manifest.permission.CAMERA
    )


    when (cameraPermissionState.status) {
        // If the camera permission is granted, then show screen with the feature enabled
        PermissionStatus.Granted -> {
            Text("Camera permission Granted")
        }
        is PermissionStatus.Denied -> {
            Column {
                val textToShow = if (cameraPermissionState.status.shouldShowRationale) {
                    // If the user has denied the permission but the rationale can be shown,
                    // then gently explain why the app requires this permission
                    "The camera is important for this app. Please grant the permission."
                } else {
                    // If it's the first time the user lands on this feature, or the user
                    // doesn't want to be asked again for this permission, explain that the
                    // permission is required
                    "Camera permission required for this feature to be available. " +
                            "Please grant the permission"
                }
                Text(textToShow)
                Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                    Text("Request permission")
                }
            }
        }
    }

    return cameraPermissionState
}


@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun requestMultiplePermissionsSample() {
    val multiplePermissionsState = rememberMultiplePermissionsState(
        listOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.CAMERA,
        )
    )
    MultipleSample(multiplePermissionsState)

}


@OptIn(ExperimentalPermissionsApi::class)
@Composable
private fun MultipleSample(multiplePermissionsState: MultiplePermissionsState) {
    if (multiplePermissionsState.allPermissionsGranted) {
        // If all permissions are granted, then show screen with the feature enabled
        Text("Camera and Read storage permissions Granted! Thank you!")
    } else {
        Column {
//            Text(
//                getTextToShowGivenPermissions(
//                    multiplePermissionsState.revokedPermissions,
//                    multiplePermissionsState.shouldShowRationale
//                )
//            )
            Text("textToShow")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { multiplePermissionsState.launchMultiplePermissionRequest() }) {
                Text("Request permissions")
            }
        }
    }
}

