# 🎨 STITCH / FIGMA MASTER PROMPT

**GymOS – Personal Gym Operating System**

---

## Product Context

Design a **mobile-first fitness application** called **GymOS** that helps users:

* Plan workouts day-wise
* Execute workouts with timers and effort tracking
* Build gym habits via reminders
* Track body metrics and progress
* Visualize consistency, energy, and weight trends

The app should feel **minimal, focused, and execution-driven**, not social or gamified-heavy.

Target platform: **Mobile (Android & iOS)**
Theme: **Dark mode first**, high contrast, gym-friendly

---

## Global Design Guidelines

* Bottom navigation with 4 tabs:

  * Home
  * Calendar
  * Progress
  * Profile
* Use cards, dividers, and section headers
* Use icons for muscle groups, reminders, stats
* All weights are in **KG**
* Inputs should be fast and thumb-friendly
* Prioritize **one-hand usability**
* Avoid clutter; default collapsed sections where possible

---

## Screen 1: Home / Today Overview

### Purpose

Give a quick snapshot of today’s workout and motivation to go to the gym.

### Layout

* Header with app name + profile icon
* Today’s date
* Gym time (editable)
* Target muscle chips (e.g., Chest, Triceps, Cardio)
* Primary CTA: **“View Today’s Workout”**
* Quick stats:

  * Attendance streak
  * Last logged weight

---

## Screen 2: Calendar View (Attendance)

### Purpose

Visualize gym consistency and muscle targeting.

### Layout

* Monthly calendar grid
* Each day shows:

  * Attended / Missed / Rest state (color-coded)
  * Small muscle indicators (dots or icons)
* Legend explaining colors and muscle dots
* Tapping a date opens **Day View**

---

## Screen 3: Day View (Pager – Core Screen)

### Purpose

Show what to train on a given day.

### Interaction

* Horizontal swipe between days (previous / today / next)
* Day title with date

### Content (Grouped by Body Part)

* Section headers per body part:

  * CHEST
  * TRICEPS
  * BACK
  * LEGS
  * CARDIO
* Under each section:

  * List of exercises (prefilled)
  * Each exercise row tappable
* Floating or inline **“+ Add Exercise”** button

---

## Screen 4: Exercise Detail / Execution

### Purpose

Guide the user while performing an exercise.

### Layout

* Exercise name
* Media section (image / video / GIF demo)
* Configurable fields:

  * Sets
  * Reps
  * Weight (KG)
  * Rest time
* Active set card:

  * Rep countdown timer
  * Energy level selector (1–3)
  * Effort level selector (1–3)
  * “Complete Set” button
* Auto rest timer between sets

---

## Screen 5: Exercise Summary

### Purpose

Give feedback after completing an exercise.

### Content

* Sets completed
* Total volume lifted
* Average energy level
* Average effort
* “Mark Exercise Done” CTA

---

## Screen 6: Add Exercise

### Purpose

Allow adding prefilled or custom exercises.

### Layout

* Search bar
* List of popular prefilled exercises with “+” action
* “Create Custom Exercise” option
* Assign body part during add flow

---

## Screen 7: Reminders & Habits

### Purpose

Help user show up prepared and consistent.

### Sections

* Gym time reminder (time picker)
* Gear checklist (editable list):

  * Water bottle
  * Gloves
  * Towel
  * Bag
  * Custom items
* Daily weight reminder toggle
* Meal time reminders:

  * Breakfast
  * Lunch
  * Dinner
* Bedtime reminder

---

## Screen 8: Profile & Body Metrics

### Purpose

Manage body data and personal info.

### Layout

* Height input
* Weight input
* BMI auto-calculated with category label
* “Update Weight” CTA

---

## Screen 9: Progress & Analytics

### Purpose

Visualize improvement and patterns.

### Charts

* Attendance over time
* Energy levels trend
* Weight gain / loss
* Workout volume per muscle group

Use simple, clean graphs with minimal decoration.

---

## UX & Interaction Rules

* Prefilled exercise library by default
* User can add custom exercises anytime
* Logging should require minimal typing
* Timers should auto-progress
* All reminder notifications are configurable
* Offline-first UX (assume data sync later)

---

## Components to Generate

* Bottom navigation bar
* Calendar component
* Exercise list item
* Muscle group section header
* Timer component
* Energy / Effort selector
* Chart components
* Reminder list item
* Gear checklist item

---

## Design Tone

* Focused
* Motivational, not aggressive
* Clean typography
* Subtle animations (timers, progress)
* No social feed, no leaderboards

---

## Output Expectation

Generate:

* A complete **multi-screen mobile UI**
* Consistent component system
* Reusable design tokens
* Clear screen-to-screen navigation