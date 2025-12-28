package dev.ch8n.gymos.ui.dayview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ExpandCircleDown
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.foundation.GymBottomNavigation
import dev.ch8n.gymos.ui.foundation.GymCategoryHeader
import dev.ch8n.gymos.ui.foundation.GymDashedPlaceholder
import dev.ch8n.gymos.ui.foundation.GymExerciseCard
import dev.ch8n.gymos.ui.foundation.GymIconButton
import dev.ch8n.gymos.ui.foundation.GymTopBar
import kotlinx.coroutines.launch

data class ExerciseData(
    val name: String,
    val sets: Int,
    val reps: Int,
    val isCompleted: Boolean,
    val icon: ImageVector,
    val iconColor: Color
)

data class MuscleGroupData(
    val name: String,
    val exercises: List<ExerciseData>
)

data class DayData(
    val date: String,
    val isToday: Boolean,
    val muscleGroups: List<MuscleGroupData>
)

@Composable
fun DayViewPagerScreen(
    onBackClick: () -> Unit
) {
    val days = remember {
        listOf(
            DayData(
                date = "Tuesday, Oct 23",
                isToday = false,
                muscleGroups = listOf(
                    MuscleGroupData(
                        name = "Back",
                        exercises = listOf(
                            ExerciseData(
                                "Deadlift",
                                3,
                                5,
                                true,
                                Icons.Default.FitnessCenter,
                                Color(0xFFFE7F2D)
                            ),
                            ExerciseData(
                                "Pullups",
                                3,
                                10,
                                true,
                                Icons.Default.FitnessCenter,
                                Color(0xFFFE7F2D)
                            )
                        )
                    )
                )
            ),
            DayData(
                date = "Wednesday, Oct 24",
                isToday = true,
                muscleGroups = listOf(
                    MuscleGroupData(
                        name = "Chest",
                        exercises = listOf(
                            ExerciseData(
                                "Barbell Bench Press",
                                3,
                                10,
                                false,
                                Icons.Default.FitnessCenter,
                                Color(0xFFFE7F2D)
                            ),
                            ExerciseData(
                                "Incline Dumbbell Press",
                                3,
                                12,
                                false,
                                Icons.Default.FitnessCenter,
                                Color(0xFFFE7F2D)
                            )
                        )
                    ),
                    MuscleGroupData(
                        name = "Triceps",
                        exercises = listOf(
                            ExerciseData(
                                "Tricep Pushdown",
                                4,
                                15,
                                false,
                                Icons.Default.ExpandCircleDown,
                                Color(0xFFFCCA46)
                            ),
                            ExerciseData(
                                "Skullcrushers",
                                3,
                                10,
                                false,
                                Icons.Default.FitnessCenter,
                                Color(0xFFFCCA46)
                            )
                        )
                    )
                )
            ),
            DayData(
                date = "Thursday, Oct 25",
                isToday = false,
                muscleGroups = listOf(
                    MuscleGroupData(
                        name = "Legs",
                        exercises = listOf(
                            ExerciseData(
                                "Squats",
                                3,
                                8,
                                false,
                                Icons.Default.FitnessCenter,
                                Color(0xFFA1C181)
                            ),
                            ExerciseData(
                                "Leg Press",
                                3,
                                12,
                                false,
                                Icons.Default.FitnessCenter,
                                Color(0xFFA1C181)
                            )
                        )
                    )
                )
            )
        )
    }

    val pagerState = rememberPagerState(initialPage = 1, pageCount = { days.size })
    val scope = rememberCoroutineScope()

    Scaffold(
        containerColor = GymTheme.colors.background,
        topBar = {
            val currentDay = days[pagerState.currentPage]
            GymTopBar(
                title = currentDay.date,
                subtitle = if (currentDay.isToday) "Today" else null,
                navigationIcon = {
                    GymIconButton(
                        icon = Icons.Default.Close,
                        onClick = onBackClick,
                        size = GymTheme.sizes.small,
                        iconSize = GymTheme.sizes.iconSmall
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            if (pagerState.currentPage > 0) {
                                scope.launch { pagerState.animateScrollToPage(pagerState.currentPage - 1) }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ChevronLeft,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                    IconButton(
                        onClick = {
                            if (pagerState.currentPage < days.size - 1) {
                                scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /* TODO */ },
                containerColor = GymTheme.colors.primary,
                contentColor = Color.White,
                icon = { Icon(Icons.Default.Add, contentDescription = null) },
                text = {
                    Text(
                        "Add Exercise",
                        style = GymTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                },
                shape = GymTheme.shapes.full
            )
        },
        bottomBar = {
            GymBottomNavigation(
                selectedRoute = "Calendar",
                onHomeClick = onBackClick // Navigate back to home or calendar
            )
        }
    ) { padding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize().padding(padding),
            verticalAlignment = Alignment.Top
        ) { pageIndex ->
            val day = days[pageIndex]
            DayContent(day)
        }
    }
}

@Composable
fun DayContent(day: DayData) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = GymTheme.spacing.pagePadding),
        verticalArrangement = Arrangement.spacedBy(GymTheme.spacing.medium),
        contentPadding = PaddingValues(bottom = 100.dp) // Space for FAB
    ) {
        item { Spacer(modifier = Modifier.height(GymTheme.spacing.small)) }

        day.muscleGroups.forEach { muscleGroup ->
            item {
                GymCategoryHeader(
                    title = muscleGroup.name,
                    count = "${muscleGroup.exercises.size} Exercises",
                    titleColor = GymTheme.colors.quaternary
                )
            }

            items(muscleGroup.exercises) { exercise ->
                GymExerciseCard(
                    name = exercise.name,
                    sets = exercise.sets,
                    reps = exercise.reps,
                    isCompleted = exercise.isCompleted,
                    onCompletedChange = { /* TODO */ },
                    icon = exercise.icon,
                    iconColor = exercise.iconColor,
                    onClick = { /* TODO */ }
                )
            }

            item { Spacer(modifier = Modifier.height(GymTheme.spacing.medium)) }
        }

        item {
            GymDashedPlaceholder(
                text = "Tap + to add exercises",
                onClick = { /* TODO */ }
            )
        }
    }
}
