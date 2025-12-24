package xyz.malefic.compose.theming

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable

/**
 * Data class representing the theme configuration for the application using Material 3 color scheme.
 *
 * @property primary The primary color of the theme.
 * @property onPrimary The color used for text and icons displayed on top of the primary color.
 * @property primaryContainer The primary container color of the theme.
 * @property onPrimaryContainer The color used for text and icons displayed on top of the primary container.
 * @property secondary The secondary color of the theme.
 * @property onSecondary The color used for text and icons displayed on top of the secondary color.
 * @property secondaryContainer The secondary container color of the theme.
 * @property onSecondaryContainer The color used for text and icons displayed on top of the secondary container.
 * @property tertiary The tertiary color of the theme.
 * @property onTertiary The color used for text and icons displayed on top of the tertiary color.
 * @property tertiaryContainer The tertiary container color of the theme.
 * @property onTertiaryContainer The color used for text and icons displayed on top of the tertiary container.
 * @property error The error color of the theme.
 * @property onError The color used for text and icons displayed on top of the error color.
 * @property errorContainer The error container color of the theme.
 * @property onErrorContainer The color used for text and icons displayed on top of the error container.
 * @property background The background color of the theme.
 * @property onBackground The color used for text and icons displayed on top of the background color.
 * @property surface The surface color of the theme.
 * @property onSurface The color used for text and icons displayed on top of the surface color.
 * @property surfaceTint The surface tint color of the theme.
 * @property surfaceVariant The surface variant color of the theme.
 * @property onSurfaceVariant The color used for text and icons displayed on top of the surface variant.
 * @property outline The outline color of the theme.
 * @property outlineVariant The outline variant color of the theme.
 * @property scrim The scrim color of the theme.
 * @property inverseSurface The inverse surface color of the theme.
 * @property inverseOnSurface The color used for text and icons displayed on top of the inverse surface.
 * @property inversePrimary The inverse primary color of the theme.
 * @property surfaceDim The dim surface color of the theme.
 * @property surfaceBright The bright surface color of the theme.
 * @property surfaceContainerLowest The lowest surface container color of the theme.
 * @property surfaceContainerLow The low surface container color of the theme.
 * @property surfaceContainer The surface container color of the theme.
 * @property surfaceContainerHigh The high surface container color of the theme.
 * @property surfaceContainerHighest The highest surface container color of the theme.
 * @property primaryFixed The primary fixed color of the theme.
 * @property primaryFixedDim The dim primary fixed color of the theme.
 * @property onPrimaryFixed The color used for text and icons displayed on top of the primary fixed color.
 * @property onPrimaryFixedVariant The color used for text and icons displayed on top of the primary fixed variant.
 * @property secondaryFixed The secondary fixed color of the theme.
 * @property secondaryFixedDim The dim secondary fixed color of the theme.
 * @property onSecondaryFixed The color used for text and icons displayed on top of the secondary fixed color.
 * @property onSecondaryFixedVariant The color used for text and icons displayed on top of the secondary fixed variant.
 * @property tertiaryFixed The tertiary fixed color of the theme.
 * @property tertiaryFixedDim The dim tertiary fixed color of the theme.
 * @property onTertiaryFixed The color used for text and icons displayed on top of the tertiary fixed color.
 * @property onTertiaryFixedVariant The color used for text and icons displayed on top of the tertiary fixed variant.
 */
data class ThemeConfig(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val secondary: Color,
    val onSecondary: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,
    val tertiary: Color,
    val onTertiary: Color,
    val tertiaryContainer: Color,
    val onTertiaryContainer: Color,
    val error: Color,
    val onError: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val surfaceVariant: Color,
    val onSurfaceVariant: Color,
    val surfaceTint: Color,
    val outline: Color,
    val outlineVariant: Color,
    val scrim: Color,
    val inverseSurface: Color,
    val inverseOnSurface: Color,
    val inversePrimary: Color,
    val surfaceDim: Color,
    val surfaceBright: Color,
    val surfaceContainerLowest: Color,
    val surfaceContainerLow: Color,
    val surfaceContainer: Color,
    val surfaceContainerHigh: Color,
    val surfaceContainerHighest: Color,
    val primaryFixed: Color,
    val primaryFixedDim: Color,
    val onPrimaryFixed: Color,
    val onPrimaryFixedVariant: Color,
    val secondaryFixed: Color,
    val secondaryFixedDim: Color,
    val onSecondaryFixed: Color,
    val onSecondaryFixedVariant: Color,
    val tertiaryFixed: Color,
    val tertiaryFixedDim: Color,
    val onTertiaryFixed: Color,
    val onTertiaryFixedVariant: Color,
)

/**
 * Serializable data class representing the theme configuration for the application using Material 3 color scheme.
 *
 * This class is used for serializing and deserializing theme configurations.
 *
 * @property primary The primary color of the theme as a string.
 * @property onPrimary The color used for text and icons displayed on top of the primary color as a string.
 * @property primaryContainer The primary container color of the theme as a string.
 * @property onPrimaryContainer The color used for text and icons displayed on top of the primary container as a string.
 * @property secondary The secondary color of the theme as a string.
 * @property onSecondary The color used for text and icons displayed on top of the secondary color as a string.
 * @property secondaryContainer The secondary container color of the theme as a string.
 * @property onSecondaryContainer The color used for text and icons displayed on top of the secondary container as a string.
 * @property tertiary The tertiary color of the theme as a string.
 * @property onTertiary The color used for text and icons displayed on top of the tertiary color as a string.
 * @property tertiaryContainer The tertiary container color of the theme as a string.
 * @property onTertiaryContainer The color used for text and icons displayed on top of the tertiary container as a string.
 * @property error The error color of the theme as a string.
 * @property onError The color used for text and icons displayed on top of the error color as a string.
 * @property errorContainer The error container color of the theme as a string.
 * @property onErrorContainer The color used for text and icons displayed on top of the error container as a string.
 * @property background The background color of the theme as a string.
 * @property onBackground The color used for text and icons displayed on top of the background color as a string.
 * @property surface The surface color of the theme as a string.
 * @property onSurface The color used for text and icons displayed on top of the surface color as a string.
 * @property surfaceVariant The surface variant color of the theme as a string.
 * @property onSurfaceVariant The color used for text and icons displayed on top of the surface variant as a string.
 * @property surfaceTint The surface tint color of the theme as a string.
 * @property outline The outline color of the theme as a string.
 * @property outlineVariant The outline variant color of the theme as a string.
 * @property scrim The scrim color of the theme as a string.
 * @property inverseSurface The inverse surface color of the theme as a string.
 * @property inverseOnSurface The color used for text and icons displayed on top of the inverse surface as a string.
 * @property inversePrimary The inverse primary color of the theme as a string.
 * @property surfaceDim The dim surface color of the theme as a string.
 * @property surfaceBright The bright surface color of the theme as a string.
 * @property surfaceContainerLowest The lowest surface container color of the theme as a string.
 * @property surfaceContainerLow The low surface container color of the theme as a string.
 * @property surfaceContainer The surface container color of the theme as a string.
 * @property surfaceContainerHigh The high surface container color of the theme as a string.
 * @property surfaceContainerHighest The highest surface container color of the theme as a string.
 * @property primaryFixed The primary fixed color of the theme as a string.
 * @property primaryFixedDim The dim primary fixed color of the theme as a string.
 * @property onPrimaryFixed The color used for text and icons displayed on top of the primary fixed color as a string.
 * @property onPrimaryFixedVariant The color used for text and icons displayed on top of the primary fixed variant as a string.
 * @property secondaryFixed The secondary fixed color of the theme as a string.
 * @property secondaryFixedDim The dim secondary fixed color of the theme as a string.
 * @property onSecondaryFixed The color used for text and icons displayed on top of the secondary fixed color as a string.
 * @property onSecondaryFixedVariant The color used for text and icons displayed on top of the secondary fixed variant as a string.
 * @property tertiaryFixed The tertiary fixed color of the theme as a string.
 * @property tertiaryFixedDim The dim tertiary fixed color of the theme as a string.
 * @property onTertiaryFixed The color used for text and icons displayed on top of the tertiary fixed color as a string.
 * @property onTertiaryFixedVariant The color used for text and icons displayed on top of the tertiary fixed variant as a string.
 */
@Serializable
data class SerializableThemeConfig(
    val primary: String,
    val onPrimary: String,
    val primaryContainer: String,
    val onPrimaryContainer: String,
    val secondary: String,
    val onSecondary: String,
    val secondaryContainer: String,
    val onSecondaryContainer: String,
    val tertiary: String,
    val onTertiary: String,
    val tertiaryContainer: String,
    val onTertiaryContainer: String,
    val error: String,
    val onError: String,
    val errorContainer: String,
    val onErrorContainer: String,
    val background: String,
    val onBackground: String,
    val surface: String,
    val onSurface: String,
    val surfaceVariant: String,
    val onSurfaceVariant: String,
    val surfaceTint: String,
    val outline: String,
    val outlineVariant: String,
    val scrim: String,
    val inverseSurface: String,
    val inverseOnSurface: String,
    val inversePrimary: String,
    val surfaceDim: String,
    val surfaceBright: String,
    val surfaceContainerLowest: String,
    val surfaceContainerLow: String,
    val surfaceContainer: String,
    val surfaceContainerHigh: String,
    val surfaceContainerHighest: String,
    val primaryFixed: String,
    val primaryFixedDim: String,
    val onPrimaryFixed: String,
    val onPrimaryFixedVariant: String,
    val secondaryFixed: String,
    val secondaryFixedDim: String,
    val onSecondaryFixed: String,
    val onSecondaryFixedVariant: String,
    val tertiaryFixed: String,
    val tertiaryFixedDim: String,
    val onTertiaryFixed: String,
    val onTertiaryFixedVariant: String,
)
