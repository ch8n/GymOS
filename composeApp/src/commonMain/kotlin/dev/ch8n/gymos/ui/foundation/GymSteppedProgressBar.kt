package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymSteppedProgressBar(
    currentStep: Int,
    totalSteps: Int,
    stepName: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
    ) {
        GymSegmentedProgressBar(
            progress = currentStep,
            maxProgress = totalSteps,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Step $currentStep of $totalSteps",
                style = GymTheme.typography.bodySmall.copy(
                    color = GymTheme.colors.textMuted,
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = stepName,
                style = GymTheme.typography.bodySmall.copy(
                    color = GymTheme.colors.primary,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
