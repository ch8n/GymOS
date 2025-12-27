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

