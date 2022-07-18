package io.sensify.sensor.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

val gray800 = Color(0xCC333333)
val gray900 = Color(0xff333333)
val rust300 = Color(0xFFE1AFAF)
val rust600 = Color(0xFF886363)
val taupe100 = Color(0xfff0eae2)
val taupe800 = Color(0xff655454)
val white150 = Color(0x26FFFFFF)
val white800 = Color(0xCCFFFFFF)
val white850 = Color(0xD9FFFFFF)
val white = Color(0xFFFFFFFF)
val black = Color(0xFF000000)
val yellow = Color(0xFFFFCF44)
val yellow500 = Color(0xFFF5BD1C)
val purple = Color(0XFF4A22A8)
val darkBlue = Color(0XFF0e0f6d)
val blue = Color(0XFF1753ce)
val skyBlue = Color(0XFF6691cb)
val sand = Color(0XFFd7975a)
val snow = Color(0xFF7C706A)
val darkGrey = Color(0xFF444444)

val backgroundColor = Color(0xFF05150E)
val backgroundColorVariant = Color(0xFF081B12)

@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}