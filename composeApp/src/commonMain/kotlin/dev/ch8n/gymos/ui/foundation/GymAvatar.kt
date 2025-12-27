package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymAvatar(
    painter: Painter,
    modifier: Modifier = Modifier,
    size: Dp = GymTheme.sizes.medium,
    borderColor: Color = GymTheme.colors.border
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(GymTheme.colors.surface)
            .border(1.dp, borderColor, CircleShape)
    ) {
        Image(
            painter = painter,
            contentDescription = "User Avatar",
            modifier = Modifier.size(size),
            contentScale = ContentScale.Crop
        )
    }
}
