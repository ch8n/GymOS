package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import dev.ch8n.gymos.theme.GymTheme

sealed class GymIconResource {
    data class Vector(val imageVector: ImageVector) : GymIconResource()
    data class Resource(val painter: Painter) : GymIconResource()
}

val ImageVector.asGymIcon: GymIconResource get() = GymIconResource.Vector(this)
val Painter.asGymIcon: GymIconResource get() = GymIconResource.Resource(this)

@Composable
fun GymIcon(
    icon: GymIconResource,
    modifier: Modifier = Modifier,
    tint: Color = GymTheme.colors.primary,
    backgroundColor: Color = Color.Transparent,
    size: Dp = GymTheme.sizes.iconMedium,
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        when (icon) {
            is GymIconResource.Vector -> {
                Icon(
                    imageVector = icon.imageVector,
                    contentDescription = null,
                    modifier = Modifier.size(size),
                    tint = tint
                )
            }

            is GymIconResource.Resource -> {
                Icon(
                    painter = icon.painter,
                    contentDescription = null,
                    modifier = Modifier.size(size),
                    tint = tint
                )
            }
        }
    }
}
