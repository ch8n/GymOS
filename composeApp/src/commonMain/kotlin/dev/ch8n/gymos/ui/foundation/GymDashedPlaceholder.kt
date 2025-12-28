package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymDashedPlaceholder(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val borderColor = GymTheme.colors.textSecondary.copy(alpha = 0.2f)
    val shape = GymTheme.shapes.default

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .clickable(onClick = onClick)
            .padding(1.dp) // Space for border
    ) {
        val cornerRadius = GymTheme.spacing.medium
        Canvas(modifier = Modifier.matchParentSize()) {
            drawRoundRect(
                color = borderColor,
                style = Stroke(
                    width = 2.dp.toPx(),
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                ),
                cornerRadius = androidx.compose.ui.geometry.CornerRadius(cornerRadius.toPx())
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = GymTheme.spacing.large),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(GymTheme.sizes.medium)
                    .clip(CircleShape)
                    .background(GymTheme.colors.textSecondary.copy(alpha = 0.05f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier.size(GymTheme.sizes.iconMedium),
                    tint = GymTheme.colors.textSecondary.copy(alpha = 0.4f)
                )
            }
            Spacer(modifier = Modifier.height(GymTheme.spacing.medium))
            Text(
                text = text,
                style = GymTheme.typography.bodySmall.copy(
                    color = GymTheme.colors.textSecondary.copy(alpha = 0.5f)
                )
            )
        }
    }
}
