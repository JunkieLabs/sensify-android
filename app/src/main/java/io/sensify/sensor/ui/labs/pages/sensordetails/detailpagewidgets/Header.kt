package io.sensify.sensor.ui.labs.pages.sensordetails.detailpagewidgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.unit.sp
import io.sensify.sensor.R
import io.sensify.sensor.ui.resource.themes.JLThemeBase
import io.sensify.sensor.ui.resource.themes.JlThemeM3
import io.sensify.sensor.ui.resource.values.JlResColors
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResStyles

/**
 * Created by Manish Kumar on 15/08/22.
 */

@Preview(showBackground=true, backgroundColor = 0xFF041B11)
@Composable
fun HeaderButton(modifier: Modifier = Modifier){


    var visualButtonColor: Brush
    var graphButtonColor: Brush

    var isVisualButtonActive = remember { mutableStateOf(true) }
    var isGraphButtonActive = remember { mutableStateOf(false) }

    if(isVisualButtonActive.value){
        visualButtonColor = Brush.linearGradient(
            listOf(
                JLThemeBase.colorPrimary30,
                JLThemeBase.colorPrimary20,
            )
        )

    } else {
        visualButtonColor = Brush.linearGradient(
            listOf(
                Color.Transparent,
                Color.Transparent,
            )
        )
    }

    if(isGraphButtonActive.value){
        graphButtonColor = Brush.linearGradient(
            listOf(
                JLThemeBase.colorPrimary30,
                JLThemeBase.colorPrimary20,
            )
        )
    } else {
        graphButtonColor = Brush.linearGradient(
            listOf(
                Color.Transparent,
                Color.Transparent,
            )
        )
    }


    Box(
        modifier = Modifier
        .fillMaxWidth()

        .clip(
            RoundedCornerShape(
                topStart = JlResDimens.dp28,
                topEnd = JlResDimens.dp28,
                bottomStart = JlResDimens.dp16,
                bottomEnd = JlResDimens.dp16
            )
        )
        .border(
            brush = Brush.verticalGradient(
                listOf(
                    Color(0x2BFFFFFF),
                    Color(0x80F2FBFF),
                )
            ),
            width = JlResDimens.dp1,
            shape = RoundedCornerShape(
                topStart = JlResDimens.dp28,
                topEnd = JlResDimens.dp28,
                bottomStart = JlResDimens.dp16,
                bottomEnd = JlResDimens.dp16
            )
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = JlResDimens.dp6),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextButton(onClick = { isVisualButtonActive.value = true
                                 isGraphButtonActive.value = false},

                modifier = Modifier
                    .weight(0.495f)
                    .padding(JlResDimens.dp4)
                    .clip(shape = RoundedCornerShape(
                            topStart = JlResDimens.dp24,
                            topEnd = JlResDimens.dp24,
                            bottomStart = JlResDimens.dp12,
                            bottomEnd = JlResDimens.dp12)
                        )
                    .background(brush = visualButtonColor)
//                    .border(
//                    brush = Brush.verticalGradient(
//                        listOf(
//                            Color(0xFFFFFFFF),
//                            Color(0x00FFFFFFF),
//                            Color(0xFFFFFFFF)
//                        )
//                    ),
//                    width = JlResDimens.dp1,
//                    shape = RoundedCornerShape(
//                        topStart = JlResDimens.dp24,
//                        topEnd = JlResDimens.dp24,
//                        bottomStart = JlResDimens.dp12,
//                        bottomEnd = JlResDimens.dp12
//                    )
//                )
            ){
                Text(text = "Visuals", color = JlThemeM3.md_theme_dark_onSurface)
            }

            Spacer(modifier = Modifier.weight(0.01f))

            TextButton(
                onClick = {
                    isGraphButtonActive.value = true
                    isVisualButtonActive.value = false },
                modifier = Modifier
                    .weight(0.495f)
                    .padding(JlResDimens.dp4)
                    .clip(shape = RoundedCornerShape(
                        topStart = JlResDimens.dp24,
                        topEnd = JlResDimens.dp24,
                        bottomStart = JlResDimens.dp12,
                        bottomEnd = JlResDimens.dp12)
                    )
                    .background(brush = graphButtonColor)
//                    .border(
//                        brush = Brush.verticalGradient(
//                            listOf(
//                                Color(0xFFFFFFFF),
//                                Color(0x00FFFFFFF),
//                                Color(0xFFFFFFFF)
//                            )
//                        ),
//                        width = JlResDimens.dp0,
//                        shape = RoundedCornerShape(
//                            topStart = JlResDimens.dp24,
//                            topEnd = JlResDimens.dp24,
//                            bottomStart = JlResDimens.dp12,
//                            bottomEnd = JlResDimens.dp12
//                        )
//                    )

            ){
                Text(text = "Graph", color = JlThemeM3.md_theme_dark_onSurface)
            }

        }

    }
}

