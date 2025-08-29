package xyz.malefic.compose.theming.util

/**
 * Platform-specific file reader for loading theme configurations.
 */
expect class PlatformFileReader {
    /**
     * Reads text content from a platform-specific resource or file.
     *
     * @param resourcePath The path to the resource or file.
     * @return The text content of the resource or file.
     */
    fun readText(resourcePath: String): String
}

/**
 * Loads a theme configuration from a JSON string.
 *
 * @param jsonContent The JSON string containing the theme configuration.
 * @return A ThemeConfig object representing the loaded theme configuration.
 * @throws IllegalArgumentException If the JSON file contains invalid color hex strings.
 */
fun loadThemeFromJsonString(jsonContent: String): ThemeConfig {
    val parsedConfig: SerializableThemeConfig = kotlinx.serialization.json.Json.decodeFromString(jsonContent)
    return ThemeConfig(
        primary = parseHexColor(parsedConfig.primary),
        primaryVariant = parseHexColor(parsedConfig.primaryVariant),
        secondary = parseHexColor(parsedConfig.secondary),
        secondaryVariant = parseHexColor(parsedConfig.secondaryVariant),
        background = parseHexColor(parsedConfig.background),
        surface = parseHexColor(parsedConfig.surface),
        error = parseHexColor(parsedConfig.error),
        onPrimary = parseHexColor(parsedConfig.onPrimary),
        onSecondary = parseHexColor(parsedConfig.onSecondary),
        onBackground = parseHexColor(parsedConfig.onBackground),
        onSurface = parseHexColor(parsedConfig.onSurface),
        onError = parseHexColor(parsedConfig.onError),
        isLight = parsedConfig.isLight,
    )
}

/**
 * Loads a theme configuration from a platform-specific resource path.
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