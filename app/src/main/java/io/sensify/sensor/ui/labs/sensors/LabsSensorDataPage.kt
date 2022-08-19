package io.sensify.sensor.ui.labs.sensors

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * Created by Niraj on 18-08-2022.
 */


@Composable
fun LabsSensorDataPage(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()


    val _tickFlow = MutableSharedFlow<Boolean>(replay = 0)
    val tickFlow = _tickFlow.asSharedFlow()

    val dsd = tickFlow.collectAsState(initial = false)
    val dse = tickFlow.collectAsState(initial = false)

    var visible1 by remember { mutableStateOf(true) }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {

        Spacer(modifier = Modifier.height(20.dp))
        Divider(color = Color.White, thickness = 1.dp)
        Text(
            text = "Data", modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp),
            fontSize = 16.sp
        )
        Divider(color = Color.White, thickness = 1.dp)

        Button(
            onClick = {

                      visible1 = !visible1
                coroutineScope.launch {

                    _tickFlow.emit(!visible1)
                }


            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(text = "S1")
        }

        if(dse.value){
            Text(
                text = "Data dse", modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(0.dp),

                fontSize = 16.sp
            )
        }

        if(dsd.value){
            Text(
                text = "Data dsd", modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(0.dp),

                fontSize = 16.sp
            )
        }



        Spacer(modifier = Modifier.height(16.dp))


    }
}