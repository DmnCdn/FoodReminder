package com.example.foodreminder.ui.common.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = colorPrimaryDark,
    onPrimary = colorOnPrimaryDark,
    primaryContainer = colorPrimaryContainerDark,
    onPrimaryContainer = colorOnPrimaryContainerDark,
    secondary = colorSecondaryDark,
    onSecondary = colorOnSecondaryDark,
    secondaryContainer = colorSecondaryContainerDark,
    onSecondaryContainer = colorOnSecondaryContainerDark,
    tertiary = colorTertiaryDark,
    onTertiary = colorOnTertiaryDark,
    tertiaryContainer = colorTertiaryContainerDark,
    onTertiaryContainer = colorOnTertiaryContainerDark,
    background = colorBackgroundDark,
    onBackground = colorOnBackgroundDark,
    surface = colorSurfaceDark,
    onSurface = colorOnSurfaceDark,
    surfaceVariant = colorSurfaceVariantDark,
    onSurfaceVariant = colorOnSurfaceVariantDark,
    surfaceTint = colorSurfaceDark,
    error = colorErrorDark,
    onError = colorOnErrorDark,
    errorContainer = colorErrorContainerDark,
    onErrorContainer = colorOnErrorContainerDark,
    outline = colorOutlineDark,
)

private val LightColorScheme = lightColorScheme(
    primary = colorPrimaryLight,
    onPrimary = colorOnPrimaryLight,
    primaryContainer = colorPrimaryContainerLight,
    onPrimaryContainer = colorOnPrimaryContainerLight,
    secondary = colorSecondaryLight,
    onSecondary = colorOnSecondaryLight,
    secondaryContainer = colorSecondaryContainerLight,
    onSecondaryContainer = colorOnSecondaryContainerLight,
    tertiary = colorTertiaryLight,
    onTertiary = colorOnTertiaryLight,
    tertiaryContainer = colorTertiaryContainerLight,
    onTertiaryContainer = colorOnTertiaryContainerLight,
    background = colorBackgroundLight,
    onBackground = colorOnBackgroundLight,
    surface = colorSurfaceLight,
    onSurface = colorOnSurfaceLight,
    surfaceVariant = colorSurfaceVariantLight,
    onSurfaceVariant = colorOnSurfaceVariantLight,
    surfaceTint = colorSurfaceLight,
    error = colorErrorLight,
    onError = colorOnErrorLight,
    errorContainer = colorErrorContainerLight,
    onErrorContainer = colorOnErrorContainerLight,
    outline = colorOutlineLight,
)

@Composable
fun FoodReminderTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}