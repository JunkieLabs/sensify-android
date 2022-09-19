package io.sensify.sensor.ui.labs.charts.line

import android.util.Log
import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.utils.MyXAxisFormatter

/**
 * Created by Niraj on 30-08-2022.
 */

@Composable
fun LabsLineChartPage(navController: NavController) {

    var isUpdating: MutableState<Boolean> = remember { mutableStateOf(false) }

    var counter = remember { mutableStateOf(10f) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {

        Spacer(modifier = Modifier.height(JlResDimens.dp20))
        Divider(color = Color.White, thickness = 1.dp)
        Button(
            onClick = {
//                Log.i("Line Chart","isUpdating.value:Click : ${!isUpdating.value}")
                isUpdating.value = !isUpdating.value
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = "Chart Button 1")
        }

//        key(keys = arrayOf(isUpdating.value)) {
            DefaultChartTesting(isUpdating)
//        }
        LabsLineChartRealtimeTesting()



    }


    /* if (isUpdating.value) {
         Log.i("LineChart Log: ", "update 2")

     } else {
         Log.i("LineChart Log: ", "update 3")

     }*/
    if (isUpdating.value) {
        try {
            Log.d("TAG", "MyLineChart: Update --- Current thread id: ${Thread.currentThread()}")

//            lineChart
//            it.data.dataSets[0].addEntry(Entry(0f, 0f))
//            it.lineData.notifyDataChanged()
//            it.notifyDataSetChanged()
//            it.invalidate()
        } catch (ex: Exception) {
            Log.d("TAG", "MyLineChart: $ex")
        }
    }
}



