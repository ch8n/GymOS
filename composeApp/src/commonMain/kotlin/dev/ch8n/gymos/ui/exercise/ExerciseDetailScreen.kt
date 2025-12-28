package dev.ch8n.gymos.ui.exercise

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.GymBottomNavigation
import dev.ch8n.gymos.ui.foundation.GymExecutionBottomCard
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymSectionHeader
import dev.ch8n.gymos.ui.foundation.GymSessionLogItem
import dev.ch8n.gymos.ui.foundation.GymStatCard
import dev.ch8n.gymos.ui.foundation.GymTopBar
import dev.ch8n.gymos.ui.foundation.GymVideoPlayer

@Composable
fun ExerciseDetailScreen(
    onBackClick: () -> Unit,
    onSummaryClick: () -> Unit
) {
    var weight by remember { mutableStateOf("100") }
    var reps by remember { mutableStateOf("") }
    var energyIndex by remember { mutableStateOf(1) }
    var effortIndex by remember { mutableStateOf(1) }
    var showExecutionCard by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = GymTheme.colors.background,
        topBar = {
            GymTopBar(
                title = "Barbell Squat",
                navigationIcon = {
                    GymIconButton(
                        icon = Icons.Default.ChevronLeft,
                        onClick = onBackClick,
                        size = GymTheme.sizes.small,
                        iconSize = GymTheme.sizes.iconSmall
                    )
                },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null,
                            tint = GymTheme.colors.textPrimary
                        )
                    }
                }
            )
        },
        bottomBar = {
            GymBottomNavigation(
                selectedRoute = "Calendar",
                onHomeClick = onBackClick
            )
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = GymTheme.spacing.pagePadding),
                verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.large)
            ) {
                Spacer(modifier = Modifier.height(GymTheme.spacing.xSmall))

                // Video Section
                GymVideoPlayer(
                    duration = "0:12 loop",
                    onPlayClick = { /* TODO */ }
                )

                // Stats Section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
                ) {
                    GymStatCard(
                        value = "140kg",
                        label = "1RM",
                        modifier = Modifier.weight(1f),
                        valueColor = GymTheme.colors.secondary
                    )
                    GymStatCard(
                        value = "100kg",
                        label = "Target",
                        modifier = Modifier.weight(1f)
                    )
                    GymStatCard(
                        value = "4",
                        label = "Sets",
                        modifier = Modifier.weight(1f)
                    )
                }

                // Log Section
                Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                    GymSectionHeader(
                        title = "Session Log",
                        trailingContent = {
                            Row(
                                modifier = Modifier
                                    .background(
                                        GymTheme.colors.secondary.copy(alpha = 0.1f),
                                        GymTheme.shapes.full
                                    )
                                    .padding(horizontal = 12.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Timer,
                                    contentDescription = null,
                                    tint = GymTheme.colors.secondary,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "Rest Timer: 00:45",
                                    style = GymTheme.typography.tiny,
                                    color = GymTheme.colors.secondary,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                        val logItems = listOf(
                            Triple(1, "Warmup", "20kg x 12"),
                            Triple(2, "Working", "80kg x 8"),
                            Triple(3, "Working", "100kg x 6"),
                            Triple(4, "Working", "100kg x 5")
                        )

                        logItems.forEachIndexed { index, (set, type, details) ->
                            GymSessionLogItem(
                                setNumber = set,
                                setType = type,
                                details = details,
                                statusText = if (index < 3) "RPE ${2 + (index * 2)}" else null,
                                isCompleted = index < 2,
                                isCurrent = index == 2,
                                onClick = { showExecutionCard = true }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(100.dp))
            }

            // Dim background when card is visible
            if (showExecutionCard) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.4f))
                        .clickable { showExecutionCard = false }
                )
            }

            // Floating Active Set Card
            androidx.compose.animation.AnimatedVisibility(
                visible = showExecutionCard,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = GymTheme.spacing.medium),
                enter = androidx.compose.animation.slideInVertically { it } + androidx.compose.animation.fadeIn(),
                exit = androidx.compose.animation.slideOutVertically { it } + androidx.compose.animation.fadeOut()
            ) {
                GymExecutionBottomCard(
                    setTitle = "Set 3",
                    setType = "Working",
                    timerText = "00:42",
                    weight = weight,
                    onWeightChange = { weight = it },
                    reps = reps,
                    onRepsChange = { reps = it },
                    energyIndex = energyIndex,
                    onEnergyIndexChange = { energyIndex = it },
                    effortIndex = effortIndex,
                    onCompleteSet = {
                        showExecutionCard = false
                        onSummaryClick()
                    },
                    modifier = Modifier.padding(horizontal = GymTheme.spacing.pagePadding)
                )
            }
        }
    }
}
