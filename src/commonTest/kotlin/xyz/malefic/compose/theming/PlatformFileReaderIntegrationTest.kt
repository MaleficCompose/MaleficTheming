package xyz.malefic.compose.theming

import xyz.malefic.compose.theming.util.PlatformFileReader
import xyz.malefic.compose.theming.util.currentPlatform
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class PlatformFileReaderIntegrationTest {
    @Test
    fun testPlatformSpecificExceptionMessages() {
        val reader = PlatformFileReader()
        val exception =
            if (currentPlatform() == "Android") {
                assertFailsWith<IllegalStateException> { reader.readText("nonexistent.json") }
            } else {
                assertFailsWith<IllegalArgumentException> { reader.readText("nonexistent.json") }
            }
        assertTrue(
            listOf("Context", "bundle", "Resource not found").any { exception.message?.contains(it) == true },
            "Exception message should be platform-specific: ${exception.message}",
        )
    }
}
