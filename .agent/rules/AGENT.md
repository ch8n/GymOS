---
trigger: always_on
---

# AGENT.md

## 1. Project Overview
GymOS is a personal gym operating system designed for workout planning, execution, habit tracking, and progress insights. It aims to bridge the gap between pure workout trackers and habit-building apps.

- **Target Audience:** Dedicated gym-goers seeking structure and beginners building discipline.
- **Architecture:** Kotlin Multiplatform (KMP) project targeting Android, iOS, Web (Wasm/JS), Desktop (JVM), and a Ktor-based Server. It follows Clean Architecture and Domain-Driven Design (DDD) principles.

## 2. Tech Stack
- **Languages:** Kotlin (Core), Swift (iOS native shell).
- **Frameworks:** Compose Multiplatform (UI), Ktor (Backend/Networking).
- **Build Tools:** Gradle (Kotlin DSL).
- **Runtime Environments:** Android JVM, iOS Native, Browser (Wasm/JS), Desktop JVM.
- **Key Libraries:** 
  - `androidx-lifecycle` for state management in Compose.
  - `kotlinx-coroutines` for asynchronous programming.
  - `Material3` for UI components.

## 3. Repository Structure
- `/composeApp`: Shared UI code using Compose Multiplatform.
  - `commonMain`: UI logic shared across all platforms.
  - `androidMain`, `iosMain`, `jvmMain`, `wasmJsMain`: Platform-specific UI implementations.
- `/shared`: Core business logic and domain entities shared across all targets (including server).
  - `commonMain`: Domain models, use cases, and repository interfaces.
- `/server`: Ktor server application logic.
- `/iosApp`: Native iOS application entry point and SwiftUI code.
- `/docs`: Project documentation, including PRD, Wireframes, and Architectural guidelines.

## 4. Architectural Principles
- **Clean Architecture & DDD:** Separate domain entities from infrastructure concerns. Keep business logic framework-independent.
- **Library-First:** Prioritize using existing libraries (e.g., via Maven Central/Compose Multiplatform) over custom implementations.
- **Library vs Custom Code:** Only write custom code for domain-specific business logic or when existing solutions don't meet requirements.
- **Separation of Concerns:** Business logic belongs in `shared`, UI logic in `composeApp`. Do not leak infrastructure details into the domain.

## 5. Coding Conventions
- **Naming:** Avoid generic names like `utils`, `helpers`, or `common`. Use domain-specific names (e.g., `WorkoutCalculator`, `HabitValidator`).
- **File Limits:** Keep files under 200 lines. Split into multiple files if they exceed this limit.
- **Function/Component Limits:** Keep functions/components under 80 lines. Decompose if they grow larger.
- **Early Return Pattern:** Use early returns to reduce nesting and improve readability.
- **Conciseness:** Prefer Kotlin idiomatic syntax (trailing lambdas, expression-body functions).

## 6. State & Data Flow
- **UI State:** Managed using Compose `State` and `MutableState` within `composeApp`.
- **Business Logic State:** Handled via ViewModels (using `androidx-lifecycle`) in the UI layer, calling into `shared` use cases.
- **Data Flow:** Unidirectional data flow (UDF) is the preferred pattern.

## 7. Testing Strategy
- **Unit Tests:** Located in `commonTest` within both `shared` and `composeApp`.
- **Focus:** Test business logic in `shared` and state transitions in `composeApp`.
- **How to Run:**
  - Run all tests: `./gradlew test`
  - Run shared tests: `./gradlew :shared:allTests`

## 8. Build & Run Instructions
- **Android:** `./gradlew :composeApp:assembleDebug`
- **Desktop:** `./gradlew :composeApp:run`
- **Server:** `./gradlew :server:run`
- **Web (Wasm):** `./gradlew :composeApp:wasmJsBrowserDevelopmentRun`
- **iOS:** Open `iosApp` directory in Xcode or use `./gradlew :composeApp:iosSimulatorArm64Run`.

## 9. Common Pitfalls
- **Generic Modules:** Creating `shared/utils` instead of specific domain modules.
- **UI Logic Leakage:** Placing UI-specific logic (like strings or colors) in the `shared` module.
- **Deep Nesting:** Going beyond 3 levels of nesting in functions.
- **Ignoring Docs:** Failing to check `docs/skills` for specific development guidelines.

## 10. How to Safely Make Changes
- **Feature Addition:** Start by defining the domain model and use cases in `shared/commonMain`.
- **UI Implementation:** Create Compose components in `composeApp/commonMain`, connecting them to business logic.
- **Verification:** Always run existing tests and add new ones for added logic.
- **Refactoring:** Ensure single responsibility and adhere to the line count limits (80/200).
- **Design System Sync:** Whenever there is change in design tokens or foundation components, its
  mandatory to update `design_system.md` file located in `.agent/rules/design_system.md`
  accordingly.
- **Token Consistency**: Always use `GymTheme.sizes` for dimensions (width, height, icon size) and
  `GymTheme.spacing` for layout gaps and padding. Hardcoded DP/SP values are PROHIBITED.

## 11. Non-Goals
- **AI Integration:** Not planned for MVP.
- **Calorie Counting:** Explicitly excluded from initial scope.
- **Wearable Support:** Future enhancement, not for MVP.
- **Social Features:** Not part of the core "Personal Operating System" vision.
