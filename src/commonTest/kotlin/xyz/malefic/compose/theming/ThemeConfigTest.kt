package xyz.malefic.compose.theming

import xyz.malefic.compose.theming.util.parseHexColor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ThemeConfigTest {
    @Test
    fun testLoadThemeFromJsonString() {
        val jsonString =
            """
            {
                "primary": "#FF6200EE",
                "onPrimary": "#FFFFFFFF",
                "primaryContainer": "#FF6200EE",
                "onPrimaryContainer": "#FFFFFFFF",
                "secondary": "#FF03DAC6",
                "onSecondary": "#FF000000",
                "secondaryContainer": "#FF03DAC6",
                "onSecondaryContainer": "#FF000000",
                "tertiary": "#FF03DAC6",
                "onTertiary": "#FF000000",
                "tertiaryContainer": "#FF03DAC6",
                "onTertiaryContainer": "#FF000000",
                "error": "#FFB00020",
                "onError": "#FFFFFFFF",
                "errorContainer": "#FFB00020",
                "onErrorContainer": "#FFFFFFFF",
                "background": "#FFFFFFFF",
                "onBackground": "#FF000000",
                "surface": "#FFFFFFFF",
                "onSurface": "#FF000000",
                "surfaceVariant": "#FFFFFFFF",
                "onSurfaceVariant": "#FF000000",
                "surfaceTint": "#FF6200EE",
                "outline": "#FF000000",
                "outlineVariant": "#FF000000",
                "scrim": "#FF000000",
                "inverseSurface": "#FF000000",
                "inverseOnSurface": "#FFFFFFFF",
                "inversePrimary": "#FF6200EE",
                "surfaceDim": "#FFFFFFFF",
                "surfaceBright": "#FFFFFFFF",
                "surfaceContainerLowest": "#FFFFFFFF",
                "surfaceContainerLow": "#FFFFFFFF",
                "surfaceContainer": "#FFFFFFFF",
                "surfaceContainerHigh": "#FFFFFFFF",
                "surfaceContainerHighest": "#FFFFFFFF"
            }
            """.trimIndent()

        val themeConfig =
            xyz.malefic.compose.theming.util
                .loadThemeFromJsonString(jsonString)

        assertNotNull(themeConfig)
        // Test that primary color was loaded correctly (check just that it's not default black)
        assertTrue(themeConfig.primary.value != 0UL)
    }

    @Test
    fun testCreateSimpleThemeConfig() {
        val themeConfig =
            createSimpleThemeConfig(
                primary = parseHexColor("#FF6200EE"),
                secondary = parseHexColor("#FF03DAC6"),
                background = parseHexColor("#FFFFFFFF"),
                surface = parseHexColor("#FFFFFFFF"),
                error = parseHexColor("#FFB00020"),
                onPrimary = parseHexColor("#FFFFFFFF"),
                onSecondary = parseHexColor("#FF000000"),
                onBackground = parseHexColor("#FF000000"),
                onSurface = parseHexColor("#FF000000"),
                onError = parseHexColor("#FFFFFFFF"),
            )

        assertNotNull(themeConfig)
        assertTrue(themeConfig.primary.value != 0UL)
        assertTrue(themeConfig.secondary.value != 0UL)
    }
}
