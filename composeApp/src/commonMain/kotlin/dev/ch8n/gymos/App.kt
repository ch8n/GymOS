package dev.ch8n.gymos

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.ch8n.gymos.theme.GymTheme
import dev.ch8n.gymos.ui.showcase.ComponentShowcaseScreen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import gymos.composeapp.generated.resources.Res
import gymos.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    var showShowcase by remember { mutableStateOf(false) }

    if (showShowcase) {
        ComponentShowcaseScreen()
    } else {
        GymTheme {
            var showContent by remember { mutableStateOf(false) }
            Column(
                modifier = Modifier
                    .background(GymTheme.colors.background)
                    .safeContentPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(
                    onClick = { showShowcase = true },
                    modifier = Modifier.padding(vertical = GymTheme.spacing.medium)
                ) {
                    Text(
                        text = "Open Component Showcase",
                        style = GymTheme.typography.captionBold,
                        color = GymTheme.colors.textPrimary
                    )
                }

                Button(
                    onClick = { showContent = !showContent },
                    modifier = Modifier.padding(vertical = GymTheme.spacing.medium)
                ) {
                    Text(
                        text = "Click me!",
                        style = GymTheme.typography.captionBold,
                        color = GymTheme.colors.textPrimary
                    )
                }
                AnimatedVisibility(showContent) {
                    val greeting = remember { Greeting().greet() }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.compose_multiplatform),
                            contentDescription = null
                        )
                        Text(
                            text = "Compose: $greeting",
                            color = GymTheme.colors.primary,
                            style = GymTheme.typography.h1
                        )
                    }
                }
            }
        }
    }
}