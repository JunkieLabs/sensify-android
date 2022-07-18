package io.sensify.sensor.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.sensify.sensor.ui.labs.viewpager.Pager
import io.sensify.sensor.ui.theme.SensifyAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensifyAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    val items = listOf(
        Color.Red,
        Color.Blue,
        Color.Green,
        Color.Yellow,
        Color.Cyan,
        Color.Magenta
    )

    Column(
        Modifier.fillMaxSize().padding(16.dp),
    ) {

        /**
         * Horizontal Pager
         */
        Spacer(modifier = Modifier.height(32.dp))
        Pager(
            items = items,
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp),
            itemFraction = .75f,
            overshootFraction = .75f,
            initialIndex = 3,
            itemSpacing = 16.dp,
            contentFactory = { item ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(item),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = item.toString(),
                        modifier = Modifier.padding(all = 16.dp),
                        style = MaterialTheme.typography.h6,
                    )
                }
            }
        )
        /**
         * Vertical pager
         */
//        Spacer(modifier = Modifier.height(32.dp))
//
//        Pager(
//            items = items,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(256.dp),
//            orientation = Orientation.Vertical,
//            itemFraction = .8f,
//            itemSpacing = 16.dp,
//            contentFactory = { item ->
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(item),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(
//                        text = item.toString(),
//                        modifier = Modifier.padding(all = 16.dp),
//                        style = MaterialTheme.typography.h6,
//                    )
//                }
//            }
//        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SensifyAndroidTheme {
        Greeting("Android")
    }
}