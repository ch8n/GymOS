package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import dev.ch8n.gymos.theme.GymTheme

/**
 * A checklist item component that displays a checkbox, label text, and optional trailing icon.
 * When checked, the text shows a strikethrough decoration and reduced opacity.
 *
 * @param label The text to display for the checklist item
 * @param checked Whether the item is checked
 * @param onCheckedChange Callback when the checkbox state changes
 * @param modifier Modifier for the component
 * @param trailingIcon Optional icon to display at the end of the item
 * @param enabled Whether the item is enabled for interaction
 */
@Composable
fun GymChecklistItem(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: GymIconResource? = null,
    enabled: Boolean = true
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(GymTheme.shapes.medium)
            .clickable(enabled = enabled) { onCheckedChange(!checked) }
            .background(Color.Transparent)
            .padding(GymTheme.spacing.medium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
    ) {
        GymCheckbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.alpha(if (enabled) 1f else 0.5f)
        )

        Text(
            text = label,
            style = GymTheme.typography.bodyMedium.copy(
                color = if (checked) {
                    GymTheme.colors.textSecondary.copy(alpha = 0.6f)
                } else {
                    GymTheme.colors.textPrimary
                },
                fontWeight = FontWeight.Medium,
                textDecoration = if (checked) TextDecoration.LineThrough else TextDecoration.None
            ),
            modifier = Modifier
                .weight(1f)
                .alpha(if (enabled) 1f else 0.5f)
        )

        if (trailingIcon != null) {
            GymIcon(
                icon = trailingIcon,
                modifier = Modifier
                    .size(GymTheme.sizes.iconMedium)
                    .alpha(if (enabled) 0.3f else 0.15f),
                tint = GymTheme.colors.textSecondary
            )
        }
    }
}
