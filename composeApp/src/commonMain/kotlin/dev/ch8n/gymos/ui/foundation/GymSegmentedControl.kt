package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymSegmentedControl(
    items: List<String>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    activeColor: Color = GymTheme.colors.secondary,
    statusText: String? = null,
    statusColor: Color = GymTheme.colors.secondary
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (label != null) {
            Text(
                text = label.uppercase(),
                style = GymTheme.typography.tiny.copy(
                    color = GymTheme.colors.textMuted,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(GymTheme.shapes.medium)
                .background(GymTheme.colors.background)
                .border(1.dp, GymTheme.colors.border, GymTheme.shapes.medium)
                .padding(GymTheme.spacing.xSmall)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.forEachIndexed { index, item ->
                    val isSelected = index == selectedIndex
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(GymTheme.shapes.small)
                            .background(if (isSelected) activeColor else Color.Transparent)
                            .clickable { onItemSelected(index) }
                            .padding(vertical = GymTheme.spacing.small),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = item,
                            style = GymTheme.typography.bodySmall.copy(
                                color = if (isSelected) GymTheme.colors.background else GymTheme.colors.textMuted,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }

        if (statusText != null) {
            Text(
                text = statusText,
                style = GymTheme.typography.tiny.copy(
                    color = statusColor,
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}
