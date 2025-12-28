package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

data class BarData(
    val label: String,
    val progress: Float, // 0.0 to 1.0
    val color: Color? = null
)

@Composable
fun GymBarChart(
    data: List<BarData>,
    modifier: Modifier = Modifier,
    barColor: Color = GymTheme.colors.primary,
    backgroundColor: Color = GymTheme.colors.surfaceHighlight
) {
    Row(
        modifier = modifier.height(GymTheme.sizes.chartHeightMedium),
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small),
        verticalAlignment = Alignment.Bottom
    ) {
        data.forEach { item ->
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.xSmall)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    // Track
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(
                                color = backgroundColor,
                                shape = GymTheme.shapes.small
                            )
                    )

                    // Progress
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(item.progress)
                            .background(
                                color = item.color ?: barColor,
                                shape = GymTheme.shapes.small
                            )
                    )
                }

                Text(
                    text = item.label,
                    style = GymTheme.typography.tiny.copy(
                        color = GymTheme.colors.textMuted,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}
