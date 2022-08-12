package io.sensify.sensor.ui.domains.permissions

import android.os.Build
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Dp

/**
 * Created by Niraj on 11-08-2022.
 */
class PermissionsManager {
}


@Composable
fun RememberPermissionManager(query: PermissionsQuery) {

}

interface PermissionsQuery {
    fun getPurposeList(): List<Int>
    abstract fun then(latest: PermissionsQuery): PermissionsQuery
    fun getPermissionsList(): List<String>

    //    fun then(): PermissionsQuery
    companion object : PermissionsQuery {
        const val PURPOSE_DETAIL = 101

        //        const val FOR_LIST = 10
        const val PURPOSE_SENSOR_STEP_COUNTER = 201

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
            when(purpose){
                PURPOSE_DETAIL -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        permissions.add(android.Manifest.permission.HIGH_SAMPLING_RATE_SENSORS)
                    }
                }
                PURPOSE_SENSOR_STEP_COUNTER ->{
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
        override fun then(latest: PermissionsQuery): PermissionsQuery {
            return this
        }

        override fun getPermissionsList(): List<String> {
            //TODO("Not yet implemented")
            return listOf()
        }

    }
}

class PermissionsQueryDelegate(var purpose: Int) : PermissionsQuery {

    var mPurposeList = mutableListOf<Int>()
    var mPermissions = mutableListOf<String>()

    init {
        mPurposeList = mutableListOf(purpose)
    }

    override fun getPurposeList(): List<Int> {
        return mPurposeList
    }


    override fun then(latest: PermissionsQuery): PermissionsQuery {
        updateValues(latest)
        return this

    }

    override fun getPermissionsList(): List<String> {
        var permissions = mutableListOf<String>()

        mPurposeList.forEach { it1 ->
            var itemPermissions = PermissionsQuery.permissionsFor(it1)
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

    internal fun updateValues(latest: PermissionsQuery) {

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
fun PermissionsQuery.forPurpose(purpose: Int) = this.then(
    PermissionsQueryDelegate(purpose)
)


//{
////    this.addApplyFor(value)
//   var applyFor =  this.mApplyFor.firstOrNull { it == value }
//
//    if(applyFor == null){
//        this.mApplyFor.add(value)
//    }
//
//}
//
//fun IPermissionsQuery.asw(value: Int) = this

/*@Stable
fun PermissionsQuery.applyFor(value: Int) {
//    this.addApplyFor(value)
    var applyFor =  this.mApplyFor.firstOrNull { it == value }

    if(applyFor == null){
        this.mApplyFor.add(value)
    }

}*/


