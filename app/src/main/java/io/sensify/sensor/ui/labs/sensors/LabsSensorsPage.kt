package io.sensify.sensor.ui.labs.sensors

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
import io.sensify.sensor.ui.resource.values.JlResDimens

/**
 * Created by Niraj on 04-08-2022.
 */

@Composable
fun LabsSensorsPage(navController: NavController) {

    val sensorsLabList = listOf(
        "Accelerometer",
        "Brightness",
        "Gravity",
        "Gyroscope",
        "Light",
        "Linear",
        "Magnetic",
        "Orientation",
        "Pressure",
        "Proximity",
        "Relative",
        "Rotation",
        "Temperature",
    )

    Column(
    modifier = Modifier
    .fillMaxSize()
    .verticalScroll(rememberScrollState()),
    ) {

        Spacer(modifier = Modifier.height(JlResDimens.dp20))
        Divider(color = Color.White, thickness = 1.dp)
        Text(
            text = "Sensors", modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(0.dp),
            fontSize = JlResDimens.sp16
        )
        Divider(color = Color.White, thickness = 1.dp)

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[0])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[1])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[2])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[3])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[4])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[5])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[6])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[7])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[8])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[9])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[10])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[11])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp16))
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp16, end = JlResDimens.dp16)
        ) {
            Text(text = sensorsLabList[12])
        }

        Spacer(modifier = Modifier.height(JlResDimens.dp20))
        Divider(color = Color.White, thickness = 1.dp)

        Spacer(modifier = Modifier.height(JlResDimens.dp20))

    }
}