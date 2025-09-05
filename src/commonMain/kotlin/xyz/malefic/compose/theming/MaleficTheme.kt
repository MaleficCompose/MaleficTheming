package xyz.malefic.compose.theming

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import xyz.malefic.compose.theming.util.loadThemeFromJsonString
import xyz.malefic.compose.theming.util.loadThemeFromResource

/**
 * Creates a simple Material 3 theme configuration with basic colors.
 * 
 * This is a convenience function for easier migration from Material 2.
 * It creates a complete Material 3 color scheme with sensible defaults.
 * 
 * @param primary The primary color
 * @param secondary The secondary color  
 * @param background The background color
 * @param surface The surface color
 * @param error The error color
 * @param onPrimary Color used on primary
 * @param onSecondary Color used on secondary
 * @param onBackground Color used on background
 * @param onSurface Color used on surface
 * @param onError Color used on error
 * @return A complete ThemeConfig for Material 3
 */
fun createSimpleThemeConfig(
    primary: Color,
    secondary: Color,
    background: Color,
    surface: Color,
    error: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    onSurface: Color,
    onError: Color,
): ThemeConfig = ThemeConfig(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primary, // Default to same as primary
    onPrimaryContainer = onPrimary,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondary, // Default to same as secondary
    onSecondaryContainer = onSecondary,
    tertiary = secondary, // Default to secondary
    onTertiary = onSecondary,
    tertiaryContainer = secondary,
    onTertiaryContainer = onSecondary,
    error = error,
    onError = onError,
    errorContainer = error,
    onErrorContainer = onError,
    background = background,
    onBackground = onBackground,
    surface = surface,
    onSurface = onSurface,
    surfaceVariant = surface,
    onSurfaceVariant = onSurface,
    surfaceTint = primary,
    outline = onSurface.copy(alpha = 0.12f),
    outlineVariant = onSurface.copy(alpha = 0.06f),
    scrim = Color.Black,
    inverseSurface = onSurface,
    inverseOnSurface = surface,
    inversePrimary = primary,
    surfaceDim = surface,
    surfaceBright = surface,
    surfaceContainerLowest = surface,
    surfaceContainerLow = surface,
    surfaceContainer = surface,
    surfaceContainerHigh = surface,
    surfaceContainerHighest = surface,
)

/**
 * Applies the Malefic theme using Material 3 design to the given content.
 *
 * @param themeConfig The configuration for the theme.
 * @param content The composable content to which the theme will be applied.
 */
@Composable
fun MaleficTheme(
    themeConfig: ThemeConfig,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = ColorScheme(
            primary = themeConfig.primary,
            onPrimary = themeConfig.onPrimary,
            primaryContainer = themeConfig.primaryContainer,
            onPrimaryContainer = themeConfig.onPrimaryContainer,
            inversePrimary = themeConfig.inversePrimary,
            secondary = themeConfig.secondary,
            onSecondary = themeConfig.onSecondary,
            secondaryContainer = themeConfig.secondaryContainer,
            onSecondaryContainer = themeConfig.onSecondaryContainer,
            tertiary = themeConfig.tertiary,
            onTertiary = themeConfig.onTertiary,
            tertiaryContainer = themeConfig.tertiaryContainer,
            onTertiaryContainer = themeConfig.onTertiaryContainer,
            background = themeConfig.background,
            onBackground = themeConfig.onBackground,
            surface = themeConfig.surface,
            onSurface = themeConfig.onSurface,
            surfaceVariant = themeConfig.surfaceVariant,
            onSurfaceVariant = themeConfig.onSurfaceVariant,
            surfaceTint = themeConfig.surfaceTint,
            inverseSurface = themeConfig.inverseSurface,
            inverseOnSurface = themeConfig.inverseOnSurface,
            error = themeConfig.error,
            onError = themeConfig.onError,
            errorContainer = themeConfig.errorContainer,
            onErrorContainer = themeConfig.onErrorContainer,
            outline = themeConfig.outline,
            outlineVariant = themeConfig.outlineVariant,
            scrim = themeConfig.scrim,
            surfaceBright = themeConfig.surfaceBright,
            surfaceDim = themeConfig.surfaceDim,
            surfaceContainer = themeConfig.surfaceContainer,
            surfaceContainerHigh = themeConfig.surfaceContainerHigh,
            surfaceContainerHighest = themeConfig.surfaceContainerHighest,
            surfaceContainerLow = themeConfig.surfaceContainerLow,
            surfaceContainerLowest = themeConfig.surfaceContainerLowest,
        ),
        typography = MaterialTheme.typography,
        shapes = MaterialTheme.shapes,
        content = content,
    )
}

/**
 * Loads a theme configuration from a JSON string and applies the Malefic theme to the given
 * content.
 *
 * @param jsonContent The JSON string containing the theme configuration.
 * @param content The composable content to which the theme will be applied.
 */
@Composable
fun MaleficThemeFromJson(
    jsonContent: String,
    content: @Composable () -> Unit,
) {
    val themeConfig = loadThemeFromJsonString(jsonContent)
    MaleficTheme(themeConfig, content)
}

/**
 * Loads a theme configuration from a platform-specific resource and applies the Malefic theme to the given
 * content.
 *
 * @param resourcePath The path to the resource containing the theme configuration.
 * @param content The composable content to which the theme will be applied.
 */
@Composable
fun MaleficThemeFromResource(
    resourcePath: String,
    content: @Composable () -> Unit,
) {
    val themeConfig = loadThemeFromResource(resourcePath)
    MaleficTheme(themeConfig, content)
}
