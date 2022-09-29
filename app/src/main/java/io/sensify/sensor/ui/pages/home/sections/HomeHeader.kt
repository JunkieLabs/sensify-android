package io.sensify.sensor.ui.pages.home.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import io.sensify.sensor.R
import io.sensify.sensor.ui.resource.themes.JLThemeBase
import io.sensify.sensor.ui.resource.themes.JlThemeM3
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResTxtStyles

/**
 * Created by Niraj on 26-09-2022.
 */

@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun HomeHeader(){
    Box(modifier = Modifier
        .fillMaxWidth()

        .clip(RoundedCornerShape(JlResDimens.dp18))
        .background(
            brush = Brush.linearGradient(

                listOf(
                    JLThemeBase.colorPrimary,
//                            MaterialTheme.colorScheme.primary,
//                    JLThemeBase.colorPrimary30,
                    JLThemeBase.colorPrimary40,
//                    JLThemeBase.colorPrimary20,
                ),

                start = Offset(0f, 0f),
                end = Offset(0f, Float.POSITIVE_INFINITY)
            )
        )
        .border(
            brush = Brush.verticalGradient(
                listOf(
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.25f),
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
                        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.2f)
                    )

                    .border(
                        brush = Brush.verticalGradient(
                            listOf(

                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
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
                    style = JlResTxtStyles.h4,
                    color = MaterialTheme.colorScheme.onSurface,
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

            /*Image(
                painterResource(id = R.drawable.ic_round_keyboard_arrow_left_24),
                contentDescription = "slide to left",
                colorFilter = ColorFilter.tint(Color(0xFFFFFFFF)),
            )*/

//            FlexCh
            Row(modifier = Modifier.weight(1f).padding(all = JlResDimens.dp0),
                horizontalArrangement = Arrangement.SpaceBetween,


                verticalAlignment = Alignment.CenterVertically) {

                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        Icons.Outlined.KeyboardArrowLeft,
                        tint = MaterialTheme.colorScheme.onSurface ,

                        contentDescription = "Arrow Back",
                    )
                }
//                Spacer(modifier = Modifier.width(JlResDimens.dp12))

                Row(modifier = Modifier.padding(all = JlResDimens.dp0),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {

                    Box(
                        contentAlignment = Alignment.Center,

                        modifier = Modifier

                            .border(
                                JlResDimens.dp1,

                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                                shape = RoundedCornerShape(JlResDimens.dp16)
                            )
                            .clip(CircleShape)
                            .background(
                                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))

                    ) {
                        Image(
                            painterResource(id = R.drawable.ic_sensor_gyroscope),
                            contentDescription = "Gyroscope",
                            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface),
                            modifier = Modifier
                                .width(JlResDimens.dp28)
                                .height(JlResDimens.dp28)
                                .padding(JlResDimens.dp6)
                        )
                    }

                    Spacer(modifier = Modifier.width(JlResDimens.dp12))

                    Text(
                        text = "Gyroscope",
                        style = JlResTxtStyles.h5,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }




//                Spacer(modifier = Modifier.width(JlResDimens.dp12))


                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(
                        Icons.Outlined.KeyboardArrowRight,
                        tint = MaterialTheme.colorScheme.onSurface ,

                        contentDescription = "Arrow Next",
                    )
                }

            }






            /*Image(
                painterResource(id = R.drawable.ic_round_keyboard_arrow_right_24),
                contentDescription = "slide to left",
                colorFilter = ColorFilter.tint(JlThemeM3.md_theme_dark_onPrimary),
            )*/
            Spacer(modifier = Modifier.width(JlResDimens.dp12))
        }

    }
}