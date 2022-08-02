package io.sensify.sensor.ui.theme


// Set of Material typography styles to start with
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.sensify.sensor.R


private val Roboto = FontFamily(
    Font(R.font.roboto_regular),
)

private val Lato = FontFamily(
    Font(R.font.lato_regular),
    Font(R.font.lato_bold, FontWeight.Bold),
    Font(R.font.lato_black, FontWeight.Black),
)

private val Jost = FontFamily(
    Font(R.font.jost_regular),
)


val Typography = Typography(

    headlineSmall = TextStyle(
        fontFamily = Jost,
        fontSize = 14.sp,
        lineHeight = 29.sp,
        letterSpacing = 0.8.sp,
    ),

    headlineMedium = TextStyle(
        fontFamily = Jost,
        fontSize = 16.sp,
        lineHeight = 29.sp,
        letterSpacing = 0.4.sp,
    ),

    headlineLarge = TextStyle(
        fontFamily = Jost,
        fontSize = 18.sp,
        lineHeight = 29.sp,
        letterSpacing = 0.4.sp,
    ),

    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)