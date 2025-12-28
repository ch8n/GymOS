package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymChip(
    text: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    dotColor: Color? = null,
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
        if (dotColor != null) {
            Box(
                modifier = Modifier
                    .size(GymTheme.sizes.indicatorSmall)
                    .clip(CircleShape)
                    .background(dotColor)
            )
            Spacer(modifier = Modifier.width(GymTheme.spacing.small))
        } else if (icon != null) {
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
                color = contentColor,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun GymBadge(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = GymTheme.colors.primary.copy(alpha = 0.1f),
    contentColor: Color = GymTheme.colors.primary
) {
    Text(
        text = text.uppercase(),
        style = GymTheme.typography.tiny.copy(
            color = contentColor,
            fontWeight = FontWeight.Black,
            letterSpacing = 1.sp
        ),
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    )
}
