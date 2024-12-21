package xyz.malefic.compose.theming

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.io.InputStream
import kotlin.test.Test

class TestComposeUI {
    @Test
    fun testThemeToggle() {
        application {
            Window(title = "Test Composable UI: Theme Toggle", onCloseRequest = ::exitApplication) {
                ThemeToggleExampleComposable()
            }
        }
    }

    @Suppress("ktlint:standard:function-naming")
    @Composable
    fun ThemeToggleExampleComposable() {
        var isLightTheme by remember { mutableStateOf(true) }

        // Load the appropriate JSON file based on the theme
        val themeInputStream: InputStream =
            if (isLightTheme) {
                this::class.java.getResourceAsStream("/light.json")!!
            } else {
                this::class.java.getResourceAsStream("/dark.json")!!
            }

        // Apply the theme using the MaleficTheme function that accepts an InputStream
        MaleficTheme(themeInputStream) {
            Box(
                modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background),
                contentAlignment = Alignment.Center,
            ) {
                Button(
                    onClick = { isLightTheme = !isLightTheme },
                ) {
                    Text(
                        text = if (isLightTheme) "Switch to Dark Mode" else "Switch to Light Mode",
                        color = MaterialTheme.colors.onPrimary,
                    )
                }
            }
        }
    }
}
