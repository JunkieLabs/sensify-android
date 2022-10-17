package io.sensify.sensor.ui.pages

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import io.sensify.sensor.R
import io.sensify.sensor.ui.labs.navigations.NavDirectionsLabs
import io.sensify.sensor.ui.navigation.NavDirectionsApp
import io.sensify.sensor.ui.resource.values.JlResColors
import io.sensify.sensor.ui.resource.values.JlResShapes
import io.sensify.sensor.ui.resource.values.JlResTxtStyles
import kotlinx.coroutines.delay

/**
 * Created by Niraj on 24-08-2022.
 */

@Composable
fun SplashPage(navController: NavController) {
//    val systemUiController = rememberSystemUiController()
////    if(darkTheme){
//        systemUiController.setSystemBarsColor(
//            color = Color.Transparent
//        )
    LaunchedEffect(key1 = true) {
        /*scaleAnimation.animateTo(
            targetValue = 0.5F,
            animationSpec = tween(
                durationMillis = durationMillisAnimation,
                easing = {
                    OvershootInterpolator(3F).getInterpolation(it)
                }
            )
        )*/

        delay(timeMillis = 2000)

        navController.popBackStack()
        navController.navigate(NavDirectionsApp.HomePage.route)

        /*navController.navigate(route = DestinationScreen.MainScreenDest.route) {
            popUpTo(route = DestinationScreen.SplashScreenDest.route) {
                inclusive = true
            }
        }*/
    }
    SplashScreen()

}

@OptIn(ExperimentalTextApi::class)
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
//    imagePainter: Painter,
//    scaleAnimation: Animatable<Float, AnimationVector1D>
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.05f),

                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.02f),
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            /*Image(
                painter = imagePainter,
                contentDescription = "Logotipo Splash Screen",
                modifier = modifier
                    .size(400.dp)
                    .scale(scale = scaleAnimation.value),
            )*/
            Image(
                painter = painterResource(id = R.drawable.pic_logo),
                contentDescription = "Logotipo Splash Screen",
                modifier = modifier
                    .size(120.dp)
//                    .scale(scale = scaleAnimation.value),
            )
            Spacer(modifier = JlResShapes.Space.H24)
            Image(
                painter = painterResource(id = R.drawable.pic_launcher_eye),
                contentDescription = "Logotipo Splash Screen",
                modifier = modifier
                    .size(220.dp)
//                    .scale(scale = scaleAnimation.value),
            )
            Spacer(modifier = JlResShapes.Space.H56)
            Text(
                text = "Sensify",
                style = JlResTxtStyles.h1.merge(
                    other = TextStyle(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.onSurface,
                                MaterialTheme.colorScheme.onSurface.copy(0.1f)
                            ),
                            tileMode = TileMode.Mirror,
                            start = Offset(0f, 0f),
                            end = Offset(0f, Float.POSITIVE_INFINITY),
                        )
                    )
                ),
//                        modifier = Modifier.(scale = scaleAnimation.value
                /*color = Color.White,
                fontSize = JlResDimens.dp40,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center,
                modifier = modifier.scale(scale = scaleAnimation.value
                */
            )
        }
    }
}