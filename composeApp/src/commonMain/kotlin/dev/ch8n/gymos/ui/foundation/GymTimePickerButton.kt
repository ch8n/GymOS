package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymTimePickerButton(
    time: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = GymTheme.colors.surface.copy(alpha = 0.5f),
    textColor: Color = GymTheme.colors.textPrimary
) {
    Box(
        modifier = modifier
            .clip(GymTheme.shapes.medium)
            .background(if (enabled) backgroundColor else backgroundColor.copy(alpha = 0.2f))
            .clickable(enabled = enabled) { onClick() }
            .padding(
                horizontal = GymTheme.spacing.medium,
                vertical = GymTheme.spacing.small
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = time,
            style = GymTheme.typography.bodyLarge.copy(
                color = if (enabled) textColor else textColor.copy(alpha = 0.3f),
                fontWeight = FontWeight.Bold
            )
        )
    }
}
