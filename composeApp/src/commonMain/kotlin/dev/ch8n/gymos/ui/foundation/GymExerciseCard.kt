package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymExerciseCard(
    name: String,
    sets: Int,
    reps: Int,
    isCompleted: Boolean,
    onCompletedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    icon: GymIconResource = Icons.Default.FitnessCenter.asGymIcon,
    iconColor: Color = GymTheme.colors.primary,
    onClick: (() -> Unit)? = null
) {
    GymCard(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        backgroundColor = GymTheme.colors.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(GymTheme.spacing.small),
            verticalAlignment = Alignment.CenterVertically
        ) {
            GymIcon(
                icon = icon,
                tint = iconColor,
                backgroundColor = iconColor.copy(alpha = 0.1f),
                modifier = Modifier.size(GymTheme.sizes.large),
                size = GymTheme.sizes.checkbox
            )

            Spacer(modifier = Modifier.width(GymTheme.spacing.medium))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = name,
                    style = GymTheme.typography.bodyLarge.copy(
                        color = GymTheme.colors.textPrimary,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(GymTheme.spacing.xSmall / 2))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Repeat,
                        contentDescription = null,
                        modifier = Modifier.size(GymTheme.sizes.xSmall * 0.8f),
                        tint = GymTheme.colors.tertiary
                    )
                    Spacer(modifier = Modifier.width(GymTheme.spacing.xSmall))
                    Text(
                        text = "$sets Sets x $reps Reps",
                        style = GymTheme.typography.bodySmall.copy(
                            color = GymTheme.colors.textSecondary,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.width(GymTheme.spacing.medium))

            GymCheckbox(
                checked = isCompleted,
                onCheckedChange = onCompletedChange,
                activeColor = iconColor
            )
        }
    }
}
