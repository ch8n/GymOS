package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymFeelingSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    title: String = "How did it feel?",
    labels: List<String> = listOf("Too Easy", "Perfect", "Too Hard"),
    steps: Int = 9
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = GymTheme.typography.h3.copy(
                color = GymTheme.colors.textPrimary,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(
                horizontal = GymTheme.spacing.small,
                vertical = GymTheme.spacing.medium
            )
        )

        GymCard(
            modifier = Modifier.fillMaxWidth(),
            shape = GymTheme.shapes.large,
            backgroundColor = GymTheme.colors.surface.copy(alpha = 0.3f),
            borderColor = GymTheme.colors.border
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(GymTheme.spacing.medium),
                verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    labels.forEachIndexed { index, label ->
                        Text(
                            text = label.uppercase(),
                            style = GymTheme.typography.tiny.copy(
                                color = if (index == 1) GymTheme.colors.primary else GymTheme.colors.textMuted,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }

                Slider(
                    value = value,
                    onValueChange = onValueChange,
                    valueRange = 0f..10f,
                    steps = steps,
                    modifier = Modifier.fillMaxWidth(),
                    colors = SliderDefaults.colors(
                        thumbColor = GymTheme.colors.primary,
                        activeTrackColor = GymTheme.colors.primary,
                        inactiveTrackColor = GymTheme.colors.surfaceHighlight
                    )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = GymTheme.spacing.xSmall),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(11) { index ->
                        val isCenter = index == 5
                        Box(
                            modifier = Modifier
                                .size(if (isCenter) GymTheme.sizes.indicatorSmall else GymTheme.spacing.xSmall)
                                .clip(CircleShape)
                                .background(
                                    if (isCenter) GymTheme.colors.primary else GymTheme.colors.textMuted.copy(
                                        alpha = 0.5f
                                    )
                                )
                        )
                    }
                }
            }
        }
    }
}
