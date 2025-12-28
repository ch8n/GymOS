package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymCalendarWeekHeader(
    modifier: Modifier = Modifier
) {
    val days = listOf("S", "M", "T", "W", "T", "F", "S")
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = GymTheme.spacing.small),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        days.forEach { day ->
            Text(
                text = day,
                style = GymTheme.typography.captionBold.copy(
                    color = GymTheme.colors.textMuted,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                ),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }
    }
}
