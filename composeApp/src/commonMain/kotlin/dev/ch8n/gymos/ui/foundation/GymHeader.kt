package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymSectionHeader(
    label: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = label.uppercase(),
            style = GymTheme.typography.captionBold.copy(
                color = GymTheme.colors.primary,
                letterSpacing = 1.sp
            )
        )
        Text(
            text = title,
            style = GymTheme.typography.displayMedium.copy(
                color = GymTheme.colors.textPrimary
            )
        )
    }
}
