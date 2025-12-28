package dev.ch8n.gymos.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class GymSpacing(
    val none: Dp = 0.dp,
    val tiny: Dp = 2.dp,
    val xSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val mediumSmall: Dp = 12.dp,
    val medium: Dp = 16.dp,
    val mediumLarge: Dp = 20.dp,
    val large: Dp = 24.dp,
    val xLarge: Dp = 32.dp,
    val xxLarge: Dp = 48.dp,
    val xxxLarge: Dp = 64.dp,
    
    // Layout semantic spacing
    val pagePadding: Dp = 16.dp,
    val sectionGap: Dp = 24.dp,
    val itemGap: Dp = 12.dp,
    
    // Component semantic spacing
    val cardPadding: Dp = 16.dp,
    val buttonPaddingVertical: Dp = 16.dp,
    val navHeight: Dp = 64.dp
)

val LocalGymSpacing = staticCompositionLocalOf { GymSpacing() }
