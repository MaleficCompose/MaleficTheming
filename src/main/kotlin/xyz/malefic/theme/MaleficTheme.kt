package xyz.malefic.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import xyz.malefic.theme.util.loadThemeFromJson

/**
 * Applies the Malefic theme to the given content.
 *
 * @param themeConfig The configuration for the theme.
 * @param content The composable content to which the theme will be applied.
 */
@Composable
fun MaleficTheme(themeConfig: ThemeConfig, content: @Composable () -> Unit) {
  MaterialTheme(
    colors =
      MaterialTheme.colors.copy(
        primary = themeConfig.primary,
        primaryVariant = themeConfig.primaryVariant,
        secondary = themeConfig.secondary,
        secondaryVariant = themeConfig.secondaryVariant,
        background = themeConfig.background,
        surface = themeConfig.surface,
        error = themeConfig.error,
        onPrimary = themeConfig.onPrimary,
        onSecondary = themeConfig.onSecondary,
        onBackground = themeConfig.onBackground,
        onSurface = themeConfig.onSurface,
        onError = themeConfig.onError,
        isLight = themeConfig.isLight,
      ),
    typography = MaterialTheme.typography,
    shapes = MaterialTheme.shapes,
    content = content,
  )
}

/**
 * Loads a theme configuration from a JSON file and applies the Malefic theme to the given content.
 *
 * @param filePath The path to the JSON file containing the theme configuration.
 * @param content The composable content to which the theme will be applied.
 */
@Composable
fun MaleficTheme(filePath: String, content: @Composable () -> Unit) {
  val themeConfig = loadThemeFromJson(filePath)
  MaleficTheme(themeConfig, content)
}
