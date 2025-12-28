package dev.ch8n.gymos.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class GymSizes(
    // Base Scale (Internal only for aliasing)
    private val size18: Dp = 18.dp,
    private val size24: Dp = 24.dp,
    private val size28: Dp = 28.dp,
    private val size32: Dp = 32.dp,
    private val size36: Dp = 36.dp,
    private val size40: Dp = 40.dp,
    private val size48: Dp = 48.dp,
    private val size56: Dp = 56.dp,
    private val size64: Dp = 64.dp,
    private val size80: Dp = 80.dp,
    private val size100: Dp = 100.dp,
    private val size120: Dp = 120.dp,
    private val size128: Dp = 128.dp,
    private val size150: Dp = 150.dp,

    val none: Dp = 0.dp,
    val borderWidth: Dp = 1.dp,

    // General Scale Aliases
    val xSmall: Dp = size18,
    val small: Dp = size36,
    val medium: Dp = size48,
    val large: Dp = size56,
    val xLarge: Dp = size64,

    // Button Sizes
    val buttonHeightSmall: Dp = small,
    val buttonHeightMedium: Dp = medium,
    val buttonHeightLarge: Dp = large,

    // Icon Sizes
    val iconSmall: Dp = xSmall,
    val iconMedium: Dp = size24,
    val iconLarge: Dp = size32,

    // Layout Metadata
    val navHeight: Dp = xLarge,
    val badgeHeight: Dp = size24,
    val indicatorSmall: Dp = 8.dp,
    val checkbox: Dp = size28,

    // Avatar Sizes
    val avatarSmall: Dp = size40,
    val avatarMedium: Dp = medium,
    val avatarLarge: Dp = size80,
    val avatarXLarge: Dp = size120,

    // Analytics & Visualization
    val chartHeightMedium: Dp = size100,
    val chartHeightLarge: Dp = size150,
    val cardHeightMedium: Dp = size120,
    val cardHeightLarge: Dp = size150,
    val donutSizeMedium: Dp = size120,
    val donutThickness: Dp = 8.dp,
    val barWidthMedium: Dp = 12.dp,

    // Visual Effects
    val glowSizeSmall: Dp = size80,
    val glowSizeMedium: Dp = size120,
    val glowSizeLarge: Dp = size128
)

val LocalGymSizes = staticCompositionLocalOf { GymSizes() }
