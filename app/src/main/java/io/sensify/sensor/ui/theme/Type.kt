package io.sensify.sensor.ui.theme


// Set of Material typography styles to start with
import androidx.compose.material.Typography
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

val typography = typographyFromDefaults(
    h1 = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Black,
        fontSize = 24.sp,
        letterSpacing = 1.15.sp
    ),
    h2 = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = 1.15.sp,

        ),
    h3 = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        letterSpacing = 0.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = Lato,
        fontSize = 14.sp,
        letterSpacing = 0.15.sp,
    ),
    body1 = TextStyle(
        fontFamily = Roboto,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
    ),
    button = TextStyle(
        fontFamily = Lato,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 1.15.sp,
    ),
    caption = TextStyle(
        fontFamily = Roboto,
        fontSize = 12.sp,
        letterSpacing = 1.15.sp,
    ),
)

fun typographyFromDefaults(
    h1: TextStyle?,
    h2: TextStyle?,
    h3: TextStyle?,
    subtitle1: TextStyle?,
    body1: TextStyle?,
    button: TextStyle?,
    caption: TextStyle?,
): Typography {
    val defaults = Typography()
    return Typography(
        h1 = defaults.h1.merge(h1),
        h2 = defaults.h2.merge(h2),
        h3 = defaults.h3.merge(h3),
        subtitle1 = defaults.subtitle1.merge(subtitle1),
        body1 = defaults.body1.merge(body1),
        button = defaults.button.merge(button),
        caption = defaults.caption.merge(caption),
    )
}