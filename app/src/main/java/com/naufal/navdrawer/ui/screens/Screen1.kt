package com.naufal.navdrawer.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.naufal.navdrawer.ui.theme.NavDrawerAppTheme

@Composable
fun Screen1(
    onBackClick: () -> Unit
) {
    ScreenContent(
        title = "Explore",
        contentText = "Discover new possibilities and features here.",
        onBackClick = onBackClick
    )
}

@Preview(showBackground = true)
@Composable
fun Screen1Preview() {
    NavDrawerAppTheme {
        Screen1(onBackClick = {})
    }
}
