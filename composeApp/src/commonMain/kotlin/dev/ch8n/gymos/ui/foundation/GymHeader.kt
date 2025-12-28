package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
fun GymCategoryHeader(
    title: String,
    count: String,
    modifier: Modifier = Modifier,
    titleColor: Color = GymTheme.colors.secondary
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = GymTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
    ) {
        Text(
            text = title.uppercase(),
            style = GymTheme.typography.displaySmall.copy(
                color = titleColor,
                fontWeight = FontWeight.Black,
                letterSpacing = 0.5.sp
            )
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(GymTheme.colors.textSecondary.copy(alpha = 0.1f))
        )

        Text(
            text = count,
            style = GymTheme.typography.bodySmall.copy(
                color = GymTheme.colors.textSecondary,
                fontWeight = FontWeight.Medium
            )
        )
    }
}

@Composable
fun GymTopBar(
    title: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
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

        Column(
            modifier = Modifier.weight(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = GymTheme.typography.bodyLarge.copy(
                    color = GymTheme.colors.textPrimary,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
            if (subtitle != null) {
                Text(
                    text = subtitle.uppercase(),
                    style = GymTheme.typography.tiny.copy(
                        color = GymTheme.colors.primary,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp,
                        background = GymTheme.colors.primary.copy(alpha = 0.1f)
                    ),
                    modifier = Modifier
                        .padding(top = 2.dp)
                        .clip(GymTheme.shapes.default)
                        .padding(horizontal = 8.dp, vertical = 2.dp),
                    textAlign = TextAlign.Center
                )
            }
        }

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            actions?.invoke(this)
        }
    }
}
