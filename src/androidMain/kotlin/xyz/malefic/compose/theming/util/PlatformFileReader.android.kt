package xyz.malefic.compose.theming.util

import android.content.Context

/**
 * Android implementation of PlatformFileReader.
 */
actual class PlatformFileReader {
    companion object {
        /**
         * Global context for accessing Android resources.
         * Must be set before using readText() method.
         */
        @Volatile
        var context: Context? = null
    }

    /**
     * Reads text content from an Android asset or resource file.
     * For Android, this function reads from the assets folder.
     *
     * Note: The global context must be set using PlatformFileReader.context = yourContext
     * before calling this method.
     *
     * @param resourcePath The path to the asset file (e.g., "themes/light.json").
     * @return The text content of the asset file.
     * @throws IllegalArgumentException If the asset is not found or context is not set.
     */
    actual fun readText(resourcePath: String): String {
        val ctx =
            context ?: throw IllegalArgumentException(
                "Context not set. Please set PlatformFileReader.context before using this method. " +
                    "Alternatively, use loadThemeFromJsonString() and provide the JSON content directly.",
            )

        return try {
            ctx.assets
                .open(resourcePath)
                .bufferedReader()
                .use { it.readText() }
        } catch (e: Exception) {
            throw IllegalArgumentException(
                "Failed to read asset: $resourcePath. Make sure the file exists in the assets folder.",
                e,
            )
        }
    }
}

/**
 * Android-specific helper function to read theme from assets with context.
 *
 * @param context The Android context for accessing assets.
 * @param assetPath The path to the asset file containing the theme configuration.
 * @return The text content of the asset file.
 * @throws IllegalArgumentException If the asset is not found.
 */
fun readThemeAsset(
    context: Context,
    assetPath: String,
): String =
    try {
        context.assets
            .open(assetPath)
            .bufferedReader()
            .use { it.readText() }
    } catch (e: Exception) {
        throw IllegalArgumentException(
            "Failed to read asset: $assetPath. Make sure the file exists in the assets folder.",
            e,
        )
    }
