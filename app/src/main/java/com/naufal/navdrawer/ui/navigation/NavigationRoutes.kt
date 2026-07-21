package com.naufal.navdrawer.ui.navigation

sealed class Screen(val route: String, val title: String) {
    object Home : Screen(route = "home", title = "Dashboard")
    object Screen1 : Screen(route = "screen_1", title = "Explore")
    object Screen2 : Screen(route = "screen_2", title = "Analytics")
    object Screen3 : Screen(route = "screen_3", title = "Settings")
}
