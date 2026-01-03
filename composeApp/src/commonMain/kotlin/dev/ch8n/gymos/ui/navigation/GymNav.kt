package dev.ch8n.gymos.ui.navigation

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Serializable
sealed interface GymRoute : NavKey {
    @Serializable
    data object HomeScreen : GymRoute

    @Serializable
    data object ShowcaseScreen : GymRoute

    @Serializable
    data object CalendarScreen : GymRoute

    @Serializable
    data object DayViewPagerScreen : GymRoute

    @Serializable
    data object ExerciseDetailScreen : GymRoute

    @Serializable
    data object ExerciseSummaryScreen : GymRoute

    @Serializable
    data object AddExerciseScreen : GymRoute

    @Serializable
    data object ReminderAndHabitScreen : GymRoute

    @Serializable
    data object ProfileScreen : GymRoute

    @Serializable
    data object ProgressAnalyticsScreen : GymRoute
}

val gymNavConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(GymRoute.HomeScreen::class, GymRoute.HomeScreen.serializer())
            subclass(GymRoute.ShowcaseScreen::class, GymRoute.ShowcaseScreen.serializer())
            subclass(GymRoute.CalendarScreen::class, GymRoute.CalendarScreen.serializer())
            subclass(GymRoute.DayViewPagerScreen::class, GymRoute.DayViewPagerScreen.serializer())
            subclass(
                GymRoute.ExerciseDetailScreen::class,
                GymRoute.ExerciseDetailScreen.serializer()
            )
            subclass(
                GymRoute.ExerciseSummaryScreen::class,
                GymRoute.ExerciseSummaryScreen.serializer()
            )
            subclass(
                GymRoute.AddExerciseScreen::class,
                GymRoute.AddExerciseScreen.serializer()
            )
            subclass(
                GymRoute.ReminderAndHabitScreen::class,
                GymRoute.ReminderAndHabitScreen.serializer()
            )
            subclass(
                GymRoute.ProfileScreen::class,
                GymRoute.ProfileScreen.serializer()
            )
            subclass(
                GymRoute.ProgressAnalyticsScreen::class,
                GymRoute.ProgressAnalyticsScreen.serializer()
            )
        }
    }
}
