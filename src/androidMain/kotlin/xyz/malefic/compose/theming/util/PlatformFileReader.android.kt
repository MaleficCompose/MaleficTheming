package xyz.malefic.compose.theming.util

/**
 * Android implementation of PlatformFileReader.
 */
actual class PlatformFileReader {
    /**
     * Reads text content from an Android asset or resource file.
     * For Android, this function assumes the resource is an asset in the assets folder.
     *
     * Note: In a real Android application, you would typically pass a Context
     * to access assets. For a library, consider using the resource path approach
     * or requiring the caller to provide the content directly.
     *
     * @param resourcePath The path to the asset file (e.g., "themes/light.json").
     * @return The text content of the asset file.
     * @throws IllegalArgumentException If the asset is not found.
     */
    actual fun readText(resourcePath: String): String {
        // For Android, this is a placeholder implementation.
        // In practice, you would need a Context to read from assets:
        // context.assets.open(resourcePath).bufferedReader().use { it.readText() }

        // For now, we'll throw an exception suggesting the use of loadThemeFromJsonString instead
        throw IllegalArgumentException(
            "Direct resource loading is not supported on Android platform. " +
                "Please use loadThemeFromJsonString() and provide the JSON content directly, " +
                "or read the file content using Android Context.assets and pass it to the function.",
        )
    }
}
