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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymStepperInput(
    label: String,
    value: Int,
    onValueChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    subLabel: String? = null,
    icon: ImageVector? = null,
    minValue: Int = 0,
    maxValue: Int = 999
) {
    GymCard(
        modifier = modifier.fillMaxWidth(),
        shape = GymTheme.shapes.xLarge
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = GymTheme.spacing.medium,
                    top = GymTheme.spacing.small,
                    bottom = GymTheme.spacing.small,
                    end = GymTheme.spacing.small
                )
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
            ) {
                if (icon != null) {
                    Box(
                        modifier = Modifier
                            .size(GymTheme.sizes.medium)
                            .clip(GymTheme.shapes.extraLarge)
                            .background(GymTheme.colors.background.copy(alpha = 0.5f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            modifier = Modifier.size(GymTheme.sizes.iconMedium),
                            tint = GymTheme.colors.textPrimary
                        )
                    }
                }

                Column {
                    Text(
                        text = label,
                        style = GymTheme.typography.bodyLarge.copy(
                            color = GymTheme.colors.textPrimary,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    if (subLabel != null) {
                        Text(
                            text = subLabel,
                            style = GymTheme.typography.bodySmall.copy(
                                color = GymTheme.colors.textSecondary
                            )
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .clip(GymTheme.shapes.extraLarge)
                    .background(GymTheme.colors.background.copy(alpha = 0.3f))
                    .padding(GymTheme.spacing.xSmall),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.tiny)
            ) {
                Box(
                    modifier = Modifier
                        .size(GymTheme.sizes.avatarSmall)
                        .clip(GymTheme.shapes.large)
                        .background(GymTheme.colors.surface)
                        .clickable(enabled = value > minValue) { onValueChange(value - 1) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "Decrease",
                        modifier = Modifier.size(GymTheme.sizes.iconSmall),
                        tint = if (value > minValue) GymTheme.colors.textPrimary else GymTheme.colors.textSecondary
                    )
                }

                Text(
                    text = value.toString(),
                    style = GymTheme.typography.displaySmall.copy(
                        color = GymTheme.colors.textPrimary,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.width(44.dp),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )

                Box(
                    modifier = Modifier
                        .size(GymTheme.sizes.avatarSmall)
                        .clip(GymTheme.shapes.large)
                        .background(GymTheme.colors.primary)
                        .clickable(enabled = value < maxValue) { onValueChange(value + 1) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Increase",
                        modifier = Modifier.size(GymTheme.sizes.iconSmall),
                        tint = androidx.compose.ui.graphics.Color.White
                    )
                }
            }
        }
    }
}
