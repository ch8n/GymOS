package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme

/**
 * A smooth Area Chart with X and Y axis labels, grid lines and interaction.
 */
@Composable
fun GymAreaChart(
    data: List<Float>, // Values from 0 to 1
    modifier: Modifier = Modifier,
    lineColor: Color = GymTheme.colors.primary,
    fillColor: Color = GymTheme.colors.primary.copy(alpha = 0.2f),
    xAxisLabels: List<String>? = null,
    yAxisLabels: List<String>? = listOf("0%", "50%", "100%")
) {
    val themeSizes = GymTheme.sizes
    val themeColors = GymTheme.colors
    val themeSpacing = GymTheme.spacing
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    val textMeasurer = rememberTextMeasurer()
    val textStyle = GymTheme.typography.tiny.copy(color = themeColors.textMuted)

    // Layout configuration
    val leftPadding = if (yAxisLabels != null) 32.dp else 0.dp
    val bottomPadding = if (xAxisLabels != null) themeSizes.badgeHeight else 0.dp

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(themeSizes.xxxxxLarge)
            .padding(top = themeSpacing.small, end = themeSpacing.small)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth()
                .height(themeSizes.xxxxxLarge)
                .pointerInput(data) {
                    detectTapGestures { offset ->
                        val availableWidth = size.width - leftPadding.toPx()
                        val stepX = availableWidth / (data.size - 1)
                        val touchX = offset.x - leftPadding.toPx()
                        if (touchX >= 0) {
                            val index = (touchX / stepX).toInt().coerceIn(0, data.size - 1)
                            selectedIndex = index
                        }
                    }
                }
        ) {
            if (data.isEmpty()) return@Canvas

            val chartWidth = size.width - leftPadding.toPx()
            val chartHeight = size.height - bottomPadding.toPx()
            val offsetX = leftPadding.toPx()
            val stepX = chartWidth / (data.size - 1)
            val gridLineColor = themeColors.textMuted.copy(alpha = 0.1f)

            // 1. Draw Y-Axis Labels and Grid Lines
            val gridLinesCount = yAxisLabels?.size?.minus(1) ?: 1
            yAxisLabels?.forEachIndexed { index, label ->
                val fraction = index.toFloat() / gridLinesCount
                val y = chartHeight - (fraction * chartHeight)

                // Grid Line
                drawLine(
                    color = gridLineColor,
                    start = Offset(offsetX, y),
                    end = Offset(size.width, y),
                    strokeWidth = themeSizes.borderWidth.toPx(),
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                )

                // Label
                val textResult = textMeasurer.measure(label, textStyle)
                drawText(
                    textLayoutResult = textResult,
                    topLeft = Offset(
                        x = (offsetX - textResult.size.width - 8.dp.toPx()).coerceAtLeast(0f),
                        y = y - (textResult.size.height / 2f)
                    )
                )
            }

            // 2. Draw X-Axis Baseline and Labels
            drawLine(
                color = themeColors.textMuted.copy(alpha = 0.3f),
                start = Offset(offsetX, chartHeight),
                end = Offset(size.width, chartHeight),
                strokeWidth = themeSizes.borderWidth.toPx()
            )

            xAxisLabels?.forEachIndexed { index, label ->
                if (index % (data.size / 4).coerceAtLeast(1) == 0 || index == data.size - 1) {
                    val x = offsetX + index * stepX
                    val textResult = textMeasurer.measure(label, textStyle)
                    drawText(
                        textLayoutResult = textResult,
                        topLeft = Offset(
                            x = x - (textResult.size.width / 2f),
                            y = chartHeight + 4.dp.toPx()
                        )
                    )
                }
            }

            // 3. Draw Path and Area
            val strokePath = Path().apply {
                data.forEachIndexed { index, value ->
                    val x = offsetX + index * stepX
                    val y = chartHeight - (value * chartHeight)
                    if (index == 0) {
                        moveTo(x, y)
                    } else {
                        val prevX = offsetX + (index - 1) * stepX
                        val prevY = chartHeight - (data[index - 1] * chartHeight)
                        cubicTo(
                            x1 = (prevX + x) / 2f,
                            y1 = prevY,
                            x2 = (prevX + x) / 2f,
                            y2 = y,
                            x3 = x,
                            y3 = y
                        )
                    }
                }
            }

            val fillPath = Path().apply {
                addPath(strokePath)
                lineTo(offsetX + chartWidth, chartHeight)
                lineTo(offsetX, chartHeight)
                close()
            }

            drawPath(
                path = fillPath,
                brush = Brush.verticalGradient(
                    colors = listOf(fillColor, Color.Transparent),
                    startY = 0f,
                    endY = chartHeight
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

            // 4. Draw Selection Indicator
            selectedIndex?.let { index ->
                val x = offsetX + index * stepX
                val y = chartHeight - (data[index] * chartHeight)

                // Vertical line from top to bottom of chart area
                drawLine(
                    color = lineColor.copy(alpha = 0.4f),
                    start = Offset(x, 0f),
                    end = Offset(x, chartHeight),
                    strokeWidth = themeSizes.borderWidth.toPx()
                )

                // Indicator point
                drawCircle(
                    color = lineColor,
                    radius = themeSizes.indicatorSmall.toPx() * 0.8f,
                    center = Offset(x, y)
                )
                drawCircle(
                    color = Color.White,
                    radius = (themeSizes.borderWidth * 2).toPx(),
                    center = Offset(x, y)
                )

                // Tooltip
                val tooltipValue = "${(data[index] * 100).toInt()}%"
                val text =
                    if (xAxisLabels != null) "${xAxisLabels[index]}: $tooltipValue" else tooltipValue
                val textResult = textMeasurer.measure(text, textStyle.copy(color = Color.White))

                val tooltipRectWidth = textResult.size.width + 16.dp.toPx()
                val tooltipRectHeight = textResult.size.height + 8.dp.toPx()

                val tooltipX =
                    (x - tooltipRectWidth / 2f).coerceIn(offsetX, size.width - tooltipRectWidth)
                val tooltipY = (y - tooltipRectHeight - 8.dp.toPx()).coerceAtLeast(0f)

                drawRoundRect(
                    color = themeColors.surfaceHighlight.copy(alpha = 0.9f),
                    topLeft = Offset(tooltipX, tooltipY),
                    size = androidx.compose.ui.geometry.Size(tooltipRectWidth, tooltipRectHeight),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(8.dp.toPx())
                )

                drawText(
                    textLayoutResult = textResult,
                    topLeft = Offset(
                        x = tooltipX + 8.dp.toPx(),
                        y = tooltipY + 4.dp.toPx()
                    )
                )
            }
        }
    }
}
