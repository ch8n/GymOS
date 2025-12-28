package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymBMICard(
    bmiValue: String,
    statusText: String,
    statusIcon: ImageVector,
    statusColor: Color,
    progress: Float,
    description: String,
    modifier: Modifier = Modifier
) {
    val themeMuted = GymTheme.colors.textMuted
    val themeTextPrimary = GymTheme.colors.textPrimary
    val themeSurfaceHighlight = GymTheme.colors.surfaceHighlight
    val quaternary = GymTheme.colors.quaternary
    val tertiary = GymTheme.colors.tertiary
    val border = GymTheme.colors.border

    val progressBrush = remember(quaternary, tertiary) {
        Brush.horizontalGradient(listOf(quaternary, tertiary))
    }

    GymCard(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.padding(GymTheme.spacing.medium)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        text = "YOUR BMI",
                        style = GymTheme.typography.tiny.copy(
                            color = themeMuted,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = bmiValue,
                        style = GymTheme.typography.h1.copy(
                            fontWeight = FontWeight.Bold,
                            color = themeTextPrimary
                        )
                    )
                }

                GymStatusBadge(
                    text = statusText,
                    icon = statusIcon,
                    backgroundColor = statusColor.copy(alpha = 0.15f),
                    contentColor = statusColor
                )
            }

            Spacer(modifier = Modifier.height(GymTheme.spacing.medium))

            // Progress Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(GymTheme.spacing.mediumSmall)
                    .clip(CircleShape)
                    .background(themeSurfaceHighlight)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progress.coerceIn(0f, 1f))
                        .height(GymTheme.spacing.mediumSmall)
                        .clip(CircleShape)
                        .background(progressBrush)
                )
            }

            Spacer(modifier = Modifier.height(GymTheme.spacing.xSmall))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "18.5",
                    style = GymTheme.typography.tiny.copy(color = themeMuted)
                )
                Text(
                    text = "25.0",
                    style = GymTheme.typography.tiny.copy(color = themeMuted)
                )
                Text(
                    text = "30.0",
                    style = GymTheme.typography.tiny.copy(color = themeMuted)
                )
            }

            Spacer(modifier = Modifier.height(GymTheme.spacing.medium))

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = GymTheme.sizes.borderWidth,
                color = border.copy(alpha = 0.5f)
            )

            Spacer(modifier = Modifier.height(GymTheme.spacing.medium))

            Text(
                text = description,
                style = GymTheme.typography.bodySmall.copy(
                    color = themeMuted
                )
            )
        }
    }
}
