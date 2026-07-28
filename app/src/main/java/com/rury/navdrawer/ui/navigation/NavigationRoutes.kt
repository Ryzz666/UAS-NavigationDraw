package com.rury.navdrawer.ui.navigation

sealed class Screen(val route: String, val title: String) {
    object Home : Screen(route = "home", title = "Pusat Kontrol")
    object Screen1 : Screen(route = "screen_1", title = "Perangkat")
    object Screen2 : Screen(route = "screen_2", title = "Statistik")
    object Screen3 : Screen(route = "screen_3", title = "Pengaturan")
}
