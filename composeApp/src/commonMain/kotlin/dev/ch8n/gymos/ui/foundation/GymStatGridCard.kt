package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymStatGridCard(
    label: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    subValue: String? = null,
    accentColor: Color = GymTheme.colors.primary,
    progress: Int? = null,
    maxProgress: Int? = null
) {
    GymCard(
        modifier = modifier,
        shape = GymTheme.shapes.large,
        backgroundColor = GymTheme.colors.surface.copy(alpha = 0.5f),
        borderColor = GymTheme.colors.border
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(GymTheme.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = label,
                    style = GymTheme.typography.bodySmall.copy(
                        color = GymTheme.colors.textMuted,
                        fontWeight = FontWeight.Medium
                    )
                )
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(GymTheme.sizes.iconSmall)
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = value,
                        style = GymTheme.typography.h2.copy(
                            color = GymTheme.colors.textPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    if (subValue != null) {
                        Text(
                            text = " $subValue",
                            style = GymTheme.typography.bodyMedium.copy(
                                color = GymTheme.colors.textMuted
                            ),
                            modifier = Modifier.padding(bottom = GymTheme.spacing.tiny)
                        )
                    }
                }

                if (progress != null && maxProgress != null) {
                    GymSegmentedProgressBar(
                        progress = progress,
                        maxProgress = maxProgress,
                        activeColor = accentColor,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }
    }
}
