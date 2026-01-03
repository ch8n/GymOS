package dev.ch8n.gymos.ui.exercise

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForward
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
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymSearchField
import dev.ch8n.gymos.ui.foundation.GymSteppedProgressBar
import dev.ch8n.gymos.ui.foundation.GymTagRow
import dev.ch8n.gymos.ui.foundation.GymTagType
import dev.ch8n.gymos.ui.foundation.GymTextButton
import dev.ch8n.gymos.ui.foundation.GymTopBar
import dev.ch8n.gymos.ui.foundation.asGymIcon

@Composable
fun CreateExerciseBodyPartScreen(
    onBackClick: () -> Unit,
    onNextClick: (bodyParts: List<String>) -> Unit,
    onSkipClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedBodyParts by remember { mutableStateOf(listOf("Chest", "Triceps")) }
    val suggestedBodyParts =
        listOf("Back", "Biceps", "Legs", "Shoulders", "Cardio", "Abs", "Glutes")

    Scaffold(
        containerColor = GymTheme.colors.background,
        topBar = {
            GymTopBar(
                title = "Assign Body Parts",
                navigationIcon = {
                    GymIconButton(
                        icon = Icons.Default.ArrowBackIosNew.asGymIcon,
                        onClick = onBackClick,
                        size = GymTheme.sizes.small,
                        iconSize = GymTheme.sizes.xSmall
                    )
                },
                actions = {
                    GymTextButton(
                        text = "Skip",
                        onClick = onSkipClick,
                        contentColor = GymTheme.colors.primary
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
                    text = "Next Step",
                    onClick = { onNextClick(selectedBodyParts) },
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = Icons.Default.ArrowForward.asGymIcon
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = GymTheme.spacing.medium)
        ) {
            Spacer(modifier = Modifier.height(GymTheme.spacing.small))

            GymSteppedProgressBar(
                currentStep = 2,
                totalSteps = 4,
                stepName = "Muscles",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(GymTheme.spacing.xLarge))

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Add the muscle groups targeted by this exercise.",
                    style = GymTheme.typography.h2.copy(
                        color = GymTheme.colors.textPrimary,
                        fontWeight = FontWeight.Medium
                    )
                )
                Spacer(modifier = Modifier.height(GymTheme.spacing.tiny))
                Text(
                    text = "Start typing to search and add tags.",
                    style = GymTheme.typography.bodySmall.copy(
                        color = GymTheme.colors.textMuted
                    )
                )
            }

            Spacer(modifier = Modifier.height(GymTheme.spacing.large))

            GymSearchField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = "Type to add (e.g. Chest)"
            )

            Spacer(modifier = Modifier.height(GymTheme.spacing.medium))

            GymTagRow(
                tags = selectedBodyParts,
                type = GymTagType.Selected,
                onTagClick = { tag -> selectedBodyParts = selectedBodyParts.filter { it != tag } },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(GymTheme.spacing.large))

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(GymTheme.sizes.borderWidth)
                    .padding(horizontal = GymTheme.spacing.small)
                    .background(GymTheme.colors.border)
            )

            Spacer(modifier = Modifier.height(GymTheme.spacing.large))

            Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                Text(
                    text = "SUGGESTED MUSCLES",
                    style = GymTheme.typography.tiny.copy(
                        color = GymTheme.colors.textMuted,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp
                    )
                )

                GymTagRow(
                    tags = suggestedBodyParts.filter { it !in selectedBodyParts },
                    type = GymTagType.Suggested,
                    onTagClick = { tag -> selectedBodyParts = selectedBodyParts + tag },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(GymTheme.spacing.xLarge))
        }
    }
}

