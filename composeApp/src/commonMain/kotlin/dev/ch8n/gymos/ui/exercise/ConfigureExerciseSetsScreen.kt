package dev.ch8n.gymos.ui.exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.GymButton
import dev.ch8n.gymos.ui.foundation.GymExerciseContextCard
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymMetricInputCard
import dev.ch8n.gymos.ui.foundation.GymSteppedProgressBar
import dev.ch8n.gymos.ui.foundation.GymStepperInput
import dev.ch8n.gymos.ui.foundation.GymTopBar
import dev.ch8n.gymos.ui.foundation.asGymIcon

@Composable
fun ConfigureExerciseSetsScreen(
    onBackClick: () -> Unit,
    onSaveToLibrary: () -> Unit,
) {
    var sets by remember { mutableStateOf(3) }
    var reps by remember { mutableStateOf(10) }
    var weight by remember { mutableStateOf("0") }
    var restTime by remember { mutableStateOf("60") }

    Scaffold(
        containerColor = GymTheme.colors.background,
        topBar = {
            GymTopBar(
                title = "Configuration",
                navigationIcon = {
                    GymIconButton(
                        icon = Icons.Default.ArrowBackIosNew.asGymIcon,
                        onClick = onBackClick,
                        size = GymTheme.sizes.small,
                        iconSize = GymTheme.sizes.xSmall
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
                    text = "Save to Library",
                    onClick = onSaveToLibrary,
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = Icons.Default.CheckCircle.asGymIcon
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = GymTheme.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.large)
        ) {
            Spacer(modifier = Modifier.height(GymTheme.spacing.small))

            GymSteppedProgressBar(
                currentStep = 3,
                totalSteps = 4,
                stepName = "Defaults",
                modifier = Modifier.fillMaxWidth()
            )

            GymExerciseContextCard(
                exerciseName = "Dumbbell Press",
                description = "Define your baseline targets for this exercise to speed up logging.",
                icon = Icons.Default.FitnessCenter.asGymIcon
            )

            Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                Text(
                    text = "CORE METRICS",
                    style = GymTheme.typography.tiny.copy(
                        color = GymTheme.colors.textMuted,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                )

                GymStepperInput(
                    label = "Default Sets",
                    value = sets,
                    onValueChange = { sets = it },
                    subLabel = "Target volume",
                    icon = Icons.Default.Layers.asGymIcon
                )

                GymStepperInput(
                    label = "Default Reps",
                    value = reps,
                    onValueChange = { reps = it },
                    subLabel = "Per set",
                    icon = Icons.Default.Repeat.asGymIcon
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                Text(
                    text = "OPTIONAL PARAMETERS",
                    style = GymTheme.typography.tiny.copy(
                        color = GymTheme.colors.textMuted,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
                ) {
                    GymMetricInputCard(
                        label = "Weight (KG)",
                        value = weight,
                        onValueChange = { weight = it },
                        unit = "kg",
                        modifier = Modifier.weight(1f),
                        icon = Icons.Default.FitnessCenter.asGymIcon,
                        accentColor = GymTheme.colors.primary
                    )

                    GymMetricInputCard(
                        label = "Rest (Sec)",
                        value = restTime,
                        onValueChange = { restTime = it },
                        unit = "sec",
                        modifier = Modifier.weight(1f),
                        icon = Icons.Default.Timer.asGymIcon,
                        accentColor = GymTheme.colors.secondary
                    )
                }
            }

            Spacer(modifier = Modifier.height(GymTheme.spacing.xLarge))
        }
    }
}
