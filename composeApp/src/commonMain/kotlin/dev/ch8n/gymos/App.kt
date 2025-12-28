package dev.ch8n.gymos

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.calendar.CalendarScreen
import dev.ch8n.gymos.ui.home.HomeScreen
import dev.ch8n.gymos.ui.navigation.GymRoute
import dev.ch8n.gymos.ui.navigation.gymNavConfig
import dev.ch8n.gymos.ui.showcase.ComponentShowcaseScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    GymTheme {
        val backStack = rememberNavBackStack(gymNavConfig, GymRoute.HomeScreen)

        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<GymRoute.HomeScreen> {
                    HomeScreen(
                        onOpenShowcase = { backStack.add(GymRoute.ShowcaseScreen) },
                        onOpenCalendar = { backStack.add(GymRoute.CalendarScreen) }
                    )
                }
                entry<GymRoute.CalendarScreen> {
                    CalendarScreen(
                        onHomeClick = { backStack.removeLastOrNull() },
                        onShowcaseClick = { backStack.add(GymRoute.ShowcaseScreen) }
                    )
                }
                entry<GymRoute.ShowcaseScreen> {
                    ComponentShowcaseScreen()
                }
            }
        )
    }
}