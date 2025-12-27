# Testing Anti-Patterns

**Load this reference when:** writing or changing tests, adding mocks, or tempted to add test-only methods to production code.

## Overview

Tests must verify real behavior, not mock behavior. Mocks are a means to isolate, not the thing being tested.

**Core principle:** Test what the code does, not what the mocks do.

**Following strict TDD prevents these anti-patterns.**

## The Iron Laws

```
1. NEVER test mock behavior
2. NEVER add test-only methods to production classes
3. NEVER mock without understanding dependencies
```

## Anti-Pattern 1: Testing Mock Behavior

**The violation:**

```kotlin
// ❌ BAD: Testing that the mock exists
@Test
fun `renders sidebar`() {
    render(Page())  // sidebar mocked internally

    assertNotNull(findByTestTag("sidebar-mock"))
}
```

**Why this is wrong:**

* You're verifying the mock works, not that the component works
* Test passes when mock is present, fails when it's not
* Tells you nothing about real behavior

**your human partner's correction:** "Are we testing the behavior of a mock?"

**The fix:**

```kotlin
// ✅ GOOD: Test real component or don't mock it
@Test
fun `renders sidebar`() {
    render(Page()) // real sidebar

    assertNotNull(findByRole("navigation"))
}

// OR if sidebar must be mocked for isolation:
// Don't assert on the mock - test Page's behavior with sidebar present
```

### Gate Function

```
BEFORE asserting on any mock element:
  Ask: "Am I testing real component behavior or just mock existence?"

  IF testing mock existence:
    STOP - Delete the assertion or unmock the component

  Test real behavior instead
```

## Anti-Pattern 2: Test-Only Methods in Production

**The violation:**

```kotlin
// ❌ BAD: destroy() only used in tests
class Session {
    suspend fun destroy() { // Looks like production API!
        workspaceManager?.destroyWorkspace(id)
        // ... cleanup
    }
}

// In tests
@AfterEach
fun tearDown() = runTest {
    session.destroy()
}
```

**Why this is wrong:**

* Production class polluted with test-only code
* Dangerous if accidentally called in production
* Violates YAGNI and separation of concerns
* Confuses object lifecycle with entity lifecycle

**The fix:**

```kotlin
// ✅ GOOD: Test utilities handle test cleanup
// Session has no destroy() - it's stateless in production

// test-utils/
suspend fun cleanupSession(session: Session) {
    val workspace = session.workspaceInfo()
    if (workspace != null) {
        workspaceManager.destroyWorkspace(workspace.id)
    }
}

// In tests
@AfterEach
fun tearDown() = runTest {
    cleanupSession(session)
}
```

### Gate Function

```
BEFORE adding any method to production class:
  Ask: "Is this only used by tests?"

  IF yes:
    STOP - Don't add it
    Put it in test utilities instead

  Ask: "Does this class own this resource's lifecycle?"

  IF no:
    STOP - Wrong class for this method
```

## Anti-Pattern 3: Mocking Without Understanding

**The violation:**

```kotlin
// ❌ BAD: Mock breaks test logic
@Test
fun `detects duplicate server`() = runTest {
    // Mock prevents config write that test depends on!
    mockkObject(ToolCatalog)
    coEvery { ToolCatalog.discoverAndCacheTools() } returns Unit

    addServer(config)
    addServer(config) // Should throw — but won't!
}
```

**Why this is wrong:**

* Mocked method had side effect test depended on (writing config)
* Over-mocking to "be safe" breaks actual behavior
* Test passes for wrong reason or fails mysteriously

**The fix:**

```kotlin
// ✅ GOOD: Mock at correct level
@Test
fun `detects duplicate server`() = runTest {
    // Mock only the slow/external part
    mockkConstructor(MCPServerProcess::class)
    every { anyConstructed<MCPServerProcess>().start() } returns Unit

    addServer(config)  // Config written
    addServer(config)  // Duplicate detected ✓
}
```

### Gate Function

```
BEFORE mocking any method:
  STOP - Don't mock yet

  1. Ask: "What side effects does the real method have?"
  2. Ask: "Does this test depend on any of those side effects?"
  3. Ask: "Do I fully understand what this test needs?"

  IF depends on side effects:
    Mock at lower level (the actual slow/external operation)
    OR use test doubles that preserve necessary behavior
    NOT the high-level method the test depends on

  IF unsure what test depends on:
    Run test with real implementation FIRST
    Observe what actually needs to happen
    THEN add minimal mocking at the right level

  Red flags:
    - "I'll mock this to be safe"
    - "This might be slow, better mock it"
    - Mocking without understanding the dependency chain
```

## Anti-Pattern 4: Incomplete Mocks

**The violation:**

```kotlin
// ❌ BAD: Partial mock - only fields you think you need
val mockResponse = ApiResponse(
    status = "success",
    data = UserData(userId = "123", name = "Alice")
    // Missing: metadata used downstream
)

// Later: crashes when code accesses response.metadata.requestId
```

**Why this is wrong:**

* **Partial mocks hide structural assumptions**
* **Downstream code may depend on omitted fields**
* **Tests pass but integration fails**
* **False confidence**

**The Iron Rule:** Mock the COMPLETE data structure as it exists in reality, not just fields your immediate test uses.

**The fix:**

```kotlin
// ✅ GOOD: Mirror real API completeness
val mockResponse = ApiResponse(
    status = "success",
    data = UserData(userId = "123", name = "Alice"),
    metadata = Metadata(
        requestId = "req-789",
        timestamp = 1_234_567_890
    )
)
```

### Gate Function

```
BEFORE creating mock responses:
  Check: "What fields does the real API response contain?"

  Actions:
    1. Examine actual API response from docs/examples
    2. Include ALL fields system might consume downstream
    3. Verify mock matches real response schema completely

  Critical:
    If you're creating a mock, you must understand the ENTIRE structure
    Partial mocks fail silently when code depends on omitted fields

  If uncertain: Include all documented fields
```

## Anti-Pattern 5: Integration Tests as Afterthought

**The violation:**

```
✅ Implementation complete
❌ No tests written
"Ready for testing"
```

**Why this is wrong:**

* Testing is part of implementation, not optional follow-up
* TDD would have caught this
* Can't claim complete without tests

**The fix:**

```
TDD cycle:
1. Write failing test
2. Implement to pass
3. Refactor
4. THEN claim complete
```

## When Mocks Become Too Complex

**Warning signs:**

* Mock setup longer than test logic
* Mocking everything to make test pass
* Mocks missing methods real components have
* Test breaks when mock changes

**your human partner's question:** "Do we need to be using a mock here?"

**Consider:** Integration tests with real components are often simpler than complex mocks

## TDD Prevents These Anti-Patterns

**Why TDD helps:**

1. **Write test first** → Forces clarity on behavior
2. **Watch it fail** → Confirms real behavior is tested
3. **Minimal implementation** → No test-only methods
4. **Real dependencies first** → Mock only when necessary

**If you're testing mock behavior, you violated TDD.**

## Quick Reference

| Anti-Pattern                    | Fix                              |
| ------------------------------- | -------------------------------- |
| Assert on mock elements         | Test real component or unmock it |
| Test-only methods in production | Move to test utilities           |
| Mock without understanding      | Understand dependencies first    |
| Incomplete mocks                | Mirror real API completely       |
| Tests as afterthought           | TDD – tests first                |
| Over-complex mocks              | Prefer integration tests         |

## Red Flags

* Assertions checking `*-mock` tags
* Methods only called in tests
* Mock setup >50% of test
* Test fails when mock removed
* Can't explain why mock exists
* Mocking "just to be safe"

## The Bottom Line

**Mocks are tools to isolate, not things to test.**

If TDD reveals you're testing mock behavior, you've already gone wrong.

Fix it by testing real behavior — or questioning why the mock exists at all.
