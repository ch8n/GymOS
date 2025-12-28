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

| Token           | Value        | usage                                    |
|-----------------|--------------|------------------------------------------|
| `primary`       | `#FE7F2D`    | Main actions, highlights (Pumpkin Spice) |
| `secondary`     | `#FCCA46`    | Secondary highlights (Golden Pollen)     |
| `tertiary`      | `#A1C181`    | Success / Completed (Gym Olive)          |
| `quaternary`    | `#619B8A`    | Secondary accent (Gym Seagrass)          |
| `background`    | `#121F29`    | Deep dark blue-black background          |
| `surface`       | `#233D4D`    | Charcoal Blue cards and containers       |
| `textPrimary`   | `#FFFFFF`    | Main headings and labels                 |
| `textSecondary` | `0x99FFFFFF` | Body text and secondary info             |

### Typography (`GymTypography`)

We use two main font families: **Lexend** for display/headers and **Noto Sans** for body/UI text.

- **DisplayExtraLarge**: Lexend (ExtraBold) 48sp - Used for major stats values (e.g. Total Volume).
- **Display**: Lexend (Bold/ExtraBold) - Used for major headlines and streaks.
- **DisplaySmall**: Lexend (Bold) 20sp - Used for standard top bars and sub-headers.
- **H1-H3**: Lexend (Bold/SemiBold) - Used for section titles.
- **BodyLarge**: Noto Sans (Medium) 16sp - Main body text.
- **BodyMedium**: Noto Sans (Normal) 14sp - Secondary body text.
- **BodySmall**: Noto Sans (Normal) 12sp - Fine print and dense UI info.
- **Caption/Tiny**: Noto Sans (Bold/Medium) - Used for small labels and navigation.

### Spacing (`GymSpacing`)

Standardized gaps and paddings to ensure consistent layout density.

- `none`: 0.dp
- `tiny`: 2.dp
- `xSmall`: 4.dp
- `small`: 8.dp
- `mediumSmall`: 12.dp
- `medium`: 16.dp
- `mediumLarge`: 20.dp
- `large`: 24.dp
- `xLarge`: 32.dp
- `xxLarge`: 48.dp
- `xxxLarge`: 64.dp
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
- `checkbox`: 28.dp
- `avatarSmall`: 40.dp
- `avatarMedium`: 48.dp

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

### GymChip & GymBadge

Small labels for categorization or status.

- **GymChip Props**: `text`, `icon`, `dotColor`, `backgroundColor`, `contentColor`.
- **GymBadge Props**: `text`, `backgroundColor`, `contentColor`.
- **Note**: `GymBadge` is a smaller, more compact version of a chip used for status tags like "
  TODAY".

### GymCheckbox

A custom animated circular checkbox.

- **Props**: `checked`, `onCheckedChange`, `activeColor`, `checkColor`.

### GymIcon

A themed icon wrapper with a circular tinted background.

- **Props**: `imageVector`, `tint`, `backgroundColor`, `size`, `iconSize`.

### GymCategoryHeader, GymTopBar & GymSectionHeader

Composite components for headers.

- **GymCategoryHeader Props**: `title`, `count`, `titleColor`. (Displays title with a divider line
  and count).
- **GymTopBar Props**: `title`, `subtitle`, `navigationIcon`, `actions`.
- **GymSectionHeader Props**: `title`, `label`, `icon`, `iconColor`, `trailingContent`. (Title
  section with optional icon and status label).

### GymExerciseCard

A specialized card for displaying exercise details.

- **Props**: `name`, `sets`, `reps`, `isCompleted`, `onCompletedChange`, `icon`, `iconColor`,
  `onClick`.

### GymDashedPlaceholder

A placeholder component with dashed borders for indicating where content can be added.

- **Props**: `text`, `onClick`.

### GymAvatar & GymTextAvatar

Circular containers for user profiles or exercise initials.

- **GymAvatar Props**: `size`, `backgroundColor`, `contentColor`, `borderColor`, `content`.
- **GymImageAvatar Props**: `painter`, `size`, `borderColor`.
- **GymTextAvatar Props**: `text`, `size`, `backgroundColor`, `contentColor`, `borderColor`.

### GymCalendar Components

Set of components to build calendar views.

- **GymCalendarDate**: Individual date cell with status (Completed, Missed, Rest) and indicator
  dots.
- **GymCalendarWeekHeader**: Row of day initials (S, M, T, W, T, F, S).
- **GymCalendarGrid**: 7-column grid layout for dates.

### GymStatCard

A small card for displaying a value and a label (e.g., 1RM, Target, Sets).

- **Props**: `value`, `label`, `valueColor`.

### GymStatGridCard

A flexible card for the 2x2 stats grid.

- **Props**: `label`, `value`, `icon`, `subValue`, `accentColor`, `progress`, `maxProgress`.

### GymSummaryHighlightCard

A large card for highlighting key metrics.

- **Props**: `label`, `value`, `unit`, `icon`, `accentColor`.

### GymSummaryHeader

A header component for the exercise summary.

- **Props**: `exerciseName`, `categoryName`, `completionTime`.

### GymFeelingSlider

A customized slider for tracking how an exercise felt.

- **Props**: `value`, `onValueChange`, `title`, `labels`, `steps`.

### GymSessionLogItem

A list item for session logs showing set details and completion status.

- **Props**: `setNumber`, `setType`, `details`, `statusText`, `isCompleted`, `isCurrent`.

### GymVideoPlayer

A component for exercise demonstration videos with a play button overlay.

- **Props**: `duration`, `onPlayClick`.

### GymNumberInput

A themed numeric input field with a unit suffix.

- **Props**: `value`, `onValueChange`, `label`, `unit`, `placeholder`.

### GymSegmentedControl

A control for selecting between multiple options (e.g., Energy, Effort).

- **Props**: `items`, `selectedIndex`, `onItemSelected`, `label`, `activeColor`, `statusText`.

### GymExecutionBottomCard

A bottom card for the active set execution UI.

- **Props**: `setTitle`, `setType`, `timerText`, `weight`, `onWeightChange`, `reps`, `onRepsChange`,
  `onCompleteSet`.

### GymTextField

A themed text input field used for search and forms.

- **Props**: `value`, `onValueChange`, `placeholder`, `leadingIcon`, `trailingIcon`.

### GymActionCard

A horizontal action card often used for "Add" or "Create" actions.

- **Props**: `text`, `icon`, `onClick`, `isDashed`, `contentColor`, `backgroundColor`.

### GymExerciseSelectionItem

A list item for selecting exercises from a library.

- **Props**: `name`, `category`, `equipment`, `initials`, `onAddClick`, `onItemClick`,
  `avatarColor`, `isAlreadyAdded`.

### GymSwitch

A custom animated switch component for toggling settings.

- **Props**: `checked`, `onCheckedChange`, `enabled`.
- **Note**: Follows the primary brand color for the active state.

### GymListItem

A versatile row component for reminders, habits, and checklist items.

- **Props**: `title`, `subtitle`, `leadingContent`, `trailingContent`, `onClick`, `enabled`.
- **Helpers**: Includes `GymIconCircle` (circular background) and `GymIconSquare` (rounded square
  background) for leading icons.

### GymTimePickerButton

A stylized button for displaying and triggering time selection.

- **Props**: `time`, `onClick`, `enabled`, `backgroundColor`, `textColor`.

### GymAddInput

A specialized input field with an inline "+" action for adding items to a list.

- **Props**: `value`, `onValueChange`, `placeholder`, `onAddClick`.
