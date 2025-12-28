package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymBadge(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = GymTheme.colors.primary.copy(alpha = 0.1f),
    contentColor: Color = GymTheme.colors.primary,
    isUppercase: Boolean = true
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .padding(
                horizontal = GymTheme.spacing.small,
                vertical = GymTheme.spacing.tiny
            )
    ) {
        Text(
            text = if (isUppercase) text.uppercase() else text,
            style = GymTheme.typography.tiny.copy(
                color = contentColor,
                fontWeight = FontWeight.Black,
                letterSpacing = 1.sp
            )
        )
    }
}
