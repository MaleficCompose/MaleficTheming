@file:Suppress("ktlint:standard:function-naming")

package xyz.malefic.compose.theming

import androidx.compose.runtime.Composable
import xyz.malefic.compose.theming.util.loadThemeFromJson
import java.io.InputStream

/**
 * JVM-specific extension for loading a theme configuration from an InputStream and applying the Malefic theme.
 * This function is provided for backward compatibility with JVM/Desktop applications.
 *
 * @param inputStream The InputStream containing the theme configuration.
 * @param content The composable content to which the theme will be applied.
 */
@Composable
fun MaleficTheme(
    inputStream: InputStream,
    content: @Composable () -> Unit,
) {
    val themeConfig = loadThemeFromJson(inputStream)
    MaleficTheme(themeConfig, content)
}