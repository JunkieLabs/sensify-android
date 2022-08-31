package io.sensify.sensor.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import io.sensify.sensor.ui.labs.navigations.labsGraph
import io.sensify.sensor.ui.labs.pages.homepage.HomeMain
import io.sensify.sensor.ui.labs.pages.sensordetails.detailpagewidgets.DetailMain
import io.sensify.sensor.ui.pages.SplashPage


/**
 * Created by Niraj on 30-08-2022.
 */
sealed class NavDirectionsApp(val route: String) {
    object Root : NavDirectionsApp("root")
    object HomePage : NavDirectionsApp("home_page")
    object DetailPage : NavDirectionsApp("detail_page")
    object Splash : NavDirectionsApp("splash_page")
}

@Composable
fun NavGraphApp(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "labs1") {

        labsGraph(navController)
//        composable(NavDirectionsApp.Root.route) { LabsPage(navController) }
        composable(NavDirectionsApp.Splash.route) { SplashPage(navController) }
        composable(NavDirectionsApp.HomePage.route) { HomeMain(navController = navController) }
        composable(NavDirectionsApp.DetailPage.route) { DetailMain(navController) }
    }
/*    navigation(startDestination = NavDirectionsLabs.Root.route, route = "labs1") {
        composable(NavDirectionsLabs.Root.route) { LabsPage(navController) }
        composable(NavDirectionsLabs.Sensors.route) { LabsSensorsPage(navController) }
        composable(NavDirectionsLabs.SensorData.route) { LabsSensorDataPage(navController) }
        composable(NavDirectionsLabs.ViewPager.route) { ViewPagerSlider() }
        composable(NavDirectionsLabs.Styles.route) { LabsStylesPage(navController) }
        composable(NavDirectionsLabs.HomePage.route) { HomeMain(navController = navController) }
        composable(NavDirectionsLabs.Permissions.route) { LabsPermissionsPage(navController) }
        composable(NavDirectionsLabs.DetailPage.route) { DetailMain(navController) }
        composable(NavDirectionsLabs.Splash.route) { SplashPage(navController) }
    }*/
}