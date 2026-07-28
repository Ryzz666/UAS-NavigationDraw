package com.rury.navdrawer.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rury.navdrawer.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen3(
    onBackClick: () -> Unit
) {
    var notificationsEnabled by remember { mutableStateOf(true) }
    var darkModeEnabled by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Surface)
            )
        },
        containerColor = Background
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            item {
                SettingsHeader("General")
            }
            item {
                SettingsSwitchItem(
                    title = "Enable Notifications",
                    description = "Receive updates about your activity",
                    icon = Icons.Rounded.Notifications,
                    checked = notificationsEnabled,
                    onCheckedChange = { notificationsEnabled = it }
                )
            }
            item {
                SettingsSwitchItem(
                    title = "Dark Mode",
                    description = "Use dark theme across the app",
                    icon = Icons.Rounded.DarkMode,
                    checked = darkModeEnabled,
                    onCheckedChange = { darkModeEnabled = it }
                )
            }
            
            item { HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp), color = Outline.copy(alpha = 0.5f)) }
            
            item {
                SettingsHeader("Account")
            }
            item {
                SettingsClickItem(
                    title = "Profile Information",
                    description = "Change your name and avatar",
                    icon = Icons.Rounded.Person
                )
            }
            item {
                SettingsClickItem(
                    title = "Privacy & Security",
                    description = "Manage your password and data",
                    icon = Icons.Rounded.Lock
                )
            }
            
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { /* Logout */ },
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFEF4444)),
                    shape = MaterialTheme.shapes.large
                ) {
                    Text("Logout", color = TextOnPrimary, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun SettingsHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelLarge,
        fontWeight = FontWeight.Bold,
        color = Primary,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun SettingsSwitchItem(
    title: String,
    description: String,
    icon: ImageVector,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    ListItem(
        headlineContent = { Text(title, fontWeight = FontWeight.SemiBold) },
        supportingContent = { Text(description) },
        leadingContent = { Icon(icon, contentDescription = null, tint = Primary) },
        trailingContent = {
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(checkedThumbColor = Primary)
            )
        },
        colors = ListItemDefaults.colors(containerColor = Background)
    )
}

@Composable
fun SettingsClickItem(
    title: String,
    description: String,
    icon: ImageVector
) {
    ListItem(
        headlineContent = { Text(title, fontWeight = FontWeight.SemiBold) },
        supportingContent = { Text(description) },
        leadingContent = { Icon(icon, contentDescription = null, tint = Primary) },
        trailingContent = { Icon(Icons.Rounded.ChevronRight, contentDescription = null, tint = TextSecondary) },
        modifier = Modifier.clickable { },
        colors = ListItemDefaults.colors(containerColor = Background)
    )
}

@Preview(showBackground = true)
@Composable
fun Screen3Preview() {
    NavDrawerAppTheme {
        Screen3(onBackClick = {})
    }
}
