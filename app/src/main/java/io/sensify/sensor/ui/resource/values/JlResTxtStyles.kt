package io.sensify.sensor.ui.resource.values

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.sensify.sensor.R

/**
 * Created by Niraj on 05-08-2022.
 */
object JlResTxtStyles {

    private val fontsJost = FontFamily(
        Font(R.font.jost_light, FontWeight.Light),
        Font(R.font.jost_regular),
        Font(R.font.jost_medium, FontWeight.Medium),
        Font(R.font.jost_bold, FontWeight.Bold)
    )

    val h1 = TextStyle(
        fontFamily = fontsJost,
        fontWeight = FontWeight.Medium,
        fontSize = JlResDimens.sp48
    )

    val h2 = TextStyle(
        fontFamily = fontsJost,
        fontWeight = FontWeight.Normal,
        fontSize = JlResDimens.sp32
    )

    val h3 = TextStyle(
        fontFamily = fontsJost,
        fontWeight = FontWeight.Normal,
        fontSize = JlResDimens.sp28
    )

    val h4 = TextStyle(
        fontFamily = fontsJost,
        fontWeight = FontWeight.Normal,
        fontSize = JlResDimens.sp24
    )

    val h5 = TextStyle(
        fontFamily = fontsJost,
        fontWeight = FontWeight.Normal,
        fontSize = JlResDimens.sp20
    )

    val h6 = TextStyle(
        fontFamily = fontsJost,
        fontWeight = FontWeight.Normal,
        fontSize = JlResDimens.sp16
    )

    val p1 = TextStyle(
        fontFamily = fontsJost,
        fontWeight = FontWeight.Normal,
        fontSize = JlResDimens.sp22
    )

    val p2 = TextStyle(
        fontFamily = fontsJost,
        fontWeight = FontWeight.Normal,
        fontSize = JlResDimens.sp18
    )

    val p3 = TextStyle(
        fontFamily = fontsJost,
        fontWeight = FontWeight.Normal,
        fontSize = JlResDimens.sp14
    )


    val button = TextStyle(
        fontFamily = fontsJost,
        fontWeight = FontWeight.Medium
    )

    val caption = TextStyle(
        fontFamily = fontsJost,
        fontWeight = FontWeight.Normal,
        fontSize = JlResDimens.sp12
    )



}