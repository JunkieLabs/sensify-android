package io.sensify.sensor.ui.labs.pages.homepage.homewidgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.sensify.sensor.R

/**
 * Created by Manish Kumar on 09/08/22.
 */

@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun HomePageHeader(){
    Box(modifier = Modifier
        .fillMaxWidth()

        .clip(RoundedCornerShape(19.dp))
        .background(
            brush = Brush.linearGradient(
                listOf(

                    Color(0xB200752F),
                    Color(0xB200752F),
                )
            )
        )
        .border(
            brush = Brush.verticalGradient(
                listOf(
                    Color(0x80FFFFFF),
                    Color(0x00FFFFFF),
                )
            ),
            width = 1.dp,
            shape = RoundedCornerShape(19.dp)
        )
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 5.dp,
                color = Color.Red,
                shape = RoundedCornerShape(1.dp)
            )
            .blur(4.dp, BlurredEdgeTreatment(RoundedCornerShape(5.dp))))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(19.dp))
                    .background(
                        brush = Brush.radialGradient(
                            listOf(
                                Color(0x33000000),
                                Color(0x33000000 ),

                                )
                        )
                    )

                    .border(
                        brush = Brush.verticalGradient(
                            listOf(

                                Color(0x00FFFFFF),
                                Color(0x80FFFFFF),
                            )
                        ),
                        width = 1.dp,
                        shape = RoundedCornerShape(19.dp)
                    )

            ) {

                Box(
                    modifier = Modifier
                        .blur(4.dp, BlurredEdgeTreatment(RoundedCornerShape(19.dp)))
                )
                Text(
                    text = "4 Active",
                    color = Color(0xFFFFFFFF),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(
                            start = 13.dp,
                            top = 16.dp,
                            end = 18.dp,
                            bottom = 17.dp,
                        )
                )
            }

            Spacer(modifier = Modifier.width(18.dp))

            Image(
                painterResource(id = R.drawable.ic_round_keyboard_arrow_left_24),
                contentDescription = "slide to left",
                colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
            )

            Spacer(modifier = Modifier.width(24.dp))

            Box(
                contentAlignment = Alignment.Center,

                modifier = Modifier

                    .border(1.dp, Color(0x33FFFFFF), shape = RoundedCornerShape(16.dp))
                    .clip(CircleShape)
                    .background(Color(0x14FFFFFF))

            ) {
                Image(
                    painterResource(id = R.drawable.ic_sensor_gyroscope),
                    contentDescription = "Gyroscope",
                    colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .width(28.dp)
                        .height(28.dp)
                        .padding(start = 7.dp, end = 7.dp, top = 7.dp, bottom = 7.dp)
                )
            }

            Spacer(modifier = Modifier.width(23.dp))

            Text(
                text = "Gyroscope",
                color = Color.White,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.width(22.dp))

            Image(
                painterResource(id = R.drawable.ic_round_keyboard_arrow_right_24),
                contentDescription = "slide to left",
                colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
            )
            Spacer(modifier = Modifier.width(12.dp))
        }

    }
}