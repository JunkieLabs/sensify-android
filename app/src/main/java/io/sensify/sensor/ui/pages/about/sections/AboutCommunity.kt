package io.sensify.sensor.ui.pages.about.sections

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import io.sensify.sensor.ui.resource.effects.drawColoredShadow
import io.sensify.sensor.ui.resource.values.JlResDimens

/**
 * Created by Niraj on 28-09-2022.
 */
@OptIn(
    ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class, ExperimentalTextApi::class,
    ExperimentalPagerApi::class
)
@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun AboutCommunity() {

    val stroke = Stroke(width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface;

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(JlResDimens.dp18))
            .background(
                brush = Brush.radialGradient(
                    listOf(
                        MaterialTheme.colorScheme.surface.copy(alpha = 0.9f),
                        MaterialTheme.colorScheme.surface.copy(alpha = 1f),
                    ),
                    center = Offset(30f, -30f),
                    radius = 500.0f
                )
            )
            .border(
                color = MaterialTheme.colorScheme.background,

                width = JlResDimens.dp1,
                shape = RoundedCornerShape(JlResDimens.dp18)
            )
            .padding(all = JlResDimens.dp24)
    ) {


        Column() {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Box(Modifier.size(size = JlResDimens.dp32),contentAlignment = Alignment.Center) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawCircle(color = onSurfaceColor.copy(alpha = 0.3f), style = stroke)
                    }
                }

                Box(Modifier.size(size = JlResDimens.dp32),contentAlignment = Alignment.Center) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawRoundRect(color = onSurfaceColor.copy(alpha = 0.3f), style = stroke, cornerRadius = CornerRadius(x = 12f, y=12f))
                    }
                }
                Box(Modifier.size(size = JlResDimens.dp32))

                Box(Modifier.size(size = JlResDimens.dp32))
                Box(Modifier.size(size = JlResDimens.dp32),contentAlignment = Alignment.Center) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawRoundRect(color = onSurfaceColor.copy(alpha = 0.3f), style = stroke, cornerRadius = CornerRadius(x = 12f, y=12f))
                    }
                }
            }
            Spacer(modifier = Modifier.height(JlResDimens.dp12))

            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {


                Box(Modifier.size(size = JlResDimens.dp32),contentAlignment = Alignment.Center) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawRoundRect(color = onSurfaceColor.copy(alpha = 0.3f), style = stroke, cornerRadius = CornerRadius(x = 12f, y=12f))
                    }
                }
                Box(Modifier.size(size = JlResDimens.dp32))
                Box(Modifier.size(size = JlResDimens.dp32),contentAlignment = Alignment.Center) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawRoundRect(color = onSurfaceColor.copy(alpha = 0.3f), style = stroke, cornerRadius = CornerRadius(x = 12f, y=12f))
                    }
                }
                Box(Modifier.size(size = JlResDimens.dp32))
                Box(Modifier.size(size = JlResDimens.dp32),contentAlignment = Alignment.Center) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawRoundRect(color = onSurfaceColor.copy(alpha = 0.3f), style = stroke, cornerRadius = CornerRadius(x = 12f, y=12f))
                    }
                }
            }
        }

    }
}