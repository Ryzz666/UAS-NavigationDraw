package com.naufal.navdrawer.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.naufal.navdrawer.ui.theme.NavDrawerAppTheme

@Composable
fun Screen3(
    onBackClick: () -> Unit
) {
    ScreenContent(
        title = "Settings",
        contentText = "Customize your application experience here.",
        onBackClick = onBackClick
    )
}

@Preview(showBackground = true)
@Composable
fun Screen3Preview() {
    NavDrawerAppTheme {
        Screen3(onBackClick = {})
    }
}
