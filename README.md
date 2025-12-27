# 🏋️‍♂️ GymOS

**The Personal Gym Operating System**

GymOS is a high-performance personal gym companion designed for planning, execution, habits, and deep insights. Built with **Kotlin Multiplatform** and **Compose Multiplatform**, it provides a seamless and energetic experience across Android, iOS, Web, Desktop, and Server.

---

## ✨ Vision & Purpose

GymOS is built to help you stay consistent, know exactly what to train, and visualize your progress through meaningful data. It combines structured workout planning with real-time execution tools and habit-based reminders—all in one premium, local-first application.

> "A personal gym operating system for planning, execution, habits, and insights."

---

## 🚀 Key Features

### 📅 Workout Planning
*   **Intelligent Calendar:** Track your attendance and targeted muscle groups at a glance.
*   **Dynamic Day Pager:** Easily plan and reorder your daily workouts with a friction-less UI.
*   **Fully Configurable:** No rigid plans—your gym, your rules.

### ⚡ Workout Execution
*   **Real-time Timers:** Stay on track with automated rest and set timers.
*   **Smart Logging:** Quickly log sets, reps, weight, energy, and effort levels.
*   **Form Guidance:** Integrated media support for exercise form.

### 🔔 Habit & Reminder System
*   **Gear Checklist:** Never forget your belt or straps again with pre-gym reminders.
*   **Nutrition Timing:** Simple reminders for meal timing to optimize performance.
*   **Weight & Recovery:** Daily weight logging prompts and bedtime reminders.

### 📊 Analytics & Insights
*   **Progress Visualization:** Beautiful charts for weight trends, volume, and energy correlation.
*   **Local-First Privacy:** Your data stays on your device, giving you full control.

---

## 🎨 Design Philosophy

GymOS features an **energetic, modern, and high-performance** aesthetic.
*   **Theme:** Premium Dark Mode (Deep Charcoal & Pumpkin Orange).
*   **Typography:** Lexend for numeric stats/headings, Noto Sans for content.
*   **Tactile Feedback:** Subtle micro-animations and scaling for every interaction.
*   **Glanceability:** Critical workout stats are oversized and high-contrast for easy reading mid-set.

---

## 🛠 Tech Stack

*   **Core:** [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html) (KMP)
*   **UI Framework:** [Compose Multiplatform](https://github.com/JetBrains/compose-multiplatform/)
*   **Backend:** [Ktor](https://ktor.io/) Server
*   **Storage:** Multiplatform Settings / SQLDelight (Local-first)
*   **Targets:** Android, iOS, Web (Wasm/JS), Desktop (JVM)

---

## 📦 Project Structure

*   [`/composeApp`](./composeApp/src) — Shared UI and business logic for all frontend targets.
*   [`/iosApp`](./iosApp/iosApp) — Native iOS entry point and SwiftUI integration.
*   [`/server`](./server/src/main/kotlin) — Ktor-based backend service.
*   [`/shared`](./shared/src) — Core shared modules across all targets.
*   [`/docs`](./docs) — Detailed PRD, Architecture, and Design specifications.

---

## 🏃‍♂️ Getting Started

### Prerequisites
*   Android Studio / IntelliJ IDEA
*   JDK 17 or higher
*   Xcode (for iOS development)

### Build and Run

#### Android
```shell
./gradlew :composeApp:assembleDebug
```

#### Desktop (JVM)
```shell
./gradlew :composeApp:run
```

#### Web (Wasm)
```shell
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

#### Server
```shell
./gradlew :server:run
```

#### iOS
Open the [`/iosApp`](./iosApp) directory in Xcode and run the project.

---

## 📄 License

This project is licensed under the Apache 2.0 License.

---

*Built with ❤️ by the Chetan Garg.*