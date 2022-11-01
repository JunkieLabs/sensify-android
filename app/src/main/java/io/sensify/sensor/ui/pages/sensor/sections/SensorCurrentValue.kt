package io.sensify.sensor.ui.pages.sensor.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.google.accompanist.pager.ExperimentalPagerApi
import io.sensify.sensor.domains.sensors.SensorsConstants
import io.sensify.sensor.ui.resource.effects.drawColoredShadow
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResTxtStyles

/**
 * Created by Niraj on 27-09-2022.
 */
@OptIn(ExperimentalPagerApi::class)
//@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun SensorDetailCurrentValue(sensorType: Int = -1, value: Float= 0.0f) {
    var hasUnit = SensorsConstants.hasUnit(sensorType)


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = JlResDimens.dp6),
        verticalAlignment = Alignment.Top,

        ) {
        Box(
            modifier = Modifier
                .size(JlResDimens.dp20)
                .background(Color(0xFFFFCA10), shape = CircleShape)
                .border(
                    width = JlResDimens.dp1, brush = Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                        )
                    ), shape = CircleShape
                )
                .drawColoredShadow(
                    Color(0xFFFFCA10), offsetY = JlResDimens.dp12,
                    shadowRadius = JlResDimens.dp8, borderRadius = JlResDimens.dp8, alpha = 0.5f
                ),
            contentAlignment = Alignment.Center

        ) {
            Box(
                modifier = Modifier
                    .size(JlResDimens.dp12)
                    .border(
                        width = JlResDimens.dp2,
                        color = MaterialTheme.colorScheme.onSurface,
                        shape = CircleShape
                    )
            )

        }

        Spacer(modifier = Modifier.width(JlResDimens.dp18))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = JlResDimens.dp12, end = JlResDimens.dp28)
        ) {

            Row(   modifier = Modifier
                .fillMaxWidth()
                ,verticalAlignment = Alignment.CenterVertically,) {


                if(hasUnit){
                    Text(
                        text = buildAnnotatedString {
                            append("Current Value in ")

                           SensorsConstants.getUnit(this, sensorType)
                        },
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                        textAlign = TextAlign.Center,
                        style = JlResTxtStyles.h4,
                    )
                }else{
                    Text(
                        text = "Current Value ",
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                        textAlign = TextAlign.Center,
                        style = JlResTxtStyles.h4,
                    )
                }


            }

            Text(
                text = "${value}",
                fontSize = JlResDimens.sp48,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        Spacer(modifier = Modifier.width(JlResDimens.dp18))


    }
}