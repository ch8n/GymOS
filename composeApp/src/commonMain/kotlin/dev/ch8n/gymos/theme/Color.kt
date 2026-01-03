package dev.ch8n.gymos.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class GymColors(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val quaternary: Color,
    val background: Color,
    val surface: Color,
    val surfaceHighlight: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textMuted: Color,
    val border: Color
)

val DarkGymColors = GymColors(
    primary = Color(0xFFFE7F2D),
    secondary = Color(0xFFFCCA46),
    tertiary = Color(0xFFA1C181),
    quaternary = Color(0xFF619B8A),
    background = Color(0xFF121F29),
    surface = Color(0xFF233D4D),
    surfaceHighlight = Color(0xFF2C4B5E),
    textPrimary = Color(0xFFFFFFFF),
    textSecondary = Color(0x99FFFFFF),
    textMuted = Color(0x66FFFFFF),
    border = Color(0x0DFFFFFF)
)

val LocalGymColors = staticCompositionLocalOf { DarkGymColors }
