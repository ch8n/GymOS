package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

enum class GymTagType {
    Selected,
    Suggested
}

@Composable
fun GymTag(
    text: String,
    type: GymTagType,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val backgroundColor = when (type) {
        GymTagType.Selected -> GymTheme.colors.primary
        GymTagType.Suggested -> GymTheme.colors.surface
    }
    val contentColor = when (type) {
        GymTagType.Selected -> Color.White
        GymTagType.Suggested -> GymTheme.colors.textPrimary
    }
    val borderColor = when (type) {
        GymTagType.Selected -> Color.Transparent
        GymTagType.Suggested -> GymTheme.colors.border
    }
    val icon: ImageVector = when (type) {
        GymTagType.Selected -> Icons.Default.Close
        GymTagType.Suggested -> Icons.Default.Add
    }
    val iconColor = when (type) {
        GymTagType.Selected -> Color.White.copy(alpha = 0.8f)
        GymTagType.Suggested -> GymTheme.colors.textMuted
    }

    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .border(GymTheme.sizes.borderWidth, borderColor, CircleShape)
            .clickable { onClick() }
            .padding(horizontal = GymTheme.spacing.medium, vertical = GymTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.xSmall)
    ) {
        Text(
            text = text,
            style = GymTheme.typography.bodySmall.copy(
                color = contentColor,
                fontWeight = FontWeight.Bold
            )
        )
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(GymTheme.sizes.iconSmall),
            tint = iconColor
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GymTagRow(
    tags: List<String>,
    type: GymTagType,
    modifier: Modifier = Modifier,
    onTagClick: (String) -> Unit = {}
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small),
        verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
    ) {
        tags.forEach { tag ->
            GymTag(
                text = tag,
                type = type,
                onClick = { onTagClick(tag) }
            )
        }
    }
}
