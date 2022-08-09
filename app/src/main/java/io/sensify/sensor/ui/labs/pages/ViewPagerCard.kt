package io.sensify.sensor.ui.labs.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.sensify.sensor.ui.labs.viewpager.Pager

/**
 * Created by Manish Kumar on 23/07/22.
 */

@Composable
fun ViewPagerPages(name: String) {

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
                        color = Color.Black,
                        style = MaterialTheme.typography.displaySmall,
                    )
                }
            }
        )
        /**
         * Vertical pager
         */
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