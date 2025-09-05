package xyz.malefic.compose.theming

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import xyz.malefic.compose.theming.util.loadThemeFromJsonString
import xyz.malefic.compose.theming.util.loadThemeFromResource

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
