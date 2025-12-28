package dev.ch8n.gymos.ui.showcase

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.CalendarDateStatus
import dev.ch8n.gymos.ui.foundation.GymAvatar
import dev.ch8n.gymos.ui.foundation.GymBadge
import dev.ch8n.gymos.ui.foundation.GymBadgeIconButton
import dev.ch8n.gymos.ui.foundation.GymButton
import dev.ch8n.gymos.ui.foundation.GymCalendarDate
import dev.ch8n.gymos.ui.foundation.GymCalendarGrid
import dev.ch8n.gymos.ui.foundation.GymCalendarWeekHeader
import dev.ch8n.gymos.ui.foundation.GymCard
import dev.ch8n.gymos.ui.foundation.GymCategoryHeader
import dev.ch8n.gymos.ui.foundation.GymCheckbox
import dev.ch8n.gymos.ui.foundation.GymChip
import dev.ch8n.gymos.ui.foundation.GymDashedPlaceholder
import dev.ch8n.gymos.ui.foundation.GymExecutionBottomCard
import dev.ch8n.gymos.ui.foundation.GymExerciseCard
import dev.ch8n.gymos.ui.foundation.GymFeelingSlider
import dev.ch8n.gymos.ui.foundation.GymIcon
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymNumberInput
import dev.ch8n.gymos.ui.foundation.GymSectionHeader
import dev.ch8n.gymos.ui.foundation.GymSegmentedControl
import dev.ch8n.gymos.ui.foundation.GymSegmentedProgressBar
import dev.ch8n.gymos.ui.foundation.GymSessionLogItem
import dev.ch8n.gymos.ui.foundation.GymStatCard
import dev.ch8n.gymos.ui.foundation.GymStatGridCard
import dev.ch8n.gymos.ui.foundation.GymSummaryHeader
import dev.ch8n.gymos.ui.foundation.GymSummaryHighlightCard
import dev.ch8n.gymos.ui.foundation.GymTopBar
import dev.ch8n.gymos.ui.foundation.GymVideoPlayer
import gymos.composeapp.generated.resources.Res
import gymos.composeapp.generated.resources.img_avatar
import gymos.composeapp.generated.resources.img_workout_upper_body
import org.jetbrains.compose.resources.painterResource

sealed class ShowcaseScreen {
    object List : ShowcaseScreen()
    data class Detail(val componentName: String) : ShowcaseScreen()
}

@Composable
fun ComponentShowcaseScreen(onBack: () -> Unit) {
    var currentScreen by remember { mutableStateOf<ShowcaseScreen>(ShowcaseScreen.List) }

    GymTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(GymTheme.colors.background)
        ) {
            when (val screen = currentScreen) {
                is ShowcaseScreen.List -> ShowcaseList(
                    onBack = onBack,
                    onComponentClick = { currentScreen = ShowcaseScreen.Detail(it) }
                )
                is ShowcaseScreen.Detail -> ShowcaseDetail(
                    componentName = screen.componentName,
                    onBack = { currentScreen = ShowcaseScreen.List }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowcaseList(
    onBack: () -> Unit,
    onComponentClick: (String) -> Unit
) {
    val components = listOf(
        "GymButton",
        "GymCard",
        "GymChip",
        "GymIcon",
        "GymSectionHeader",
        "GymCategoryHeader",
        "GymTopBar",
        "GymCheckbox",
        "GymExerciseCard",
        "GymDashedPlaceholder",
        "GymAvatar",
        "WorkoutImage",
        "GymCalendar",
        "GymStatCard",
        "GymSessionLogItem",
        "GymVideoPlayer",
        "GymNumberInput",
        "GymSegmentedControl",
        "GymExecutionBottomCard",
        "GymSummaryHeader",
        "GymSummaryHighlightCard",
        "GymStatGridCard",
        "GymFeelingSlider",
        "GymSegmentedProgressBar"
    )

    Scaffold(
        topBar = {
            GymTopBar(
                title = "Showcase",
                navigationIcon = {
                    GymIconButton(
                        icon = Icons.Default.ChevronLeft,
                        onClick = onBack,
                        size = GymTheme.sizes.small,
                        iconSize = GymTheme.sizes.iconSmall
                    )
                }
            )
        },
        containerColor = GymTheme.colors.background
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(GymTheme.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
        ) {
            items(components) { component ->
                GymCard(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onComponentClick(component) }
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(GymTheme.spacing.medium),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = component,
                            style = GymTheme.typography.h2,
                            color = GymTheme.colors.textPrimary
                        )
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = null,
                            tint = GymTheme.colors.textSecondary
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowcaseDetail(componentName: String, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            GymTopBar(
                title = componentName,
                navigationIcon = {
                    GymIconButton(
                        icon = Icons.Default.ChevronLeft,
                        onClick = onBack,
                        size = GymTheme.sizes.small,
                        iconSize = GymTheme.sizes.iconSmall
                    )
                }
            )
        },
        containerColor = GymTheme.colors.background
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(GymTheme.spacing.medium)
                .background(GymTheme.colors.background)
        ) {
            when (componentName) {
                "GymButton" -> GymButtonShowcase()
                "GymCard" -> GymCardShowcase()
                "GymChip" -> GymChipShowcase()
                "GymIcon" -> GymIconShowcase()
                "GymSectionHeader" -> GymHeaderShowcase()
                "GymCategoryHeader" -> GymCategoryHeaderShowcase()
                "GymTopBar" -> GymTopBarShowcase()
                "GymCheckbox" -> GymCheckboxShowcase()
                "GymExerciseCard" -> GymExerciseCardShowcase()
                "GymDashedPlaceholder" -> GymDashedPlaceholderShowcase()
                "GymAvatar" -> GymAvatarShowcase()
                "WorkoutImage" -> WorkoutImageShowcase()
                "GymCalendar" -> GymCalendarShowcase()
                "GymStatCard" -> GymStatCardShowcase()
                "GymSessionLogItem" -> GymSessionLogItemShowcase()
                "GymVideoPlayer" -> GymVideoPlayerShowcase()
                "GymNumberInput" -> GymNumberInputShowcase()
                "GymSegmentedControl" -> GymSegmentedControlShowcase()
                "GymExecutionBottomCard" -> GymExecutionBottomCardShowcase()
                "GymSummaryHeader" -> GymSummaryHeaderShowcase()
                "GymSummaryHighlightCard" -> GymSummaryHighlightCardShowcase()
                "GymStatGridCard" -> GymStatGridCardShowcase()
                "GymFeelingSlider" -> GymFeelingSliderShowcase()
                "GymSegmentedProgressBar" -> GymSegmentedProgressBarShowcase()
            }
        }
    }
}

@Composable
fun ShowcaseSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = GymTheme.spacing.medium)) {
        Text(
            text = title,
            style = GymTheme.typography.h3,
            color = GymTheme.colors.primary,
            modifier = Modifier.padding(bottom = GymTheme.spacing.small)
        )
        content()
    }
}

@Composable
fun GymButtonShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Primary Button") {
            GymButton(text = "Start Workout", onClick = {})
        }
        ShowcaseSection("Button with Icon") {
            GymButton(text = "Start Workout", icon = Icons.Default.PlayArrow, onClick = {})
        }
        ShowcaseSection("Icon Buttons") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymIconButton(icon = Icons.Default.Edit, onClick = {})
                GymIconButton(icon = Icons.Default.Add, onClick = {})
                GymIconButton(
                    icon = Icons.Default.Delete,
                    onClick = {},
                    backgroundColor = Color.Red.copy(alpha = 0.2f),
                    contentColor = Color.Red
                )
            }
        }
        ShowcaseSection("Badge Icon Button") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymBadgeIconButton(icon = Icons.Default.Notifications, onClick = {})
                GymBadgeIconButton(
                    icon = Icons.Default.Mail,
                    onClick = {},
                    badgeColor = GymTheme.colors.secondary
                )
            }
        }
    }
}

@Composable
fun GymCardShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Default Card") {
            GymCard(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "This is a default card",
                    modifier = Modifier.padding(GymTheme.spacing.medium),
                    color = GymTheme.colors.textPrimary
                )
            }
        }
        ShowcaseSection("Clickable Card") {
            GymCard(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                Text(
                    "This card is clickable",
                    modifier = Modifier.padding(GymTheme.spacing.medium),
                    color = GymTheme.colors.textPrimary
                )
            }
        }
        ShowcaseSection("Custom Shape (Large)") {
            GymCard(modifier = Modifier.fillMaxWidth(), shape = GymTheme.shapes.lg) {
                Text(
                    "Large Rounded Card",
                    modifier = Modifier.padding(GymTheme.spacing.medium),
                    color = GymTheme.colors.textPrimary
                )
            }
        }
    }
}

@Composable
fun GymChipShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Standard Chips") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                GymChip(text = "Chest")
                GymChip(text = "Triceps")
            }
        }
        ShowcaseSection("Chips with Icons") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                GymChip(text = "Cardio", icon = Icons.Default.Favorite)
                GymChip(text = "Strength", icon = Icons.Default.Settings)
            }
        }
        ShowcaseSection("Chips with Status Dots") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                GymChip(text = "Completed", dotColor = GymTheme.colors.tertiary)
                GymChip(text = "Missed", dotColor = GymTheme.colors.warning)
                GymChip(text = "Rest", dotColor = GymTheme.colors.textMuted)
            }
        }
        ShowcaseSection("GymBadge (Compact Status)") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                GymBadge(text = "Today")
                GymBadge(
                    text = "New",
                    backgroundColor = GymTheme.colors.secondary.copy(alpha = 0.1f),
                    contentColor = GymTheme.colors.secondary
                )
            }
        }
    }
}

@Composable
fun GymIconShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Themed Icons") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymIcon(imageVector = Icons.Default.CheckCircle)
                GymIcon(imageVector = Icons.Default.Favorite, tint = GymTheme.colors.secondary)
                GymIcon(imageVector = Icons.Default.Home, tint = GymTheme.colors.quaternary)
            }
        }
        ShowcaseSection("Large Icons") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymIcon(imageVector = Icons.Default.List, size = 64.dp, iconSize = 32.dp)
            }
        }
    }
}

@Composable
fun GymHeaderShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Section Header") {
            GymSectionHeader(label = "Today's Plan", title = "Tue, Oct 24")
        }
        ShowcaseSection("Section Header with Trailing Content") {
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
                            modifier = androidx.compose.ui.Modifier.size(16.dp)
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
        }
    }
}

@Composable
fun GymTopBarShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Standard Top Bar") {
            GymTopBar(
                title = "October 2023",
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.ChevronLeft,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.ChevronRight,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            )
        }
        ShowcaseSection("Top Bar with Subtitle (Badge)") {
            GymTopBar(
                title = "Wednesday, Oct 24",
                subtitle = "Today",
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.ChevronLeft,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.ChevronRight,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun GymCategoryHeaderShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Category Header with Count") {
            GymCategoryHeader(title = "Chest", count = "2 Exercises")
        }
        ShowcaseSection("Category Header Variations") {
            GymCategoryHeader(
                title = "Triceps",
                count = "3 Exercises",
                titleColor = GymTheme.colors.primary
            )
        }
    }
}

@Composable
fun GymCheckboxShowcase() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(true) }

    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Animated Checkbox") {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
            ) {
                GymCheckbox(checked = checked1, onCheckedChange = { checked1 = it })
                Text("Unchecked state", color = GymTheme.colors.textPrimary)
            }

            Row(
                modifier = Modifier.padding(top = GymTheme.spacing.small),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
            ) {
                GymCheckbox(checked = checked2, onCheckedChange = { checked2 = it })
                Text("Checked state", color = GymTheme.colors.textPrimary)
            }
        }
    }
}

@Composable
fun GymExerciseCardShowcase() {
    var completed1 by remember { mutableStateOf(false) }
    var completed2 by remember { mutableStateOf(true) }

    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Exercise Card - Uncompleted") {
            GymExerciseCard(
                name = "Barbell Bench Press",
                sets = 3,
                reps = 10,
                isCompleted = completed1,
                onCompletedChange = { completed1 = it }
            )
        }
        ShowcaseSection("Exercise Card - Completed") {
            GymExerciseCard(
                name = "Incline Dumbbell Press",
                sets = 3,
                reps = 12,
                isCompleted = completed2,
                onCompletedChange = { completed2 = it },
                iconColor = GymTheme.colors.quaternary
            )
        }
    }
}

@Composable
fun GymDashedPlaceholderShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Dashed Placeholder (Add Action)") {
            GymDashedPlaceholder(
                text = "Tap + to add exercises",
                onClick = {}
            )
        }
    }
}

@Composable
fun GymAvatarShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("User Avatar") {
            GymAvatar(painter = painterResource(Res.drawable.img_avatar))
        }
        ShowcaseSection("Large Avatar") {
            GymAvatar(
                painter = painterResource(Res.drawable.img_avatar),
                size = 80.dp
            )
        }
    }
}

@Composable
fun WorkoutImageShowcase() {
    ShowcaseSection("Workout Image") {
        GymCard(
            modifier = Modifier.fillMaxWidth().height(200.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.img_workout_upper_body),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun GymCalendarShowcase() {
    val mockIndicators = listOf(GymTheme.colors.primary, GymTheme.colors.secondary)

    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Calendar Week Header") {
            GymCalendarWeekHeader()
        }

        ShowcaseSection("Calendar Dates") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                GymCalendarDate(date = "1", isToday = true)
                GymCalendarDate(date = "2", isSelected = true)
                GymCalendarDate(date = "3", status = CalendarDateStatus.Completed)
                GymCalendarDate(date = "4", status = CalendarDateStatus.Missed)
                GymCalendarDate(date = "5", status = CalendarDateStatus.Rest)
                GymCalendarDate(date = "6", indicators = mockIndicators)
            }
        }

        ShowcaseSection("Calendar Grid Sample") {
            GymCalendarGrid(items = (1..31).toList()) { date ->
                GymCalendarDate(
                    date = date.toString(),
                    isSelected = date == 18,
                    status = when (date) {
                        in listOf(
                            1,
                            2,
                            5,
                            6,
                            8,
                            10,
                            11,
                            13,
                            14,
                            15,
                            17
                        ) -> CalendarDateStatus.Completed

                        in listOf(4, 9) -> CalendarDateStatus.Missed
                        in listOf(3, 7, 12, 16) -> CalendarDateStatus.Rest
                        else -> CalendarDateStatus.None
                    },
                    indicators = if (date % 3 == 0) mockIndicators else emptyList()
                )
            }
        }
    }
}

@Composable
fun GymStatCardShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Workout Stats") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymStatCard(
                    value = "140kg",
                    label = "1RM",
                    modifier = Modifier.weight(1f),
                    valueColor = GymTheme.colors.secondary
                )
                GymStatCard(value = "100kg", label = "Target", modifier = Modifier.weight(1f))
                GymStatCard(value = "4", label = "Sets", modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun GymSessionLogItemShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Session Log Items") {
            Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                GymSessionLogItem(
                    setNumber = 1,
                    setType = "Warmup",
                    details = "20kg x 12",
                    statusText = "RPE 2",
                    isCompleted = true
                )
                GymSessionLogItem(
                    setNumber = 2,
                    setType = "Working",
                    details = "80kg x 8",
                    statusText = "RPE 6",
                    isCompleted = true
                )
                GymSessionLogItem(
                    setNumber = 3,
                    setType = "Working",
                    details = "100kg x 6",
                    statusText = "RPE 8",
                    isCompleted = false,
                    isCurrent = true
                )
                GymSessionLogItem(
                    setNumber = 4,
                    setType = "Working",
                    details = "100kg x 5",
                    statusText = null,
                    isCompleted = false
                )
            }
        }
    }
}

@Composable
fun GymVideoPlayerShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Exercise Demonstration") {
            GymVideoPlayer(duration = "0:12 loop")
        }
    }
}

@Composable
fun GymNumberInputShowcase() {
    var weight by remember { mutableStateOf("100") }
    var reps by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Numeric Inputs") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymNumberInput(
                    value = weight,
                    onValueChange = { weight = it },
                    label = "Weight",
                    unit = "KG",
                    modifier = Modifier.weight(1f)
                )
                GymNumberInput(
                    value = reps,
                    onValueChange = { reps = it },
                    label = "Reps",
                    placeholder = "-",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun GymSegmentedControlShowcase() {
    var energyIndex by remember { mutableStateOf(1) }
    var effortIndex by remember { mutableStateOf(2) }

    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Selection Controls") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymSegmentedControl(
                    items = listOf("1", "2", "3"),
                    selectedIndex = energyIndex,
                    onItemSelected = { energyIndex = it },
                    label = "Energy (1-3)",
                    statusText = when (energyIndex) {
                        0 -> "Low"; 1 -> "Moderate"; else -> "High"
                    },
                    modifier = Modifier.weight(1f)
                )
                GymSegmentedControl(
                    items = listOf("1", "2", "3"),
                    selectedIndex = effortIndex,
                    onItemSelected = { effortIndex = it },
                    label = "Effort (1-3)",
                    activeColor = GymTheme.colors.quaternary,
                    statusText = when (effortIndex) {
                        0 -> "Easy"; 1 -> "Moderate"; else -> "Hard"
                    },
                    statusColor = GymTheme.colors.quaternary,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun GymExecutionBottomCardShowcase() {
    var weight by remember { mutableStateOf("100") }
    var reps by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Active Execution Card") {
            GymExecutionBottomCard(
                setTitle = "Set 3",
                setType = "Working",
                timerText = "00:42",
                weight = weight,
                onWeightChange = { weight = it },
                reps = reps,
                onRepsChange = { reps = it },
                onCompleteSet = {}
            )
        }
    }
}

@Composable
fun GymSummaryHeaderShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Exercise Summary Header") {
            GymSummaryHeader(
                exerciseName = "Barbell Squat",
                categoryName = "Leg Day",
                completionTime = "Completed at 6:42 PM"
            )
        }
    }
}

@Composable
fun GymSummaryHighlightCardShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Total Volume Highlight") {
            GymSummaryHighlightCard(
                label = "Total Volume",
                value = "1,100",
                unit = "kg",
                accentColor = GymTheme.colors.quaternary
            )
        }
    }
}

@Composable
fun GymStatGridCardShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Stats Grid Items") {
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
                    label = "Avg Energy",
                    value = "2",
                    subValue = "/ 3",
                    icon = Icons.Default.Timer, // Replace with appropriate icon if needed
                    accentColor = GymTheme.colors.secondary,
                    progress = 2,
                    maxProgress = 3,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun GymFeelingSliderShowcase() {
    var value by remember { mutableStateOf(7f) }
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Exercise Feedback") {
            GymFeelingSlider(
                value = value,
                onValueChange = { value = it }
            )
        }
    }
}

@Composable
fun GymSegmentedProgressBarShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Discrete Progress Levels") {
            Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymSegmentedProgressBar(progress = 1, maxProgress = 3)
                GymSegmentedProgressBar(
                    progress = 2,
                    maxProgress = 3,
                    activeColor = GymTheme.colors.secondary
                )
                GymSegmentedProgressBar(
                    progress = 3,
                    maxProgress = 3,
                    activeColor = GymTheme.colors.tertiary
                )
            }
        }
    }
}
