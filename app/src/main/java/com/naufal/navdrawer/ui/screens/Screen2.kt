package com.naufal.navdrawer.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.naufal.navdrawer.ui.theme.NavDrawerAppTheme

@Composable
fun Screen2(
    onBackClick: () -> Unit
) {
    ScreenContent(
        title = "Analytics",
        contentText = "Detailed insights and performance data will appear here.",
        onBackClick = onBackClick
    )
}

@Preview(showBackground = true)
@Composable
fun Screen2Preview() {
    NavDrawerAppTheme {
        Screen2(onBackClick = {})
    }
}
