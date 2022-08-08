package io.sensify.sensor.ui.theme


import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by Manish Kumar on 11/07/22.
 */
@Deprecated("not in use")
@Immutable
data class Elevations(
    val Backdrop: Dp = 8.dp,
    val Card: Dp = 4.dp,
)

internal val LocalElevations = staticCompositionLocalOf { Elevations() }