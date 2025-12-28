package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    backgroundColor: Color = GymTheme.colors.primary,
    contentColor: Color = Color.White
) {
    Box(
        modifier = modifier
            .height(GymTheme.sizes.buttonHeightMedium) // Use token for height
            .shadow(
                elevation = GymTheme.spacing.small,
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
            if (trailingIcon != null) {
                Spacer(modifier = Modifier.width(GymTheme.spacing.small))
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = null,
                    modifier = Modifier.size(GymTheme.sizes.iconMedium),
                    tint = contentColor
                )
            }
        }
    }
}

@Composable
fun GymTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    contentColor: Color = GymTheme.colors.textSecondary
) {
    Row(
        modifier = modifier
            .clip(GymTheme.shapes.medium)
            .clickable(onClick = onClick)
            .padding(horizontal = GymTheme.spacing.medium, vertical = GymTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(GymTheme.sizes.iconSmall),
                tint = contentColor
            )
            Spacer(modifier = Modifier.width(GymTheme.spacing.xSmall))
        }
        Text(
            text = text,
            style = GymTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
        )
    }
}

@Composable
fun GymIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = GymTheme.colors.surface,
    contentColor: Color = GymTheme.colors.textPrimary,
    size: androidx.compose.ui.unit.Dp = GymTheme.sizes.medium,
    iconSize: androidx.compose.ui.unit.Dp = GymTheme.sizes.iconMedium
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(iconSize),
            tint = contentColor
        )
    }
}

@Composable
fun GymBadgeIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    badgeColor: Color = GymTheme.colors.primary,
    backgroundColor: Color = GymTheme.colors.surface,
    contentColor: Color = GymTheme.colors.textPrimary
) {
    Box(
        modifier = modifier
            .size(GymTheme.sizes.medium)
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable(onClick = onClick)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .size(GymTheme.sizes.iconMedium),
            tint = contentColor
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = GymTheme.spacing.mediumSmall, end = GymTheme.spacing.mediumSmall)
                .size(GymTheme.sizes.indicatorSmall)
                .clip(CircleShape)
                .background(badgeColor)
                .border(GymTheme.sizes.borderWidth * 1.5f, backgroundColor, CircleShape)
        )
    }
}
