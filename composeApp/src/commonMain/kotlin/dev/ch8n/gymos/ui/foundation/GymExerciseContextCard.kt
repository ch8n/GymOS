package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymExerciseContextCard(
    exerciseName: String,
    description: String,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.FitnessCenter
) {
    GymCard(
        modifier = modifier.fillMaxWidth(),
        shape = GymTheme.shapes.xLarge
    ) {
        Column(
            modifier = Modifier
                .padding(GymTheme.spacing.large)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(GymTheme.sizes.xLarge)
                    .clip(CircleShape)
                    .background(GymTheme.colors.primary.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(GymTheme.sizes.iconLarge),
                    tint = GymTheme.colors.primary
                )
            }

            Text(
                text = exerciseName,
                style = GymTheme.typography.h1.copy(
                    color = GymTheme.colors.textPrimary,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = GymTheme.spacing.medium)
            )

            Text(
                text = description,
                style = GymTheme.typography.bodyMedium.copy(
                    color = GymTheme.colors.textSecondary,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.padding(
                    top = GymTheme.spacing.small,
                    start = GymTheme.spacing.medium,
                    end = GymTheme.spacing.medium
                )
            )
        }
    }
}
