package xyz.malefic.compose.theming.util

/**
 * iOS implementation of PlatformFileReader.
 */
actual class PlatformFileReader {
    /**
     * Reads text content from an iOS bundle resource.
     * For iOS, this function assumes the resource is in the main bundle.
     *
     * @param resourcePath The path to the resource file (e.g., "light.json").
     * @return The text content of the resource file.
     * @throws IllegalArgumentException If the resource is not found.
     */
    actual fun readText(resourcePath: String): String {
        // For iOS, this is a placeholder implementation.
        // In practice, you would use NSBundle to read resources:
        // val bundle = NSBundle.mainBundle()
        // val path = bundle.pathForResource(resourceName, ofType: "json")
        // val content = NSString.stringWithContentsOfFile(path!!, encoding = NSUTF8StringEncoding, error = null)

        // For now, we'll throw an exception suggesting the use of loadThemeFromJsonString instead
        throw IllegalArgumentException(
            "Direct resource loading is not supported on iOS platform. " +
                "Please use loadThemeFromJsonString() and provide the JSON content directly, " +
                "or read the file content using iOS NSBundle and pass it to the function.",
        )
    }
}
