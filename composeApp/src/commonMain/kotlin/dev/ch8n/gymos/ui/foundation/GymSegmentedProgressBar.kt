package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymSegmentedProgressBar(
    progress: Int,
    maxProgress: Int,
    modifier: Modifier = Modifier,
    activeColor: Color = GymTheme.colors.primary,
    inactiveColor: Color = GymTheme.colors.surfaceHighlight
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(GymTheme.sizes.indicatorSmall),
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.xSmall)
    ) {
        repeat(maxProgress) { index ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(GymTheme.sizes.indicatorSmall)
                    .clip(CircleShape)
                    .background(if (index < progress) activeColor else inactiveColor)
            )
        }
    }
}
