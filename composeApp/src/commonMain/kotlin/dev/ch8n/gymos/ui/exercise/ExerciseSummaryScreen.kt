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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FormatListNumbered
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.GymBottomNavigation
import dev.ch8n.gymos.ui.foundation.GymButton
import dev.ch8n.gymos.ui.foundation.GymFeelingSlider
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymStatGridCard
import dev.ch8n.gymos.ui.foundation.GymSummaryHeader
import dev.ch8n.gymos.ui.foundation.GymSummaryHighlightCard
import dev.ch8n.gymos.ui.foundation.GymTopBar

@Composable
fun ExerciseSummaryScreen(
    onCloseClick: () -> Unit,
    onHomeClick: () -> Unit,
    onFinishClick: () -> Unit,
    onCalendarClick: () -> Unit = {},
    onProgressClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    var feelingValue by remember { mutableStateOf(7f) }

    Scaffold(
        containerColor = GymTheme.colors.background,
        topBar = {
            GymTopBar(
                title = "Exercise Summary",
                navigationIcon = {
                    GymIconButton(
                        icon = Icons.Default.Close,
                        onClick = onCloseClick,
                        size = GymTheme.sizes.small,
                        iconSize = GymTheme.sizes.iconSmall
                    )
                },
                actions = {
                    TextButton(onClick = { }) {
                        Text(
                            text = "Help",
                            style = GymTheme.typography.bodyLarge.copy(
                                color = GymTheme.colors.primary,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            )
        },
        bottomBar = {
            Column {
                GymButton(
                    text = "Mark Exercise Done",
                    icon = Icons.Default.Check,
                    onClick = onFinishClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = GymTheme.spacing.medium)
                        .padding(bottom = GymTheme.spacing.medium)
                )
                GymBottomNavigation(
                    selectedRoute = "Home", // Adjust based on active tab
                    onHomeClick = onHomeClick,
                    onCalendarClick = onCalendarClick,
                    onProgressClick = onProgressClick,
                    onProfileClick = onProfileClick
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
                .padding(bottom = GymTheme.spacing.xxxLarge),
            verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.sectionGap)
        ) {
            GymSummaryHeader(
                exerciseName = "Barbell Squat",
                categoryName = "Chest Day", // Adjusted to match wireframe text
                completionTime = "Completed at 6:42 PM"
            )

            GymSummaryHighlightCard(
                label = "Total Volume",
                value = "1,100",
                unit = "kg",
                accentColor = GymTheme.colors.quaternary
            )

            Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                    GymStatGridCard(
                        label = "Sets Done",
                        value = "5",
                        subValue = "/ 5",
                        icon = Icons.Default.CheckCircle,
                        accentColor = GymTheme.colors.tertiary,
                        modifier = Modifier.weight(1f)
                    )
                    GymStatGridCard(
                        label = "Rep Range",
                        value = "8 - 12",
                        icon = Icons.Default.FormatListNumbered,
                        accentColor = GymTheme.colors.quaternary,
                        modifier = Modifier.weight(1f)
                    )
                }

                Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                    GymStatGridCard(
                        label = "Avg Energy",
                        value = "2",
                        subValue = "/ 3",
                        icon = Icons.Default.Timer,
                        accentColor = GymTheme.colors.secondary,
                        progress = 2,
                        maxProgress = 3,
                        modifier = Modifier.weight(1f)
                    )
                    GymStatGridCard(
                        label = "Avg Effort",
                        value = "3",
                        subValue = "/ 3",
                        icon = Icons.Default.Speed,
                        accentColor = GymTheme.colors.primary,
                        progress = 3,
                        maxProgress = 3,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            GymFeelingSlider(
                value = feelingValue,
                onValueChange = { feelingValue = it }
            )

            Spacer(modifier = Modifier.height(GymTheme.spacing.large))
        }
    }
}
