package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    backgroundColor: Color = GymTheme.colors.primary,
    contentColor: Color = Color.White
) {
    Box(
        modifier = modifier
            .height(GymTheme.sizes.buttonHeightMedium) // Use token for height
            .shadow(
                elevation = 8.dp,
                shape = CircleShape,
                spotColor = backgroundColor.copy(alpha = 0.5f)
            )
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(horizontal = GymTheme.spacing.large),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(horizontal = GymTheme.spacing.small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (icon != null) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(GymTheme.sizes.iconMedium),
                    tint = contentColor
                )
                Spacer(modifier = Modifier.width(GymTheme.spacing.small))
            }
            Text(
                text = text,
                style = GymTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = contentColor
                )
            )
        }
    }
}

@Composable
fun GymIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = GymTheme.colors.surface,
    contentColor: Color = GymTheme.colors.textPrimary
) {
    Box(
        modifier = modifier
            .size(GymTheme.sizes.medium) // 48dp as per design.json md size
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(GymTheme.sizes.iconMedium),
            tint = contentColor
        )
    }
}
