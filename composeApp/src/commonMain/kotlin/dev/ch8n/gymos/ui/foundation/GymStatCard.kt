package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymStatCard(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    valueColor: Color = GymTheme.colors.textPrimary
) {
    GymCard(
        modifier = modifier,
        contentPadding = PaddingValues(GymTheme.spacing.medium),
        shape = GymTheme.shapes.default
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = value,
                style = GymTheme.typography.h2.copy(
                    color = valueColor,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = label.uppercase(),
                style = GymTheme.typography.tiny.copy(
                    color = GymTheme.colors.textMuted,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            )
        }
    }
}
