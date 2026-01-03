package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymListItem(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(GymTheme.shapes.medium)
            .clickable(enabled = onClick != null && enabled) { onClick?.invoke() }
            .padding(GymTheme.spacing.medium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
    ) {
        if (leadingContent != null) {
            Box(
                modifier = Modifier.alphaIf(!enabled, 0.5f),
                contentAlignment = Alignment.Center
            ) {
                leadingContent()
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .alphaIf(!enabled, 0.5f)
        ) {
            Text(
                text = title,
                style = GymTheme.typography.bodyMedium.copy(
                    color = GymTheme.colors.textPrimary,
                    fontWeight = FontWeight.Medium
                )
            )
            if (subtitle != null) {
                Text(
                    text = subtitle,
                    style = GymTheme.typography.caption.copy(
                        color = if (enabled) GymTheme.colors.textSecondary else GymTheme.colors.textSecondary.copy(
                            alpha = 0.5f
                        )
                    )
                )
            }
        }

        if (trailingContent != null) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
            ) {
                trailingContent()
            }
        }
    }
}

private fun Modifier.alphaIf(condition: Boolean, alpha: Float): Modifier {
    return if (condition) this.then(Modifier.alpha(alpha)) else this
}


@Composable
fun GymIconCircle(
    icon: GymIconResource,
    modifier: Modifier = Modifier,
    backgroundColor: Color = GymTheme.colors.primary.copy(alpha = 0.15f),
    iconColor: Color = GymTheme.colors.primary,
    size: androidx.compose.ui.unit.Dp = GymTheme.sizes.avatarSmall
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(androidx.compose.foundation.shape.CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        GymIcon(
            icon = icon,
            modifier = Modifier.size(GymTheme.sizes.iconMedium),
            tint = iconColor
        )
    }
}

@Composable
fun GymIconSquare(
    icon: GymIconResource,
    modifier: Modifier = Modifier,
    backgroundColor: Color = GymTheme.colors.secondary.copy(alpha = 0.15f),
    iconColor: Color = GymTheme.colors.secondary,
    size: androidx.compose.ui.unit.Dp = GymTheme.sizes.avatarSmall
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(GymTheme.shapes.medium)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        GymIcon(
            icon = icon,
            modifier = Modifier.size(GymTheme.sizes.xSmall),
            tint = iconColor
        )
    }
}
