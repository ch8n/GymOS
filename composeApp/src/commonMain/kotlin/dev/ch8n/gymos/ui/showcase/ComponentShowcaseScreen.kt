package dev.ch8n.gymos.ui.showcase

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.*

sealed class ShowcaseScreen {
    object List : ShowcaseScreen()
    data class Detail(val componentName: String) : ShowcaseScreen()
}

@Composable
fun ComponentShowcaseScreen() {
    var currentScreen by remember { mutableStateOf<ShowcaseScreen>(ShowcaseScreen.List) }

    GymTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(GymTheme.colors.background)
        ) {
            when (val screen = currentScreen) {
                is ShowcaseScreen.List -> ShowcaseList(onComponentClick = { currentScreen = ShowcaseScreen.Detail(it) })
                is ShowcaseScreen.Detail -> ShowcaseDetail(
                    componentName = screen.componentName,
                    onBack = { currentScreen = ShowcaseScreen.List }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowcaseList(onComponentClick: (String) -> Unit) {
    val components = listOf(
        "GymButton",
        "GymCard",
        "GymChip",
        "GymIcon",
        "GymSectionHeader",
        "GymAvatar"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Component Showcase", style = GymTheme.typography.h1) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GymTheme.colors.background,
                    titleContentColor = GymTheme.colors.textPrimary
                )
            )
        },
        containerColor = GymTheme.colors.background
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(GymTheme.spacing.medium),
            verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
        ) {
            items(components) { component ->
                GymCard(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onComponentClick(component) }
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(GymTheme.spacing.medium),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = component,
                            style = GymTheme.typography.h2,
                            color = GymTheme.colors.textPrimary
                        )
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = null,
                            tint = GymTheme.colors.textSecondary
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowcaseDetail(componentName: String, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(componentName, style = GymTheme.typography.h1) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = GymTheme.colors.textPrimary)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GymTheme.colors.background,
                    titleContentColor = GymTheme.colors.textPrimary
                )
            )
        },
        containerColor = GymTheme.colors.background
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(GymTheme.spacing.medium)
                .background(GymTheme.colors.background)
        ) {
            when (componentName) {
                "GymButton" -> GymButtonShowcase()
                "GymCard" -> GymCardShowcase()
                "GymChip" -> GymChipShowcase()
                "GymIcon" -> GymIconShowcase()
                "GymSectionHeader" -> GymHeaderShowcase()
                "GymAvatar" -> GymAvatarShowcase()
            }
        }
    }
}

@Composable
fun ShowcaseSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = GymTheme.spacing.medium)) {
        Text(
            text = title,
            style = GymTheme.typography.h3,
            color = GymTheme.colors.primary,
            modifier = Modifier.padding(bottom = GymTheme.spacing.small)
        )
        content()
    }
}

@Composable
fun GymButtonShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Primary Button") {
            GymButton(text = "Start Workout", onClick = {})
        }
        ShowcaseSection("Button with Icon") {
            GymButton(text = "Start Workout", icon = Icons.Default.PlayArrow, onClick = {})
        }
        ShowcaseSection("Icon Buttons") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymIconButton(icon = Icons.Default.Edit, onClick = {})
                GymIconButton(icon = Icons.Default.Add, onClick = {})
                GymIconButton(
                    icon = Icons.Default.Delete,
                    onClick = {},
                    backgroundColor = Color.Red.copy(alpha = 0.2f),
                    contentColor = Color.Red
                )
            }
        }
    }
}

@Composable
fun GymCardShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Default Card") {
            GymCard(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "This is a default card",
                    modifier = Modifier.padding(GymTheme.spacing.medium),
                    color = GymTheme.colors.textPrimary
                )
            }
        }
        ShowcaseSection("Clickable Card") {
            GymCard(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                Text(
                    "This card is clickable",
                    modifier = Modifier.padding(GymTheme.spacing.medium),
                    color = GymTheme.colors.textPrimary
                )
            }
        }
        ShowcaseSection("Custom Shape (Large)") {
            GymCard(modifier = Modifier.fillMaxWidth(), shape = GymTheme.shapes.lg) {
                Text(
                    "Large Rounded Card",
                    modifier = Modifier.padding(GymTheme.spacing.medium),
                    color = GymTheme.colors.textPrimary
                )
            }
        }
    }
}

@Composable
fun GymChipShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Standard Chips") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                GymChip(text = "Chest")
                GymChip(text = "Triceps")
            }
        }
        ShowcaseSection("Chips with Icons") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)) {
                GymChip(text = "Cardio", icon = Icons.Default.Favorite)
                GymChip(text = "Strength", icon = Icons.Default.Settings)
            }
        }
    }
}

@Composable
fun GymIconShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Themed Icons") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymIcon(imageVector = Icons.Default.CheckCircle)
                GymIcon(imageVector = Icons.Default.Favorite, tint = GymTheme.colors.secondary)
                GymIcon(imageVector = Icons.Default.Home, tint = GymTheme.colors.quaternary)
            }
        }
        ShowcaseSection("Large Icons") {
            Row(horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
                GymIcon(imageVector = Icons.Default.List, size = 64.dp, iconSize = 32.dp)
            }
        }
    }
}

@Composable
fun GymHeaderShowcase() {
    Column(verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)) {
        ShowcaseSection("Standard Header") {
            GymSectionHeader(label = "Today's Plan", title = "Tue, Oct 24")
        }
        ShowcaseSection("Another Context") {
            GymSectionHeader(label = "Progress", title = "Monthly Stats")
        }
    }
}

@Composable
fun GymAvatarShowcase() {
    // Note: In a real app we would use an image painter. For showcase we'll use a placeholder or dummy.
    // Since I can't easily get a painter here without resources, I'll use a simple placeholder if I can't find one.
    // I'll skip the actual Painter usage and just show the structure expectations.
    Text("Avatar requires a Painter resource. See GymAvatar.kt implementation.", color = GymTheme.colors.textSecondary)
}
