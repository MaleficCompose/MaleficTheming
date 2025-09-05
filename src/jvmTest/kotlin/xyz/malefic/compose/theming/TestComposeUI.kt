package xyz.malefic.compose.theming

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import xyz.malefic.compose.theming.util.parseHexColor
import kotlin.test.Test

class TestComposeUI {
    // @Test  // Commented out as this is a GUI test that requires a display
    fun manualThemeToggleTest() {
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

        // Create theme configurations for light and dark themes
        val lightTheme =
            createSimpleThemeConfig(
                primary = parseHexColor("#FF6200EE"),
                secondary = parseHexColor("#FF03DAC6"),
                background = Color.White,
                surface = Color.White,
                error = parseHexColor("#FFB00020"),
                onPrimary = Color.White,
                onSecondary = Color.Black,
                onBackground = Color.Black,
                onSurface = Color.Black,
                onError = Color.White,
            )

        val darkTheme =
            createSimpleThemeConfig(
                primary = parseHexColor("#FFBB86FC"),
                secondary = parseHexColor("#FF03DAC6"),
                background = parseHexColor("#FF121212"),
                surface = parseHexColor("#FF121212"),
                error = parseHexColor("#FFCF6679"),
                onPrimary = Color.Black,
                onSecondary = Color.Black,
                onBackground = Color.White,
                onSurface = Color.White,
                onError = Color.Black,
            )

        val currentTheme = if (isLightTheme) lightTheme else darkTheme

        // Apply the theme using the MaleficTheme function
        MaleficTheme(currentTheme) {
            Box(
                modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center,
            ) {
                Button(
                    onClick = { isLightTheme = !isLightTheme },
                ) {
                    Text(
                        text = if (isLightTheme) "Switch to Dark Mode" else "Switch to Light Mode",
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                }
            }
        }
    }
}
