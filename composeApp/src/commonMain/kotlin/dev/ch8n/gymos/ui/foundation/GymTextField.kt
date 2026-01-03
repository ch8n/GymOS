package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    backgroundColor: Color = GymTheme.colors.surfaceHighlight,
    contentColor: Color = GymTheme.colors.textPrimary,
    placeholderColor: Color = GymTheme.colors.textMuted
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .height(GymTheme.sizes.buttonHeightMedium)
            .clip(CircleShape)
            .background(backgroundColor)
            .border(GymTheme.sizes.borderWidth, GymTheme.colors.border, CircleShape),
        textStyle = GymTheme.typography.bodyMedium.copy(color = contentColor),
        cursorBrush = SolidColor(GymTheme.colors.primary),
        keyboardOptions = keyboardOptions,
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = GymTheme.spacing.medium),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        modifier = Modifier.size(GymTheme.sizes.iconMedium),
                        tint = GymTheme.colors.primary
                    )
                    Spacer(modifier = Modifier.width(GymTheme.spacing.small))
                }

                Box(modifier = Modifier.weight(1f)) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = GymTheme.typography.bodyMedium.copy(
                                color = placeholderColor
                            )
                        )
                    }
                    innerTextField()
                }

                if (trailingIcon != null) {
                    trailingIcon()
                }
            }
        }
    )
}

@Composable
fun GymSearchField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    onMicClick: () -> Unit = {}
) {
    GymTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        modifier = modifier,
        leadingIcon = Icons.Default.Search,
        trailingIcon = {
            GymIconButton(
                icon = Icons.Default.Mic,
                onClick = onMicClick,
                backgroundColor = Color.Transparent,
                contentColor = GymTheme.colors.textMuted
            )
        }
    )
}
