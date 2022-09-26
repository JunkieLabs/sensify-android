package io.sensify.sensor.ui.labs.pages.homepage.homewidgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.sensify.sensor.R

/**
 * Created by Manish Kumar on 08/08/22.
 */

@Preview(showBackground=true, backgroundColor = 0xFF041B11)
@Composable
fun HomeSensorCard(
    sensorName: String = "Magnatic Field",
    sensorValue: String = "9.7",
    sensorUnit: String = "m/s\u2008",
    sensorIcon: Int = R.drawable.ic_sensor_gravity,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0x1D17FF58)
        ),
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Column(modifier = Modifier) {
            Box(
                contentAlignment = Alignment.Center,

                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
                    .border(1.dp, Color(0x33FFFFFF), shape = RoundedCornerShape(16.dp))
                    .clip(CircleShape)
                    .background(Color(0x14FFFFFF))

            ){
                Image(
                    painterResource(sensorIcon),
                    contentDescription = sensorName,
                    colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),

                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                        .padding(start = 7.dp, end = 7.dp, top = 7.dp, bottom = 7.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = sensorName,
                color = Color.White,
                fontSize = 16.sp,
                softWrap = true,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
            )

            Spacer(modifier = Modifier.height(11.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ) {

                Column(modifier = Modifier) {
                    Text(
                        text = "in $sensorUnit",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                    Text(
                        text = sensorValue,
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .align(Alignment.Bottom)
                ){

                    val interactionSource = remember { MutableInteractionSource() }
                    val isPressed by interactionSource.collectIsPressedAsState()
                    // Use the state to change our UI
                    val color = if (isPressed) Color.Blue else Color.Yellow

                    Switch(
                        checked = false,
                        onCheckedChange = null,
                        interactionSource = interactionSource,
                        colors= SwitchDefaults.colors(
                            checkedThumbColor = Color(0xFF13ED6A),
                            uncheckedThumbColor = Color(0xFF898989),
                            checkedTrackColor = Color(0x4D00FF66),
                            uncheckedTrackColor = Color(0x33B1B1B1)
                        ),
                        modifier = Modifier
                            .width(30.dp)
                            .height(16.dp)
                            .padding(end = 1.dp, bottom = 1.dp)
                            .align(Alignment.BottomEnd),
                    )
                }
            }
        }
    }
}