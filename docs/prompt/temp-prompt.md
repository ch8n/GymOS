context :
Project context : read @.agent/rules/AGENT.md
Design tokens and design system components: read @.agent/rules/design_system.md

High level Task :
1. analyse @docs/wireframe/stitch_calendar_view/progress_&_analytics_dashboard/ code and screenshot of the ProgressAnalytics Page design.
2. Jetpack compose implementation of progress_&_analytics_dashboard is in @composeApp/src/commonMain/kotlin/dev/ch8n/gymos/ui/progressAnalytics/ProgressAnalyticsScreen.kt
3. App navigation context : composeApp/src/commonMain/kotlin/dev/ch8n/gymos/App.kt
AIM : 
1. figure out on which screen level composable does GymBottomNavigation composable is getting used
2. for all screen level composable pass lambda of onProgressClick from App.kt to screen to GymBottomNavigation
3. In App.kt for all screen add navigate to ProgressAnalyticsScreen
