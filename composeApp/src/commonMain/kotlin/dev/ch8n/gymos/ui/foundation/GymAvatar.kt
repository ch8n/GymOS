package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymAvatar(
    modifier: Modifier = Modifier,
    size: Dp = GymTheme.sizes.medium,
    backgroundColor: Color = GymTheme.colors.surface,
    borderColor: Color = Color.Transparent,
    onEditClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .clip(CircleShape)
                .background(backgroundColor)
                .border(GymTheme.sizes.borderWidth, borderColor, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            content()
        }

        if (onEditClick != null) {
            GymIconButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .border(
                        width = GymTheme.sizes.borderWidth * 2,
                        color = GymTheme.colors.background,
                        shape = CircleShape
                    ),
                icon = Icons.Default.Edit,
                onClick = onEditClick,
                backgroundColor = GymTheme.colors.primary,
                contentColor = Color.White,
                size = size * 0.3f,
                iconSize = (size * 0.3f) * 0.6f
            )
        }
    }
}

@Composable
fun GymImageAvatar(
    painter: Painter,
    modifier: Modifier = Modifier,
    size: Dp = GymTheme.sizes.medium,
    borderColor: Color = GymTheme.colors.border,
    onEditClick: (() -> Unit)? = null,
) {
    GymAvatar(
        modifier = modifier,
        size = size,
        borderColor = borderColor,
        backgroundColor = GymTheme.colors.surface,
        onEditClick = onEditClick
    ) {
        Image(
            painter = painter,
            contentDescription = "User Avatar",
            modifier = Modifier.size(size),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun GymTextAvatar(
    text: String,
    modifier: Modifier = Modifier,
    size: Dp = GymTheme.sizes.medium,
    backgroundColor: Color = GymTheme.colors.primary.copy(alpha = 0.1f),
    contentColor: Color = GymTheme.colors.primary,
    borderColor: Color = Color.Transparent,
    onEditClick: (() -> Unit)? = null,
) {
    GymAvatar(
        modifier = modifier,
        size = size,
        backgroundColor = backgroundColor,
        borderColor = borderColor,
        onEditClick = onEditClick
    ) {
        Text(
            text = text.uppercase(),
            style = GymTheme.typography.captionBold.copy(
                color = contentColor,
                fontSize = (size.value * 0.4f).sp
            )
        )
    }
}
