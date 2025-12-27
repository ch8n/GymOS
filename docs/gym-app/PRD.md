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
