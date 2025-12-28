package dev.ch8n.gymos.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
data class GymShapes(
    val none: Shape,
    val small: Shape,
    val medium: Shape,
    val default: Shape,
    val large: Shape,
    val xLarge: Shape,
    val full: Shape
)

val DefaultGymShapes = GymShapes(
    none = RoundedCornerShape(0.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    default = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(32.dp),
    xLarge = RoundedCornerShape(48.dp),
    full = RoundedCornerShape(9999.dp)
)

val LocalGymShapes = staticCompositionLocalOf { DefaultGymShapes }
