package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymNumberInput(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    unit: String? = null,
    placeholder: String = "0"
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.xSmall)
    ) {
        Text(
            text = label.uppercase(),
            style = GymTheme.typography.tiny.copy(
                color = GymTheme.colors.textMuted,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            ),
            modifier = Modifier.padding(start = GymTheme.spacing.xSmall)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(GymTheme.shapes.medium)
                .background(GymTheme.colors.background)
                .border(GymTheme.sizes.borderWidth, GymTheme.colors.border, GymTheme.shapes.medium)
                .padding(vertical = GymTheme.spacing.medium),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    modifier = Modifier.width(IntrinsicSize.Min),
                    textStyle = GymTheme.typography.h2.copy(
                        color = GymTheme.colors.textPrimary,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    ),
                    cursorBrush = SolidColor(GymTheme.colors.primary),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    decorationBox = { innerTextField ->
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = GymTheme.typography.h2.copy(
                                    color = GymTheme.colors.textMuted.copy(alpha = 0.3f),
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                        innerTextField()
                    }
                )

                if (unit != null && value.isNotEmpty()) {
                    Text(
                        text = unit.uppercase(),
                        style = GymTheme.typography.tiny.copy(
                            color = GymTheme.colors.textMuted,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(
                            start = GymTheme.spacing.xSmall,
                            top = GymTheme.spacing.xSmall
                        )
                    )
                }
            }
        }
    }
}
