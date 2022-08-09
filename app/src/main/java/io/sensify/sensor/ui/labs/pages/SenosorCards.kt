package io.sensify.sensor.ui.labs.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.SwitchDefaults
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.sensify.sensor.R
import androidx.compose.material.Switch

/**
 * Created by Manish Kumar on 31/07/22.
 */

@Preview
@Composable
fun GyroscopeCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0x1D17FF58)
            ),
        modifier = Modifier
            .width(128.dp)
            .height(128.dp)

    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                contentAlignment = Alignment.Center,

                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
                    .border(1.dp, Color(0x33FFFFFF), shape = RoundedCornerShape(16.dp))
                    .clip(CircleShape)
                    .background(Color(0x14FFFFFF))

            ){
                Image(
                    painterResource(R.drawable.ic_sensor_gyroscope),
                    contentDescription = "Gyroscope",
                    colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),

                    modifier = Modifier
                        .width(28.dp)
                        .height(28.dp)
                        .padding(start = 7.dp, end = 7.dp, top = 7.dp, bottom = 7.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Gyroscope",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 16.dp),
            )
            
            Spacer(modifier = Modifier.height(11.dp))
            
            Row(modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
            ) {

                Column(modifier = Modifier) {
                    Text(
                        text = "in rpm",
                        color = Color.White,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "340",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    contentAlignment = Alignment.CenterEnd,
                    modifier = Modifier
                        .fillMaxSize()
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
                            .padding(end = 1.dp),
                    )
                }
            }
        }
    }
}
