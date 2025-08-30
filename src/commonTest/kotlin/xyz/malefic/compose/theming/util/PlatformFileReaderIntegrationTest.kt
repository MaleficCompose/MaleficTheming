package xyz.malefic.compose.theming.util

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class PlatformFileReaderIntegrationTest {

    @Test
    fun testPlatformSpecificExceptionMessages() {
        val reader = PlatformFileReader()
        
        // Test that platform-specific implementations throw appropriate exceptions
        // when context/bundle resources are not available
        val exception = assertFailsWith<IllegalArgumentException> {
            reader.readText("nonexistent.json")
        }
        
        // Verify that the exception message is platform-specific and helpful
        assertTrue(
            exception.message?.contains("Context") == true || // Android
            exception.message?.contains("bundle") == true ||   // iOS
            exception.message?.contains("Resource not found") == true, // JVM
            "Exception message should be platform-specific: ${exception.message}"
        )
    }
}