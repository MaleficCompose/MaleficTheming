package xyz.malefic.compose.theming.util

import xyz.malefic.compose.theming.ThemeConfig
import java.io.InputStream

/**
 * JVM implementation of PlatformFileReader.
 */
actual class PlatformFileReader {
    /**
     * Reads text content from a JVM resource or file using InputStream.
     *
     * @param resourcePath The path to the resource or file.
     * @return The text content of the resource or file.
     */
    actual fun readText(resourcePath: String): String {
        require(resourcePath.isNotBlank()) { "Resource path must not be empty or blank." }
        val inputStream: InputStream =
            this::class.java.getResourceAsStream(resourcePath)
                ?: throw IllegalArgumentException("Resource not found: $resourcePath")
        return inputStream.bufferedReader().use { it.readText() }
    }
}

/**
 * JVM-specific function to load theme from InputStream for backward compatibility.
 *
 * @param inputStream The InputStream containing the theme configuration.
 * @return A ThemeConfig object representing the loaded theme configuration.
 * @throws IllegalArgumentException If the JSON file contains invalid color hex strings.
 */
fun loadThemeFromJson(inputStream: InputStream): ThemeConfig {
    val jsonContent = inputStream.bufferedReader().use { it.readText() }
    return loadThemeFromJsonString(jsonContent)
}
