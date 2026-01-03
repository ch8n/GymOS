package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymSessionLogItem(
    setNumber: Int,
    setType: String,
    details: String,
    statusText: String?,
    isCompleted: Boolean,
    modifier: Modifier = Modifier,
    isCurrent: Boolean = false,
    onClick: (() -> Unit)? = null
) {
    val alpha = if (isCompleted || isCurrent) 1f else 0.3f
    val backgroundColor =
        if (isCurrent) GymTheme.colors.surfaceHighlight else GymTheme.colors.surface.copy(alpha = 0.6f)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(GymTheme.shapes.default)
            .background(backgroundColor)
            .border(1.dp, GymTheme.colors.border, GymTheme.shapes.default)
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier)
            .padding(GymTheme.spacing.medium)
            .alpha(alpha),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
        ) {
            // Set Number Circle
            Box(
                modifier = Modifier
                    .size(GymTheme.sizes.iconLarge)
                    .clip(CircleShape)
                    .background(GymTheme.colors.surface)
                    .border(1.dp, GymTheme.colors.border, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = setNumber.toString(),
                    style = GymTheme.typography.bodySmall.copy(
                        color = GymTheme.colors.textPrimary,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            Column {
                Text(
                    text = setType,
                    style = GymTheme.typography.bodySmall.copy(
                        color = GymTheme.colors.textPrimary,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Text(
                    text = details,
                    style = GymTheme.typography.tiny.copy(
                        color = GymTheme.colors.textSecondary
                    )
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
        ) {
            if (statusText != null) {
                Text(
                    text = statusText.uppercase(),
                    style = GymTheme.typography.tiny.copy(
                        color = GymTheme.colors.textMuted,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )
                )
            }

            Icon(
                imageVector = if (isCompleted) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
                contentDescription = if (isCompleted) "Completed" else "Incomplete",
                tint = if (isCompleted) GymTheme.colors.tertiary else GymTheme.colors.textMuted,
                modifier = Modifier.size(GymTheme.sizes.xSmall)
            )
        }
    }
}
