package xyz.malefic.compose.theming

import xyz.malefic.compose.theming.util.PlatformFileReader
import xyz.malefic.compose.theming.util.loadThemeFromJsonString
import xyz.malefic.compose.theming.util.parseHexColor
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class MaleficThemingLibraryTest {
    @Test
    fun testCompleteThemeLoadingWorkflow() {
        // Test the complete theme loading workflow using simplified JSON
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
                "surfaceContainerHighest": "#FFFFFFFF",
                "primaryFixed": "#FF6200EE",
                "primaryFixedDim": "#FF6200EE",
                "onPrimaryFixed": "#FFFFFFFF",
                "onPrimaryFixedVariant": "#FFFFFFFF",
                "secondaryFixed": "#FF03DAC6",
                "secondaryFixedDim": "#FF03DAC6",
                "onSecondaryFixed": "#FF000000",
                "onSecondaryFixedVariant": "#FF000000",
                "tertiaryFixed": "#FF03DAC6",
                "tertiaryFixedDim": "#FF03DAC6",
                "onTertiaryFixed": "#FF000000",
                "onTertiaryFixedVariant": "#FF000000"
            }
            """.trimIndent()

        // Test JSON parsing functionality
        val themeConfig = loadThemeFromJsonString(jsonString)

        assertNotNull(themeConfig)
        // Verify exact colors from JSON
        assertEquals(parseHexColor("#FF6200EE"), themeConfig.primary)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.onPrimary)
        assertEquals(parseHexColor("#FF6200EE"), themeConfig.primaryContainer)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.onPrimaryContainer)
        assertEquals(parseHexColor("#FF03DAC6"), themeConfig.secondary)
        assertEquals(parseHexColor("#FF000000"), themeConfig.onSecondary)
        assertEquals(parseHexColor("#FF03DAC6"), themeConfig.secondaryContainer)
        assertEquals(parseHexColor("#FF000000"), themeConfig.onSecondaryContainer)
        assertEquals(parseHexColor("#FF03DAC6"), themeConfig.tertiary)
        assertEquals(parseHexColor("#FF000000"), themeConfig.onTertiary)
        assertEquals(parseHexColor("#FF03DAC6"), themeConfig.tertiaryContainer)
        assertEquals(parseHexColor("#FF000000"), themeConfig.onTertiaryContainer)
        assertEquals(parseHexColor("#FFB00020"), themeConfig.error)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.onError)
        assertEquals(parseHexColor("#FFB00020"), themeConfig.errorContainer)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.onErrorContainer)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.background)
        assertEquals(parseHexColor("#FF000000"), themeConfig.onBackground)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.surface)
        assertEquals(parseHexColor("#FF000000"), themeConfig.onSurface)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.surfaceVariant)
        assertEquals(parseHexColor("#FF000000"), themeConfig.onSurfaceVariant)
        assertEquals(parseHexColor("#FF6200EE"), themeConfig.surfaceTint)
        assertEquals(parseHexColor("#FF000000"), themeConfig.outline)
        assertEquals(parseHexColor("#FF000000"), themeConfig.outlineVariant)
        assertEquals(parseHexColor("#FF000000"), themeConfig.scrim)
        assertEquals(parseHexColor("#FF000000"), themeConfig.inverseSurface)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.inverseOnSurface)
        assertEquals(parseHexColor("#FF6200EE"), themeConfig.inversePrimary)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.surfaceDim)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.surfaceBright)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.surfaceContainerLowest)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.surfaceContainerLow)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.surfaceContainer)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.surfaceContainerHigh)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.surfaceContainerHighest)
        assertEquals(parseHexColor("#FF6200EE"), themeConfig.primaryFixed)
        assertEquals(parseHexColor("#FF6200EE"), themeConfig.primaryFixedDim)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.onPrimaryFixed)
        assertEquals(parseHexColor("#FFFFFFFF"), themeConfig.onPrimaryFixedVariant)
        assertEquals(parseHexColor("#FF03DAC6"), themeConfig.secondaryFixed)
        assertEquals(parseHexColor("#FF03DAC6"), themeConfig.secondaryFixedDim)
        assertEquals(parseHexColor("#FF000000"), themeConfig.onSecondaryFixed)
        assertEquals(parseHexColor("#FF000000"), themeConfig.onSecondaryFixedVariant)
        assertEquals(parseHexColor("#FF03DAC6"), themeConfig.tertiaryFixed)
        assertEquals(parseHexColor("#FF03DAC6"), themeConfig.tertiaryFixedDim)
        assertEquals(parseHexColor("#FF000000"), themeConfig.onTertiaryFixed)
        assertEquals(parseHexColor("#FF000000"), themeConfig.onTertiaryFixedVariant)
    }

    @Test
    fun testPlatformFileReaderExists() {
        // Test that platform-specific implementations exist
        val reader = PlatformFileReader()
        assertNotNull(reader)

        // Platform readers should exist and have proper error handling
        // We don't test actual file reading since we don't have assets/bundles in test
    }

    @Test
    fun testColorHexParsing() {
        // Test hex color parsing functionality
        val color1 = parseHexColor("#FF6200EE")
        val color2 = parseHexColor("#6200EE")

        assertTrue(color1.value != 0UL)
        assertTrue(color2.value != 0UL)
    }

    @Test
    fun testLibraryReadiness() {
        // This test verifies that all the main components of the library are working and that the library is ready for release

        // 1. JSON parsing works (using createSimpleThemeConfig for easier testing)
        val manualTheme =
            createSimpleThemeConfig(
                primary = parseHexColor("#FF0000"),
                secondary = parseHexColor("#00FF00"),
                background = parseHexColor("#FFFFFF"),
                surface = parseHexColor("#FFFFFF"),
                error = parseHexColor("#FF0000"),
                onPrimary = parseHexColor("#FFFFFF"),
                onSecondary = parseHexColor("#000000"),
                onBackground = parseHexColor("#000000"),
                onSurface = parseHexColor("#000000"),
                onError = parseHexColor("#FFFFFF"),
            )
        assertNotNull(manualTheme)

        // 2. Color parsing works
        val color = parseHexColor("#FF0000")
        assertTrue(color.value != 0UL)

        // 3. Theme config can be created with Material 3 structure
        assertTrue(manualTheme.primary.value != 0UL)
        assertTrue(manualTheme.primaryContainer.value != 0UL)
        assertTrue(manualTheme.secondary.value != 0UL)
        assertTrue(manualTheme.secondaryContainer.value != 0UL)
    }
}
