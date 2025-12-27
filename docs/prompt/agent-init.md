### Objective
Create `AGENT.md` as a **living guide for future coding agents** so they can:
- Understand how this project works
- Make safe, consistent changes
- Avoid breaking assumptions or architectural constraints

### What you MUST do first
1. Scan the repository structure
2. Read:
   - README and any existing docs
   - package/build configs (package.json, gradle, pom, etc.)
   - entry points, app bootstrap files
   - core domain / business logic
   - test setup and conventions
3. Infer patterns from real code (do NOT guess)

### AGENT.md Structure (required)

Use the following sections **exactly in this order**:

---

# AGENT.md

## 1. Project Overview
- What the project does
- Who it is for
- High-level architecture (frontend/backend/mobile/library/etc.)

## 2. Tech Stack
- Languages
- Frameworks
- Build tools
- Runtime environments
- Key libraries (only those actually used)

## 3. Repository Structure
Explain important folders and their responsibilities.
Call out:
- Entry points
- Domain / core logic
- UI vs business logic separation
- Test directories

## 4. Architectural Principles
Document patterns that are **actually followed**, such as:
- Layered / Clean Architecture / MVVM / MVC
- State management approach
- Dependency boundaries
- Immutability / side-effect rules
- Error handling strategy

## 5. Coding Conventions
Based on the existing code:
- Naming conventions
- File organization rules
- Preferred patterns
- Things explicitly avoided in the codebase

## 6. State & Data Flow
Explain:
- How data flows through the system
- Where state lives
- How it is updated and consumed

## 7. Testing Strategy
- Types of tests present
- How tests are structured
- What should and should not be tested
- How to run tests

## 8. Build & Run Instructions
- Local setup steps
- Build commands
- Run commands
- Environment variables (if any)

## 9. Common Pitfalls
List things a new agent might easily break, such as:
- Implicit assumptions
- Tight couplings
- Non-obvious dependencies
- Performance or security concerns

## 10. How to Safely Make Changes
Step-by-step guidance:
- Where to add new features
- How to add new files
- How to refactor safely
- What must be updated together

## 11. Non-Goals
Explicitly state what this project does NOT try to do.

---

### Writing Rules
- Be **precise and concrete**
- Do NOT restate generic best practices
- Do NOT invent rules not supported by the code
- If something is unclear, explicitly say so
- Prefer bullet points and short paragraphs
- Assume the reader is another AI agent, not a human beginner
