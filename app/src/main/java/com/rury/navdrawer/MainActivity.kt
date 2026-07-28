package com.rury.navdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.rury.navdrawer.ui.navigation.NavGraph
import com.rury.navdrawer.ui.theme.NavDrawerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            NavDrawerAppTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
