package io.sensify.sensor.ui.pages.sensor.sections

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Inbox
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.pager.ExperimentalPagerApi
import io.sensify.sensor.domains.sensors.provider.SensorsProvider
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResTxtStyles

/**
 * Created by Niraj on 27-09-2022.
 */
@OptIn(ExperimentalPagerApi::class)
//@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun SensorDetail(
    keyValues: Map<String, Any> = mutableMapOf(
        Pair("Name", "MN26005 ALS"),
        Pair("Max Range", "655365 lx"),
        Pair("Version", "1")
    )
 /*           keyValues: List<Pair<String, String>> = listOf(
Pair("Name", "MN26005 ALS"),
Pair("Max Range", "655365 lx"),
Pair("Version", "1")
)*/
) {

    Log.d("SensorDetail", "1: ${keyValues}")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(JlResDimens.dp18))
            .background(
                brush = Brush.radialGradient(

                    listOf(
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
//                            MaterialTheme.colorScheme.primary,
//                    JLThemeBase.colorPrimary30,
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.03f),
//                    Color.Transparent,
                    ),
                    center = Offset(30f, -30f),

                    radius = 200.0f


//                start = Offset(0f, 0f),
//                end = Offset(0f, Float.POSITIVE_INFINITY)
                )
            )
            .border(
                brush = Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.0f),
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.15f),
//                    Color(0x00FFFFFF),
                    ),
                    startY = 0f,
                    endY = Float.POSITIVE_INFINITY,

                    ),

                width = JlResDimens.dp1,
                shape = RoundedCornerShape(JlResDimens.dp18)
            )
            .padding(all = JlResDimens.dp24)
    ) {

        Column() {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Rounded.Info, "info",
                    modifier = Modifier.size(JlResDimens.dp12),
                    tint = MaterialTheme.colorScheme.onSurface)
                Spacer(modifier = Modifier.width(JlResDimens.dp20))
                Text(
                    text = "Sensor Details",
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f),
                    textAlign = TextAlign.Center,
                    style = JlResTxtStyles.h4,
                )
            }
            Spacer(modifier = Modifier.height(JlResDimens.dp20))

            for (item in keyValues){
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = JlResDimens.dp32)) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "${item.key}:",
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.34f),
                        textAlign = TextAlign.Start,
                        style = JlResTxtStyles.h4,
                    )
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "${item.value}",
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f),
                        textAlign = TextAlign.Start,
                        style = JlResTxtStyles.h4,
                    )
                }
                Spacer(modifier = Modifier.height(JlResDimens.dp12))

            }


        }

    }

}