package io.sensify.sensor.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import io.sensify.sensor.ui.Screens.LabListScreen
import io.sensify.sensor.ui.labs.viewpager.Screens.ViewPagerPages
import io.sensify.sensor.ui.labs.viewpager.ViewPagerSlider

/**
 * Created by Manish Kumar on 30/07/22.
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavigationGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenUrls.LabListScreen.route) {

        composable(route = ScreenUrls.LabListScreen.route){
            LabListScreen(navController)
        }

        composable(route = ScreenUrls.ViewPagerScreen.route){
            ViewPagerSlider()
        }
    }
}