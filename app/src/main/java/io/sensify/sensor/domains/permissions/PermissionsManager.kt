package io.sensify.sensor.domains.permissions

import android.Manifest
import android.os.Build
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

/**
 * Created by Niraj on 11-08-2022.
 */
class PermissionsManager {
}


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RememberPermissionManager(
    query: PermissionsRequest,
    callbackResult: (isGranted: Boolean) -> Unit = {}
): MutablePermissionState {

    Log.d("RememberPermissionManager: ", "query.getPermissionsList(): ${query.getPermissionsList()}")

    var multiplePermissionsState =
        if (query.getPermissionsList().isEmpty()) {
            null
        } else {
            rememberMultiplePermissionsState(
//        listOf(
//            Manifest.permission.READ_EXTERNAL_STORAGE,
//            Manifest.permission.CAMERA,
//        )
                query.getPermissionsList(),
                onPermissionsResult = {
                    if (it.containsValue(false)) {
                        callbackResult.invoke(false)
                    } else {
                        callbackResult.invoke(true)
                    }

                }
            )
        }


    val permissionsState = remember(query, multiplePermissionsState) {
        MutablePermissionState(query, multiplePermissionsState)
    }


    val lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current;

//    multiplePermissionsState,
    DisposableEffect(lifecycleOwner) {
//        multiplePermissionsState.launcher = launcher

        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
//                currentOnStart()
                Log.d("RememberPermissionManager: ", "on_start")
            } else if (event == Lifecycle.Event.ON_STOP) {
//                currentOnStop()
                Log.d("RememberPermissionManager: ", "on_stop")
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)

//            multiplePermissionsState.launcher = null
        }
    }

    if (query.shouldRunAtStart()) {
        LaunchedEffect(true) {
            Log.d("RememberPermissionManager: ", "shouldRunAtStart")
            if (!permissionsState.isGranted) {
                Log.d("RememberPermissionManager: ", "shouldRunAtStart 2")
                permissionsState.requestManually()

            }

        }

    }

    /*if (multiplePermissionsState != null) {
        if (multiplePermissionsState.allPermissionsGranted) {

        }
        when (multiplePermissionsState.allPermissionsGranted) {


            else -> {}
        }
    }*/

    return permissionsState


}

interface PermissionsRequest {
    fun getPurposeList(): List<Int>
    fun getPermissionsList(): List<String>
    fun shouldRunAtStart(): Boolean

    fun _runCondition(): Int?

    fun then(latest: PermissionsRequest): PermissionsRequest

    //    fun then(): PermissionsQuery
    companion object : PermissionsRequest {
        const val PURPOSE_DETAIL = 101

        //        const val FOR_LIST = 10
        const val PURPOSE_SENSOR_STEP_COUNTER = 201

        internal const val RUN_AT_START = 1
        internal const val RUN_MANUALLY = 2


        /*val PERMISSIONS_MAP =
            mutableMapOf<Int, Array<String>>(
                Pair(
                    PURPOSE_DETAIL, arrayOf(
                        android.Manifest.permission.HIGH_SAMPLING_RATE_SENSORS
                    )
                ),
                Pair(
                    PURPOSE_SENSOR_STEP_COUNTER, arrayOf(
                        android.Manifest.permission.ACTIVITY_RECOGNITION
                    )
                )
            )
*/


        internal fun permissionsFor(purpose: Int): MutableList<String> {
            var permissions = mutableListOf<String>()
            when (purpose) {
                PURPOSE_DETAIL -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        permissions.add(
                            android.Manifest.permission.HIGH_SAMPLING_RATE_SENSORS
                        )
                    }
                    permissions.add(android.Manifest.permission.CAMERA)
                }
                PURPOSE_SENSOR_STEP_COUNTER -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        android.Manifest.permission.ACTIVITY_RECOGNITION
                    }
                }

            }
            return permissions

        }


        override fun getPurposeList(): List<Int> {
            return listOf()
        }

        //        override
        override fun then(latest: PermissionsRequest): PermissionsRequest {
            return PermissionsRequestDelegate(null).then(latest)
        }

        override fun getPermissionsList(): List<String> {
            //TODO("Not yet implemented")
            return listOf()
        }

        override fun shouldRunAtStart(): Boolean {
            return true
        }

        override fun _runCondition(): Int? {
            return null
        }

    }
}

class PermissionsRequestDelegate(var purpose: Int?, var runAtStart: Boolean? = null) :
    PermissionsRequest {

    var mPurposeList = mutableListOf<Int>()
    var mPermissions = mutableListOf<String>()

    var mRunCondition: Int? = null

    init {

        if (runAtStart != null) {
            if (runAtStart!!) {
                mRunCondition = PermissionsRequest.RUN_AT_START
            } else {
                mRunCondition = PermissionsRequest.RUN_MANUALLY
            }
        }
        if (purpose != null) {
            mPurposeList = mutableListOf(purpose!!)
            Log.d("PermissionsRequestDelegate: ", "init $purpose")

        }
    }

    override fun getPurposeList(): List<Int> {
        return mPurposeList
    }


    override fun then(latest: PermissionsRequest): PermissionsRequest {
        updateValues(latest)
        return this

    }

    override fun getPermissionsList(): List<String> {
        var permissions = mutableListOf<String>()

        mPurposeList.forEach { it1 ->
            Log.d("PermissionsRequestDelegate: ", "getPermissionsList $it1")

            var itemPermissions = PermissionsRequest.permissionsFor(it1)
            itemPermissions.forEach { permission ->
                var applyFor = permissions.firstOrNull { it == permission }
                if (applyFor == null) {
                    permissions.add(permission)
                }
            }

        }
        mPermissions = permissions
        return permissions

    }

    override fun shouldRunAtStart(): Boolean {
        return true
    }

    override fun _runCondition(): Int? {
        return mRunCondition
    }


    private fun updateValues(latest: PermissionsRequest) {

        var runCondition = latest._runCondition()
        if (runCondition != null) {
            this.mRunCondition = runCondition
        }

        var purpose = latest.getPurposeList()
        purpose.forEach { it1 ->
            var applyFor = this.mPurposeList.firstOrNull { it == it1 }
            if (applyFor == null) {
                this.mPurposeList.add(it1)
            }
        }


    }
}

@Stable
fun PermissionsRequest.forPurpose(purpose: Int) = this.then(
    PermissionsRequestDelegate(purpose)
)

@Stable
fun PermissionsRequest.runAtStart(shouldRun: Boolean) = this.then(
    PermissionsRequestDelegate(null, shouldRun)
)




