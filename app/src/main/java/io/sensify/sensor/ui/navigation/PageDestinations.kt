package io.sensify.sensor.ui.navigation

/**
 * Created by Manish Kumar on 30/07/22.
 */

sealed class PageDestinations(val route: String){
    object LabListScreen: PageDestinations("lab_list_screen")
    object ViewPagerScreen: PageDestinations("view_pager_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
