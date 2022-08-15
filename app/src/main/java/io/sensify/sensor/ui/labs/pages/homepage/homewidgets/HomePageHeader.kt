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
import io.sensify.sensor.ui.resource.themes.JLThemeBase
import io.sensify.sensor.ui.resource.themes.JlThemeM3
import io.sensify.sensor.ui.resource.values.JlResDimens

/**
 * Created by Manish Kumar on 09/08/22.
 */

@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun HomePageHeader(){
    Box(modifier = Modifier
        .fillMaxWidth()

        .clip(RoundedCornerShape(JlResDimens.dp18))
        .background(
            brush = Brush.linearGradient(
                listOf(
                    JLThemeBase.colorPrimary30,
                    JLThemeBase.colorPrimary20,
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
            width = JlResDimens.dp1,
            shape = RoundedCornerShape(JlResDimens.dp18)
        )
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .border(
                width = JlResDimens.dp5,
                color = JlThemeM3.md_theme_dark_error,
                shape = RoundedCornerShape(JlResDimens.dp1)
            )
            .blur(JlResDimens.dp4, BlurredEdgeTreatment(RoundedCornerShape(JlResDimens.dp5))))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = JlResDimens.dp6),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(JlResDimens.dp18))
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
                        width = JlResDimens.dp1,
                        shape = RoundedCornerShape(JlResDimens.dp18)
                    )

            ) {

                Box(
                    modifier = Modifier
                        .blur(JlResDimens.dp4, BlurredEdgeTreatment(RoundedCornerShape(JlResDimens.dp18)))
                )
                Text(
                    text = "4 Active",
                    color = JlThemeM3.md_theme_dark_onPrimary,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(
                            start = JlResDimens.dp12,
                            top = JlResDimens.dp16,
                            end = JlResDimens.dp18,
                            bottom = JlResDimens.dp18,
                        )
                )
            }

            Spacer(modifier = Modifier.width(JlResDimens.dp18))

            Image(
                painterResource(id = R.drawable.ic_round_keyboard_arrow_left_24),
                contentDescription = "slide to left",
                colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
            )

            Spacer(modifier = Modifier.width(JlResDimens.dp24))

            Box(
                contentAlignment = Alignment.Center,

                modifier = Modifier

                    .border(JlResDimens.dp1, Color(0x33FFFFFF), shape = RoundedCornerShape(JlResDimens.dp16))
                    .clip(CircleShape)
                    .background(Color(0x14FFFFFF))

            ) {
                Image(
                    painterResource(id = R.drawable.ic_sensor_gyroscope),
                    contentDescription = "Gyroscope",
                    colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
                    modifier = Modifier
                        .width(JlResDimens.dp28)
                        .height(JlResDimens.dp28)
                        .padding(JlResDimens.dp6)
                )
            }

            Spacer(modifier = Modifier.width(JlResDimens.dp24))

            Text(
                text = "Gyroscope",
                color = JlThemeM3.md_theme_dark_onPrimary,
                fontSize = JlResDimens.sp12,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.width(JlResDimens.dp24))

            Image(
                painterResource(id = R.drawable.ic_round_keyboard_arrow_right_24),
                contentDescription = "slide to left",
                colorFilter = ColorFilter.tint(JlThemeM3.md_theme_dark_onPrimary),
            )
            Spacer(modifier = Modifier.width(JlResDimens.dp12))
        }

    }
}