package io.sensify.sensor.ui.navigation

/**
 * Created by Manish Kumar on 30/07/22.
 */

sealed class ScreenUrls(val route: String){
    object LabListScreen: ScreenUrls("lab_list_screen")
    object ViewPagerScreen: ScreenUrls("view_pager_screen")
    object HomeScreen: ScreenUrls("Home_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
