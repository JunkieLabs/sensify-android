package io.sensify.sensor.ui.pages.sensor.details.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import io.sensify.sensor.ui.resource.effects.drawColoredShadow
import io.sensify.sensor.ui.resource.themes.JlThemeM3
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResTxtStyles

/**
 * Created by Niraj on 27-09-2022.
 */
@OptIn(ExperimentalPagerApi::class)
//@Preview(showBackground = true, backgroundColor = 0xFF041B11)
@Composable
fun SensorDetailCurrentValue() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = JlResDimens.dp6),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(JlResDimens.dp18)
                .background(Color(0xFFFFCA10), shape = CircleShape)
                .border(
                    width = JlResDimens.dp1, brush = Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                        )
                    ), shape = CircleShape
                ).drawColoredShadow(Color(0xFFFFCA10), offsetY = JlResDimens.dp12),
            contentAlignment = Alignment.Center

        ) {
            Box(
                modifier = Modifier
                    .size(JlResDimens.dp12)
                    .border(width = JlResDimens.dp2, color = Color.White, shape = CircleShape)
            )

        }

        Spacer(modifier = Modifier.width(JlResDimens.dp18))

        Text(
            text = "Current Value",
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            style = JlResTxtStyles.h5,
        )
    }
}