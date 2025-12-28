package dev.ch8n.gymos.ui.calendar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.CalendarDateStatus
import dev.ch8n.gymos.ui.foundation.GymBadgeIconButton
import dev.ch8n.gymos.ui.foundation.GymBottomNavigation
import dev.ch8n.gymos.ui.foundation.GymCalendarDate
import dev.ch8n.gymos.ui.foundation.GymCalendarGrid
import dev.ch8n.gymos.ui.foundation.GymCalendarWeekHeader
import dev.ch8n.gymos.ui.foundation.GymCard
import dev.ch8n.gymos.ui.foundation.GymChip
import dev.ch8n.gymos.ui.foundation.GymIcon
import dev.ch8n.gymos.ui.foundation.GymTopBar

@Composable
fun CalendarScreen(
    onHomeClick: () -> Unit,
    onShowcaseClick: () -> Unit,
    onDateClick: (Int) -> Unit
) {
    Scaffold(
        containerColor = GymTheme.colors.background,
        topBar = {
            CalendarHeader(onShowcaseClick)
        },
        bottomBar = {
            GymBottomNavigation(
                selectedRoute = "Calendar",
                onHomeClick = onHomeClick
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = GymTheme.spacing.pagePadding)
                .padding(bottom = GymTheme.spacing.large),
            verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.sectionGap)
        ) {
            Spacer(modifier = Modifier.height(GymTheme.spacing.xSmall))

            SummaryStatsSection()

            CalendarGridSection(onDateClick)

            StatusKeySection()

            MuscleFocusSection()
        }
    }
}

@Composable
fun CalendarHeader(onShowcaseClick: () -> Unit) {
    GymTopBar(
        title = "October 2023",
        navigationIcon = {
            TextButton(onClick = { }) {
                Text(
                    text = "TODAY",
                    style = GymTheme.typography.captionBold.copy(
                        color = GymTheme.colors.secondary,
                        letterSpacing = 1.sp
                    )
                )
            }
        },
        actions = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { }) {
                    Icon(Icons.Default.ChevronLeft, contentDescription = null, tint = Color.White)
                }
                IconButton(onClick = { }) {
                    Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color.White)
                }
                Spacer(modifier = Modifier.width(GymTheme.spacing.small))
                GymBadgeIconButton(
                    icon = Icons.Default.Notifications,
                    onClick = onShowcaseClick // Reuse for showcase access if needed
                )
            }
        }
    )
}

@Composable
fun SummaryStatsSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
    ) {
        GymCard(
            modifier = Modifier.weight(1f),
            shape = GymTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.padding(GymTheme.spacing.medium),
                verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    GymIcon(
                        imageVector = Icons.Default.FitnessCenter,
                        tint = GymTheme.colors.tertiary,
                        backgroundColor = GymTheme.colors.tertiary.copy(alpha = 0.1f),
                        size = 32.dp,
                        iconSize = 16.dp
                    )
                    Spacer(modifier = Modifier.width(GymTheme.spacing.small))
                    Text(
                        text = "VOLUME",
                        style = GymTheme.typography.tiny.copy(letterSpacing = 1.sp),
                        color = GymTheme.colors.textMuted
                    )
                }
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = "12,450",
                        style = GymTheme.typography.h1,
                        color = GymTheme.colors.textPrimary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "kg",
                        style = GymTheme.typography.bodyMedium,
                        color = GymTheme.colors.textMuted
                    )
                }
            }
        }

        GymCard(
            modifier = Modifier.weight(1f),
            shape = GymTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.padding(GymTheme.spacing.medium),
                verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    GymIcon(
                        imageVector = Icons.Default.LocalFireDepartment,
                        tint = GymTheme.colors.primary,
                        backgroundColor = GymTheme.colors.primary.copy(alpha = 0.1f),
                        size = 32.dp,
                        iconSize = 16.dp
                    )
                    Spacer(modifier = Modifier.width(GymTheme.spacing.small))
                    Text(
                        text = "ACTIVE",
                        style = GymTheme.typography.tiny.copy(letterSpacing = 1.sp),
                        color = GymTheme.colors.textMuted
                    )
                }
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = "18",
                        style = GymTheme.typography.h1,
                        color = GymTheme.colors.textPrimary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "days",
                        style = GymTheme.typography.bodyMedium,
                        color = GymTheme.colors.textMuted
                    )
                }
            }
        }
    }
}

@Composable
fun CalendarGridSection(onDateClick: (Int) -> Unit) {
    Column {
        GymCalendarWeekHeader()
        GymCalendarGrid(items = (1..31).toList()) { date ->
            GymCalendarDate(
                date = date.toString(),
                isSelected = date == 18,
                onClick = { onDateClick(date) },
                status = when (date) {
                    in listOf(1, 2, 5, 6, 8, 10, 11, 13, 14, 15, 17) -> CalendarDateStatus.Completed
                    in listOf(4, 9) -> CalendarDateStatus.Missed
                    in listOf(3, 7, 12, 16) -> CalendarDateStatus.Rest
                    else -> CalendarDateStatus.None
                },
                indicators = when (date) {
                    1 -> listOf(GymTheme.colors.tertiary, GymTheme.colors.secondary)
                    2 -> listOf(GymTheme.colors.quaternary)
                    5 -> listOf(GymTheme.colors.tertiary, GymTheme.colors.tertiary)
                    6 -> listOf(GymTheme.colors.secondary)
                    8 -> listOf(GymTheme.colors.quaternary, GymTheme.colors.secondary)
                    18 -> listOf(GymTheme.colors.textMuted)
                    else -> emptyList()
                }
            )
        }
    }
}

@Composable
fun StatusKeySection() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
        Text(
            text = "STATUS KEY",
            style = GymTheme.typography.captionBold.copy(letterSpacing = 1.sp),
            color = GymTheme.colors.textMuted
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
        ) {
            GymChip(
                text = "Completed",
                dotColor = GymTheme.colors.tertiary,
                backgroundColor = GymTheme.colors.tertiary.copy(alpha = 0.1f),
                contentColor = GymTheme.colors.tertiary,
                borderColor = GymTheme.colors.tertiary.copy(alpha = 0.2f)
            )
            GymChip(
                text = "Rest",
                dotColor = GymTheme.colors.textMuted,
                backgroundColor = GymTheme.colors.surface,
                contentColor = GymTheme.colors.textSecondary
            )
            GymChip(
                text = "Missed",
                dotColor = GymTheme.colors.primary,
                backgroundColor = GymTheme.colors.primary.copy(alpha = 0.1f),
                contentColor = GymTheme.colors.primary,
                borderColor = GymTheme.colors.primary.copy(alpha = 0.2f)
            )
        }
    }
}

@Composable
fun MuscleFocusSection() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
        Text(
            text = "MUSCLE FOCUS",
            style = GymTheme.typography.captionBold.copy(letterSpacing = 1.sp),
            color = GymTheme.colors.textMuted
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
        ) {
            GymChip(
                text = "Upper",
                dotColor = GymTheme.colors.secondary,
                modifier = Modifier.weight(1f)
            )
            GymChip(
                text = "Lower",
                dotColor = GymTheme.colors.tertiary,
                modifier = Modifier.weight(1f)
            )
            GymChip(
                text = "Cardio",
                dotColor = GymTheme.colors.quaternary,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
