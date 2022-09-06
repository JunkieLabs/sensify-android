package io.sensify.sensor.ui.labs.navigations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.google.accompanist.pager.ExperimentalPagerApi
import io.sensify.sensor.ui.labs.charts.line.LabsLineChartPage
import io.sensify.sensor.ui.labs.pages.homepage.HomeMain
import io.sensify.sensor.ui.labs.pages.sensordetails.detailpagewidgets.DetailMain
import io.sensify.sensor.ui.labs.permissions.LabsPermissionsPage
import io.sensify.sensor.ui.labs.root.LabsPage
import io.sensify.sensor.ui.labs.sensors.LabsSensorDataPage
import io.sensify.sensor.ui.labs.sensors.LabsSensorsPage
import io.sensify.sensor.ui.labs.styles.LabsStylesPage
import io.sensify.sensor.ui.labs.viewpager.ViewPagerSlider

/**
 * Created by Niraj on 04-08-2022.
 */
sealed class NavDirectionsLabs(val route: String) {
    object Root: NavDirectionsLabs("root")
    object Sensors: NavDirectionsLabs("sensors")
    object SensorData: NavDirectionsLabs("sensorData")
    object Styles: NavDirectionsLabs("styles")
    object ViewPager: NavDirectionsLabs("view_pager_screen")
    object HomePage: NavDirectionsLabs("home_page")
    object Permissions: NavDirectionsLabs("permissions")
    object DetailPage: NavDirectionsLabs("detail_page")
    object LineChart: NavDirectionsLabs("line_chart")

}

@OptIn(ExperimentalPagerApi::class)
fun NavGraphBuilder.labsGraph(navController: NavController){
    navigation(startDestination = NavDirectionsLabs.Root.route, route = "labs1") {
        composable(NavDirectionsLabs.Root.route) { LabsPage(navController) }
        composable(NavDirectionsLabs.Sensors.route) { LabsSensorsPage(navController) }
        composable(NavDirectionsLabs.SensorData.route) { LabsSensorDataPage(navController) }
        composable(NavDirectionsLabs.ViewPager.route) { ViewPagerSlider() }
        composable(NavDirectionsLabs.Styles.route) { LabsStylesPage(navController) }
        composable(NavDirectionsLabs.HomePage.route) { HomeMain(navController = navController) }
        composable(NavDirectionsLabs.Permissions.route) { LabsPermissionsPage(navController) }
        composable(NavDirectionsLabs.DetailPage.route) { DetailMain(navController) }
        composable(NavDirectionsLabs.LineChart.route) { LabsLineChartPage(navController) }
    }
}