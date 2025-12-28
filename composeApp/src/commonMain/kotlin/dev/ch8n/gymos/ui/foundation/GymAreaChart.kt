package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymAreaChart(
    data: List<Float>, // Values from 0 to 1
    modifier: Modifier = Modifier,
    lineColor: Color = GymTheme.colors.primary,
    fillColor: Color = GymTheme.colors.primary.copy(alpha = 0.2f)
) {
    val themeSizes = GymTheme.sizes
    Canvas(modifier = modifier.fillMaxWidth().height(themeSizes.chartHeightLarge)) {
        if (data.isEmpty()) return@Canvas

        val width = size.width
        val height = size.height
        val stepX = width / (data.size - 1)

        val strokePath = Path().apply {
            data.forEachIndexed { index, value ->
                val x = index * stepX
                val y = height - (value * height)
                if (index == 0) {
                    moveTo(x, y)
                } else {
                    lineTo(x, y)
                }
            }
        }

        val fillPath = Path().apply {
            addPath(strokePath)
            lineTo(width, height)
            lineTo(0f, height)
            close()
        }

        drawPath(
            path = fillPath,
            brush = Brush.verticalGradient(
                colors = listOf(fillColor, Color.Transparent),
                startY = 0f,
                endY = height
            )
        )

        drawPath(
            path = strokePath,
            color = lineColor,
            style = Stroke(
                width = (themeSizes.borderWidth * 3).toPx(),
                cap = StrokeCap.Round
            )
        )
    }
}
