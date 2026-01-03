# Design System Documentation

GymOS follows a customized design system built on top of Material 3 principles but with a unique
visual identity ("Charcoal Blue" and "Pumpkin Spice").

## Design Token Implementation Rules

- **Token-First Approach**: Always use design tokens for Colors, Typography, Spacing, and Sizes.
- **No Hardcoded Dimensions**: Avoid using hardcoded `dp` or `sp` values in components. Instead, map
  them to the closest token in `GymSpacing` or `GymSizes`.
- **Consistency**: Maintain visual consistency across all platforms by strictly adhering to the
  defined tokens.

## Design Tokens

Design tokens are the visual atoms of our system. They are defined in
`composeApp/src/commonMain/kotlin/dev/ch8n/gymos/theme/`.

### Colors (`GymColors`)

The color palette is optimized for a dark, high-contrast fitness experience.

| Token              | Value        | Usage                                    |
|--------------------|--------------|------------------------------------------|
| `primary`          | `#FE7F2D`    | Main actions, highlights (Pumpkin Spice) |
| `secondary`        | `#FCCA46`    | Secondary highlights (Golden Pollen)     |
| `tertiary`         | `#A1C181`    | Success / Completed (Gym Olive)          |
| `quaternary`       | `#619B8A`    | Secondary accent (Gym Seagrass)          |
| `background`       | `#121F29`    | Deep dark blue-black background          |
| `surface`          | `#233D4D`    | Charcoal Blue cards and containers       |
| `surfaceHighlight` | `#2C4B5E`    | Lighter surface for inputs/cards         |
| `textPrimary`      | `#FFFFFF`    | Main headings and labels                 |
| `textSecondary`    | `0x99FFFFFF` | Body text and secondary info             |
| `textMuted`        | `0x66FFFFFF` | De-emphasized text                       |
| `border`           | `0x0DFFFFFF` | Subtle borders                           |

### Typography (`GymTypography`)

We use two main font families: **Lexend** for display/headers and **Noto Sans** for body/UI text.

| Token               | Font Family | Weight    | Size | Usage                                  |
|---------------------|-------------|-----------|------|----------------------------------------|
| `displayExtraLarge` | Lexend      | ExtraBold | 48sp | Major stats values (e.g. Total Volume) |
| `displayLarge`      | Lexend      | ExtraBold | 36sp | Major headlines and streaks            |
| `displayMedium`     | Lexend      | Bold      | 30sp | Medium headlines                       |
| `displaySmall`      | Lexend      | Bold      | 20sp | Standard top bars and sub-headers      |
| `h1`                | Lexend      | Bold      | 24sp | Primary section titles                 |
| `h2`                | Lexend      | Bold      | 20sp | Secondary section titles               |
| `h3`                | Lexend      | SemiBold  | 18sp | Tertiary section titles                |
| `bodyLarge`         | Noto Sans   | Medium    | 16sp | Main body text                         |
| `bodyMedium`        | Noto Sans   | Normal    | 14sp | Secondary body text                    |
| `bodySmall`         | Noto Sans   | Normal    | 12sp | Fine print and dense UI info           |
| `captionBold`       | Noto Sans   | Bold      | 12sp | Bold small labels                      |
| `caption`           | Noto Sans   | Normal    | 12sp | Small labels and navigation            |
| `tiny`              | Noto Sans   | Medium    | 10sp | Micro labels                           |

### Spacing (`GymSpacing`)

Standardized gaps and paddings to ensure consistent layout density.

| Token         | Value | Usage                            |
|---------------|-------|----------------------------------|
| `none`        | 0.dp  | No spacing                       |
| `tiny`        | 2.dp  | Minimal spacing                  |
| `xSmall`      | 4.dp  | Extra small spacing              |
| `small`       | 8.dp  | Small spacing                    |
| `mediumSmall` | 12.dp | Between small and medium         |
| `medium`      | 16.dp | Standard spacing (padding, gaps) |
| `mediumLarge` | 20.dp | Between medium and large         |
| `large`       | 24.dp | Large spacing (section gaps)     |
| `xLarge`      | 32.dp | Extra large spacing              |
| `xxLarge`     | 48.dp | Double extra large spacing       |
| `xxxLarge`    | 64.dp | Triple extra large spacing       |

### Sizes (`GymSizes`)

Unified size scale for all components.

**Base Scale:**

| Token         | Value  | Usage                              |
|---------------|--------|------------------------------------|
| `none`        | 0.dp   | No size                            |
| `borderWidth` | 1.dp   | Standard border width              |
| `xSmall`      | 18.dp  | Extra small icons, buttons         |
| `small`       | 36.dp  | Small buttons, chips               |
| `medium`      | 48.dp  | Medium buttons, avatars            |
| `large`       | 56.dp  | Large buttons                      |
| `xLarge`      | 64.dp  | Extra large components, nav height |
| `xxLarge`     | 80.dp  | Double extra large                 |
| `xxxLarge`    | 100.dp | Chart heights (medium)             |
| `xxxxLarge`   | 120.dp | Card heights, donut charts         |
| `xxxxxLarge`  | 150.dp | Large chart/card heights           |

**Component Specific:**

| Token               | Value  | Usage                        |
|---------------------|--------|------------------------------|
| `iconMedium`        | 24.dp  | Medium icons                 |
| `iconLarge`         | 32.dp  | Large icons                  |
| `indicatorSmall`    | 8.dp   | Small indicators, dots       |
| `checkbox`          | 28.dp  | Checkbox size                |
| `badgeHeight`       | 24.dp  | Badge height                 |
| `avatarSmall`       | 40.dp  | Small avatars                |
| `avatarLarge`       | 80.dp  | Large avatars                |
| `avatarXLarge`      | 120.dp | Extra large avatars          |
| `donutThickness`    | 8.dp   | Donut chart stroke thickness |
| `barWidthMedium`    | 12.dp  | Bar chart bar width          |
| `switchTrackWidth`  | 44.dp  | Switch track width           |
| `switchTrackHeight` | 24.dp  | Switch track height          |
| `switchThumbSize`   | 20.dp  | Switch thumb size            |
| `glowSizeLarge`     | 128.dp | Large glow effect size       |

### Shapes (`GymShapes`)

Corner radius definitions for cards and containers.

| Token     | Value   | Usage                          |
|-----------|---------|--------------------------------|
| `none`    | 0.dp    | No rounding (sharp corners)    |
| `small`   | 8.dp    | Small rounding                 |
| `medium`  | 12.dp   | Medium rounding                |
| `default` | 16.dp   | Default card rounding          |
| `large`   | 32.dp   | Large rounding                 |
| `xLarge`  | 48.dp   | Extra large rounding           |
| `full`    | 9999.dp | Fully rounded (pills, circles) |

---
