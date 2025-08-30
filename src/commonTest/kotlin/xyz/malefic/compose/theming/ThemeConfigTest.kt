package xyz.malefic.compose.theming

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ThemeConfigTest {
    @Test
    fun testLoadThemeFromJsonString() {
        val jsonString =
            """
            {
                "primary": "#FF6200EE",
                "primaryVariant": "#FF3700B3",
                "secondary": "#FF03DAC6",
                "secondaryVariant": "#FF018786",
                "background": "#FFFFFFFF",
                "surface": "#FFFFFFFF",
                "error": "#FFB00020",
                "onPrimary": "#FFFFFFFF",
                "onSecondary": "#FF000000",
                "onBackground": "#FF000000",
                "onSurface": "#FF000000",
                "onError": "#FFFFFFFF",
                "isLight": true
            }
            """.trimIndent()

        val themeConfig =
            xyz.malefic.compose.theming.util
                .loadThemeFromJsonString(jsonString)

        assertNotNull(themeConfig)
        assertEquals(true, themeConfig.isLight)
    }
}
