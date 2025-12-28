package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymSummaryHeader(
    exerciseName: String,
    categoryName: String,
    completionTime: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = GymTheme.spacing.large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
    ) {
        GymBadge(
            text = categoryName.uppercase(),
            backgroundColor = GymTheme.colors.tertiary.copy(alpha = 0.15f),
            contentColor = GymTheme.colors.tertiary
        )

        Text(
            text = exerciseName,
            style = GymTheme.typography.displayLarge.copy(
                color = GymTheme.colors.textPrimary,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            text = completionTime,
            style = GymTheme.typography.bodySmall.copy(
                color = GymTheme.colors.textMuted
            )
        )
    }
}
