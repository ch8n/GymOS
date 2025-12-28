# Design System Documentation

GymOS follows a customized design system built on top of Material 3 principles but with a unique
visual identity ("Charcoal Blue" and "Pumpkin Spice").

## Design Tokens

Design tokens are the visual atoms of our system. They are defined in
`composeApp/src/commonMain/kotlin/dev/ch8n/gymos/theme/`.

### Colors (`GymColors`)

The color palette is optimized for a dark, high-contrast fitness experience.

| Token           | Value        | usage                                    |
|-----------------|--------------|------------------------------------------|
| `primary`       | `#FE7F2D`    | Main actions, highlights (Pumpkin Spice) |
| `secondary`     | `#FCCA46`    | Secondary highlights (Golden Pollen)     |
| `background`    | `#121F29`    | Deep dark blue-black background          |
| `surface`       | `#233D4D`    | Charcoal Blue cards and containers       |
| `textPrimary`   | `#FFFFFF`    | Main headings and labels                 |
| `textSecondary` | `0x99FFFFFF` | Body text and secondary info             |

### Typography (`GymTypography`)

We use two main font families: **Lexend** for display/headers and **Noto Sans** for body/UI text.

- **Display**: Lexend (Bold/ExtraBold) - Used for major headlines and streaks.
- **DisplaySmall**: Lexend (Bold) 20sp - Used for standard top bars and sub-headers.
- **H1-H3**: Lexend (Bold/SemiBold) - Used for section titles.
- **Body**: Noto Sans (Medium/Normal) - Used for instructional text, exercise details, and inputs.
- **Caption/Tiny**: Noto Sans (Bold/Medium) - Used for small labels and navigation.

### Spacing (`GymSpacing`)

Standardized gaps and paddings to ensure consistent layout density.

- `none`: 0.dp
- `xSmall`: 4.dp
- `small`: 8.dp
- `mediumSmall`: 12.dp
- `medium`: 16.dp
- `mediumLarge`: 20.dp
- `large`: 24.dp
- `pagePadding`: 16.dp
- `sectionGap`: 24.dp

### Sizes (`GymSizes`)

Component-specific dimensions for height and icons.

- `buttonHeightSmall`: 36.dp
- `buttonHeightMedium`: 48.dp
- `buttonHeightLarge`: 56.dp
- `iconSmall`: 18.dp
- `iconMedium`: 24.dp
- `iconLarge`: 32.dp
- `indicatorSmall`: 8.dp

---

## Atomic Components

Located in `composeApp/src/commonMain/kotlin/dev/ch8n/gymos/ui/foundation/`.

### GymButton

A primary call-to-action button with a pill shape and brand-matched shadow.

- **Props**: `text`, `onClick`, `icon`, `backgroundColor`, `contentColor`.
- **States**: Default, With Icon.

### GymIconButton & GymBadgeIconButton

Circular icon buttons for secondary actions. `GymBadgeIconButton` includes a notification/status
dot.

- **Props**: `icon`, `onClick`, `badgeColor` (Badge only), `backgroundColor`, `contentColor`.

### GymCard

The fundamental container for grouping related content.

- **Props**: `shape`, `backgroundColor`, `borderColor`, `contentPadding`, `onClick`.
- **Note**: Uses a subtle border by default for separation in dark mode.

### GymChip

A small, pill-shaped label for categorization.

- **Props**: `text`, `icon`, `dotColor`, `backgroundColor`, `contentColor`.
- **Feature**: Supports `dotColor` for status indication (e.g., Completed, Missed).

### GymIcon

A themed icon wrapper with a circular tinted background.

- **Props**: `imageVector`, `tint`, `backgroundColor`, `size`, `iconSize`.

### GymSectionHeader & GymTopBar

Composite components for headers. `GymTopBar` is used for screen navigations.

- **GymSectionHeader Props**: `label`, `title`.
- **GymTopBar Props**: `title`, `navigationIcon`, `actions`.

### GymAvatar

A circular image container for user profiles.

- **Props**: `painter`, `size`, `borderColor`.

### GymCalendar Components

Set of components to build calendar views.

- **GymCalendarDate**: Individual date cell with status (Completed, Missed, Rest) and indicator
  dots.
- **GymCalendarWeekHeader**: Row of day initials (S, M, T, W, T, F, S).
- **GymCalendarGrid**: 7-column grid layout for dates.

---

## Testing & Preview

You can verify and interact with these components in the **Component Showcase Screen**.

- Path: `composeApp/src/commonMain/kotlin/dev/ch8n/gymos/ui/showcase/`
- Accessibility: Via the "Open Component Showcase" button on the main app screen.
