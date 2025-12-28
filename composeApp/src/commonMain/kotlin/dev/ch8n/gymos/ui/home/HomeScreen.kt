package dev.ch8n.gymos.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.GymBottomNavigation
import dev.ch8n.gymos.ui.foundation.GymButton
import dev.ch8n.gymos.ui.foundation.GymCard
import dev.ch8n.gymos.ui.foundation.GymChip
import dev.ch8n.gymos.ui.foundation.GymIcon
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymImageAvatar
import dev.ch8n.gymos.ui.foundation.GymSectionHeader
import gymos.composeapp.generated.resources.Res
import gymos.composeapp.generated.resources.img_avatar
import gymos.composeapp.generated.resources.img_workout_upper_body
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreen(
    onOpenShowcase: () -> Unit,
    onOpenCalendar: () -> Unit,
    onOpenReminder: () -> Unit,
    onOpenProfile: () -> Unit,
    onOpenProgress: () -> Unit
) {
    Scaffold(
        containerColor = GymTheme.colors.background,
        topBar = { HomeHeader(onOpenShowcase, onOpenReminder, onOpenProfile) },
        bottomBar = {
            GymBottomNavigation(
                selectedRoute = "Home",
                onCalendarClick = onOpenCalendar,
                onProfileClick = onOpenProfile,
                onProgressClick = onOpenProgress
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
            Spacer(modifier = Modifier.height(GymTheme.spacing.small))

            // Today's Plan Section
            GymSectionHeader(
                label = "Today's Plan",
                title = "Tue, Oct 24"
            )

            // Scheduled Time Card
            ScheduledTimeCard()

            // Exercise Tags
            ExerciseTagsSection()

            // Featured Workout Card
            FeaturedWorkoutCard()

            // Stats Grid
            StatsGrid()
        }
    }
}

@Composable
fun HomeHeader(
    onOpenShowcase: () -> Unit,
    onOpenReminder: () -> Unit,
    onOpenProfile: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .safeDrawingPadding()
            .padding(horizontal = GymTheme.spacing.pagePadding, vertical = GymTheme.spacing.medium),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "GymOS",
                style = GymTheme.typography.h1.copy(
                    fontWeight = FontWeight.Black,
                    fontSize = 28.sp
                ),
                color = GymTheme.colors.textPrimary
            )
            Spacer(modifier = Modifier.width(GymTheme.spacing.small))
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Showcase",
                tint = GymTheme.colors.textMuted,
                modifier = Modifier
                    .size(20.dp)
                    .clickable { onOpenShowcase() }
            )
        }
        GymImageAvatar(
            painter = painterResource(Res.drawable.img_avatar),
            size = GymTheme.sizes.avatarMedium,
            modifier = Modifier.clickable { onOpenProfile() }
        )
    }
}

@Composable
fun ScheduledTimeCard() {
    GymCard(
        modifier = Modifier.fillMaxWidth(),
        onClick = { /* Edit Schedule */ }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(GymTheme.spacing.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                GymIcon(
                    imageVector = Icons.Default.Schedule,
                    tint = GymTheme.colors.primary,
                    backgroundColor = GymTheme.colors.primary.copy(alpha = 0.1f)
                )
                Spacer(modifier = Modifier.width(GymTheme.spacing.medium))
                Column {
                    Text(
                        text = "Scheduled Time",
                        style = GymTheme.typography.bodyMedium,
                        color = GymTheme.colors.textSecondary
                    )
                    Text(
                        text = "06:00 PM",
                        style = GymTheme.typography.h2,
                        color = GymTheme.colors.textPrimary
                    )
                }
            }
            GymIconButton(
                icon = Icons.Default.Edit,
                onClick = { },
                contentColor = GymTheme.colors.textSecondary
            )
        }
    }
}

@Composable
fun ExerciseTagsSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
    ) {
        GymChip(text = "Chest", icon = Icons.Default.FitnessCenter)
        GymChip(text = "Triceps")
        GymChip(text = "Cardio", icon = Icons.Default.MonitorHeart)
    }
}

@Composable
fun FeaturedWorkoutCard() {
    GymCard(
        modifier = Modifier.fillMaxWidth().height(380.dp),
        shape = GymTheme.shapes.large,
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(Res.drawable.img_workout_upper_body),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Gradient Overlay
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                GymTheme.colors.surface.copy(alpha = 0.8f),
                                GymTheme.colors.surface
                            ),
                            startY = 200f
                        )
                    )
            )

            // Top Badge
            Box(
                modifier = Modifier
                    .padding(GymTheme.spacing.medium)
                    .clip(CircleShape)
                    .background(GymTheme.colors.background.copy(alpha = 0.6f))
                    .padding(
                        horizontal = GymTheme.spacing.mediumSmall,
                        vertical = GymTheme.spacing.xSmall
                    )
            ) {
                Text(
                    text = "HYPERTROPHY",
                    style = GymTheme.typography.tiny.copy(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.2.sp
                    ),
                    color = Color.White
                )
            }

            // Bottom Content
            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(GymTheme.spacing.large),
                verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
            ) {
                Column {
                    Text(
                        text = "Upper Body Power",
                        style = GymTheme.typography.displayMedium,
                        color = GymTheme.colors.textPrimary
                    )
                    Text(
                        text = "45 mins • 6 Exercises",
                        style = GymTheme.typography.bodyLarge,
                        color = GymTheme.colors.textSecondary
                    )
                }
                GymButton(
                    text = "Start Workout",
                    icon = Icons.Default.PlayArrow,
                    onClick = { },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun StatsGrid() {
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
                GymIcon(
                    imageVector = Icons.Default.LocalFireDepartment,
                    tint = GymTheme.colors.secondary,
                    backgroundColor = GymTheme.colors.secondary.copy(alpha = 0.1f)
                )
                Column {
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "12",
                            style = GymTheme.typography.h1,
                            color = GymTheme.colors.textPrimary
                        )
                        Spacer(modifier = Modifier.width(GymTheme.spacing.xSmall))
                        Text(
                            text = "Days",
                            style = GymTheme.typography.bodyMedium,
                            color = GymTheme.colors.textSecondary
                        )
                    }
                    Text(
                        text = "STREAK",
                        style = GymTheme.typography.tiny.copy(letterSpacing = 1.sp),
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
                GymIcon(
                    imageVector = Icons.Default.MonitorWeight,
                    tint = GymTheme.colors.quaternary,
                    backgroundColor = GymTheme.colors.quaternary.copy(alpha = 0.1f)
                )
                Column {
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "84.1",
                            style = GymTheme.typography.h1,
                            color = GymTheme.colors.textPrimary
                        )
                        Spacer(modifier = Modifier.width(GymTheme.spacing.xSmall))
                        Text(
                            text = "kg",
                            style = GymTheme.typography.bodyMedium,
                            color = GymTheme.colors.textSecondary
                        )
                    }
                    Text(
                        text = "LAST WEIGHT",
                        style = GymTheme.typography.tiny.copy(letterSpacing = 1.sp),
                        color = GymTheme.colors.textMuted
                    )
                }
            }
        }
    }
}


