package dev.ch8n.gymos.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun GymTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalGymColors provides DarkGymColors,
        LocalGymTypography provides gymTypography(),
        LocalGymShapes provides DefaultGymShapes,
        LocalGymSpacing provides GymSpacing(),
        LocalGymSizes provides GymSizes(),
        content = content
    )
}

object GymTheme {
    val colors: GymColors
        @Composable
        @ReadOnlyComposable
        get() = LocalGymColors.current

    val typography: GymTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalGymTypography.current

    val shapes: GymShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalGymShapes.current

    val spacing: GymSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalGymSpacing.current

    val sizes: GymSizes
        @Composable
        @ReadOnlyComposable
        get() = LocalGymSizes.current
}
