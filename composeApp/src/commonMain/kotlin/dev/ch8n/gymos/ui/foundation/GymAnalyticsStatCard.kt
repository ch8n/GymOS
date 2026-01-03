package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymAnalyticsStatCard(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    trend: String? = null,
    trendColor: Color = GymTheme.colors.success,
    unit: String? = null,
    accentColor: Color = GymTheme.colors.primary
) {
    GymCard(
        modifier = modifier.height(GymTheme.sizes.cardHeightMedium),
        shape = GymTheme.shapes.large
    ) {
        Box(modifier = Modifier.padding(GymTheme.spacing.medium)) {
            // Glow effect
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = GymTheme.spacing.medium, y = -GymTheme.spacing.medium)
                    .size(GymTheme.sizes.glowSizeSmall)
                    .background(accentColor.copy(alpha = 0.1f), CircleShape)
                    .blur(GymTheme.spacing.xxLarge)
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = label,
                    style = GymTheme.typography.caption.copy(
                        color = GymTheme.colors.textMuted,
                        fontWeight = FontWeight.Medium
                    )
                )

                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.xSmall)
                ) {
                    Text(
                        text = value,
                        style = GymTheme.typography.h1.copy(
                            color = GymTheme.colors.textPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    if (unit != null) {
                        Text(
                            text = unit,
                            style = GymTheme.typography.bodySmall.copy(
                                color = GymTheme.colors.textSecondary,
                                fontWeight = FontWeight.Medium
                            ),
                            modifier = Modifier.padding(bottom = GymTheme.spacing.tiny)
                        )
                    }

                    if (trend != null) {
                        GymBadge(
                            text = trend,
                            backgroundColor = trendColor.copy(alpha = 0.1f),
                            contentColor = trendColor,
                            modifier = Modifier.offset(y = (-GymTheme.spacing.xSmall))
                        )
                    }
                }
            }
        }
    }
}
