package dev.ch8n.gymos.ui.foundation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    activeColor: Color = GymTheme.colors.primary,
    checkColor: Color = Color.White
) {
    val backgroundColor by animateColorAsState(
        if (checked) activeColor else Color.Transparent
    )
    val borderColor by animateColorAsState(
        if (checked) activeColor else GymTheme.colors.textSecondary.copy(alpha = 0.2f)
    )
    val scale by animateFloatAsState(if (checked) 1f else 0.8f)

    Box(
        modifier = modifier
            .size(GymTheme.sizes.checkbox)
            .clip(CircleShape)
            .background(backgroundColor)
            .border(GymTheme.sizes.borderWidth * 2, borderColor, CircleShape)
            .clickable { onCheckedChange(!checked) }
            .scale(scale),
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                modifier = Modifier.size(GymTheme.sizes.iconSmall),
                tint = checkColor
            )
        }
    }
}
