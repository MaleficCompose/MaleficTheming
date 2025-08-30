package xyz.malefic.compose.theming.util

import androidx.compose.ui.graphics.Color

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
