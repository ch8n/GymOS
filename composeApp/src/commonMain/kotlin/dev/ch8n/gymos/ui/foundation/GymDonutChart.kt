package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import dev.ch8n.gymos.theme.GymTheme

data class DonutData(
    val percentage: Float, // 0.0 to 1.0
    val color: Color
)

@Composable
fun GymDonutChart(
    data: List<DonutData>,
    modifier: Modifier = Modifier,
    thickness: Dp = GymTheme.sizes.donutThickness,
    centerContent: @Composable () -> Unit = {}
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(GymTheme.sizes.donutSizeMedium)) {
            var startAngle = -90f
            data.forEach { item ->
                val sweepAngle = item.percentage * 360f
                drawArc(
                    color = item.color,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(
                        width = thickness.toPx(),
                        cap = StrokeCap.Round
                    )
                )
                startAngle += sweepAngle
            }
        }
        centerContent()
    }
}
