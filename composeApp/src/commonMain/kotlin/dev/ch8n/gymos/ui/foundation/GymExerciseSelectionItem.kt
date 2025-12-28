package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymExerciseSelectionItem(
    name: String,
    category: String,
    equipment: String,
    initials: String,
    onAddClick: () -> Unit,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
    avatarColor: Color = GymTheme.colors.primary,
    isAlreadyAdded: Boolean = false
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(GymTheme.shapes.medium)
            .clickable(onClick = onItemClick)
            .padding(GymTheme.spacing.medium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GymTextAvatar(
            text = initials,
            size = GymTheme.sizes.avatarSmall,
            backgroundColor = avatarColor.copy(alpha = 0.1f),
            contentColor = avatarColor
        )

        Spacer(modifier = Modifier.width(GymTheme.spacing.medium))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = name,
                style = GymTheme.typography.bodyLarge.copy(
                    color = GymTheme.colors.textPrimary,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "$category • $equipment",
                style = GymTheme.typography.bodySmall.copy(
                    color = GymTheme.colors.textSecondary
                )
            )
        }

        IconButton(
            onClick = onAddClick,
            modifier = Modifier
                .size(GymTheme.sizes.avatarSmall)
                .clip(CircleShape),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = if (isAlreadyAdded) {
                    GymTheme.colors.surfaceHighlight
                } else {
                    GymTheme.colors.primary
                },
                contentColor = if (isAlreadyAdded) {
                    GymTheme.colors.textSecondary
                } else {
                    GymTheme.colors.background
                }
            )
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Exercise",
                modifier = Modifier.size(GymTheme.sizes.iconMedium)
            )
        }
    }
}
