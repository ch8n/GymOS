package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymMetricInputCard(
    label: String,
    value: String,
    unit: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    icon: GymIconResource? = null,
    accentColor: Color? = null,
    placeholder: String = "0"
) {
    val themePrimary = GymTheme.colors.primary
    val themeMuted = GymTheme.colors.textMuted
    val themeTextPrimary = GymTheme.colors.textPrimary

    GymCard(
        modifier = modifier.fillMaxWidth(),
        shape = GymTheme.shapes.xLarge
    ) {
        Box {
            // Accent decoration
            if (accentColor != null) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = GymTheme.spacing.xLarge, y = -GymTheme.spacing.xLarge)
                        .size(GymTheme.spacing.xxxLarge)
                        .clip(CircleShape)
                        .background(accentColor.copy(alpha = 0.1f))
                )
            }

            Column(
                modifier = Modifier
                    .padding(GymTheme.spacing.medium)
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
                ) {
                    if (icon != null) {
                        GymIcon(
                            icon = icon,
                            size = GymTheme.sizes.iconMedium,
                            tint = accentColor ?: themeMuted
                        )
                    }
                    Text(
                        text = label.uppercase(),
                        style = GymTheme.typography.bodySmall.copy(
                            color = themeMuted,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                    )
                }

                Spacer(modifier = Modifier.size(GymTheme.spacing.medium))

                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    BasicTextField(
                        value = value,
                        onValueChange = onValueChange,
                        modifier = Modifier
                            .widthIn(min = GymTheme.spacing.small)
                            .width(IntrinsicSize.Min),
                        textStyle = GymTheme.typography.h1.copy(
                            color = accentColor ?: themeTextPrimary,
                            fontWeight = FontWeight.Bold
                        ),
                        cursorBrush = SolidColor(accentColor ?: themePrimary),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                        decorationBox = { innerTextField ->
                            if (value.isEmpty()) {
                                Text(
                                    text = placeholder,
                                    style = GymTheme.typography.h1.copy(
                                        color = themeMuted.copy(alpha = 0.3f),
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                            innerTextField()
                        }
                    )

                    Spacer(modifier = Modifier.width(GymTheme.spacing.small))

                    Text(
                        text = unit.uppercase(),
                        style = GymTheme.typography.bodySmall.copy(
                            color = themeMuted,
                            fontWeight = FontWeight.Medium
                        ),
                        modifier = Modifier.padding(bottom = GymTheme.spacing.xSmall)
                    )
                }
            }
        }
    }
}
