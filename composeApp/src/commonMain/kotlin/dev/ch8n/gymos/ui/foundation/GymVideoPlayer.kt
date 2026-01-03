package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymVideoPlayer(
    modifier: Modifier = Modifier,
    duration: String? = null,
    onPlayClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
            .clip(GymTheme.shapes.default)
            .background(GymTheme.colors.surface)
    ) {
        // Placeholder for visual content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(GymTheme.colors.surfaceHighlight)
        )

        // Play Button Overlay
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .size(GymTheme.sizes.large)
                .clip(CircleShape)
                .background(GymTheme.colors.primary.copy(alpha = 0.9f))
                .clickable { onPlayClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(GymTheme.sizes.checkbox)
            )
        }

        // Duration / Metadata Badge
        if (duration != null) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(GymTheme.spacing.small)
                    .clip(GymTheme.shapes.small)
                    .background(Color.Black.copy(alpha = 0.6f))
                    .padding(horizontal = GymTheme.spacing.small, vertical = GymTheme.spacing.tiny)
            ) {
                Text(
                    text = duration,
                    style = GymTheme.typography.tiny.copy(color = Color.White)
                )
            }
        }
    }
}
