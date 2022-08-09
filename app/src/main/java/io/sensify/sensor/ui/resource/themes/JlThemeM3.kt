package io.sensify.sensor.ui.resource.themes

import android.os.Build
import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import io.sensify.sensor.ui.resource.values.JlResColors
import io.sensify.sensor.ui.resource.values.JlResDimens
import io.sensify.sensor.ui.resource.values.JlResTxtStyles

/**
 * Created by Niraj on 05-08-2022.
 */
object JlThemeM3 {

    val md_theme_light_primary = JLThemeBase.colorPrimary
    val md_theme_light_onPrimary = JlResColors.white
    val md_theme_light_primaryContainer = JLThemeBase.colorPrimary90
    val md_theme_light_onPrimaryContainer = JLThemeBase.colorPrimary10
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

    val md_theme_dark_primary = JLThemeBase.colorPrimary
    val md_theme_dark_onPrimary = JlResColors.white
    val md_theme_dark_primaryContainer = JLThemeBase.colorPrimary40
    val md_theme_dark_onPrimaryContainer = JLThemeBase.colorPrimary90
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

    val LightColorScheme = lightColorScheme(
        primary = md_theme_light_primary,
        onPrimary = md_theme_light_onPrimary,
        primaryContainer = md_theme_light_primaryContainer,
        onPrimaryContainer = md_theme_light_onPrimaryContainer,
        secondary = md_theme_light_secondary,
        onSecondary = md_theme_light_onSecondary,
        secondaryContainer = md_theme_light_secondaryContainer,
        onSecondaryContainer = md_theme_light_onSecondaryContainer,
        tertiary = md_theme_light_tertiary,
        onTertiary = md_theme_light_onTertiary,
        tertiaryContainer = md_theme_light_tertiaryContainer,
        onTertiaryContainer = md_theme_light_onTertiaryContainer,
        error = md_theme_light_error,
        errorContainer = md_theme_light_errorContainer,
        onError = md_theme_light_onError,
        onErrorContainer = md_theme_light_onErrorContainer,
        background = md_theme_light_background,
        onBackground = md_theme_light_onBackground,
        surface = md_theme_light_surface,
        onSurface = md_theme_light_onSurface,
        surfaceVariant = md_theme_light_surfaceVariant,
        onSurfaceVariant = md_theme_light_onSurfaceVariant,
        outline = md_theme_light_outline,
        inverseOnSurface = md_theme_light_inverseOnSurface,
        inverseSurface = md_theme_light_inverseSurface,
        inversePrimary = md_theme_light_inversePrimary,
    )
    val DarkColorScheme = darkColorScheme(
        primary = md_theme_dark_primary,
        onPrimary = md_theme_dark_onPrimary,
        primaryContainer = md_theme_dark_primaryContainer,
        onPrimaryContainer = md_theme_dark_onPrimaryContainer,
        secondary = md_theme_dark_secondary,
        onSecondary = md_theme_dark_onSecondary,
        secondaryContainer = md_theme_dark_secondaryContainer,
        onSecondaryContainer = md_theme_dark_onSecondaryContainer,
        tertiary = md_theme_dark_tertiary,
        onTertiary = md_theme_dark_onTertiary,
        tertiaryContainer = md_theme_dark_tertiaryContainer,
        onTertiaryContainer = md_theme_dark_onTertiaryContainer,
        error = md_theme_dark_error,
        errorContainer = md_theme_dark_errorContainer,
        onError = md_theme_dark_onError,
        onErrorContainer = md_theme_dark_onErrorContainer,
        background = md_theme_dark_background,
        onBackground = md_theme_dark_onBackground,
        surface = md_theme_dark_surface,
        onSurface = md_theme_dark_onSurface,
        surfaceVariant = md_theme_dark_surfaceVariant,
        onSurfaceVariant = md_theme_dark_onSurfaceVariant,
        outline = md_theme_dark_outline,
        inverseOnSurface = md_theme_dark_inverseOnSurface,
        inverseSurface = md_theme_dark_inverseSurface,
        inversePrimary = md_theme_dark_inversePrimary,
    )

    val m3Typography = Typography(

        headlineSmall = JlResTxtStyles.h5.merge(
            other = TextStyle(
                lineHeight = JlResDimens.sp16,
                letterSpacing = JlResDimens.sp0_8,
            )
        ),

        headlineMedium = JlResTxtStyles.h3.merge(
            other = TextStyle(
                lineHeight = JlResDimens.sp22,
                letterSpacing = JlResDimens.sp0_4,
            )
        ),

        headlineLarge = JlResTxtStyles.h1.merge(
            other = TextStyle(
                lineHeight = JlResDimens.sp36,
                letterSpacing = JlResDimens.sp0_4,
            )
        ),

        bodyLarge = JlResTxtStyles.p1.merge(
            other = TextStyle(
                lineHeight = JlResDimens.sp22,
                letterSpacing = JlResDimens.sp0_6,
            )
        ),

        titleLarge = JlResTxtStyles.h4.merge(
            other = TextStyle(
                lineHeight = JlResDimens.sp20,
                letterSpacing = JlResDimens.sp0_0,
            )
        ),


        labelSmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        )
    )
}


@Composable
fun SensifyM3Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> {
            Log.i("Theme", "DarkMode is On")
            JlThemeM3.DarkColorScheme
        }
        else -> JlThemeM3.LightColorScheme
    }

    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = JlThemeM3.m3Typography,
        content = content
    )
}