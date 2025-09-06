package xyz.malefic.compose.theming.util

import android.content.Context

/**
 * Android implementation of PlatformFileReader.
 *
 * Usage example:
 * ```kotlin
 * // Obtain the Application Context (never use Activity or Fragment context)
 * val appContext = applicationContext
 *
 * // Create and initialize the reader
 * val reader = PlatformFileReader()
 * reader.init(appContext)
 *
 * // Read a file from assets
 * val themeJson = reader.readText("themes/light.json")
 * ```
 *
 * Note:
 * - You must call [init] with the Application Context before using [readText].
 * - Never use an Activity or Fragment context to avoid memory leaks.
 * - [readText] will throw an [IllegalStateException] if [init] was not called.
 */
actual class PlatformFileReader {
    /**
     * Holds the Application Context. Must be initialized before use.
     * Never use Activity or Fragment context to avoid memory leaks.
     */
    private var context: Context? = null

    /**
     * Initializes the PlatformFileReader with an Application Context.
     *
     * @param context The Application Context (never Activity/Fragment).
     */
    fun init(context: Context) {
        this.context = context.applicationContext
    }

    /**
     * Reads text content from an Android asset or resource file.
     * For Android, this function reads from the assets folder.
     *
     * @param resourcePath The path to the asset file (e.g., "themes/light.json").
     * @return The text content of the asset file.
     * @throws IllegalArgumentException If the asset is not found or context is not initialized.
     */
    actual fun readText(resourcePath: String): String =
        readThemeAsset(
            context ?: throw IllegalStateException(
                "PlatformFileReader not initialized. Call init(context) with Application Context before use.",
            ),
            resourcePath,
        )
}

/**
 * Android-specific helper function to read theme from assets with context.
 *
 * Usage example:
 * ```kotlin
 * val themeJson = readThemeAsset(applicationContext, "themes/light.json")
 * ```
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
        val inputStream = context.assets.open(assetPath)
        inputStream.bufferedReader().use { it.readText() }
    } catch (e: Exception) {
        throw IllegalArgumentException(
            "Failed to read asset: $assetPath. Make sure the file exists in the assets folder.",
            e,
        )
    }
