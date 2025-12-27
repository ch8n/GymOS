package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymChip(
    text: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    backgroundColor: Color = GymTheme.colors.surface,
    contentColor: Color = GymTheme.colors.textPrimary,
    borderColor: Color = GymTheme.colors.border
) {
    Row(
        modifier = modifier
            .height(GymTheme.sizes.buttonHeightSmall)
            .clip(CircleShape)
            .background(backgroundColor)
            .border(1.dp, borderColor, CircleShape)
            .padding(horizontal = GymTheme.spacing.medium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(GymTheme.sizes.iconSmall),
                tint = GymTheme.colors.quaternary
            )
            Spacer(modifier = Modifier.width(GymTheme.spacing.xSmall))
        }
        Text(
            text = text,
            style = GymTheme.typography.bodyMedium.copy(
                color = contentColor
            )
        )
    }
}
