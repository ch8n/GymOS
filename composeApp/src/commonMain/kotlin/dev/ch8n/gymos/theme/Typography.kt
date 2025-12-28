package dev.ch8n.gymos.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import gymos.composeapp.generated.resources.Res
import gymos.composeapp.generated.resources.lexend
import gymos.composeapp.generated.resources.notosans
import org.jetbrains.compose.resources.Font

@Immutable
data class GymTypography(
    val displayExtraLarge: TextStyle,
    val displayLarge: TextStyle,
    val displayMedium: TextStyle,
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val displaySmall: TextStyle,
    val bodyLarge: TextStyle,
    val bodyMedium: TextStyle,
    val bodySmall: TextStyle,
    val captionBold: TextStyle,
    val caption: TextStyle,
    val tiny: TextStyle
)

@Composable
fun gymTypography(): GymTypography {
    val lexend = FontFamily(Font(Res.font.lexend))
    val notoSans = FontFamily(Font(Res.font.notosans))

    return GymTypography(
        displayExtraLarge = TextStyle(
            fontFamily = lexend,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 48.sp,
            letterSpacing = (-1).sp
        ),
        displayLarge = TextStyle(
            fontFamily = lexend,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 36.sp,
            letterSpacing = (-0.5).sp
        ),
        displayMedium = TextStyle(
            fontFamily = lexend,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            letterSpacing = (-0.5).sp
        ),
        h1 = TextStyle(
            fontFamily = lexend,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            letterSpacing = (-0.5).sp
        ),
        h2 = TextStyle(
            fontFamily = lexend,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            letterSpacing = (-0.5).sp
        ),
        h3 = TextStyle(
            fontFamily = lexend,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            letterSpacing = 0.sp
        ),
        displaySmall = TextStyle(
            fontFamily = lexend,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            letterSpacing = (-0.5).sp
        ),
        bodyLarge = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            letterSpacing = 0.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            letterSpacing = 0.sp
        ),
        bodySmall = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            letterSpacing = 0.sp
        ),
        captionBold = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            letterSpacing = 0.1.sp
        ),
        caption = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            letterSpacing = 0.sp
        ),
        tiny = TextStyle(
            fontFamily = notoSans,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
            letterSpacing = 0.1.sp
        )
    )
}

val LocalGymTypography = staticCompositionLocalOf<GymTypography> {
    error("No GymTypography provided")
}
