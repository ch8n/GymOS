package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme

enum class CalendarDateStatus {
    None, Completed, Missed, Rest
}

@Composable
fun GymCalendarDate(
    date: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    isToday: Boolean = false,
    isCurrentMonth: Boolean = true,
    status: CalendarDateStatus = CalendarDateStatus.None,
    indicators: List<Color> = emptyList(),
    onClick: () -> Unit = {}
) {
    val backgroundColor = when {
        isSelected -> Color.White
        status == CalendarDateStatus.Completed -> GymTheme.colors.tertiary
        status == CalendarDateStatus.Rest -> GymTheme.colors.surfaceHighlight
        status == CalendarDateStatus.Missed -> GymTheme.colors.warning.copy(alpha = 0.1f)
        else -> Color.Transparent
    }

    val contentColor = when {
        isSelected -> GymTheme.colors.surface
        status == CalendarDateStatus.Completed -> GymTheme.colors.surface
        status == CalendarDateStatus.Rest -> GymTheme.colors.textSecondary
        status == CalendarDateStatus.Missed -> GymTheme.colors.warning
        !isCurrentMonth -> GymTheme.colors.textMuted
        else -> GymTheme.colors.textPrimary
    }

    val borderColor = when {
        status == CalendarDateStatus.Missed -> GymTheme.colors.warning.copy(alpha = 0.4f)
        isToday && !isSelected -> GymTheme.colors.textPrimary.copy(alpha = 0.2f)
        else -> Color.Transparent
    }

    Column(
        modifier = modifier
            .width(44.dp)
            .wrapContentHeight()
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(44.dp), // Increase size to match outer ring if needed
            contentAlignment = Alignment.Center
        ) {
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .border(1.dp, GymTheme.colors.textPrimary.copy(alpha = 0.2f), CircleShape)
                )
            }
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(backgroundColor)
                    .then(
                        if (borderColor != Color.Transparent) {
                            Modifier.border(2.dp, borderColor, CircleShape)
                        } else Modifier
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = date,
                    style = GymTheme.typography.bodyMedium.copy(
                        color = contentColor,
                        fontWeight = if (isSelected || status != CalendarDateStatus.None) FontWeight.Bold else FontWeight.Normal
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(GymTheme.spacing.xSmall))

        Row(
            modifier = Modifier.height(GymTheme.sizes.indicatorSmall),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            indicators.take(3).forEach { color ->
                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .clip(CircleShape)
                        .background(color)
                )
            }
        }
    }
}
