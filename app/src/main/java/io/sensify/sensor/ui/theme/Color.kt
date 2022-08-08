package io.sensify.sensor.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.toArgb

@Deprecated("replaced with resource/values/JlResColors")


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
val headerCardColor = Color(0x1ADA66B2)



val NoteYellow = Color(0xFFFFF389)
val NotePink = Color(0xFFE2648C)
val NoteRed = Color(0xFFE76A6A)
val NoteBlue = Color(0xFF81DBDF)
val NoteOrange = Color(0xFFE68049)
val NoteMint = Color(0xFF3ECC89)
val NoteViolet = Color(0xFFF0A2FF)
val NoteIndigo = Color(0xFFA7ABE9)
val NoteGreen = Color(0xFF8DDF69)
val NoteWhite = Color(0xFFFFE2EB)
val NoteBrown = Color(0xFFBD7857)
val NoteGray = Color(0xFFA5969B)

val GoalGreen = Color(0xFF86C768)
val GoalYellow = Color(0xFFD8D76A)
val GoalCarrot = Color(0xFFD89D53)
val GoalRed = Color(0xFFD57171)

val md_theme_light_primary = Color(0xFF984065)
val md_theme_light_onPrimary = Color(0xFFffffff)
val md_theme_light_primaryContainer = Color(0xFFffd8e5)
val md_theme_light_onPrimaryContainer = Color(0xFF3e001f)
val md_theme_light_secondary = Color(0xFF735760)
val md_theme_light_onSecondary = Color(0xFFffffff)
val md_theme_light_secondaryContainer = Color(0xFFffd8e3)
val md_theme_light_onSecondaryContainer = Color(0xFF2b151d)
val md_theme_light_tertiary = Color(0xFF7d5636)
val md_theme_light_onTertiary = Color(0xFFffffff)
val md_theme_light_tertiaryContainer = Color(0xFFffdcc1)
val md_theme_light_onTertiaryContainer = Color(0xFF2f1500)
val md_theme_light_error = Color(0xFFba1b1b)
val md_theme_light_errorContainer = Color(0xFFffdad4)
val md_theme_light_onError = Color(0xFFffffff)
val md_theme_light_onErrorContainer = Color(0xFF410001)
val md_theme_light_background = Color(0xFFfcfcfc)
val md_theme_light_onBackground = Color(0xFF1f1a1b)
val md_theme_light_surface = Color(0xFFfcfcfc)
val md_theme_light_onSurface = Color(0xFF1f1a1b)
val md_theme_light_surfaceVariant = Color(0xFFf2dde2)
val md_theme_light_onSurfaceVariant = Color(0xFF514347)
val md_theme_light_outline = Color(0xFF827377)
val md_theme_light_inverseOnSurface = Color(0xFFfaeef0)
val md_theme_light_inverseSurface = Color(0xFF352f30)
val md_theme_light_inversePrimary = Color(0xFFffb0cd)

val md_theme_dark_primary = Color(0xFFffb0cd)
val md_theme_dark_onPrimary = Color(0xFF5d1136)
val md_theme_dark_primaryContainer = Color(0xFF7a294d)
val md_theme_dark_onPrimaryContainer = Color(0xFFffd8e5)
val md_theme_dark_secondary = Color(0xFFe1bdc7)
val md_theme_dark_onSecondary = Color(0xFF422932)
val md_theme_dark_secondaryContainer = Color(0xFF5a3f48)
val md_theme_dark_onSecondaryContainer = Color(0xFFffd8e3)
val md_theme_dark_tertiary = Color(0xFFf0bc95)
val md_theme_dark_onTertiary = Color(0xFF48290d)
val md_theme_dark_tertiaryContainer = Color(0xFF623f21)
val md_theme_dark_onTertiaryContainer = Color(0xFFffdcc1)
val md_theme_dark_error = Color(0xFFffb4a9)
val md_theme_dark_errorContainer = Color(0xFF930006)
val md_theme_dark_onError = Color(0xFF680003)
val md_theme_dark_onErrorContainer = Color(0xFFffdad4)
val md_theme_dark_background = Color(0xFF041B11)
val md_theme_dark_onBackground = Color(0xFFebdfe1)
val md_theme_dark_surface = Color(0xFF1f1a1b)
val md_theme_dark_onSurface = Color(0xFFebdfe1)
val md_theme_dark_surfaceVariant = Color(0xFF514347)
val md_theme_dark_onSurfaceVariant = Color(0xFFd5c1c6)
val md_theme_dark_outline = Color(0xFF9d8c90)
val md_theme_dark_inverseOnSurface = Color(0xFF1f1a1b)
val md_theme_dark_inverseSurface = Color(0xFFebdfe1)
val md_theme_dark_inversePrimary = Color(0xFF984065)


val noteColors =
    listOf(
        NoteYellow,
        NoteGreen,
        NoteMint,
        NoteBlue,
        NoteIndigo,
        NoteViolet,
        NoteOrange,
        NoteRed,
        NotePink,
        NoteWhite,
        NoteGray,
        NoteBrown
    )

val goalColors =
    listOf(
        GoalGreen,
        GoalYellow,
        GoalCarrot,
        GoalRed
    )

val Int.priority
    get() = when (this) {
        NoteWhite.toArgb() -> -3
        NoteGray.toArgb() -> -2
        NoteBrown.toArgb() -> -1
        NoteYellow.toArgb() -> 0
        NoteGreen.toArgb() -> 1
        NoteMint.toArgb() -> 2
        NoteBlue.toArgb() -> 3
        NoteIndigo.toArgb() -> 4
        NoteViolet.toArgb() -> 5
        NoteOrange.toArgb() -> 6
        NoteRed.toArgb() -> 7
        else -> 8
    }

val Int.position
    get() = when (this) {
        NoteWhite.toArgb() -> 9
        NoteGray.toArgb() -> 10
        NoteBrown.toArgb() -> 11
        NoteYellow.toArgb() -> 0
        NoteGreen.toArgb() -> 1
        NoteMint.toArgb() -> 2
        NoteBlue.toArgb() -> 3
        NoteIndigo.toArgb() -> 4
        NoteViolet.toArgb() -> 5
        NoteOrange.toArgb() -> 6
        NoteRed.toArgb() -> 7
        else -> 8
    }

val Int.priorityGoal
    get() = when (this) {
        GoalGreen.toArgb() -> 0
        GoalYellow.toArgb() -> 1
        GoalCarrot.toArgb() -> 2
        else -> 3
    }


@Composable
fun ColorScheme.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}