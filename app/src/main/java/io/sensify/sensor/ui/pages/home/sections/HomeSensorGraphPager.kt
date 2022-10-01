package io.sensify.sensor.ui.pages.home.sections

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.util.lerp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import io.sensify.sensor.ui.pages.home.items.HomeSensorChart
import io.sensify.sensor.ui.resource.effects.drawColoredShadow
import io.sensify.sensor.ui.resource.themes.JLThemeBase
import io.sensify.sensor.ui.resource.values.JlResDimens
import kotlin.math.absoluteValue

/**
 * Created by Niraj on 29-09-2022.
 */
@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun HomeSensorGraphPager(modifier: Modifier = Modifier) {


    HorizontalPager(
        count = 3,
        // Add 32.dp horizontal padding to 'center' the pages
        contentPadding = PaddingValues(horizontal = JlResDimens.dp32),
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = JlResDimens.dp20)
    ) { page ->
        Card(
            Modifier
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    // We animate the scaleX + scaleY, between 85% and 100%
                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    ).also { scale ->
                        Log.d("HomeSensorGraphPager", " scale: $scale")
                        scaleX = scale
                        scaleY = scale
                    }

                    // We animate the alpha, between 50% and 100%
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                }
                .fillMaxWidth()
                .height(220.dp)
                .background(
                    brush = Brush.radialGradient(

                        listOf(
                            Color(ColorUtils.blendARGB(MaterialTheme.colorScheme.onSurface.toArgb(), MaterialTheme.colorScheme.surface.toArgb(), 0.65f)),
//                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
//                            MaterialTheme.colorScheme.primary,
//                    JLThemeBase.colorPrimary30,
                            Color(ColorUtils.blendARGB(MaterialTheme.colorScheme.onSurface.toArgb(), MaterialTheme.colorScheme.surface.toArgb(), 0.95f)),
//                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.07f),
//                    Color.Transparent,
                        ),
                        center = Offset(200f, -30f),

                        radius = 600.0f


//                start = Offset(0f, 0f),
//                end = Offset(0f, Float.POSITIVE_INFINITY)
                    ), shape = RoundedCornerShape(JlResDimens.dp28)
                )
                .drawColoredShadow(
                    Color.Black, offsetY = JlResDimens.dp12,

                    shadowRadius = JlResDimens.dp16, borderRadius = JlResDimens.dp32, alpha = 0.1f
                ),
            shape = RoundedCornerShape(JlResDimens.dp28),
            border = BorderStroke(
                brush = Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.25f),
                    )
                ),
                width = JlResDimens.dp1,
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
// HomeSensorChart

//                .fillMaxSize()
//                .height(120.dp)
//                .aspectRatio(1f)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize(),

                ) {
                HomeSensorChart()
//                Text(text = "Graph $page", modifier = Modifier.align(alignment = Alignment.Center))
            }

        }
    }

}