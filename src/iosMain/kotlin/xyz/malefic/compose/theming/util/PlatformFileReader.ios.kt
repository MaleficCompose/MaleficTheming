package xyz.malefic.compose.theming.util

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCObjectVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import platform.Foundation.NSBundle
import platform.Foundation.NSError
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.stringWithContentsOfFile

/**
 * iOS implementation of PlatformFileReader.
 */
actual class PlatformFileReader {
    /**
     * Reads text content from an iOS bundle resource.
     *
     * @param resourcePath The path to the resource file (e.g., "light.json").
     * @return The text content of the resource file.
     * @throws IllegalArgumentException If the resource is not found.
     */
    actual fun readText(resourcePath: String): String {
        val pathComponents = resourcePath.split(".")
        val fileName =
            if (pathComponents.size > 1) {
                pathComponents.dropLast(1).joinToString(".")
            } else {
                resourcePath
            }
        val fileExtension =
            if (pathComponents.size > 1) {
                pathComponents.last()
            } else {
                "json"
            }
        return readBundleResource(fileName, fileExtension)
    }
}

/**
 * iOS-specific helper function to read theme from bundle resources.
 *
 * @param resourceName The name of the resource file (without extension).
 * @param fileExtension The file extension (e.g., "json").
 * @return The text content of the resource file.
 * @throws IllegalArgumentException If the resource is not found.
 */
@OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
fun readBundleResource(
    resourceName: String,
    fileExtension: String = "json",
): String {
    val bundle = NSBundle.mainBundle
    val path =
        bundle.pathForResource(resourceName, fileExtension)
            ?: throw IllegalArgumentException(
                "Resource not found: $resourceName.$fileExtension. Make sure the file is included in the iOS bundle.",
            )

    return memScoped {
        val errorPtr = alloc<ObjCObjectVar<NSError?>>()
        val content =
            NSString.stringWithContentsOfFile(
                path,
                encoding = NSUTF8StringEncoding,
                error = errorPtr.ptr,
            )

        if (content != null) {
            content
        } else {
            val error = errorPtr.value
            throw IllegalArgumentException(
                "Failed to read resource: $resourceName.$fileExtension. Error: ${error?.localizedDescription}",
            )
        }
    }
}
