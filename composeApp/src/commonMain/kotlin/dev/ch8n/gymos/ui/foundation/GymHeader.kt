package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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

@Composable
fun GymTopBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: (@Composable () -> Unit)? = null,
    actions: (@Composable RowScope.() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(GymTheme.spacing.medium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.weight(1f)) {
            navigationIcon?.invoke()
        }

        Text(
            text = title,
            style = GymTheme.typography.displaySmall.copy(
                color = GymTheme.colors.textPrimary,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.weight(2f),
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            actions?.invoke(this)
        }
    }
}
