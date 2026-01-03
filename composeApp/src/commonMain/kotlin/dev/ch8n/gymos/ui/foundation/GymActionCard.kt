package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymActionCard(
    text: String,
    icon: GymIconResource,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isDashed: Boolean = true,
    contentColor: Color = GymTheme.colors.primary,
    backgroundColor: Color = GymTheme.colors.surfaceHighlight
) {
    val themeSizes = GymTheme.sizes
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(themeSizes.medium)
            .clip(CircleShape)
            .clickable(onClick = onClick)
            .background(backgroundColor)
            .padding(themeSizes.borderWidth) // Space for border
    ) {
        if (isDashed) {
            val cornerRadius = themeSizes.medium / 2
            val borderColor = contentColor.copy(alpha = 0.5f)
            Canvas(modifier = Modifier.matchParentSize()) {
                drawRoundRect(
                    color = borderColor,
                    style = Stroke(
                        width = themeSizes.borderWidth.toPx(),
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                    ),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(cornerRadius.toPx())
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = GymTheme.spacing.small),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(themeSizes.small)
                    .clip(CircleShape)
                    .background(contentColor.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                GymIcon(
                    icon = icon,
                    size = themeSizes.xSmall,
                    tint = contentColor
                )
            }

            Spacer(modifier = Modifier.width(GymTheme.spacing.medium))

            Text(
                text = text,
                style = GymTheme.typography.bodyMedium.copy(
                    color = contentColor,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                modifier = Modifier.size(themeSizes.xSmall),
                tint = contentColor.copy(alpha = 0.5f)
            )

            Spacer(modifier = Modifier.width(GymTheme.spacing.small))
        }
    }
}
