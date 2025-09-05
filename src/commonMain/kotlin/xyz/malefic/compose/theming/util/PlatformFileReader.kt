package xyz.malefic.compose.theming.util

import kotlinx.serialization.json.Json
import xyz.malefic.compose.theming.SerializableThemeConfig
import xyz.malefic.compose.theming.ThemeConfig

/**
 * Platform-specific file reader for loading theme configurations.
 */
expect class PlatformFileReader() {
    /**
     * Reads text content from a platform-specific resource or file.
     *
     * @param resourcePath The path to the resource or file.
     * @return The text content of the resource or file.
     */
    fun readText(resourcePath: String): String
}

/**
 * Loads a theme configuration from a JSON string using Material 3 color scheme.
 *
 * @param jsonContent The JSON string containing the theme configuration.
 * @return A ThemeConfig object representing the loaded theme configuration.
 * @throws IllegalArgumentException If the JSON file contains invalid color hex strings.
 */
fun loadThemeFromJsonString(jsonContent: String): ThemeConfig {
    val parsedConfig: SerializableThemeConfig = Json.decodeFromString(jsonContent)
    return ThemeConfig(
        primary = parseHexColor(parsedConfig.primary),
        onPrimary = parseHexColor(parsedConfig.onPrimary),
        primaryContainer = parseHexColor(parsedConfig.primaryContainer),
        onPrimaryContainer = parseHexColor(parsedConfig.onPrimaryContainer),
        secondary = parseHexColor(parsedConfig.secondary),
        onSecondary = parseHexColor(parsedConfig.onSecondary),
        secondaryContainer = parseHexColor(parsedConfig.secondaryContainer),
        onSecondaryContainer = parseHexColor(parsedConfig.onSecondaryContainer),
        tertiary = parseHexColor(parsedConfig.tertiary),
        onTertiary = parseHexColor(parsedConfig.onTertiary),
        tertiaryContainer = parseHexColor(parsedConfig.tertiaryContainer),
        onTertiaryContainer = parseHexColor(parsedConfig.onTertiaryContainer),
        error = parseHexColor(parsedConfig.error),
        onError = parseHexColor(parsedConfig.onError),
        errorContainer = parseHexColor(parsedConfig.errorContainer),
        onErrorContainer = parseHexColor(parsedConfig.onErrorContainer),
        background = parseHexColor(parsedConfig.background),
        onBackground = parseHexColor(parsedConfig.onBackground),
        surface = parseHexColor(parsedConfig.surface),
        onSurface = parseHexColor(parsedConfig.onSurface),
        surfaceVariant = parseHexColor(parsedConfig.surfaceVariant),
        onSurfaceVariant = parseHexColor(parsedConfig.onSurfaceVariant),
        surfaceTint = parseHexColor(parsedConfig.surfaceTint),
        outline = parseHexColor(parsedConfig.outline),
        outlineVariant = parseHexColor(parsedConfig.outlineVariant),
        scrim = parseHexColor(parsedConfig.scrim),
        inverseSurface = parseHexColor(parsedConfig.inverseSurface),
        inverseOnSurface = parseHexColor(parsedConfig.inverseOnSurface),
        inversePrimary = parseHexColor(parsedConfig.inversePrimary),
        surfaceDim = parseHexColor(parsedConfig.surfaceDim),
        surfaceBright = parseHexColor(parsedConfig.surfaceBright),
        surfaceContainerLowest = parseHexColor(parsedConfig.surfaceContainerLowest),
        surfaceContainerLow = parseHexColor(parsedConfig.surfaceContainerLow),
        surfaceContainer = parseHexColor(parsedConfig.surfaceContainer),
        surfaceContainerHigh = parseHexColor(parsedConfig.surfaceContainerHigh),
        surfaceContainerHighest = parseHexColor(parsedConfig.surfaceContainerHighest),
    )
}

/**
 * Loads a theme configuration from a platform-specific resource path using Material 3 color scheme.
 *
 * @param resourcePath The path to the resource containing the JSON theme configuration.
 * @return A ThemeConfig object representing the loaded theme configuration.
 * @throws IllegalArgumentException If the JSON file contains invalid color hex strings.
 */
fun loadThemeFromResource(resourcePath: String): ThemeConfig {
    val fileReader = PlatformFileReader()
    val jsonContent = fileReader.readText(resourcePath)
    return loadThemeFromJsonString(jsonContent)
}
