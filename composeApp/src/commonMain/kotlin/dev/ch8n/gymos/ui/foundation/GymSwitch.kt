package dev.ch8n.gymos.ui.foundation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val trackWidth = GymTheme.sizes.switchTrackWidth
    val trackHeight = GymTheme.sizes.switchTrackHeight
    val thumbSize = GymTheme.sizes.switchThumbSize
    val padding = GymTheme.spacing.tiny

    val trackColor by animateColorAsState(
        targetValue = if (checked) {
            GymTheme.colors.primary
        } else {
            GymTheme.colors.surface.copy(alpha = 0.2f)
        }
    )

    val thumbOffset by animateDpAsState(
        targetValue = if (checked) trackWidth - thumbSize - padding else padding
    )

    Box(
        modifier = modifier
            .width(trackWidth)
            .height(trackHeight)
            .clip(CircleShape)
            .background(trackColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                enabled = enabled
            ) {
                onCheckedChange(!checked)
            }
            .padding(padding),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .offset(x = thumbOffset - padding)
                .size(thumbSize)
                .clip(CircleShape)
                .background(Color.White)
        )
    }
}
