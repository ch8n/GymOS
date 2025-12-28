package dev.ch8n.gymos.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class GymSizes(
    val none: Dp = 0.dp,
    val xSmall: Dp = 18.dp,  // e.g. for tiny icons or indicators
    val small: Dp = 36.dp,   // Button SM height
    val medium: Dp = 48.dp,  // Button MD height
    val large: Dp = 56.dp,   // Button XL height
    val xLarge: Dp = 64.dp,  // Bottom Nav height
    
    // Component specific sizes (semantic)
    val buttonHeightSmall: Dp = 36.dp,
    val buttonHeightMedium: Dp = 48.dp,
    val buttonHeightLarge: Dp = 56.dp,
    val navHeight: Dp = 64.dp,
    val iconSmall: Dp = 18.dp,
    val iconMedium: Dp = 24.dp,
    val iconLarge: Dp = 32.dp,
    val badgeHeight: Dp = 24.dp,
    val indicatorSmall: Dp = 8.dp,
    val checkbox: Dp = 28.dp,
    val borderWidth: Dp = 1.dp,
    val avatarSmall: Dp = 40.dp,
    val avatarMedium: Dp = 48.dp,
    val avatarLarge: Dp = 80.dp,
    val avatarXLarge: Dp = 120.dp
)

val LocalGymSizes = staticCompositionLocalOf { GymSizes() }
