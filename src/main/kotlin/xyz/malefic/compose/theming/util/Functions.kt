package xyz.malefic.compose.theming.util

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.json.Json
import xyz.malefic.compose.theming.SerializableThemeConfig
import xyz.malefic.compose.theming.ThemeConfig
import java.io.InputStream

/**
 * Loads a theme configuration from a JSON input stream.
 *
 * @param inputStream The input stream containing the JSON theme configuration.
 * @return A ThemeConfig object representing the loaded theme configuration.
 * @throws IllegalArgumentException If the JSON file contains invalid color hex strings.
 */
fun loadThemeFromJson(inputStream: InputStream): ThemeConfig {
    val jsonContent = inputStream.bufferedReader().use { it.readText() }
    val parsedConfig: SerializableThemeConfig = Json.decodeFromString(jsonContent)
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
 * Parses a hex color string and returns a Color object.
 *
 * @param hex The hex color string to parse. It can be in the format of #RRGGBB or #AARRGGBB.
 * @return A Color object representing the parsed color.
 * @throws IllegalArgumentException If the hex string is not in a valid format.
 */
fun parseHexColor(hex: String): Color {
    val cleanedHex = hex.removePrefix("#")
    return when (cleanedHex.length) {
        6 -> {
            // If 6 characters (RGB), prepend alpha value (FF for full opacity)
            val colorValue = cleanedHex.toLong(16) or (0xFF000000)
            Color(colorValue.toInt())
        }
        8 -> {
            // If 8 characters (ARGB), parse directly
            val colorValue = cleanedHex.toLong(16)
            Color(colorValue.toInt())
        }
        else -> throw IllegalArgumentException("Invalid color hex string: $hex")
    }
}
