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
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LunchDining
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Whatshot
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
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.BarData
import dev.ch8n.gymos.ui.foundation.CalendarDateStatus
import dev.ch8n.gymos.ui.foundation.DonutData
import dev.ch8n.gymos.ui.foundation.GymActionCard
import dev.ch8n.gymos.ui.foundation.GymAddInput
import dev.ch8n.gymos.ui.foundation.GymAnalyticsStatCard
import dev.ch8n.gymos.ui.foundation.GymAreaChart
import dev.ch8n.gymos.ui.foundation.GymAvatar
import dev.ch8n.gymos.ui.foundation.GymBMICard
import dev.ch8n.gymos.ui.foundation.GymBadge
import dev.ch8n.gymos.ui.foundation.GymBadgeIconButton
import dev.ch8n.gymos.ui.foundation.GymBarChart
import dev.ch8n.gymos.ui.foundation.GymButton
import dev.ch8n.gymos.ui.foundation.GymCalendarDate
import dev.ch8n.gymos.ui.foundation.GymCalendarGrid
import dev.ch8n.gymos.ui.foundation.GymCalendarWeekHeader
import dev.ch8n.gymos.ui.foundation.GymCard
import dev.ch8n.gymos.ui.foundation.GymCategoryHeader
import dev.ch8n.gymos.ui.foundation.GymCheckbox
import dev.ch8n.gymos.ui.foundation.GymChip
import dev.ch8n.gymos.ui.foundation.GymDashedPlaceholder
import dev.ch8n.gymos.ui.foundation.GymDonutChart
import dev.ch8n.gymos.ui.foundation.GymExecutionBottomCard
import dev.ch8n.gymos.ui.foundation.GymExerciseCard
import dev.ch8n.gymos.ui.foundation.GymExerciseSelectionItem
import dev.ch8n.gymos.ui.foundation.GymFeelingSlider
import dev.ch8n.gymos.ui.foundation.GymIcon
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymIconCircle
import dev.ch8n.gymos.ui.foundation.GymIconSquare
import dev.ch8n.gymos.ui.foundation.GymImageAvatar
import dev.ch8n.gymos.ui.foundation.GymListItem
import dev.ch8n.gymos.ui.foundation.GymMetricInputCard
import dev.ch8n.gymos.ui.foundation.GymNumberInput
import dev.ch8n.gymos.ui.foundation.GymSectionHeader
import dev.ch8n.gymos.ui.foundation.GymSegmentedControl
import dev.ch8n.gymos.ui.foundation.GymSegmentedProgressBar
import dev.ch8n.gymos.ui.foundation.GymSessionLogItem
import dev.ch8n.gymos.ui.foundation.GymStatCard
import dev.ch8n.gymos.ui.foundation.GymStatGridCard
import dev.ch8n.gymos.ui.foundation.GymStatusBadge
import dev.ch8n.gymos.ui.foundation.GymSummaryHeader
import dev.ch8n.gymos.ui.foundation.GymSummaryHighlightCard
import dev.ch8n.gymos.ui.foundation.GymSwitch
import dev.ch8n.gymos.ui.foundation.GymTextAvatar
import dev.ch8n.gymos.ui.foundation.GymTextButton
import dev.ch8n.gymos.ui.foundation.GymTextField
import dev.ch8n.gymos.ui.foundation.GymTimePickerButton
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
    val listState = rememberLazyListState()

    GymTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(GymTheme.colors.background)
        ) {
            when (val screen = currentScreen) {
                is ShowcaseScreen.List -> ShowcaseList(
                    onBack = onBack,
                    state = listState,
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
    state: LazyListState,
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
        "GymSegmentedProgressBar",
        "GymTextField",
        "GymActionCard",
        "GymExerciseSelectionItem",
        "GymSwitch",
        "GymListItem",
        "GymTimePickerButton",
        "GymAddInput",
        "GymMetricInputCard",
        "GymBMICard",
        "GymStatusBadge",
        "GymAnalyticsStatCard",
        "GymBarChart",
        "GymAreaChart",
        "GymDonutChart"
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
            state = state,
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
                "GymTextField" -> GymTextFieldShowcase()
                "GymActionCard" -> GymActionCardShowcase()
                "GymExerciseSelectionItem" -> GymExerciseSelectionItemShowcase()
                "GymSwitch" -> GymSwitchShowcase()
                "GymListItem" -> GymListItemShowcase()
                "GymTimePickerButton" -> GymTimePickerButtonShowcase()
                "GymAddInput" -> GymAddInputShowcase()
                "GymMetricInputCard" -> GymMetricInputCardShowcase()
                "GymBMICard" -> GymBMICardShowcase()
                "GymStatusBadge" -> GymStatusBadgeShowcase()
                "GymAnalyticsStatCard" -> GymAnalyticsStatCardShowcase()
                "GymBarChart" -> GymBarChartShowcase()
                "GymAreaChart" -> GymAreaChartShowcase()
                "GymDonutChart" -> GymDonutChartShowcase()
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
        ShowcaseSection("Large Button with Trailing Icon") {
            GymButton(
                text = "Update Weight",
                trailingIcon = Icons.Default.ArrowForward,
                onClick = {}
            )
        }
        ShowcaseSection("Text Buttons") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymTextButton(text = "View History", icon = Icons.Default.History, onClick = {})
                GymTextButton(text = "Cancel", onClick = {})
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
            GymCard(modifier = Modifier.fillMaxWidth(), shape = GymTheme.shapes.large) {
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
                GymIcon(
                    imageVector = Icons.Default.List,
                    size = GymTheme.spacing.xxxLarge,
                    iconSize = GymTheme.sizes.iconLarge
                )
            }
        }
    }
}

@Composable
fun GymHeaderShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Section Header with Icon") {
            GymSectionHeader(
                title = "Recent",
                icon = Icons.Default.History,
                iconColor = GymTheme.colors.primary
            )
        }
        ShowcaseSection("Section Header with Secondary Icon") {
            GymSectionHeader(
                title = "Popular Exercises",
                icon = Icons.Default.Whatshot,
                iconColor = GymTheme.colors.secondary
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
        ShowcaseSection("Image Avatar") {
            GymAvatar {
                Image(
                    painter = painterResource(Res.drawable.img_avatar),
                    contentDescription = null,
                    modifier = Modifier.size(GymTheme.sizes.medium),
                    contentScale = ContentScale.Crop
                )
            }
        }
        ShowcaseSection("Text Avatar (Initials)") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymTextAvatar(
                    text = "BP",
                    backgroundColor = GymTheme.colors.quaternary.copy(alpha = 0.1f),
                    contentColor = GymTheme.colors.quaternary
                )
                GymTextAvatar(
                    text = "JD",
                    size = GymTheme.sizes.avatarXLarge,
                    backgroundColor = GymTheme.colors.primary.copy(alpha = 0.1f),
                    contentColor = GymTheme.colors.primary,
                    onEditClick = {}
                )
            }
        }
        ShowcaseSection("Editable Avatar (Large)") {
            GymImageAvatar(
                painter = painterResource(Res.drawable.img_avatar),
                size = GymTheme.sizes.avatarLarge,
                onEditClick = {}
            )
        }
    }
}

@Composable
fun WorkoutImageShowcase() {
    ShowcaseSection("Workout Image") {
        GymCard(
            modifier = Modifier.fillMaxWidth().height(GymTheme.spacing.xxxLarge * 3),
            contentPadding = PaddingValues(GymTheme.spacing.none)
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

@Composable
fun GymTextFieldShowcase() {
    var search by remember { mutableStateOf("") }
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Search Field") {
            GymTextField(
                value = search,
                onValueChange = { search = it },
                placeholder = "Search bench press, squat...",
                leadingIcon = Icons.Default.Search
            )
        }
    }
}

@Composable
fun GymActionCardShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Dashed Action Card") {
            GymActionCard(
                text = "Create Custom Exercise",
                icon = Icons.Default.Edit,
                onClick = {}
            )
        }
        ShowcaseSection("Solid Action Card") {
            GymActionCard(
                text = "Add Exercise",
                icon = Icons.Default.Add,
                isDashed = false,
                onClick = {}
            )
        }
    }
}

@Composable
fun GymExerciseSelectionItemShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Exercise Selection Item") {
            Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                GymExerciseSelectionItem(
                    name = "Barbell Bench Press",
                    category = "Chest",
                    equipment = "Barbell",
                    initials = "BP",
                    onAddClick = {},
                    onItemClick = {},
                    avatarColor = GymTheme.colors.quaternary
                )
                GymExerciseSelectionItem(
                    name = "Barbell Squat",
                    category = "Legs",
                    equipment = "Barbell",
                    initials = "SQ",
                    onAddClick = {},
                    onItemClick = {},
                    avatarColor = GymTheme.colors.primary,
                    isAlreadyAdded = true
                )
            }
        }
    }
}

@Composable
fun GymSwitchShowcase() {
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(true) }

    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Switches") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymSwitch(checked = checked1, onCheckedChange = { checked1 = it })
                GymSwitch(checked = checked2, onCheckedChange = { checked2 = it })
            }
        }
    }
}

@Composable
fun GymListItemShowcase() {
    var checked by remember { mutableStateOf(true) }
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Reminder List Items") {
            Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                GymListItem(
                    title = "Workout Time",
                    subtitle = "Scheduled for mornings",
                    leadingContent = {
                        GymIconCircle(
                            icon = Icons.Default.Schedule,
                            backgroundColor = GymTheme.colors.quaternary.copy(alpha = 0.2f),
                            iconColor = GymTheme.colors.quaternary
                        )
                    },
                    trailingContent = {
                        GymTimePickerButton(time = "06:30 AM", onClick = {})
                    }
                )

                GymListItem(
                    title = "Push Notifications",
                    leadingContent = {
                        GymIconCircle(
                            icon = Icons.Default.NotificationsActive,
                            backgroundColor = GymTheme.colors.secondary.copy(alpha = 0.2f),
                            iconColor = GymTheme.colors.secondary
                        )
                    },
                    trailingContent = {
                        GymSwitch(checked = checked, onCheckedChange = { checked = it })
                    }
                )
            }
        }

        ShowcaseSection("Meal Timer List Items") {
            Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                GymListItem(
                    title = "Breakfast",
                    leadingContent = {
                        GymIconSquare(
                            icon = Icons.Default.BakeryDining,
                            backgroundColor = GymTheme.colors.tertiary.copy(alpha = 0.2f),
                            iconColor = GymTheme.colors.tertiary
                        )
                    },
                    trailingContent = {
                        GymTimePickerButton(time = "07:00 AM", onClick = {})
                        GymSwitch(checked = true, onCheckedChange = {})
                    }
                )
                GymListItem(
                    title = "Lunch",
                    leadingContent = {
                        GymIconSquare(
                            icon = Icons.Default.LunchDining,
                            backgroundColor = GymTheme.colors.tertiary.copy(alpha = 0.2f),
                            iconColor = GymTheme.colors.tertiary
                        )
                    },
                    trailingContent = {
                        GymTimePickerButton(time = "01:00 PM", onClick = {})
                        GymSwitch(checked = true, onCheckedChange = {})
                    }
                )
            }
        }
    }
}

@Composable
fun GymTimePickerButtonShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Time Picker Buttons") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymTimePickerButton(time = "06:30 AM", onClick = {})
                GymTimePickerButton(time = "10:45 PM", onClick = {})
            }
        }
    }
}

@Composable
fun GymAddInputShowcase() {
    var value by remember { mutableStateOf("") }
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Add Input Field") {
            GymAddInput(
                value = value,
                onValueChange = { value = it },
                onAddClick = { value = "" }
            )
        }
    }
}

@Composable
fun GymMetricInputCardShowcase() {
    var height by remember { mutableStateOf("180") }
    var weight by remember { mutableStateOf("75.5") }
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Standard Metric Card") {
            GymMetricInputCard(
                label = "Height",
                value = height,
                onValueChange = { height = it },
                unit = "cm"
            )
        }
        ShowcaseSection("Accented Metric Card") {
            GymMetricInputCard(
                label = "Weight",
                value = weight,
                onValueChange = { weight = it },
                unit = "KG",
                accentColor = GymTheme.colors.primary
            )
        }
    }
}

@Composable
fun GymBMICardShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("BMI Summary Card") {
            GymBMICard(
                bmiValue = "23.3",
                statusText = "Healthy",
                statusIcon = Icons.Default.CheckCircle,
                statusColor = GymTheme.colors.tertiary,
                progress = 0.46f,
                description = "Your BMI is in the Healthy Weight range. Keep up the good work maintaining your balance."
            )
        }
    }
}

@Composable
fun GymStatusBadgeShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Status Badges") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymStatusBadge(
                    text = "Normal",
                    icon = Icons.Default.CheckCircle,
                    backgroundColor = GymTheme.colors.tertiary.copy(alpha = 0.2f),
                    contentColor = GymTheme.colors.tertiary
                )
                GymStatusBadge(
                    text = "High",
                    icon = Icons.Default.Whatshot,
                    backgroundColor = GymTheme.colors.primary.copy(alpha = 0.2f),
                    contentColor = GymTheme.colors.primary
                )
            }
        }
    }
}

@Composable
fun GymAnalyticsStatCardShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Analytics Stats") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymAnalyticsStatCard(
                    label = "Total Workouts",
                    value = "12",
                    trend = "↑ 2",
                    modifier = Modifier.weight(1f)
                )
                GymAnalyticsStatCard(
                    label = "Avg Duration",
                    value = "45",
                    unit = "m",
                    accentColor = GymTheme.colors.secondary,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun GymBarChartShowcase() {
    val mockData = listOf(
        BarData("M", 0.4f),
        BarData("T", 0.1f, color = GymTheme.colors.surfaceHighlight),
        BarData("W", 0.8f, color = GymTheme.colors.primary),
        BarData("T", 0.6f),
        BarData("F", 0.1f, color = GymTheme.colors.surfaceHighlight),
        BarData("S", 1.0f),
        BarData("S", 0.4f, color = GymTheme.colors.primary.copy(alpha = 0.5f))
    )

    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Consistency Bar Chart") {
            GymCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(GymTheme.spacing.medium)) {
                    GymSectionHeader(title = "Consistency", label = "Last 14 Days")
                    GymBarChart(
                        data = mockData,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = GymTheme.spacing.medium)
                    )
                }
            }
        }
    }
}

@Composable
fun GymAreaChartShowcase() {
    val weightData = listOf(0.4f, 0.6f, 0.5f, 0.7f, 0.55f, 0.8f, 0.65f, 0.9f)
    val energyData = listOf(0.2f, 0.4f, 0.3f, 0.6f, 0.5f, 0.8f, 0.7f, 0.9f)

    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Weight Trend (Area Chart)") {
            GymCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(GymTheme.spacing.medium)) {
                    GymAnalyticsStatCard(
                        label = "Weight Trend",
                        value = "185",
                        unit = "lbs",
                        trend = "-1.2%",
                        accentColor = GymTheme.colors.quaternary
                    )
                    GymAreaChart(
                        data = weightData,
                        lineColor = GymTheme.colors.quaternary,
                        fillColor = GymTheme.colors.quaternary.copy(alpha = 0.2f),
                        modifier = Modifier.fillMaxWidth().padding(top = GymTheme.spacing.medium)
                    )
                }
            }
        }

        ShowcaseSection("Energy Levels (Area Chart)") {
            GymCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(GymTheme.spacing.medium)) {
                    GymSectionHeader(
                        title = "Energy Levels",
                        trailingContent = {
                            GymBadge(
                                text = "High",
                                backgroundColor = GymTheme.colors.secondary.copy(alpha = 0.1f),
                                contentColor = GymTheme.colors.secondary
                            )
                        }
                    )
                    GymAreaChart(
                        data = energyData,
                        lineColor = GymTheme.colors.secondary,
                        fillColor = GymTheme.colors.secondary.copy(alpha = 0.2f),
                        modifier = Modifier.fillMaxWidth().padding(top = GymTheme.spacing.medium)
                    )
                }
            }
        }
    }
}

@Composable
fun GymDonutChartShowcase() {
    val muscleData = listOf(
        DonutData(0.4f, GymTheme.colors.primary),
        DonutData(0.3f, GymTheme.colors.secondary),
        DonutData(0.2f, GymTheme.colors.quaternary)
    )

    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Volume by Muscle (Donut Chart)") {
            GymCard(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.padding(GymTheme.spacing.medium),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.large)
                ) {
                    GymDonutChart(data = muscleData) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Total",
                                style = GymTheme.typography.tiny,
                                color = GymTheme.colors.textMuted
                            )
                            Text(
                                text = "12.5k",
                                style = GymTheme.typography.bodyLarge,
                                color = GymTheme.colors.textPrimary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small),
                        modifier = Modifier.weight(1f)
                    ) {
                        muscleData.zip(listOf("Legs", "Push", "Pull")).forEach { (data, label) ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.xSmall)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(GymTheme.spacing.small)
                                            .background(data.color, CircleShape)
                                    )
                                    Text(
                                        text = label,
                                        style = GymTheme.typography.bodySmall,
                                        color = GymTheme.colors.textSecondary
                                    )
                                }
                                Text(
                                    text = "${(data.percentage * 100).toInt()}%",
                                    style = GymTheme.typography.bodySmall,
                                    color = GymTheme.colors.textPrimary,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
