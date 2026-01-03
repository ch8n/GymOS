package dev.ch8n.gymos.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.GymBMICard
import dev.ch8n.gymos.ui.foundation.GymBottomNavigation
import dev.ch8n.gymos.ui.foundation.GymButton
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymImageAvatar
import dev.ch8n.gymos.ui.foundation.GymMetricInputCard
import dev.ch8n.gymos.ui.foundation.GymTextButton
import dev.ch8n.gymos.ui.foundation.GymTopBar
import dev.ch8n.gymos.ui.foundation.asGymIcon
import gymos.composeapp.generated.resources.Res
import gymos.composeapp.generated.resources.img_avatar
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileScreen(
    onBack: () -> Unit,
    onOpenHome: () -> Unit,
    onOpenCalendar: () -> Unit,
    onOpenProgress: () -> Unit
) {
    var height by remember { mutableStateOf("180") }
    var weight by remember { mutableStateOf("75.5") }

    Scaffold(
        containerColor = GymTheme.colors.background,
        topBar = {
            GymTopBar(
                title = "Profile",
                navigationIcon = {
                    GymIconButton(
                        icon = Icons.Default.ArrowBack.asGymIcon,
                        onClick = onBack,
                        contentColor = GymTheme.colors.textPrimary
                    )
                }
            )
        },
        bottomBar = {
            GymBottomNavigation(
                selectedRoute = "Profile",
                onHomeClick = onOpenHome,
                onCalendarClick = onOpenCalendar,
                onProfileClick = { /* Already here */ },
                onProgressClick = onOpenProgress
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = GymTheme.spacing.medium)
                .padding(bottom = GymTheme.spacing.large),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.large)
        ) {
            // User Profile Section
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = GymTheme.spacing.large)
            ) {
                GymImageAvatar(
                    painter = painterResource(Res.drawable.img_avatar),
                    size = GymTheme.sizes.avatarXLarge,
                    onEditClick = { /* Handle Edit Avatar */ }
                )
                Spacer(modifier = Modifier.height(GymTheme.spacing.medium))
                Text(
                    text = "John Doe",
                    style = GymTheme.typography.h2.copy(fontWeight = FontWeight.Bold),
                    color = GymTheme.colors.textPrimary
                )
                Text(
                    text = "GymOS Member",
                    style = GymTheme.typography.bodyMedium,
                    color = GymTheme.colors.secondary
                )
            }

            // Body Metrics Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
            ) {
                GymMetricInputCard(
                    label = "Height",
                    value = height,
                    unit = "cm",
                    onValueChange = { height = it },
                    modifier = Modifier.weight(1f)
                )
                GymMetricInputCard(
                    label = "Weight",
                    value = weight,
                    unit = "KG",
                    onValueChange = { weight = it },
                    accentColor = GymTheme.colors.primary,
                    modifier = Modifier.weight(1f)
                )
            }

            // BMI Section
            GymBMICard(
                bmiValue = "23.3",
                statusText = "Normal",
                statusIcon = Icons.Default.CheckCircle.asGymIcon,
                statusColor = GymTheme.colors.tertiary,
                progress = 0.46f,
                description = "Your BMI is in the Healthy Weight range. Keep up the good work maintaining your balance."
            )

            // Actions Section
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
            ) {
                GymButton(
                    text = "Update Weight",
                    trailingIcon = Icons.Default.ArrowForward.asGymIcon,
                    onClick = { /* Handle Weight Update */ },
                    modifier = Modifier.fillMaxWidth()
                )
                GymTextButton(
                    text = "View Weight History",
                    icon = Icons.Default.History.asGymIcon,
                    onClick = { /* Navigate to History */ }
                )
            }
        }
    }
}
