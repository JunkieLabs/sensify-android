package io.sensify.sensor.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import io.sensify.sensor.ui.labs.utils.Sensors.ProximitySensor
import io.sensify.sensor.ui.labs.viewpager.ViewPagerSlider
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
                    ViewPagerSlider()
                    ProximitySensor()

                }
            }
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