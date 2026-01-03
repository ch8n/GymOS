package dev.ch8n.gymos

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.calendar.CalendarScreen
import dev.ch8n.gymos.ui.dayview.DayViewPagerScreen
import dev.ch8n.gymos.ui.exercise.AddExerciseScreen
import dev.ch8n.gymos.ui.exercise.ExerciseDetailScreen
import dev.ch8n.gymos.ui.exercise.ExerciseSummaryScreen
import dev.ch8n.gymos.ui.home.HomeScreen
import dev.ch8n.gymos.ui.navigation.GymRoute
import dev.ch8n.gymos.ui.navigation.gymNavConfig
import dev.ch8n.gymos.ui.profile.ProfileScreen
import dev.ch8n.gymos.ui.progressAnalytics.ProgressAnalyticsScreen
import dev.ch8n.gymos.ui.reminder.ReminderAndHabitScreen
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
                        onOpenCalendar = { backStack.add(GymRoute.CalendarScreen) },
                        onOpenReminder = { backStack.add(GymRoute.ReminderAndHabitScreen) },
                        onOpenProfile = { backStack.add(GymRoute.ProfileScreen) },
                        onOpenProgress = { backStack.add(GymRoute.ProgressAnalyticsScreen) }
                    )
                }
                entry<GymRoute.CalendarScreen> {
                    CalendarScreen(
                        onHomeClick = { backStack.removeLastOrNull() },
                        onShowcaseClick = { backStack.add(GymRoute.ShowcaseScreen) },
                        onDateClick = { backStack.add(GymRoute.DayViewPagerScreen) },
                        onProfileClick = { backStack.add(GymRoute.ProfileScreen) },
                        onProgressClick = { backStack.add(GymRoute.ProgressAnalyticsScreen) }
                    )
                }
                entry<GymRoute.DayViewPagerScreen> {
                    DayViewPagerScreen(
                        onBackClick = { backStack.removeLastOrNull() },
                        onExerciseClick = { backStack.add(GymRoute.ExerciseDetailScreen) },
                        onAddExerciseClick = { backStack.add(GymRoute.AddExerciseScreen) }
                    )
                }
                entry<GymRoute.ExerciseDetailScreen> {
                    ExerciseDetailScreen(
                        onBackClick = { backStack.removeLastOrNull() },
                        onSummaryClick = { backStack.add(GymRoute.ExerciseSummaryScreen) }
                    )
                }
                entry<GymRoute.ExerciseSummaryScreen> {
                    ExerciseSummaryScreen(
                        onCloseClick = { backStack.removeLastOrNull() },
                        onHomeClick = {
                            while (backStack.lastOrNull() != GymRoute.HomeScreen) {
                                backStack.removeLastOrNull()
                            }
                        },
                        onFinishClick = {
                            while (backStack.lastOrNull() != GymRoute.HomeScreen) {
                                backStack.removeLastOrNull()
                            }
                        }
                    )
                }
                entry<GymRoute.AddExerciseScreen> {
                    AddExerciseScreen(
                        onBackClick = { backStack.removeLastOrNull() },
                        onCustomExerciseClick = { /* Handle custom */ },
                        onHomeClick = {
                            while (backStack.lastOrNull() != GymRoute.HomeScreen) {
                                backStack.removeLastOrNull()
                            }
                        },
                        onCalendarClick = {
                            while (backStack.lastOrNull() != GymRoute.CalendarScreen && backStack.size > 1) {
                                backStack.removeLastOrNull()
                            }
                        }
                    )
                }
                entry<GymRoute.ShowcaseScreen> {
                    ComponentShowcaseScreen(
                        onBack = { backStack.removeLastOrNull() }
                    )
                }
                entry<GymRoute.ReminderAndHabitScreen> {
                    ReminderAndHabitScreen(
                        onBack = { backStack.removeLastOrNull() },
                        onSave = { backStack.removeLastOrNull() }
                    )
                }
                entry<GymRoute.ProfileScreen> {
                    ProfileScreen(
                        onBack = { backStack.removeLastOrNull() },
                        onOpenHome = {
                            while (backStack.lastOrNull() != GymRoute.HomeScreen) {
                                backStack.removeLastOrNull()
                            }
                        },
                        onOpenCalendar = {
                            while (backStack.lastOrNull() != GymRoute.CalendarScreen && backStack.size > 1) {
                                backStack.removeLastOrNull()
                            }
                            if (backStack.lastOrNull() != GymRoute.CalendarScreen) {
                                backStack.add(GymRoute.CalendarScreen)
                            }
                        },
                        onOpenProgress = {
                            while (backStack.lastOrNull() != GymRoute.ProgressAnalyticsScreen && backStack.size > 1) {
                                backStack.removeLastOrNull()
                            }
                            if (backStack.lastOrNull() != GymRoute.ProgressAnalyticsScreen) {
                                backStack.add(GymRoute.ProgressAnalyticsScreen)
                            }
                        }
                    )
                }
                entry<GymRoute.ProgressAnalyticsScreen> {
                    ProgressAnalyticsScreen(
                        onHomeClick = {
                            while (backStack.lastOrNull() != GymRoute.HomeScreen) {
                                backStack.removeLastOrNull()
                            }
                        },
                        onCalendarClick = {
                            while (backStack.lastOrNull() != GymRoute.CalendarScreen && backStack.size > 1) {
                                backStack.removeLastOrNull()
                            }
                            if (backStack.lastOrNull() != GymRoute.CalendarScreen) {
                                backStack.add(GymRoute.CalendarScreen)
                            }
                        },
                        onProfileClick = {
                            while (backStack.lastOrNull() != GymRoute.ProfileScreen && backStack.size > 1) {
                                backStack.removeLastOrNull()
                            }
                            if (backStack.lastOrNull() != GymRoute.ProfileScreen) {
                                backStack.add(GymRoute.ProfileScreen)
                            }
                        }
                    )
                }
            }
        )
    }
}