## Atomic Components

Located in `composeApp/src/commonMain/kotlin/dev/ch8n/gymos/ui/foundation/`.

### GymButton

A primary call-to-action button with a pill shape and brand-matched shadow.

- **Props**: `text`, `onClick`, `icon` (`GymIconResource?`), `trailingIcon` (`GymIconResource?`),
  `backgroundColor`, `contentColor`.
- **States**: Default, With Icon (Start/End).
- **GymTextButton**: A subtle variant for secondary actions.

### GymIconButton & GymBadgeIconButton

Circular icon buttons for secondary actions. `GymBadgeIconButton` includes a notification/status
dot.

- **Props**: `icon` (`GymIconResource`), `onClick`, `badgeColor` (Badge only), `backgroundColor`,
  `contentColor`.

### GymCard

The fundamental container for grouping related content.

- **Props**: `shape`, `backgroundColor`, `borderColor`, `contentPadding`, `onClick`.
- **Note**: Uses a subtle border by default for separation in dark mode.

### GymChip & GymBadge

Small labels for categorization or status.

- **GymChip Props**: `text`, `icon` (`GymIconResource?`), `dotColor`, `backgroundColor`,
  `contentColor`.
- **GymBadge Props**: `text`, `backgroundColor`, `contentColor`.
- **Note**: `GymBadge` is a smaller, more compact version of a chip used for status tags like "
  TODAY".
- **GymStatusBadge**: A pill-shaped badge with an icon (`GymIconResource`) and label, used for
  status like "Normal", "High", etc.

### GymCheckbox

A custom animated circular checkbox.

- **Props**: `checked`, `onCheckedChange`, `activeColor`, `checkColor`.

### GymIcon

A themed icon wrapper that uses a sealed class `GymIconResource` to support both `ImageVector` and
`Painter`. Features an optional circular tinted background.

- **Props**: `icon` (`GymIconResource`), `tint`, `backgroundColor`, `size`.

### GymCategoryHeader, GymTopBar & GymSectionHeader

Composite components for headers.

- **GymCategoryHeader Props**: `title`, `count`, `titleColor`. (Displays title with a divider line
  and count).
- **GymTopBar Props**: `title`, `subtitle`, `navigationIcon`, `actions`.
- **GymSectionHeader Props**: `title`, `label`, `icon` (`GymIconResource?`), `iconColor`,
  `trailingContent`. (Title section with optional icon and status label).

### GymExerciseCard

A specialized card for displaying exercise details.

- **Props**: `name`, `sets`, `reps`, `isCompleted`, `onCompletedChange`, `icon` (`GymIconResource`),
  `iconColor`, `onClick`.

### GymDashedPlaceholder

A placeholder component with dashed borders for indicating where content can be added.

- **Props**: `text`, `onClick`.

### GymAvatar & GymTextAvatar

Circular containers for user profiles or exercise initials.

- **GymAvatar Props**: `size`, `backgroundColor`, `borderColor`, `onEditClick`, `content`.
- **GymImageAvatar Props**: `painter`, `size`, `borderColor`, `onEditClick`.
- **GymTextAvatar Props**: `text`, `size`, `backgroundColor`, `contentColor`, `borderColor`,
  `onEditClick`.
- **Note**: Supports an optional `onEditClick` to show an edit icon overlay.

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

- **Props**: `label`, `value`, `icon` (`GymIconResource`), `subValue`, `accentColor`, `progress`,
  `maxProgress`.

### GymSummaryHighlightCard

A large card for highlighting key metrics.

- **Props**: `label`, `value`, `unit`, `icon` (`GymIconResource`), `accentColor`.

### GymSummaryHeader

A header component for the exercise summary.

- **Props**: `exerciseName`, `categoryName`, `completionTime`.

### GymSegmentedProgressBar

A linear progress indicator split into equal segments, used for tracking sets or progress goals.

- **Props**: `progress`, `maxProgress`, `activeColor`, `inactiveColor`.

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

- **Props**: `items`, `selectedIndex`, `onItemSelected`, `label` (optional), `activeColor`,
  `statusText`.
- **Note**: Supports a "pill" look when no label is provided.

### GymExecutionBottomCard

A bottom card for the active set execution UI.

- **Props**: `setTitle`, `setType`, `timerText`, `weight`, `onWeightChange`, `reps`, `onRepsChange`,
  `onCompleteSet`.

### GymTextField

A themed text input field used for search and forms.

- **Props**: `value`, `onValueChange`, `placeholder`, `leadingIcon` (`GymIconResource?`),
  `trailingIcon`, `shape`, `singleLine`, `maxLines`.
- **GymSearchField**: A specialized variant with a leading search icon and trailing mic action.

### GymActionCard

A horizontal action card often used for "Add" or "Create" actions.

- **Props**: `text`, `icon` (`GymIconResource`), `onClick`, `isDashed`, `contentColor`,
  `backgroundColor`.

### GymExerciseSelectionItem

A list item for selecting exercises from a library.

- **Props**: `name`, `category`, `equipment`, `initials`, `onAddClick`, `onItemClick`,
  `avatarColor`, `isAlreadyAdded`.

### GymSwitch

A custom animated switch component for toggling settings.

- **Props**: `checked`, `onCheckedChange`, `enabled`.
- **Note**: Follows the primary brand color for the active state. Uses standardized `GymSizes` for
  track and thumb.

### GymListItem

A versatile row component for reminders, habits, and checklist items.

- **Props**: `title`, `subtitle`, `leadingContent`, `trailingContent`, `onClick`, `enabled`.
- **Helpers**: Includes `GymIconCircle` (circular background) and `GymIconSquare` (rounded square
  background) for leading icons. Both helpers support `GymIconResource`.

### GymTimePickerButton

A stylized button for displaying and triggering time selection.

- **Props**: `time`, `onClick`, `enabled`, `backgroundColor`, `textColor`.

### GymAddInput

A specialized input field with an inline "+" action for adding items to a list. Features a refined
seagrass (`quaternary`) styling for the action button.

- **Props**: `value`, `onValueChange`, `placeholder`, `onAddClick`.

### GymMetricInputCard

A card for profile metrics like Height and Weight with inline numeric input and unit labels.

- **Props**: `label`, `value`, `unit`, `onValueChange`, `icon` (`GymIconResource?`), `accentColor`,
  `placeholder`.

### GymBMICard

A comprehensive card for BMI display, featuring a continuous progress range and status badge.

- **Props**: `bmiValue`, `statusText`, `statusIcon` (`GymIconResource`), `statusColor`, `progress`,
  `description`.

### GymSteppedProgressBar

A multi-step progress indicator with visual segments and step labels.

- **Props**: `currentStep`, `totalSteps`, `stepName`.

### GymTag & GymTagRow

Components for managing selectable or removable tags (e.g., muscle groups).

- **GymTag Props**: `text`, `type` (`Selected` or `Suggested`), `onClick`.
- **GymTagRow**: A flow layout container for multiple tags.

### GymExerciseContextCard

A descriptive card displayed at the top of configuration screens to provide context or instructions.

- **Props**: `exerciseName`, `description`, `icon` (`GymIconResource`).

### GymStepperInput

A split control for incrementing/decrementing values (like sets or reps) with a central display.

- **Props**: `label`, `subLabel`, `value`, `onValueChange`, `icon` (`GymIconResource?`), `minValue`,
  `maxValue`.

### Analytics & Chart Components

Located in `composeApp/src/commonMain/kotlin/dev/ch8n/gymos/ui/foundation/`.

#### GymAnalyticsStatCard

A metric card for dashboard overview with optional trend indicators (badges) and background glow
effects.

- **Props**: `label`, `value`, `trend`, `trendColor`, `unit`, `accentColor`.

#### GymBarChart

A data-driven bar chart for periodic consistency (e.g., weekly attendance).

- **Props**: `data` (List of `BarData`), `barColor`, `backgroundColor`.

#### GymAreaChart

A smooth visualization using Canvas for trends (e.g., Weight or Energy). Features gradient fills and
line smoothing.

- **Props**: `data` (List of Floats 0..1), `lineColor`, `fillColor`.

#### GymDonutChart

A circular chart for category distribution (e.g., Muscle Volume). Supports custom center content for
totals.

- **Props**: `data` (List of `DonutData`), `thickness`, `centerContent`.