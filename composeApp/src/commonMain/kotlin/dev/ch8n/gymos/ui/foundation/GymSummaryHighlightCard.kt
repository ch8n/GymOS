package dev.ch8n.gymos.ui.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.ch8n.gymos.theme.GymTheme

@Composable
fun GymSummaryHighlightCard(
    label: String,
    value: String,
    unit: String,
    modifier: Modifier = Modifier,
    icon: GymIconResource = Icons.Default.FitnessCenter.asGymIcon,
    accentColor: Color = GymTheme.colors.quaternary
) {
    GymCard(
        modifier = modifier.fillMaxWidth(),
        shape = GymTheme.shapes.large,
        backgroundColor = GymTheme.colors.surface,
        borderColor = GymTheme.colors.border
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            // Glow effect
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = GymTheme.spacing.xxLarge, y = -GymTheme.spacing.xxLarge)
                    .size(GymTheme.sizes.glowSizeLarge)
                    .background(GymTheme.colors.primary.copy(alpha = 0.2f), CircleShape)
                    .blur(GymTheme.spacing.xxLarge)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = GymTheme.spacing.xLarge),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = GymTheme.spacing.small)
                ) {
                    GymIcon(
                        icon = icon,
                        tint = accentColor,
                        size = GymTheme.sizes.xSmall
                    )
                    Spacer(modifier = Modifier.width(GymTheme.spacing.small))
                    Text(
                        text = label.uppercase(),
                        style = GymTheme.typography.captionBold.copy(
                            color = accentColor,
                            letterSpacing = 2.sp
                        )
                    )
                }

                Row(verticalAlignment = Alignment.Top) {
                    Text(
                        text = value,
                        style = GymTheme.typography.displayExtraLarge.copy(
                            color = GymTheme.colors.textPrimary,
                            fontWeight = FontWeight.Black
                        )
                    )
                    Text(
                        text = unit,
                        style = GymTheme.typography.h1.copy(
                            color = accentColor,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(
                            top = GymTheme.spacing.small,
                            start = GymTheme.spacing.xSmall
                        )
                    )
                }
            }
        }
    }
}
