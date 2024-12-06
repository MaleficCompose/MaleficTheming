package xyz.malefic.theme

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable

/**
 * Data class representing the theme configuration for the application.
 *
 * @property primary The primary color of the theme.
 * @property primaryVariant The variant of the primary color.
 * @property secondary The secondary color of the theme.
 * @property secondaryVariant The variant of the secondary color.
 * @property background The background color of the theme.
 * @property surface The surface color of the theme.
 * @property error The error color of the theme.
 * @property onPrimary The color used for text and icons displayed on top of the primary color.
 * @property onSecondary The color used for text and icons displayed on top of the secondary color.
 * @property onBackground The color used for text and icons displayed on top of the background
 *   color.
 * @property onSurface The color used for text and icons displayed on top of the surface color.
 * @property onError The color used for text and icons displayed on top of the error color.
 * @property isLight A boolean indicating if the theme is light or dark.
 */
data class ThemeConfig(
  val primary: Color,
  val primaryVariant: Color,
  val secondary: Color,
  val secondaryVariant: Color,
  val background: Color,
  val surface: Color,
  val error: Color,
  val onPrimary: Color,
  val onSecondary: Color,
  val onBackground: Color,
  val onSurface: Color,
  val onError: Color,
  val isLight: Boolean,
)

/**
 * Serializable data class representing the theme configuration for the application.
 *
 * This class is used for serializing and deserializing theme configurations.
 *
 * @property primary The primary color of the theme as a string.
 * @property primaryVariant The variant of the primary color as a string.
 * @property secondary The secondary color of the theme as a string.
 * @property secondaryVariant The variant of the secondary color as a string.
 * @property background The background color of the theme as a string.
 * @property surface The surface color of the theme as a string.
 * @property error The error color of the theme as a string.
 * @property onPrimary The color used for text and icons displayed on top of the primary color as a
 *   string.
 * @property onSecondary The color used for text and icons displayed on top of the secondary color
 *   as a string.
 * @property onBackground The color used for text and icons displayed on top of the background color
 *   as a string.
 * @property onSurface The color used for text and icons displayed on top of the surface color as a
 *   string.
 * @property onError The color used for text and icons displayed on top of the error color as a
 *   string.
 * @property isLight A boolean indicating if the theme is light or dark.
 */
@Serializable
data class SerializableThemeConfig(
  val primary: String,
  val primaryVariant: String,
  val secondary: String,
  val secondaryVariant: String,
  val background: String,
  val surface: String,
  val error: String,
  val onPrimary: String,
  val onSecondary: String,
  val onBackground: String,
  val onSurface: String,
  val onError: String,
  val isLight: Boolean,
)
