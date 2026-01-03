package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

/**
 * A list item component that displays an icon, title, subtitle, and a time picker button.
 * Used for scheduling and time-based settings.
 *
 * @param title The main title text
 * @param subtitle The subtitle text displayed below the title
 * @param time The time string to display in the time picker button
 * @param icon The icon to display on the left
 * @param modifier Modifier for the component
 * @param iconBackgroundColor Background color for the icon container
 * @param iconTint Tint color for the icon
 * @param onTimeClick Callback when the time picker button is clicked
 * @param onClick Optional callback when the entire item is clicked
 */
@Composable
fun GymTimeListItem(
    title: String,
    subtitle: String,
    time: String,
    icon: GymIconResource,
    modifier: Modifier = Modifier,
    iconBackgroundColor: Color = GymTheme.colors.quaternary.copy(alpha = 0.2f),
    iconTint: Color = GymTheme.colors.quaternary,
    onTimeClick: () -> Unit = {},
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(GymTheme.shapes.medium)
            .then(
                if (onClick != null) {
                    Modifier.clickable { onClick() }
                } else {
                    Modifier
                }
            )
            .background(Color.Transparent)
            .padding(GymTheme.spacing.medium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
    ) {
        GymIconCircle(
            icon = icon,
            backgroundColor = iconBackgroundColor,
            iconColor = iconTint,
            size = GymTheme.sizes.avatarSmall
        )

        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.xSmall)
        ) {
            Text(
                text = title,
                style = GymTheme.typography.bodyMedium.copy(
                    color = GymTheme.colors.textPrimary,
                    fontWeight = FontWeight.Medium
                )
            )
            Text(
                text = subtitle,
                style = GymTheme.typography.caption.copy(
                    color = GymTheme.colors.textSecondary
                )
            )
        }

        GymTimePickerButton(
            time = time,
            onClick = onTimeClick,
            backgroundColor = GymTheme.colors.surface.copy(alpha = 0.5f),
            textColor = GymTheme.colors.textPrimary
        )
    }
}
