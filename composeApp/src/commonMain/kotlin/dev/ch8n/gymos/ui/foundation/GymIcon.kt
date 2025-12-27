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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymIcon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    tint: Color = GymTheme.colors.primary,
    backgroundColor: Color = GymTheme.colors.primary.copy(alpha = 0.1f),
    size: Dp = GymTheme.sizes.medium,
    iconSize: Dp = GymTheme.sizes.iconMedium
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier.size(iconSize),
            tint = tint
        )
    }
}
