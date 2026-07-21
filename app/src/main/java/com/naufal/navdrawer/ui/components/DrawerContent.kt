package com.naufal.navdrawer.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Analytics
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.naufal.navdrawer.ui.navigation.Screen
import com.naufal.navdrawer.ui.theme.*

data class DrawerMenuItem(
    val screen: Screen,
    val icon: ImageVector,
    val label: String
)

@Composable
fun DrawerContent(
    currentRoute: String?,
    onMenuClick: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    val menuItems = listOf(
        DrawerMenuItem(
            screen = Screen.Home,
            icon = Icons.Rounded.Dashboard,
            label = "Dashboard"
        ),
        DrawerMenuItem(
            screen = Screen.Screen1,
            icon = Icons.Rounded.Explore,
            label = "Explore"
        ),
        DrawerMenuItem(
            screen = Screen.Screen2,
            icon = Icons.Rounded.Analytics,
            label = "Analytics"
        ),
        DrawerMenuItem(
            screen = Screen.Screen3,
            icon = Icons.Rounded.Settings,
            label = "Settings"
        )
    )

    ModalDrawerSheet(
        modifier = modifier,
        drawerContainerColor = Surface,
        drawerShape = MaterialTheme.shapes.extraLarge
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(Primary),
            contentAlignment = Alignment.BottomStart
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = Surface.copy(alpha = 0.2f),
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Dashboard,
                        contentDescription = null,
                        tint = TextOnPrimary,
                        modifier = Modifier.padding(12.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Modern Nav",
                    color = TextOnPrimary,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Professional Dashboard",
                    color = TextOnPrimary.copy(alpha = 0.7f),
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        menuItems.forEach { menuItem ->
            val isSelected = currentRoute == menuItem.screen.route

            NavigationDrawerItem(
                icon = { Icon(menuItem.icon, contentDescription = null) },
                label = {
                    Text(
                        text = menuItem.label,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                    )
                },
                selected = isSelected,
                onClick = { onMenuClick(menuItem.screen) },
                colors = NavigationDrawerItemDefaults.colors(
                    selectedContainerColor = PrimaryContainer,
                    selectedTextColor = Primary,
                    selectedIconColor = Primary,
                    unselectedTextColor = OnSurface,
                    unselectedIconColor = OnSurface.copy(alpha = 0.6f)
                ),
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
            color = Outline.copy(alpha = 0.5f)
        )
        
        Text(
            text = "Version 1.0.0",
            modifier = Modifier.padding(start = 24.dp, bottom = 24.dp),
            fontSize = 12.sp,
            color = TextSecondary
        )
    }
}
