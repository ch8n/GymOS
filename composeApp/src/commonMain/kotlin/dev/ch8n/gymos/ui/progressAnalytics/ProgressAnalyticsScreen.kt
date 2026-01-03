package dev.ch8n.gymos.ui.progressAnalytics

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
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
import dev.ch8n.gymos.ui.foundation.BarData
import dev.ch8n.gymos.ui.foundation.DonutData
import dev.ch8n.gymos.ui.foundation.GymAnalyticsStatCard
import dev.ch8n.gymos.ui.foundation.GymAreaChart
import dev.ch8n.gymos.ui.foundation.GymBadge
import dev.ch8n.gymos.ui.foundation.GymBarChart
import dev.ch8n.gymos.ui.foundation.GymBottomNavigation
import dev.ch8n.gymos.ui.foundation.GymCard
import dev.ch8n.gymos.ui.foundation.GymDonutChart
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymSegmentedControl
import dev.ch8n.gymos.ui.foundation.GymTopBar
import dev.ch8n.gymos.ui.foundation.asGymIcon

/**
 * The Progress & Analytics Dashboard screen.
 */
@Composable
fun ProgressAnalyticsScreen(
    onHomeClick: () -> Unit = {},
    onCalendarClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    var selectedTimeRange by remember { mutableStateOf(1) } // Default to 30D
    val timeRangeOptions = listOf("7D", "30D", "3M", "YTD")

    Scaffold(
        containerColor = GymTheme.colors.background,
        topBar = {
            GymTopBar(
                title = "Your Progress",
                actions = {
                    GymIconButton(
                        icon = Icons.Default.CalendarMonth.asGymIcon,
                        onClick = onCalendarClick
                    )
                }
            )
        },
        bottomBar = {
            GymBottomNavigation(
                selectedRoute = "Progress",
                onHomeClick = onHomeClick,
                onCalendarClick = onCalendarClick,
                onProfileClick = onProfileClick,
                onProgressClick = { /* Already here */ }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
                .padding(horizontal = GymTheme.spacing.medium)
                .padding(bottom = GymTheme.spacing.xxxLarge),
            verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.large)
        ) {
            // Time Range Selector
            GymSegmentedControl(
                items = timeRangeOptions,
                selectedIndex = selectedTimeRange,
                onItemSelected = { selectedTimeRange = it },
                label = "",
                activeColor = GymTheme.colors.primary,
                modifier = Modifier.fillMaxWidth().padding(top = GymTheme.spacing.medium)
            )

            // Top Stats Summary
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
            ) {
                GymAnalyticsStatCard(
                    label = "Total Workouts",
                    value = "12",
                    trend = "↑ 2",
                    accentColor = GymTheme.colors.primary,
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

            // Consistency Section
            AnalyticsCard(title = "Consistency", subtitle = "Last 14 Days") {
                Column {
                    val consistencyData = listOf(
                        BarData("M", 0.4f),
                        BarData("T", 0.05f),
                        BarData("W", 0.8f),
                        BarData("T", 0.6f),
                        BarData("F", 0.05f),
                        BarData("S", 1.0f),
                        BarData("S", 0.4f)
                    )

                    GymBarChart(
                        data = consistencyData,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            // Weight Trend Section
            AnalyticsCard(title = "Weight Trend", subtitle = "Oct 1 - Today") {
                val weightData = listOf(0.4f, 0.6f, 0.5f, 0.7f, 0.55f, 0.8f, 0.65f, 0.9f)
                val xAxisLabels = listOf("Oct 1", "Oct 8", "Oct 15", "Oct 22", "Today")

                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
                    ) {
                        Text(
                            text = "185",
                            style = GymTheme.typography.displayMedium.copy(
                                color = GymTheme.colors.textPrimary,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "lbs",
                            style = GymTheme.typography.bodyLarge.copy(color = GymTheme.colors.textMuted),
                            modifier = Modifier.padding(bottom = GymTheme.spacing.tiny)
                        )
                        GymBadge(
                            text = "-1.2%",
                            backgroundColor = GymTheme.colors.tertiary.copy(alpha = 0.1f),
                            contentColor = GymTheme.colors.tertiary,
                            modifier = Modifier.padding(bottom = GymTheme.spacing.small)
                        )
                    }

                    GymAreaChart(
                        data = weightData,
                        xAxisLabels = xAxisLabels,
                        lineColor = GymTheme.colors.quaternary,
                        fillColor = GymTheme.colors.quaternary.copy(alpha = 0.2f),
                        modifier = Modifier.fillMaxWidth().padding(top = GymTheme.spacing.medium)
                    )
                }
            }

            // Distribution Section
            AnalyticsCard(title = "Muscle Distribution", subtitle = "Monthly Focus") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.large),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val volumeData = listOf(
                        DonutData(0.45f, GymTheme.colors.primary, "Chest"),
                        DonutData(0.25f, GymTheme.colors.secondary, "Back"),
                        DonutData(0.30f, GymTheme.colors.quaternary, "Legs")
                    )

                    GymDonutChart(
                        data = volumeData,
                        modifier = Modifier.weight(1f),
                        centerContent = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "Total",
                                    style = GymTheme.typography.tiny.copy(color = GymTheme.colors.textMuted)
                                )
                                Text(
                                    text = "12.5k",
                                    style = GymTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold)
                                )
                            }
                        }
                    )

                    // Legend
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
                    ) {
                        volumeData.forEach { data ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
                            ) {
                                ColorDot(color = data.color)
                                Text(
                                    text = data.label ?: "Other",
                                    style = GymTheme.typography.bodySmall,
                                    color = GymTheme.colors.textSecondary
                                )
                                Text(
                                    text = "${data.percentage}%",
                                    style = GymTheme.typography.tiny.copy(fontWeight = FontWeight.Bold),
                                    color = GymTheme.colors.textPrimary,
                                    modifier = Modifier.padding(start = GymTheme.spacing.xSmall)
                                )
                            }
                        }
                    }
                }
            }

            // Energy Levels Section
            AnalyticsCard(title = "Energy Levels", subtitle = "Recovery & Effort") {
                val energyData = listOf(0.2f, 0.4f, 0.3f, 0.6f, 0.5f, 0.8f, 0.7f, 0.9f)
                val xAxisLabels = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "Today")

                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "High",
                                style = GymTheme.typography.h2.copy(
                                    color = GymTheme.colors.secondary,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Spacer(Modifier.width(GymTheme.spacing.small))
                            GymBadge(
                                text = "Optimal",
                                backgroundColor = GymTheme.colors.secondary.copy(alpha = 0.1f),
                                contentColor = GymTheme.colors.secondary
                            )
                        }
                    }

                    GymAreaChart(
                        data = energyData,
                        xAxisLabels = xAxisLabels,
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
private fun ColorDot(color: Color) {
    Canvas(modifier = Modifier.size(8.dp)) {
        drawCircle(color = color)
    }
}

@Composable
private fun AnalyticsCard(
    title: String,
    subtitle: String,
    content: @Composable () -> Unit
) {
    GymCard(
        modifier = Modifier.fillMaxWidth(),
        shape = GymTheme.shapes.large
    ) {
        Column(
            modifier = Modifier.padding(GymTheme.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
        ) {
            Column {
                Text(
                    text = title,
                    style = GymTheme.typography.h3.copy(
                        color = GymTheme.colors.textPrimary,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = subtitle,
                    style = GymTheme.typography.bodySmall.copy(color = GymTheme.colors.textMuted)
                )
            }
            content()
        }
    }
}
