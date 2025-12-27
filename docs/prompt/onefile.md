---
name: frontend-design
description: Create distinctive, production-grade frontend interfaces with high design quality. Use this skill when the user asks to build web components, pages, artifacts, posters, or applications (examples include websites, landing pages, dashboards, React components, HTML/CSS layouts, or when styling/beautifying any web UI). Generates creative, polished code and UI design that avoids generic AI aesthetics.
license: Complete terms in LICENSE.txt
---

This skill guides creation of distinctive, production-grade frontend interfaces that avoid generic "AI slop" aesthetics. Implement real working code with exceptional attention to aesthetic details and creative choices.

The user provides frontend requirements: a component, page, application, or interface to build. They may include context about the purpose, audience, or technical constraints.

## Design Thinking

Before coding, understand the context and commit to a BOLD aesthetic direction:
- **Purpose**: What problem does this interface solve? Who uses it?
- **Tone**: Pick an extreme: brutally minimal, maximalist chaos, retro-futuristic, organic/natural, luxury/refined, playful/toy-like, editorial/magazine, brutalist/raw, art deco/geometric, soft/pastel, industrial/utilitarian, etc. There are so many flavors to choose from. Use these for inspiration but design one that is true to the aesthetic direction.
- **Constraints**: Technical requirements (framework, performance, accessibility).
- **Differentiation**: What makes this UNFORGETTABLE? What's the one thing someone will remember?

**CRITICAL**: Choose a clear conceptual direction and execute it with precision. Bold maximalism and refined minimalism both work - the key is intentionality, not intensity.

Then implement working code (HTML/CSS/JS, React, Vue, etc.) that is:
- Production-grade and functional
- Visually striking and memorable
- Cohesive with a clear aesthetic point-of-view
- Meticulously refined in every detail

## Frontend Aesthetics Guidelines

Focus on:
- **Typography**: Choose fonts that are beautiful, unique, and interesting. Avoid generic fonts like Arial and Inter; opt instead for distinctive choices that elevate the frontend's aesthetics; unexpected, characterful font choices. Pair a distinctive display font with a refined body font.
- **Color & Theme**: Commit to a cohesive aesthetic. Use CSS variables for consistency. Dominant colors with sharp accents outperform timid, evenly-distributed palettes.
- **Motion**: Use animations for effects and micro-interactions. Prioritize CSS-only solutions for HTML. Use Motion library for React when available. Focus on high-impact moments: one well-orchestrated page load with staggered reveals (animation-delay) creates more delight than scattered micro-interactions. Use scroll-triggering and hover states that surprise.
- **Spatial Composition**: Unexpected layouts. Asymmetry. Overlap. Diagonal flow. Grid-breaking elements. Generous negative space OR controlled density.
- **Backgrounds & Visual Details**: Create atmosphere and depth rather than defaulting to solid colors. Add contextual effects and textures that match the overall aesthetic. Apply creative forms like gradient meshes, noise textures, geometric patterns, layered transparencies, dramatic shadows, decorative borders, custom cursors, and grain overlays.

NEVER use generic AI-generated aesthetics like overused font families (Inter, Roboto, Arial, system fonts), cliched color schemes (particularly purple gradients on white backgrounds), predictable layouts and component patterns, and cookie-cutter design that lacks context-specific character.

Interpret creatively and make unexpected choices that feel genuinely designed for the context. No design should be the same. Vary between light and dark themes, different fonts, different aesthetics. NEVER converge on common choices (Space Grotesk, for example) across generations.

**IMPORTANT**: Match implementation complexity to the aesthetic vision. Maximalist designs need elaborate code with extensive animations and effects. Minimalist or refined designs need restraint, precision, and careful attention to spacing, typography, and subtle details. Elegance comes from executing the vision well.

Remember: You are capable of extraordinary creative work. Don't hold back, show what can truly be created when thinking outside the box and committing fully to a distinctive vision.

---

using frontend-design skill design UI for the following application :

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


----

# Detailed wireframe for Guidelines

ß# 🧩 ASCII WIREFRAMES — GYM APP

---

## 1. App Entry / Home (Today Focus)

```
+------------------------------------------------+
|  GymOS                                 ⚙️ Profile|
+------------------------------------------------+
|  📅 Today: Monday, 14 Oct                       |
|                                                |
|  ⏰ Gym Time: 6:30 PM                           |
|                                                |
|  🎯 Target Muscles                             |
|   [ Chest ] [ Triceps ] [ Cardio ]             |
|                                                |
|  👉 View Today’s Workout  >                    |
|                                                |
|  📊 Quick Stats                                |
|   Attendance: 🔥 4-day streak                  |
|   Last Weight: 72.4 kg                         |
+------------------------------------------------+
|  🏠 Home   📅 Calendar   📈 Progress   🔔 Alerts |
+------------------------------------------------+
```

---

## 2. Calendar View (Attendance + Muscle Indicator)

```
+------------------------------------------------+
|  📅 Calendar                                   |
+------------------------------------------------+
|   Oct 2025                                     |
|                                                |
|  Su Mo Tu We Th Fr Sa                          |
|      1  2  3  4                                |
|   5  6  7  8  9 10 11                          |
|  12 13 14 15 16 17 18                          |
|                                                |
|  Legend:                                      |
|   ● Green = Attended                           |
|   ● Red = Missed                              |
|   ● Grey = Rest                               |
|                                                |
|  Muscle dots:                                 |
|   🔴 Chest  🔵 Back  🟢 Legs  🟡 Cardio         |
+------------------------------------------------+
| Tap a day to open workout                      |
+------------------------------------------------+
```

---

## 3. Day View (Pager) — **Grouped by Body Part**

```
+------------------------------------------------+
|  ◀  Monday, 14 Oct  ▶                          |
+------------------------------------------------+
|  🎯 Body Parts                                 |
|   Chest • Triceps • Cardio                     |
|                                                |
|  ── CHEST ──────────────────────────           |
|  ▢ Bench Press        >                        |
|  ▢ Incline DB Press   >                        |
|  ▢ Cable Fly          >                        |
|                                                |
|  ── TRICEPS ───────────────────────            |
|  ▢ Tricep Pushdown    >                        |
|  ▢ Skull Crushers    >                        |
|                                                |
|  ── CARDIO ───────────────────────             |
|  ▢ Treadmill          >                        |
|                                                |
|  [+ Add Exercise]                             |
+------------------------------------------------+
```

👉 Exercises here are **prefilled**, tap opens details.
➕ Add allows user-defined/custom exercises.

---

## 4. Exercise Detail / Execution Screen

```
+------------------------------------------------+
|  Bench Press                                  |
+------------------------------------------------+
|  [ Image / Video Demo ]                        |
|                                                |
|  Sets: 3       Reps: 10                        |
|  Weight: 40 kg                                 |
|  Rest: 90 sec                                  |
|                                                |
|  ── SET 1 ─────────────────────────            |
|  ⏱ Rep Timer: 00:30                            |
|                                                |
|  Energy:  [1] [2] [3]                          |
|  Effort:  [1] [2] [3]                          |
|                                                |
|  [ Complete Set ]                              |
|                                                |
|  Next Rest: 01:30                              |
+------------------------------------------------+
```

---

## 5. Post-Exercise Summary

```
+------------------------------------------------+
|  Bench Press — Summary                         |
+------------------------------------------------+
|  Sets Completed: 3 / 3                         |
|  Total Volume: 1200 kg                         |
|                                                |
|  Avg Energy: 2                                 |
|  Avg Effort: 3                                 |
|                                                |
|  ✔ Mark Exercise Done                          |
+------------------------------------------------+
```

---

## 6. Add Exercise (Prefilled + Custom)

```
+------------------------------------------------+
|  ➕ Add Exercise                               |
+------------------------------------------------+
|  🔍 Search Exercise                            |
|  [ Bench Press        ]                        |
|                                                |
|  Popular:                                     |
|  • Squat                                   +   |
|  • Deadlift                               +   |
|  • Shoulder Press                         +   |
|                                                |
|  [+ Create Custom Exercise]                    |
+------------------------------------------------+
```

---

## 7. Reminders & Habits Setup

```
+------------------------------------------------+
|  🔔 Reminders                                  |
+------------------------------------------------+
|  ⏰ Gym Time                                   |
|   6:30 PM   [ Edit ]                           |
|                                                |
|  🎒 Gear Checklist                             |
|   ☑ Water Bottle                              |
|   ☑ Gloves                                    |
|   ☐ Towel                                     |
|   [+ Add Item]                                 |
|                                                |
|  ⚖️ Daily Weight Reminder                     |
|   Enabled                                     |
|                                                |
|  🍽 Meal Reminders                             |
|   Breakfast: 9:00 AM                           |
|   Lunch: 1:30 PM                               |
|   Dinner: 8:30 PM                              |
|                                                |
|  😴 Bedtime Reminder                           |
|   11:30 PM                                    |
+------------------------------------------------+
```

---

## 8. Profile & Body Metrics

```
+------------------------------------------------+
|  👤 Profile                                    |
+------------------------------------------------+
|  Height: 175 cm                                |
|  Weight: 72.4 kg                               |
|                                                |
|  BMI: 23.6 (Normal)                            |
|                                                |
|  [ Update Weight ]                             |
+------------------------------------------------+
```

---

## 9. Progress & Analytics Dashboard

```
+------------------------------------------------+
|  📈 Progress                                   |
+------------------------------------------------+
|  📅 Attendance                                 |
|  [ Graph: Days vs Attendance ]                 |
|                                                |
|  ⚡ Energy Levels                               |
|  [ Line Chart ]                                |
|                                                |
|  ⚖️ Weight Trend                               |
|  [ Line Chart ]                                |
|                                                |
|  🏋️ Volume per Muscle Group                   |
|  [ Bar Chart ]                                 |
+------------------------------------------------+
```

---

## 10. Missed Workout Recovery (Optional UX)

```
+------------------------------------------------+
|  ❗ Workout Missed                             |
+------------------------------------------------+
|  You missed Monday’s workout                   |
|                                                |
|  [ Reschedule ]   [ Skip ]                     |
+------------------------------------------------+
```

---

## UX PRINCIPLES USED

* **Execution-first** (timers, minimal typing)
* **Grouped mental model** (body parts > exercises)
* **Offline-friendly**
* **Low friction logging**
* **Habit reinforcement over guilt**

---

# 📄 Product Requirements Document (PRD)

## Product Name (Working): **GymOS**

*A personal gym operating system for planning, execution, habits, and insights*

---

## 1. Purpose & Vision

### Vision

Build a **personal gym companion** that helps users:

* Stay consistent with workouts
* Know what to train each day
* Track effort, energy, and progress
* Build gym-related habits (timing, gear, nutrition, sleep)
* Visualize physical improvement over time

### Problem Statement

Gym-goers lack a single app that combines:

* Structured workout planning
* Real-time workout execution tools
* Habit-based reminders
* Meaningful insights from workout + lifestyle data

Existing apps either track workouts **or** habits — rarely both.

---

## 2. Target Users

### Primary User

* Regular gym-goer (3–6 days/week)
* Wants structure but flexibility
* Tracks progress manually or inconsistently

### Secondary User

* Beginner trying to build discipline
* Returning gym member restarting routine

---

## 3. Success Metrics

### Product KPIs

* Weekly active users (WAU)
* Workout completion rate
* Attendance streak length
* Weight logging consistency
* Reminder engagement rate

### User Success Signals

* Increased gym attendance
* Visible weight or performance trends
* Reduced missed workouts

---

## 4. Core User Flows

1. **Plan workout** → Calendar → Day view → Add workouts
2. **Execute workout** → Timers → Set completion → Effort logging
3. **Build habits** → Reminders → Gear checklist → Nutrition timing
4. **Track body** → Weight → BMI → Trends
5. **Review progress** → Charts → Insights

---

## 5. Features & Requirements

---

## 5.1 Workout Planning

### Calendar View

**Description**

* Monthly calendar showing gym attendance

**Functional Requirements**

* Each day shows:

  * Attended / Missed / Rest
* Visual indicators for targeted muscle groups
* Tap on date opens Day Pager

**Non-Functional**

* Offline support
* Fast rendering (<300ms)

---

### Day Pager (Day-wise Workout List)

**Description**
Horizontal swipeable day view

**Functional Requirements**

* Add/remove workouts
* Assign multiple muscle groups per day
* Include cardio as a muscle category
* Reorder workouts

**Constraints**

* No predefined rigid plans in MVP
* Fully user-configurable

---

## 5.2 Workout Detail Screen

**Description**
Detailed execution screen per exercise

### Media

* Image / GIF / video showing correct form

### Configuration Fields

* Sets (integer)
* Reps per set (integer)
* Weight (KG only)
* Rest time (seconds)
* Optional rep countdown timer

### During Workout

* Start/stop timers
* Auto-advance to next set
* Quick input per set:

  * Energy level (1–3)
  * Effort level (1–3)
  * Weight used

### Post Workout

* Auto summary:

  * Total volume
  * Average effort
  * Completion status

---

## 5.3 Habit & Reminder System

### Gym Time Reminder

* User-defined gym time
* Notifications:

  * Before gym time
  * Missed workout follow-up

---

### Gear Checklist Reminder

* User-defined checklist items
* Notification triggered before gym time
* Editable list

---

### Nutrition Timing Reminders

* Breakfast / Lunch / Dinner time
* Simple reminder notifications
* No calorie counting in MVP

---

### Weight Logging Reminder

* Daily reminder to log weight
* Escalation reminder if skipped multiple days

---

### Bedtime Reminder

* User-defined bedtime
* Contextual reminder if gym planned next day

---

## 5.4 Profile & Body Metrics

### Profile Fields

* Height
* Weight
* Optional: Age, Gender

### Calculations

* BMI (auto-calculated)
* Weight change over time

---

## 5.5 Analytics & Insights

### Charts

* Attendance over time
* Energy levels over time
* Weight trend
* Workout volume per muscle group

### Insights (Rule-Based)

* Energy vs workout intensity
* Attendance consistency
* Weight change correlation with activity

---

## 6. MVP Scope

### Included in MVP

* Calendar view
* Day pager
* Workout CRUD
* Workout execution timers
* Energy & effort tracking
* Gym time reminders
* Gear checklist
* Weight logging + BMI
* Basic charts

### Excluded from MVP

* AI workout recommendations
* Nutrition macros
* Wearable integrations
* Social / coach features

---

## 7. Future Enhancements

* Smart rest day recommendations
* Missed workout auto-rescheduling
* PR tracking
* Coach sharing mode
* Voice input during workouts
* Data export (CSV / PDF)
* Cloud sync across devices

---

## 8. Non-Functional Requirements

* Offline-first
* Data privacy (local-first storage)
* Fast startup (<1 second)
* Battery-efficient background reminders

---

## 9. Risks & Mitigations

| Risk               | Mitigation                  |
| ------------------ | --------------------------- |
| Too many reminders | User-configurable frequency |
| Data entry fatigue | Defaults + quick inputs     |
| User drop-off      | Streaks & visual progress   |

---

## 10. Open Questions (For Next Phase)

* Preloaded exercise library or manual only? - Yes
* Dark mode default? - Yes
* Cloud sync in MVP or Phase 2?
* Wearable integration priority?
