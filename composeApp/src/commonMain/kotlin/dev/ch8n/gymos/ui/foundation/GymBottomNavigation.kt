package dev.ch8n.gymos.ui.foundation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymBottomNavigation(
    selectedRoute: String,
    onHomeClick: () -> Unit = {},
    onCalendarClick: () -> Unit = {},
    onProgressClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    NavigationBar(
        containerColor = GymTheme.colors.surface.copy(alpha = 0.95f),
        contentColor = GymTheme.colors.textSecondary,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            selected = selectedRoute == "Home",
            onClick = onHomeClick,
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home", style = GymTheme.typography.tiny) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = GymTheme.colors.primary,
                selectedTextColor = GymTheme.colors.primary,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = selectedRoute == "Calendar",
            onClick = onCalendarClick,
            icon = { Icon(Icons.Default.CalendarMonth, contentDescription = "Calendar") },
            label = { Text("Calendar", style = GymTheme.typography.tiny) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = GymTheme.colors.primary,
                selectedTextColor = GymTheme.colors.primary,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = selectedRoute == "Progress",
            onClick = onProgressClick,
            icon = { Icon(Icons.Default.BarChart, contentDescription = "Progress") },
            label = { Text("Progress", style = GymTheme.typography.tiny) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = GymTheme.colors.primary,
                selectedTextColor = GymTheme.colors.primary,
                indicatorColor = Color.Transparent
            )
        )
        NavigationBarItem(
            selected = selectedRoute == "Profile",
            onClick = onProfileClick,
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile", style = GymTheme.typography.tiny) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = GymTheme.colors.primary,
                selectedTextColor = GymTheme.colors.primary,
                indicatorColor = Color.Transparent
            )
        )
    }
}
