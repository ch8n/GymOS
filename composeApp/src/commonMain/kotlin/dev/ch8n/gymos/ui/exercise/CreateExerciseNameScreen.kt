package dev.ch8n.gymos.ui.exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.GymButton
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymSteppedProgressBar
import dev.ch8n.gymos.ui.foundation.GymTextButton
import dev.ch8n.gymos.ui.foundation.GymTextField
import dev.ch8n.gymos.ui.foundation.GymTopBar

@Composable
fun CreateExerciseNameScreen(
    onBackClick: () -> Unit,
    onNextClick: (name: String, description: String) -> Unit,
    onCancelClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Scaffold(
        containerColor = GymTheme.colors.background,
        topBar = {
            GymTopBar(
                title = "New Exercise",
                navigationIcon = {
                    GymIconButton(
                        icon = Icons.Default.Close,
                        onClick = onBackClick,
                        size = GymTheme.sizes.small,
                        iconSize = GymTheme.sizes.iconSmall
                    )
                },
                actions = {
                    GymTextButton(
                        text = "Cancel",
                        onClick = onCancelClick,
                        contentColor = GymTheme.colors.textMuted
                    )
                }
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(GymTheme.spacing.medium)
            ) {
                GymButton(
                    text = "Next: Select Body Part",
                    onClick = { onNextClick(name, description) },
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = Icons.Default.ArrowForward
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = GymTheme.spacing.pagePadding)
        ) {
            Spacer(modifier = Modifier.height(GymTheme.spacing.small))

            GymSteppedProgressBar(
                currentStep = 1,
                totalSteps = 3,
                stepName = "Details",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(GymTheme.spacing.xLarge))

            Text(
                text = "Name your exercise",
                style = GymTheme.typography.h1.copy(
                    color = GymTheme.colors.textPrimary,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(GymTheme.spacing.small))

            Text(
                text = "Give it a clear name so you can track your progress easily.",
                style = GymTheme.typography.bodyMedium.copy(
                    color = GymTheme.colors.textMuted
                )
            )

            Spacer(modifier = Modifier.height(GymTheme.spacing.xLarge))

            Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.large)) {
                Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                    Text(
                        text = "Exercise Name *",
                        style = GymTheme.typography.bodySmall.copy(
                            color = GymTheme.colors.textSecondary,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    GymTextField(
                        value = name,
                        onValueChange = { name = it },
                        placeholder = "e.g., Dumbbell Row"
                    )
                }

                Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                    Text(
                        text = "Description / Notes (Optional)",
                        style = GymTheme.typography.bodySmall.copy(
                            color = GymTheme.colors.textSecondary,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    GymTextField(
                        value = description,
                        onValueChange = { description = it },
                        placeholder = "Technique cues, equipment needed...",
                        modifier = Modifier.height(GymTheme.sizes.cardHeightMedium),
                        shape = GymTheme.shapes.medium,
                        singleLine = false
                    )
                }
            }

            Spacer(modifier = Modifier.height(GymTheme.spacing.xLarge))
        }
    }
}
