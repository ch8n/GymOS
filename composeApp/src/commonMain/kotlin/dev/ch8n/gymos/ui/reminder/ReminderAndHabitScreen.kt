package dev.ch8n.gymos.ui.reminder

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.Checkroom
import androidx.compose.material.icons.filled.DinnerDining
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.LunchDining
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.GymAddInput
import dev.ch8n.gymos.ui.foundation.GymBottomNavigation
import dev.ch8n.gymos.ui.foundation.GymButton
import dev.ch8n.gymos.ui.foundation.GymCard
import dev.ch8n.gymos.ui.foundation.GymCheckbox
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymIconCircle
import dev.ch8n.gymos.ui.foundation.GymIconSquare
import dev.ch8n.gymos.ui.foundation.GymListItem
import dev.ch8n.gymos.ui.foundation.GymSwitch
import dev.ch8n.gymos.ui.foundation.GymTimePickerButton
import dev.ch8n.gymos.ui.foundation.GymTopBar
import dev.ch8n.gymos.ui.foundation.asGymIcon

@Composable
fun ReminderAndHabitScreen(
    onBack: () -> Unit,
    onSave: () -> Unit,
    onHomeClick: () -> Unit = {},
    onCalendarClick: () -> Unit = {},
    onProgressClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    var notificationsEnabled by remember { mutableStateOf(true) }
    var dailyWeighInEnabled by remember { mutableStateOf(true) }

    var breakfastEnabled by remember { mutableStateOf(true) }
    var lunchEnabled by remember { mutableStateOf(true) }
    var dinnerEnabled by remember { mutableStateOf(false) }

    var checklistItems by remember {
        mutableStateOf(
            listOf(
                ReminderChecklistItem("Water Bottle", true, Icons.Default.WaterDrop),
                ReminderChecklistItem("Gym Towel", false, Icons.Default.Checkroom),
                ReminderChecklistItem("Weightlifting Gloves", true, Icons.Default.FitnessCenter)
            )
        )
    }
    var newItemName by remember { mutableStateOf("") }

    Scaffold(
        containerColor = GymTheme.colors.background,
        topBar = {
            GymTopBar(
                title = "Reminders & Habits",
                navigationIcon = {
                    GymIconButton(
                        icon = Icons.AutoMirrored.Filled.ArrowBack.asGymIcon,
                        onClick = onBack,
                        size = GymTheme.sizes.small,
                        iconSize = GymTheme.sizes.xSmall
                    )
                },
                actions = {
                    GymButton(
                        text = "SAVE",
                        onClick = onSave,
                        backgroundColor = GymTheme.colors.surfaceHighlight,
                        contentColor = GymTheme.colors.primary,
                        modifier = Modifier.height(GymTheme.sizes.small)
                    )
                }
            )
        },
        bottomBar = {
            GymBottomNavigation(
                selectedRoute = "Profile",
                onHomeClick = onHomeClick,
                onCalendarClick = onCalendarClick,
                onProgressClick = onProgressClick,
                onProfileClick = onProfileClick
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = GymTheme.spacing.medium)
                .padding(bottom = GymTheme.spacing.large),
            verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
        ) {

            Spacer(modifier = Modifier.height(GymTheme.spacing.small))

            // GYM ROUTINE Section
            ReminderSection(title = "GYM ROUTINE") {
                GymCard(modifier = Modifier.fillMaxWidth()) {
                    Column {
                        GymListItem(
                            title = "Workout Time",
                            subtitle = "Scheduled for mornings",
                            leadingContent = {
                                GymIconCircle(
                                    icon = Icons.Default.Schedule.asGymIcon,
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
                                    icon = Icons.Default.NotificationsActive.asGymIcon,
                                    backgroundColor = GymTheme.colors.secondary.copy(alpha = 0.2f),
                                    iconColor = GymTheme.colors.secondary
                                )
                            },
                            trailingContent = {
                                GymSwitch(
                                    checked = notificationsEnabled,
                                    onCheckedChange = { notificationsEnabled = it }
                                )
                            }
                        )
                    }
                }
            }

            // GEAR CHECKLIST Section
            ReminderSection(
                title = "GEAR CHECKLIST",
                trailing = {
                    Text(
                        text = "+ MANAGE PRESETS",
                        style = GymTheme.typography.captionBold.copy(
                            color = GymTheme.colors.quaternary
                        ),
                        modifier = Modifier.clickable { /* Manage Presets */ }
                    )
                }
            ) {
                GymCard(modifier = Modifier.fillMaxWidth()) {
                    Column {
                        checklistItems.forEach { item ->
                            GymListItem(
                                title = item.name,
                                leadingContent = {
                                    GymCheckbox(
                                        checked = item.isChecked,
                                        onCheckedChange = { checked ->
                                            checklistItems = checklistItems.map {
                                                if (it.name == item.name) it.copy(isChecked = checked) else it
                                            }
                                        }
                                    )
                                },
                                trailingContent = {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = null,
                                        tint = GymTheme.colors.textMuted,
                                        modifier = Modifier.size(GymTheme.sizes.xSmall)
                                    )
                                }
                            )
                        }
                        GymAddInput(
                            value = newItemName,
                            onValueChange = { newItemName = it },
                            onAddClick = {
                                if (newItemName.isNotBlank()) {
                                    checklistItems = checklistItems + ReminderChecklistItem(
                                        newItemName,
                                        false,
                                        Icons.Default.Inventory2
                                    )
                                    newItemName = ""
                                }
                            }
                        )
                    }
                }
            }

            // BODY METRICS Section
            ReminderSection(title = "BODY METRICS") {
                GymCard(modifier = Modifier.fillMaxWidth()) {
                    GymListItem(
                        title = "Daily Weigh-in",
                        subtitle = "Remind me at 08:00 AM",
                        leadingContent = {
                            GymIconCircle(
                                icon = Icons.Default.MonitorWeight.asGymIcon,
                                backgroundColor = GymTheme.colors.primary.copy(alpha = 0.2f),
                                iconColor = GymTheme.colors.primary
                            )
                        },
                        trailingContent = {
                            GymSwitch(
                                checked = dailyWeighInEnabled,
                                onCheckedChange = { dailyWeighInEnabled = it }
                            )
                        }
                    )
                }
            }

            // MEAL TIMERS Section
            ReminderSection(title = "MEAL TIMERS") {
                GymCard(modifier = Modifier.fillMaxWidth()) {
                    Column {
                        GymListItem(
                            title = "Breakfast",
                            leadingContent = {
                                GymIconSquare(
                                    icon = Icons.Default.BakeryDining.asGymIcon,
                                    backgroundColor = GymTheme.colors.tertiary.copy(alpha = 0.2f),
                                    iconColor = GymTheme.colors.tertiary
                                )
                            },
                            trailingContent = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
                                ) {
                                    GymTimePickerButton(time = "07:00 AM", onClick = {})
                                    GymSwitch(
                                        checked = breakfastEnabled,
                                        onCheckedChange = { breakfastEnabled = it })
                                }
                            }
                        )
                        GymListItem(
                            title = "Lunch",
                            leadingContent = {
                                GymIconSquare(
                                    icon = Icons.Default.LunchDining.asGymIcon,
                                    backgroundColor = GymTheme.colors.tertiary.copy(alpha = 0.2f),
                                    iconColor = GymTheme.colors.tertiary
                                )
                            },
                            trailingContent = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
                                ) {
                                    GymTimePickerButton(time = "01:00 PM", onClick = {})
                                    GymSwitch(
                                        checked = lunchEnabled,
                                        onCheckedChange = { lunchEnabled = it })
                                }
                            }
                        )
                        GymListItem(
                            title = "Dinner",
                            enabled = dinnerEnabled,
                            leadingContent = {
                                GymIconSquare(
                                    icon = Icons.Default.DinnerDining.asGymIcon,
                                    backgroundColor = GymTheme.colors.tertiary.copy(alpha = 0.2f),
                                    iconColor = GymTheme.colors.tertiary
                                )
                            },
                            trailingContent = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
                                ) {
                                    GymTimePickerButton(
                                        time = "08:00 PM",
                                        onClick = {},
                                        enabled = dinnerEnabled
                                    )
                                    GymSwitch(
                                        checked = dinnerEnabled,
                                        onCheckedChange = { dinnerEnabled = it })
                                }
                            }
                        )
                    }
                }
            }

            // RECOVERY Section
            ReminderSection(title = "RECOVERY") {
                GymCard(modifier = Modifier.fillMaxWidth()) {
                    GymListItem(
                        title = "Bedtime Goal",
                        subtitle = "Sleep duration tracking",
                        leadingContent = {
                            GymIconCircle(
                                icon = Icons.Default.Bedtime.asGymIcon,
                                backgroundColor = GymTheme.colors.quaternary.copy(alpha = 0.2f),
                                iconColor = GymTheme.colors.quaternary
                            )
                        },
                        trailingContent = {
                            GymTimePickerButton(time = "10:45 PM", onClick = {})
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun ReminderSection(
    title: String,
    trailing: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = GymTheme.spacing.small),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = GymTheme.typography.captionBold.copy(
                    color = GymTheme.colors.textMuted,
                    fontWeight = FontWeight.Bold
                )
            )
            trailing?.invoke()
        }
        content()
    }
}

private data class ReminderChecklistItem(
    val name: String,
    val isChecked: Boolean,
    val icon: ImageVector
)
