# Material 3 Migration Guide

This document provides guidance for migrating from Material Design to Material 3 in the MaleficTheming library.

## Overview

The MaleficTheming library has been updated to use Material 3 design system, which includes:
- New color scheme with 33+ color tokens
- Removal of deprecated `primaryVariant` and `secondaryVariant`
- Addition of container colors, surface variants, and outline colors
- Support for Material 3's enhanced theming capabilities

## Migration Steps

### 1. Update Dependencies

The library now uses `material3` instead of `material`. No changes needed for consumers - this is handled internally.

### 2. Color Scheme Changes

#### Old Material 2 Structure:
```kotlin
// Material 2 had 12 color properties + isLight boolean
val oldTheme = ThemeConfig(
    primary = Color.Blue,
    primaryVariant = Color.DarkBlue,    // REMOVED
    secondary = Color.Teal,
    secondaryVariant = Color.DarkTeal,  // REMOVED
    background = Color.White,
    surface = Color.White,
    error = Color.Red,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White,
    isLight = true  // REMOVED
)
```

#### New Material 3 Structure:
```kotlin
// Material 3 has 33+ color properties
val newTheme = ThemeConfig(
    // Primary colors
    primary = Color.Blue,
    onPrimary = Color.White,
    primaryContainer = Color.LightBlue,
    onPrimaryContainer = Color.DarkBlue,
    
    // Secondary colors
    secondary = Color.Teal,
    onSecondary = Color.Black,
    secondaryContainer = Color.LightTeal,
    onSecondaryContainer = Color.DarkTeal,
    
    // Tertiary colors (new)
    tertiary = Color.Green,
    onTertiary = Color.Black,
    tertiaryContainer = Color.LightGreen,
    onTertiaryContainer = Color.DarkGreen,
    
    // Error colors
    error = Color.Red,
    onError = Color.White,
    errorContainer = Color.LightRed,
    onErrorContainer = Color.DarkRed,
    
    // Background and surface
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    surfaceVariant = Color.LightGray,
    onSurfaceVariant = Color.DarkGray,
    surfaceTint = Color.Blue,
    
    // Outlines
    outline = Color.Gray,
    outlineVariant = Color.LightGray,
    
    // Utility colors
    scrim = Color.Black,
    inverseSurface = Color.Black,
    inverseOnSurface = Color.White,
    inversePrimary = Color.LightBlue,
    
    // Surface containers
    surfaceDim = Color.DarkGray,
    surfaceBright = Color.White,
    surfaceContainerLowest = Color.White,
    surfaceContainerLow = Color.LightGray,
    surfaceContainer = Color.Gray,
    surfaceContainerHigh = Color.DarkGray,
    surfaceContainerHighest = Color.Black,
)
```

### 3. Easy Migration with Helper Function

For quick migration from Material 2, use the `createSimpleThemeConfig()` helper:

```kotlin
import xyz.malefic.compose.theming.createSimpleThemeConfig
import xyz.malefic.compose.theming.util.parseHexColor

val theme = createSimpleThemeConfig(
    primary = parseHexColor("#6200EE"),
    secondary = parseHexColor("#03DAC6"),
    background = Color.White,
    surface = Color.White,
    error = parseHexColor("#B00020"),
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White,
)
```

This helper automatically generates all the required Material 3 color properties with sensible defaults.

### 4. JSON Theme Format

#### Old Format:
```json
{
  "primary": "#6200EE",
  "primaryVariant": "#3700B3",
  "secondary": "#03DAC6",
  "secondaryVariant": "#018786",
  "background": "#FFFFFF",
  "surface": "#FFFFFF",
  "error": "#B00020",
  "onPrimary": "#FFFFFF",
  "onSecondary": "#000000",
  "onBackground": "#000000",
  "onSurface": "#000000",
  "onError": "#FFFFFF",
  "isLight": true
}
```

#### New Format:
```json
{
  "primary": "#6200EE",
  "onPrimary": "#FFFFFF",
  "primaryContainer": "#6200EE",
  "onPrimaryContainer": "#FFFFFF",
  "secondary": "#03DAC6",
  "onSecondary": "#000000",
  "secondaryContainer": "#03DAC6",
  "onSecondaryContainer": "#000000",
  "tertiary": "#03DAC6",
  "onTertiary": "#000000",
  "tertiaryContainer": "#03DAC6",
  "onTertiaryContainer": "#000000",
  "error": "#B00020",
  "onError": "#FFFFFF",
  "errorContainer": "#B00020",
  "onErrorContainer": "#FFFFFF",
  "background": "#FFFFFF",
  "onBackground": "#000000",
  "surface": "#FFFFFF",
  "onSurface": "#000000",
  "surfaceVariant": "#FFFFFF",
  "onSurfaceVariant": "#000000",
  "surfaceTint": "#6200EE",
  "outline": "#000000",
  "outlineVariant": "#000000",
  "scrim": "#000000",
  "inverseSurface": "#000000",
  "inverseOnSurface": "#FFFFFF",
  "inversePrimary": "#6200EE",
  "surfaceDim": "#FFFFFF",
  "surfaceBright": "#FFFFFF",
  "surfaceContainerLowest": "#FFFFFF",
  "surfaceContainerLow": "#FFFFFF",
  "surfaceContainer": "#FFFFFF",
  "surfaceContainerHigh": "#FFFFFF",
  "surfaceContainerHighest": "#FFFFFF"
}
```

### 5. Usage Examples

#### Basic Usage:
```kotlin
@Composable
fun MyApp() {
    val theme = createSimpleThemeConfig(
        primary = parseHexColor("#6200EE"),
        secondary = parseHexColor("#03DAC6"),
        background = Color.White,
        surface = Color.White,
        error = parseHexColor("#B00020"),
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black,
        onError = Color.White,
    )
    
    MaleficTheme(theme) {
        // Your app content here
        // Now uses Material 3 components and colors
    }
}
```

#### From JSON:
```kotlin
@Composable  
fun MyAppFromJson() {
    val jsonContent = """{ /* your Material 3 JSON theme */ }"""
    
    MaleficThemeFromJson(jsonContent) {
        // Your app content here
    }
}
```

## Key Benefits of Material 3

1. **Enhanced Color System**: More semantic color roles and better contrast ratios
2. **Container Colors**: Dedicated colors for elevated surfaces and containers  
3. **Surface Variants**: Better hierarchy and depth with multiple surface levels
4. **Improved Accessibility**: Better contrast and readability
5. **Consistent Design**: Aligned with latest Material Design guidelines

## Breaking Changes

1. `primaryVariant` and `secondaryVariant` removed
2. `isLight` property removed (determined automatically from colors)
3. JSON format requires all 33+ color properties
4. `MaterialTheme.colors` replaced with `MaterialTheme.colorScheme`

## Migration Checklist

- [ ] Update existing themes to use `createSimpleThemeConfig()` helper
- [ ] Update JSON theme files with new Material 3 format  
- [ ] Test your app's appearance with the new color scheme
- [ ] Verify accessibility and contrast ratios
- [ ] Update any hardcoded color references in your UI components
- [ ] Consider using new Material 3 color tokens like containers and variants

The migration provides access to Material 3's enhanced theming capabilities while maintaining the same simple API for theme configuration.