package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymExerciseContextCard(
    exerciseName: String,
    description: String,
    modifier: Modifier = Modifier,
    icon: GymIconResource = Icons.Default.FitnessCenter.asGymIcon
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
            GymIcon(
                icon = icon,
                modifier = Modifier.size(GymTheme.sizes.xLarge),
                size = GymTheme.sizes.iconLarge,
                backgroundColor = GymTheme.colors.primary.copy(alpha = 0.1f),
                tint = GymTheme.colors.primary
            )

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
