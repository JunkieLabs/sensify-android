package io.sensify.sensor.ui.pages.home.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.sensify.sensor.R
import io.sensify.sensor.ui.labs.navigations.NavDirectionsLabs
import io.sensify.sensor.ui.resource.themes.JLThemeBase
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResShapes
import io.sensify.sensor.ui.resource.values.JlResTxtStyles

/**
 * Created by Niraj on 26-09-2022.
 */

@Preview(showBackground = true, backgroundColor = 0xFFf5f5f5)
@Composable
fun HomeSensorItem(
    sensorName: String = " Sensor 1",
    sensorValue: String = "Sa",
    sensorUnit: String = "m/s\u2008",
    sensorIcon: Int = R.drawable.ic_sensor_gravity,
    onClick : () -> Unit =  { }
) {
    val mCheckedState = remember{ mutableStateOf(false)}

    var cardColor = if(mCheckedState.value)  MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface;
    var borderColor = if(mCheckedState.value)  MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface;
    Box(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(JlResDimens.dp18))
        .clickable(
            enabled = true,
            onClickLabel = "Card Click",
            onClick = {
                onClick.invoke()
            })
        .background(
            brush = Brush.radialGradient(

                listOf(
                    cardColor.copy(alpha = 0.1f),
//                            MaterialTheme.colorScheme.primary,
//                    JLThemeBase.colorPrimary30,
                    cardColor.copy(alpha = 0.03f),
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
                    borderColor.copy(alpha = 0.0f),
                    borderColor.copy(alpha = 0.15f),
//                    Color(0x00FFFFFF),
                ),
                startY = 0f,
                endY = Float.POSITIVE_INFINITY,

                ),

            width = JlResDimens.dp1,
            shape = RoundedCornerShape(JlResDimens.dp18)
        )
    ) {

//    }
//
//    Card(
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
//        ),
//        modifier = Modifier
//            .fillMaxWidth()
//    ) {

        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
            Box(
                contentAlignment = Alignment.Center,

                modifier = Modifier
                    .border(1.dp, Color(0x33FFFFFF), shape = RoundedCornerShape(16.dp))
                    .clip(CircleShape)
                    .background(Color(0x14FFFFFF))

            ) {
                Image(
                    painterResource(sensorIcon),
                    contentDescription = sensorName,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),

                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                        .padding(start = 7.dp, end = 7.dp, top = 7.dp, bottom = 7.dp)
                )
            }
            Spacer(modifier = JlResShapes.Space.H4)
            Text(
                text = "sensorName",
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                style = JlResTxtStyles.h5,
                fontWeight = FontWeight(400),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = JlResDimens.dp48),
                verticalAlignment = Alignment.Bottom
            ) {

                if(mCheckedState.value){
                    Column(modifier = Modifier,
                    ) {
                        Text(
                            text = "in $sensorUnit",
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f),
                            fontSize = 12.sp
                        )
                        Text(
                            text = sensorValue,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.75f),
                            fontSize = 14.sp
                        )
                    }
                }


                Spacer(modifier = Modifier.weight(1f))
                Switch(
                    checked = mCheckedState.value,
                    onCheckedChange = { mCheckedState.value = it } ,
//                    interactionSource = interactionSource,
                    colors= SwitchDefaults.colors(
                        checkedThumbColor = Color(0xFF13ED6A),
                        uncheckedThumbColor = Color(0xFF898989),
                        checkedTrackColor = Color(0x4D00FF66),
                        uncheckedTrackColor = Color(0x33B1B1B1)
                    ),
                    modifier = Modifier
                        .width(30.dp)
                        .height(16.dp)
                        .padding(end = 1.dp, bottom = 1.dp),

                )


            }
        }

    }

}
