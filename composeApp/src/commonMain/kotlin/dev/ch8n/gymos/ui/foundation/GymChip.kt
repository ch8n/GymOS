package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymChip(
    text: String,
    modifier: Modifier = Modifier,
    icon: GymIconResource? = null,
    dotColor: Color? = null,
    backgroundColor: Color = GymTheme.colors.surface,
    contentColor: Color = GymTheme.colors.textPrimary,
    borderColor: Color = GymTheme.colors.border
) {
    Row(
        modifier = modifier
            .height(GymTheme.sizes.small)
            .clip(CircleShape)
            .background(backgroundColor)
            .border(GymTheme.sizes.borderWidth, borderColor, CircleShape)
            .padding(horizontal = GymTheme.spacing.medium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (dotColor != null) {
            Box(
                modifier = Modifier
                    .size(GymTheme.sizes.indicatorSmall)
                    .clip(CircleShape)
                    .background(dotColor)
            )
            Spacer(modifier = Modifier.width(GymTheme.spacing.small))
        } else if (icon != null) {
            GymIcon(
                icon = icon,
                size = GymTheme.sizes.xSmall,
                tint = GymTheme.colors.quaternary
            )
            Spacer(modifier = Modifier.width(GymTheme.spacing.xSmall))
        }
        Text(
            text = text,
            style = GymTheme.typography.bodyMedium.copy(
                color = contentColor,
                fontWeight = FontWeight.Bold
            )
        )
    }
}


@Composable
fun GymStatusBadge(
    text: String,
    icon: GymIconResource,
    modifier: Modifier = Modifier,
    backgroundColor: Color = GymTheme.colors.primary.copy(alpha = 0.1f),
    contentColor: Color = GymTheme.colors.primary
) {
    Row(
        modifier = modifier
            .clip(GymTheme.shapes.medium)
            .background(backgroundColor)
            .padding(horizontal = GymTheme.spacing.small, vertical = GymTheme.spacing.xSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.xSmall)
    ) {
        GymIcon(
            icon = icon,
            size = GymTheme.sizes.xSmall,
            tint = contentColor
        )
        Text(
            text = text,
            style = GymTheme.typography.bodySmall.copy(
                color = contentColor,
                fontWeight = FontWeight.Bold
            )
        )
    }
}
