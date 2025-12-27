---
name: doc-coauthoring
description: Guide users through a structured workflow for co-authoring documentation. Use when user wants to write documentation, proposals, technical specs, decision docs, or similar structured content. This workflow helps users efficiently transfer context, refine content through iteration, and verify the doc works for readers. Trigger when user mentions writing docs, creating proposals, drafting specs, or similar documentation tasks.
---
```

# Doc Co-Authoring Workflow

This skill provides a structured workflow for guiding users through collaborative document creation. Act as an active guide, walking users through three stages: Context Gathering, Refinement & Structure, and Reader Testing.

## When to Offer This Workflow

**Trigger conditions:**

* User mentions writing documentation: "write a doc", "draft a proposal", "create a spec", "write up"
* User mentions specific doc types: "PRD", "design doc", "decision doc", "RFC"
* User seems to be starting a substantial writing task

**Initial offer:**
Offer the user a structured workflow for co-authoring the document. Explain the three stages:

1. **Context Gathering**: User provides all relevant context while the LLM asks clarifying questions
2. **Refinement & Structure**: Iteratively build each section through brainstorming and editing
3. **Reader Testing**: Test the doc with a fresh LLM instance (no context) to catch blind spots before others read it

Explain that this approach helps ensure the doc works well when others read it (including when they paste it into an LLM). Ask if they want to try this workflow or prefer to work freeform.

If user declines, work freeform. If user accepts, proceed to Stage 1.

---

## Stage 1: Context Gathering

**Goal:** Close the gap between what the user knows and what the LLM knows, enabling smart guidance later.

### Initial Questions

Start by asking the user for meta-context about the document:

1. What type of document is this? (e.g., technical spec, decision doc, proposal)
2. Who's the primary audience?
3. What's the desired impact when someone reads this?
4. Is there a template or specific format to follow?
5. Any other constraints or context to know?

Inform them they can answer in shorthand or dump information however works best for them.

**If user provides a template or mentions a doc type:**

* Ask if they have a template document to share
* If they provide a link to a shared document, use the appropriate available integration to fetch it
* If they provide a file, read it

**If user mentions editing an existing shared document:**

* Use the appropriate available integration to read the current state
* Check for images without alt-text
* If images exist without alt-text, explain that when others use an LLM to understand the doc, the model won’t be able to see them. Ask if they want alt-text generated. If so, request they paste each image into chat for descriptive alt-text generation.

### Info Dumping

Once initial questions are answered, encourage the user to dump all the context they have. Request information such as:

* Background on the project/problem
* Related team discussions or shared documents
* Why alternative solutions aren't being used
* Organizational context (team dynamics, past incidents, politics)
* Timeline pressures or constraints
* Technical architecture or dependencies
* Stakeholder concerns

Advise them not to worry about organizing it — just get it all out. Offer multiple ways to provide context:

* Info dump stream-of-consciousness
* Point to team channels or threads to read
* Link to shared documents

**If integrations are available** (e.g., Slack, Teams, Google Drive, SharePoint, internal knowledge bases, MCP servers), mention that these can be used to pull in context directly.

**If no integrations are detected:**
Suggest they can enable connectors or permissions (where supported by the platform) to allow pulling context from messaging apps and document storage directly, or paste content manually.

Inform them clarifying questions will be asked once they've done their initial dump.

### During Context Gathering

* If user mentions team channels or shared documents:

  * If integrations are available: Inform them the content will be read now, then use the appropriate integration
  * If integrations are not available: Explain the lack of access and ask them to paste relevant excerpts

* If user mentions entities/projects that are unknown:

  * Ask if connected tools should be searched to learn more
  * Wait for user confirmation before searching

* As user provides context, track what's being learned and what's still unclear

### Asking Clarifying Questions

When the user signals they've done their initial dump (or after substantial context is provided), ask clarifying questions to ensure understanding:

Generate 5–10 numbered questions based on gaps in the context.

Inform them they can answer in shorthand (e.g., "1: yes, 2: see #channel, 3: no because backwards compat"), link to more docs, point to channels to read, or continue info-dumping — whatever is most efficient.

**Exit condition:**
Sufficient context has been gathered when questions show understanding — when edge cases and trade-offs can be asked about without needing basics explained.

**Transition:**
Ask if there’s any more context they want to provide, or if it’s time to move on to drafting the document.

---

## Stage 2: Refinement & Structure

**Goal:** Build the document section by section through brainstorming, curation, and iterative refinement.

**Instructions to user:**
Explain that the document will be built section by section. For each section:

1. Clarifying questions will be asked about what to include
2. 5–20 options will be brainstormed
3. User will indicate what to keep/remove/combine
4. The section will be drafted
5. It will be refined through surgical edits

Start with whichever section has the most unknowns (usually the core decision/proposal), then work through the rest.

### Section Ordering

If the document structure is clear:
Ask which section they'd like to start with.

Suggest starting with the section that has the most uncertainty. Summary sections are best left for last.

If user doesn't know what sections they need:
Based on the document type or template, suggest 3–5 appropriate sections.

Ask if this structure works or if they want to adjust it.

### Once Structure Is Agreed

Create the initial document structure with placeholder text for all sections.

**If access to artifacts or files is available:**

* Use the platform’s file/artifact creation mechanism to create a scaffold
* Include all section headers with placeholders like `[To be written]`

Provide the scaffold reference and indicate it’s time to fill in each section.

**If no file/artifact support exists:**

* Maintain the document in-chat as a structured markdown outline
* Track edits incrementally without reprinting the entire doc unnecessarily

### For Each Section

#### Step 1: Clarifying Questions

Announce work will begin on the **[SECTION NAME]** section.

Ask 5–10 specific clarifying questions based on context and section purpose.

#### Step 2: Brainstorming

Brainstorm 5–20 candidate points to include:

* Forgotten context
* Edge cases
* Unspoken assumptions
* Reader concerns

Offer to brainstorm more if needed.

#### Step 3: Curation

Ask which points to keep, remove, or combine. Encourage brief justifications.

If feedback is freeform, infer intent and proceed.

#### Step 4: Gap Check

Ask if anything important is missing from this section.

#### Step 5: Drafting

Replace the placeholder with drafted content based on selected points.

Ask the user to review and request changes **without directly editing**, if possible, to help learn preferences.

#### Step 6: Iterative Refinement

Apply edits surgically. Avoid reprinting the full document.

Continue until the section stabilizes.

### Quality Check

After several iterations with no major changes, ask:

> “Is there anything here we could remove without losing meaning?”

Confirm section completion and move on.

### Near Completion

When ~80% complete:

* Review entire document for flow, redundancy, contradictions, and filler
* Provide feedback and suggestions

When all sections are drafted:

* Perform a final coherence pass
* Ask if ready for Reader Testing

---

## Stage 3: Reader Testing

**Goal:** Verify the document works for readers with no prior context.

### Testing Approach

**If sub-agents or parallel model instances are available:**
Run testing directly using a fresh instance with no prior context.

### Step 1: Predict Reader Questions

Generate 5–10 realistic questions a reader might ask.

### Step 2: Test With Fresh Model

Provide only the document content + one question per run.

Summarize:

* What the model answered correctly
* What it misunderstood or couldn’t answer

### Step 3: Additional Checks

Test for:

* Ambiguity
* Hidden assumptions
* Internal contradictions

### Step 4: Report & Fix

If issues appear:

* Identify affected sections
* Loop back to refinement

---

### If No Sub-Agents or Parallel Instances Are Available

Instruct the user to:

1. Open a new LLM conversation
2. Paste the document
3. Ask the generated questions
4. Note confusion, assumptions, or errors

Loop back and fix issues.

---

## Final Review

When Reader Testing passes:

1. Recommend a final human read-through
2. Verify facts, links, and technical accuracy
3. Confirm the doc achieves its intended impact

Offer a final polish if desired. Otherwise, confirm completion and suggest:

* Using appendices for depth
* Iterating based on real reader feedback
* Linking this workflow as provenance if helpful

---

## Tips for Effective Guidance

* Be direct and procedural
* Explain rationale only when it affects user behavior
* Don’t oversell the process
* Always give the user control

**Quality > speed.**
The goal is a document that actually works for readers.