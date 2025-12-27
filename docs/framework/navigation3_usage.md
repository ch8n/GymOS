# Navigation 3 in GymOS (Compose Multiplatform)

This document outlines the usage and configuration of the **Navigation 3** library in the GymOS
project. Navigation 3 is a Compose-first navigation solution that provides a user-owned back stack
and low-level building blocks.

## 📦 Dependency Setup

Navigation 3 is integrated using the following dependencies in `libs.versions.toml`:

```toml
[versions]
androidx-navigation3 = "1.0.0-alpha05"
androidx-savedstate = "1.3.0-alpha02"
kotlinx-serialization = "1.8.0"

[libraries]
androidx-navigation3-ui = { module = "org.jetbrains.androidx.navigation3:navigation3-ui", version.ref = "androidx-navigation3" }
androidx-savedstate = { module = "org.jetbrains.androidx.savedstate:savedstate", version.ref = "androidx-savedstate" }
kotlinx-serialization-json = { module = "org.jetbrains.kotlinx:kotlinx-serialization-json", version.ref = "kotlinx-serialization" }

[plugins]
kotlinSerialization = { id = "org.jetbrains.kotlin.plugin.serialization", version.ref = "kotlin" }
```

Applied in `composeApp/build.gradle.kts`:

```kotlin
plugins {
    alias(libs.plugins.kotlinSerialization)
}

commonMain.dependencies {
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.savedstate)
    implementation(libs.kotlinx.serialization.json)
}
```

## 🗺️ Defining Routes

Routes are defined as classes or objects that implement the `NavKey` interface and are annotated
with `@Serializable`.

Example in `GymNav.kt`:

```kotlin
@Serializable
sealed interface GymRoute : NavKey {
    @Serializable
    data object HomeScreen : GymRoute

    @Serializable
    data object ShowcaseScreen : GymRoute
}
```

## ⚙️ Serialization Configuration

To support non-JVM platforms (like iOS and Web) and handle process death/configuration changes, you
must provide a `SavedStateConfiguration` with a `SerializersModule` that registers your polymorphic
routes.

```kotlin
val gymNavConfig = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(GymRoute.HomeScreen::class, GymRoute.HomeScreen.serializer())
            subclass(GymRoute.ShowcaseScreen::class, GymRoute.ShowcaseScreen.serializer())
        }
    }
}
```

## 🚀 Setting Up Navigation

In your main `@Composable` (e.g., `App()`), use `rememberNavBackStack` to create the back stack and
`NavDisplay` to render the current destination.

```kotlin
@Composable
fun App() {
    val backStack = rememberNavBackStack(gymNavConfig, GymRoute.HomeScreen)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<GymRoute.HomeScreen> {
                HomeScreenContent(
                    onOpenShowcase = { backStack.add(GymRoute.ShowcaseScreen) }
                )
            }
            entry<GymRoute.ShowcaseScreen> {
                ComponentShowcaseScreen()
            }
        }
    )
}
```

## 💡 Key Concepts

- **User-Owned Back Stack**: The `backStack` is a `SnapshotStateList<NavKey>`. You can directly add,
  remove, or modify it.
- **Transitive Dependencies**: `navigation3-ui` transitively includes `navigation3-common` and
  `navigation3-runtime`.
- **SavedState**: The navigation state is automatically saved and restored using the provided
  `SavedStateConfiguration`.
- **Type-Safety**: Using `entry<RouteType>` inside `entryProvider` ensures type-safety when
  accessing route parameters.
