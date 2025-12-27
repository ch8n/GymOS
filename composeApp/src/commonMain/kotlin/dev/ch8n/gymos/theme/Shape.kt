package dev.ch8n.gymos.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
data class GymShapes(
    val none: Shape,
    val sm: Shape,
    val md: Shape,
    val default: Shape,
    val lg: Shape,
    val xl: Shape,
    val full: Shape
)

val DefaultGymShapes = GymShapes(
    none = RoundedCornerShape(0.dp),
    sm = RoundedCornerShape(8.dp),
    md = RoundedCornerShape(12.dp),
    default = RoundedCornerShape(16.dp),
    lg = RoundedCornerShape(32.dp),
    xl = RoundedCornerShape(48.dp),
    full = RoundedCornerShape(9999.dp)
)

val LocalGymShapes = staticCompositionLocalOf { DefaultGymShapes }
