package io.sensify.sensor.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import io.sensify.sensor.ui.labs.navigations.labsGraph

/**
 * Created by Manish Kumar on 30/07/22.
 */

@Deprecated("replaced with navGraphApp")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavigationGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "labs1") {

        labsGraph(navController)
/*        composable(route = ScreenUrls.LabListScreen.route){
            LabListScreen(navController)
        }

        composable(route = ScreenUrls.ViewPagerScreen.route){
            ViewPagerSlider()
        }*/
    }

    /*
     NavHost(navController = navController, startDestination = ScreenUrls.LabListScreen.route) {

        labsGraph(navController)
/*        composable(route = ScreenUrls.LabListScreen.route){
            LabListScreen(navController)
        }

        composable(route = ScreenUrls.ViewPagerScreen.route){
            ViewPagerSlider()
        }*/
    }
    * */
}