package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

/**
 * A list item component that displays an icon, label, time picker button, and a switch toggle.
 * Used for meal timers and similar time-based toggleable features.
 *
 * @param label The text label for the item
 * @param time The time string to display
 * @param icon The icon to display on the left
 * @param checked Whether the switch is checked
 * @param onCheckedChange Callback when the switch state changes
 * @param modifier Modifier for the component
 * @param iconBackgroundColor Background color for the icon container
 * @param iconTint Tint color for the icon
 * @param onTimeClick Callback when the time picker button is clicked
 * @param enabled Whether the item is enabled for interaction
 */
@Composable
fun GymMealTimerItem(
    label: String,
    time: String,
    icon: GymIconResource,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    iconBackgroundColor: Color = GymTheme.colors.tertiary.copy(alpha = 0.2f),
    iconTint: Color = GymTheme.colors.tertiary,
    onTimeClick: () -> Unit = {},
    enabled: Boolean = true
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(GymTheme.shapes.medium)
            .background(Color.Transparent)
            .padding(GymTheme.spacing.medium)
            .alpha(if (enabled) 1f else 0.5f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.mediumSmall)
    ) {
        GymIconSquare(
            icon = icon,
            backgroundColor = iconBackgroundColor,
            iconColor = iconTint,
            size = GymTheme.sizes.iconLarge
        )

        Text(
            text = label,
            style = GymTheme.typography.bodyMedium.copy(
                color = GymTheme.colors.textPrimary,
                fontWeight = FontWeight.Medium
            ),
            modifier = Modifier.weight(1f)
        )

        GymTimePickerButton(
            time = time,
            onClick = onTimeClick,
            enabled = enabled,
            backgroundColor = GymTheme.colors.surface.copy(alpha = 0.5f),
            textColor = GymTheme.colors.textSecondary
        )

        GymSwitch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled
        )
    }
}
