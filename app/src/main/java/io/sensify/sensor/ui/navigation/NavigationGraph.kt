package io.sensify.sensor.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import io.sensify.sensor.ui.labs.pages.HomeScreen
import io.sensify.sensor.ui.labs.pages.homepage.HomePage
import io.sensify.sensor.ui.pages.LabListScreen
import io.sensify.sensor.ui.labs.viewpager.ViewPagerSlider

/**
 * Created by Manish Kumar on 30/07/22.
 */

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavigationGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = PageDestinations.LabPage.route) {

        composable(route = PageDestinations.LabPage.route){
            LabListScreen(navController)
        }

        composable(route = PageDestinations.ViewPagerPage.route){
            ViewPagerSlider()
        }

        composable(route = PageDestinations.HomePage.route){
            HomePage()
        }
    }
}