package io.sensify.sensor.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.sensify.sensor.ui.labs.navigations.labsGraph
import io.sensify.sensor.ui.pages.home.HomeMain
import io.sensify.sensor.ui.labs.pages.sensordetails.detailpagewidgets.DetailMain
import io.sensify.sensor.ui.pages.SplashPage
import io.sensify.sensor.ui.pages.home.HomePage
import io.sensify.sensor.ui.pages.sensor.details.SensorDetailPage


/**
 * Created by Niraj on 30-08-2022.
 */
sealed class NavDirectionsApp(val route: String) {
    object Root : NavDirectionsApp("root")
    object HomePage : NavDirectionsApp("home_page")
    object SensorDetailPage : NavDirectionsApp("sensor_detail_page")
    object Splash : NavDirectionsApp("splash_page")
}

@Composable
fun NavGraphApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "labs1") {

        labsGraph(navController)
//        composable(NavDirectionsApp.Root.route) { LabsPage(navController) }
        composable(NavDirectionsApp.Splash.route) { SplashPage(navController) }
        composable(NavDirectionsApp.HomePage.route) { HomePage(navController = navController) }
        composable(NavDirectionsApp.SensorDetailPage.route) { SensorDetailPage(navController = navController) }
    }

}