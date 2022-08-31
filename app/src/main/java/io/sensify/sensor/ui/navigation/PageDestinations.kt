package io.sensify.sensor.ui.navigation

/**
 * Created by Manish Kumar on 30/07/22.
 */
@Deprecated("replaced with NavDirectionsApp")
sealed class PageDestinations(val route: String){
    object LabPage: PageDestinations("lab_list_screen")
    object ViewPagerPage: PageDestinations("view_pager_screen")
    object HomePage: PageDestinations("home_page")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
