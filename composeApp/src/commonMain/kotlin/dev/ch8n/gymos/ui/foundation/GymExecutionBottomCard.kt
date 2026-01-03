package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymExecutionBottomCard(
    setTitle: String,
    setType: String,
    timerText: String,
    weight: String,
    onWeightChange: (String) -> Unit,
    reps: String,
    onRepsChange: (String) -> Unit,
    onCompleteSet: () -> Unit,
    energyIndex: Int = 1,
    onEnergyIndexChange: (Int) -> Unit = {},
    effortIndex: Int = 1,
    onEffortIndexChange: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(GymTheme.shapes.large)
            .background(GymTheme.colors.surface)
            .border(1.dp, GymTheme.colors.border, GymTheme.shapes.large)
            .padding(GymTheme.spacing.mediumLarge),
        verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.mediumLarge)
    ) {
        // Handle
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(40.dp)
                .height(GymTheme.spacing.xSmall)
                .clip(GymTheme.shapes.full)
                .background(GymTheme.colors.textMuted.copy(alpha = 0.2f))
        )

        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
            ) {
                Box(
                    modifier = Modifier
                        .size(GymTheme.spacing.mediumSmall)
                        .clip(GymTheme.shapes.full)
                        .background(GymTheme.colors.primary)
                )
                Text(
                    text = setTitle,
                    style = GymTheme.typography.h3.copy(color = GymTheme.colors.textPrimary)
                )
                Text(
                    text = setType,
                    style = GymTheme.typography.bodySmall.copy(color = GymTheme.colors.textMuted)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.xSmall)
            ) {
                Icon(
                    imageVector = Icons.Default.Timer,
                    contentDescription = "Timer",
                    tint = GymTheme.colors.primary,
                    modifier = Modifier.size(GymTheme.sizes.iconSmall)
                )
                Text(
                    text = timerText,
                    style = GymTheme.typography.bodyLarge.copy(
                        color = GymTheme.colors.primary,
                        fontWeight = FontWeight.Bold,
                        fontFamily = GymTheme.typography.displaySmall.fontFamily
                    )
                )
            }
        }

        // Inputs
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
        ) {
            GymNumberInput(
                value = weight,
                onValueChange = onWeightChange,
                label = "Weight",
                unit = "KG",
                modifier = Modifier.weight(1f)
            )
            GymNumberInput(
                value = reps,
                onValueChange = onRepsChange,
                label = "Reps",
                modifier = Modifier.weight(1f)
            )
        }

        // Selection Controls
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
        ) {
            GymSegmentedControl(
                items = listOf("1", "2", "3"),
                selectedIndex = energyIndex,
                onItemSelected = onEnergyIndexChange,
                label = "Energy (1-3)",
                statusText = when (energyIndex) {
                    0 -> "Low"; 1 -> "Mod"; else -> "High"
                },
                modifier = Modifier.weight(1f)
            )
            GymSegmentedControl(
                items = listOf("1", "2", "3"),
                selectedIndex = effortIndex,
                onItemSelected = onEffortIndexChange,
                label = "Effort (1-3)",
                activeColor = GymTheme.colors.quaternary,
                statusText = when (effortIndex) {
                    0 -> "Easy"; 1 -> "Mod"; else -> "Hard"
                },
                statusColor = GymTheme.colors.quaternary,
                modifier = Modifier.weight(1f)
            )
        }

        GymButton(
            text = "Complete Set",
            onClick = onCompleteSet,
            modifier = Modifier.fillMaxWidth(),
            icon = Icons.Default.CheckCircle.asGymIcon,
            backgroundColor = GymTheme.colors.primary,
            contentColor = Color.White
        )
    }
}
