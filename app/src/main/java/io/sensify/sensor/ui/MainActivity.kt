package io.sensify.sensor.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import io.sensify.sensor.ui.labs.utils.Sensors.ProximitySensor
import io.sensify.sensor.ui.labs.viewpager.ViewPagerSlider
import io.sensify.sensor.ui.navigation.NavigationGraph
import io.sensify.sensor.ui.theme.SensifyAndroidTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensifyAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    ViewPagerPages(name = "Android")
//                    ViewPagerSlider()
//                    ProximitySensor()

//                    val sensorsLabList = listOf(
//                        "Accelerometer",
//                        "Brightness",
//                        "Gravity",
//                        "Gyroscope",
//                        "Light",
//                        "Linear",
//                        "Magnetic",
//                        "Orientation",
//                        "Pressure",
//                        "Proximity",
//                        "Relative",
//                        "Rotation",
//                        "Temperature",
//                        "Launcher",
//                        "Home",
//                        "ViewPager"
//                    )
//
//                    var activityToOpen by remember { mutableStateOf("") }
//
//                    when (activityToOpen) {
//                        "ViewPager" -> ViewPagerSlider()
//                        else -> Log.e("Button Click", "Invalid Selection")
//                    }
//                    LabPage(sensorsLabList) {
//                        activityToOpen = it
//                    }

                    NavigationGraph()

                }
            }
        }
    }

    @Composable
    fun LabPage(sensorsList: List<String>, onClick: (String) -> Unit) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {

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
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[13])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[14])
            }

            Spacer(modifier = Modifier.height(20.dp))
            Divider(color = Color.White, thickness = 1.dp)
            Text(
                text = "Sensors", modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(0.dp),
                fontSize = 16.sp
            )
            Divider(color = Color.White, thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[0])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[1])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[2])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[3])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[4])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[5])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[6])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[7])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[8])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[9])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[10])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[11])
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[12])
            }

            Spacer(modifier = Modifier.height(20.dp))
            Divider(color = Color.White, thickness = 1.dp)
            Text(
                text = "Others", modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(0.dp),
                fontSize = 16.sp
            )
            Divider(color = Color.White, thickness = 1.dp)

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { onClick(sensorsList[15]) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = sensorsList[15])
            }

            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}
//@Composable
//fun Greeting(name: String) {
//    Text(text = name)
//}
//
////@Preview(showBackground = true, backgroundColor = 0xFF041B11)
//@Composable
//fun HomeScreenAppBarPreview(){
//    SensifyAndroidTheme {
//        HomeScreenAppBar(Modifier.padding(2.dp))
//    }
//}
//
////@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    SensifyAndroidTheme {
//        Greeting("Android")
//    }
//}