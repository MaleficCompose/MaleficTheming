package xyz.malefic.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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

        val lightTheme =
            ThemeConfig(
                primary = Color(0xFF6200EE),
                primaryVariant = Color(0xFF3700B3),
                secondary = Color(0xFF03DAC6),
                secondaryVariant = Color(0xFF018786),
                background = Color(0xFFFFFFFF),
                surface = Color(0xFFFFFFFF),
                error = Color(0xFFB00020),
                onPrimary = Color.White,
                onSecondary = Color.Black,
                onBackground = Color.Black,
                onSurface = Color.Black,
                onError = Color.White,
                isLight = true,
            )

        val darkTheme =
            ThemeConfig(
                primary = Color(0xFFBB86FC),
                primaryVariant = Color(0xFF3700B3),
                secondary = Color(0xFF03DAC6),
                secondaryVariant = Color(0xFF03DAC6),
                background = Color(0xFF121212),
                surface = Color(0xFF121212),
                error = Color(0xFFCF6679),
                onPrimary = Color.Black,
                onSecondary = Color.Black,
                onBackground = Color.White,
                onSurface = Color.White,
                onError = Color.Black,
                isLight = false,
            )

        MaleficTheme(if (isLightTheme) lightTheme else darkTheme) {
            Box(
                modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.background),
                contentAlignment = Alignment.Center,
            ) {
                Button(
                    onClick = { isLightTheme = !isLightTheme },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
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
