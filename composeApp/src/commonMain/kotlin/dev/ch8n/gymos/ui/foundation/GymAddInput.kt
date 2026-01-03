package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymAddInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Add item...",
    onAddClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(GymTheme.colors.surface.copy(alpha = 0.3f))
            .padding(GymTheme.spacing.mediumSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.mediumSmall)
    ) {
        Box(
            modifier = Modifier
                .size(GymTheme.sizes.iconLarge)
                .clip(CircleShape)
                .background(GymTheme.colors.quaternary.copy(alpha = 0.2f))
                .clickable { onAddClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.size(GymTheme.sizes.iconSmall),
                tint = GymTheme.colors.quaternary
            )
        }

        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.weight(1f),
            textStyle = GymTheme.typography.bodyMedium.copy(
                color = GymTheme.colors.textPrimary
            ),
            cursorBrush = SolidColor(GymTheme.colors.primary),
            decorationBox = { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = GymTheme.typography.bodyMedium.copy(
                            color = GymTheme.colors.textSecondary.copy(alpha = 0.5f)
                        )
                    )
                }
                innerTextField()
            }
        )
    }
}
