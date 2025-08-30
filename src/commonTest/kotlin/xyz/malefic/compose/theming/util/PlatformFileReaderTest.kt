package xyz.malefic.compose.theming.util

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull

class PlatformFileReaderTest {
    @Test
    fun testPlatformFileReaderInstantiation() {
        // Test that we can create a PlatformFileReader instance
        val reader = PlatformFileReader()
        assertNotNull(reader)
    }

    @Test
    fun testInvalidResourcePath() {
        val reader = PlatformFileReader()

        // Test with an invalid path - should throw an exception
        assertFailsWith<IllegalArgumentException> {
            reader.readText("nonexistent/invalid.json")
        }
    }

    @Test
    fun testEmptyResourcePath() {
        val reader = PlatformFileReader()

        // Test with empty path - should throw an exception
        assertFailsWith<IllegalArgumentException> {
            reader.readText("")
        }
    }
}
