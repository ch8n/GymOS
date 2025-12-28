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
}

val gymNavConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(GymRoute.HomeScreen::class, GymRoute.HomeScreen.serializer())
            subclass(GymRoute.ShowcaseScreen::class, GymRoute.ShowcaseScreen.serializer())
            subclass(GymRoute.CalendarScreen::class, GymRoute.CalendarScreen.serializer())
            subclass(GymRoute.DayViewPagerScreen::class, GymRoute.DayViewPagerScreen.serializer())
        }
    }
}
