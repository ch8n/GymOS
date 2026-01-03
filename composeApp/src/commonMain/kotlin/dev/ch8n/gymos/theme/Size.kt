package dev.ch8n.gymos.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class GymSizes(
    // Base Scale
    val xSmall: Dp = 18.dp,
    val small: Dp = 36.dp,
    val medium: Dp = 48.dp,
    val large: Dp = 56.dp,
    val xLarge: Dp = 64.dp,
    val xxLarge: Dp = 80.dp,
    val xxxLarge: Dp = 100.dp,
    val xxxxLarge: Dp = 120.dp,
    val xxxxxLarge: Dp = 150.dp,

    val none: Dp = 0.dp,
    val borderWidth: Dp = 1.dp,

    // Component specific
    val iconMedium: Dp = 24.dp,
    val iconLarge: Dp = 32.dp,
    val indicatorSmall: Dp = 8.dp,
    val checkbox: Dp = 28.dp,
    val badgeHeight: Dp = 24.dp,

    // Avatar Sizes
    val avatarSmall: Dp = 40.dp,
    val avatarLarge: Dp = 80.dp,
    val avatarXLarge: Dp = 120.dp,

    // Visualization
    val donutThickness: Dp = 8.dp,
    val barWidthMedium: Dp = 12.dp,

    // Switch Sizes
    val switchTrackWidth: Dp = 44.dp,
    val switchTrackHeight: Dp = 24.dp,
    val switchThumbSize: Dp = 20.dp,

    // Visual Effects
    val glowSizeLarge: Dp = 128.dp
)

val LocalGymSizes = staticCompositionLocalOf { GymSizes() }
