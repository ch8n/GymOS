package dev.ch8n.gymos.ui.exercise

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Whatshot
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.GymActionCard
import dev.ch8n.gymos.ui.foundation.GymBottomNavigation
import dev.ch8n.gymos.ui.foundation.GymChip
import dev.ch8n.gymos.ui.foundation.GymExerciseSelectionItem
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymSectionHeader
import dev.ch8n.gymos.ui.foundation.GymTextField
import dev.ch8n.gymos.ui.foundation.GymTopBar

@Composable
fun AddExerciseScreen(
    onBackClick: () -> Unit,
    onCustomExerciseClick: () -> Unit,
    onHomeClick: () -> Unit,
    onCalendarClick: () -> Unit,
    onProgressClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }

    Scaffold(
        containerColor = GymTheme.colors.background,
        topBar = {
            GymTopBar(
                title = "Add Exercise",
                navigationIcon = {
                    GymIconButton(
                        icon = Icons.Default.Close,
                        onClick = onBackClick
                    )
                }
            )
        },
        bottomBar = {
            GymBottomNavigation(
                selectedRoute = "Calendar",
                onHomeClick = onHomeClick,
                onCalendarClick = onCalendarClick,
                onProgressClick = onProgressClick,
                onProfileClick = onProfileClick
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Search and Create Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = GymTheme.spacing.pagePadding),
                verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium)
            ) {
                GymTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = "Search bench press, squat...",
                    leadingIcon = Icons.Default.Search
                )

                GymActionCard(
                    text = "Create Custom Exercise",
                    icon = Icons.Default.Edit,
                    onClick = onCustomExerciseClick,
                    isDashed = true
                )
            }

            Spacer(modifier = Modifier.height(GymTheme.spacing.large))

            // Category Tabs
            CategoryTabs(
                selectedCategory = selectedCategory,
                onCategorySelected = { selectedCategory = it }
            )

            Spacer(modifier = Modifier.height(GymTheme.spacing.medium))

            // Exercise List
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    bottom = GymTheme.spacing.large
                ),
                verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.small)
            ) {
                item {
                    GymSectionHeader(
                        title = "Recent",
                        icon = Icons.Default.History,
                        modifier = Modifier.padding(horizontal = GymTheme.spacing.pagePadding)
                    )
                }

                items(recentExercises) { exercise ->
                    GymExerciseSelectionItem(
                        name = exercise.name,
                        category = exercise.category,
                        equipment = exercise.equipment,
                        initials = exercise.initials,
                        onAddClick = { /* Handle Add */ },
                        onItemClick = { /* Handle Click */ },
                        avatarColor = exercise.color,
                        modifier = Modifier.padding(horizontal = GymTheme.spacing.small)
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(GymTheme.spacing.medium))
                    GymSectionHeader(
                        title = "Popular Exercises",
                        icon = Icons.Default.Whatshot,
                        modifier = Modifier.padding(horizontal = GymTheme.spacing.pagePadding)
                    )
                }

                items(popularExercises) { exercise ->
                    GymExerciseSelectionItem(
                        name = exercise.name,
                        category = exercise.category,
                        equipment = exercise.equipment,
                        initials = exercise.initials,
                        onAddClick = { /* Handle Add */ },
                        onItemClick = { /* Handle Click */ },
                        avatarColor = exercise.color,
                        modifier = Modifier.padding(horizontal = GymTheme.spacing.small)
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryTabs(
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    val categories = listOf("All", "Chest", "Back", "Legs", "Shoulders", "Arms", "Core")
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(GymTheme.spacing.small),
        contentPadding = PaddingValues(horizontal = GymTheme.spacing.pagePadding)
    ) {
        items(categories) { category ->
            val isSelected = category == selectedCategory
            GymChip(
                text = category,
                backgroundColor = if (isSelected) GymTheme.colors.primary else GymTheme.colors.surfaceHighlight,
                contentColor = if (isSelected) GymTheme.colors.background else GymTheme.colors.textPrimary,
                modifier = Modifier.clickable { onCategorySelected(category) }
            )
        }
    }
}

private data class ExerciseMock(
    val name: String,
    val category: String,
    val equipment: String,
    val initials: String,
    val color: androidx.compose.ui.graphics.Color
)

private val recentExercises = listOf(
    ExerciseMock("Barbell Bench Press", "Chest", "Barbell", "BP", Color(0xFF619B8A)),
    ExerciseMock("Dumbbell Row", "Back", "Dumbbell", "DR", Color(0xFFFCCA46))
)

private val popularExercises = listOf(
    ExerciseMock("Barbell Squat", "Legs", "Barbell", "BS", Color(0xFFFE7F2D)),
    ExerciseMock("Deadlift", "Back", "Barbell", "DL", Color(0xFFA1C181)),
    ExerciseMock("Military Press", "Shoulders", "Barbell", "MP", Color(0xFF619B8A)),
    ExerciseMock("Pull Ups", "Back", "Bodyweight", "PU", Color(0xFFFCCA46))
)
