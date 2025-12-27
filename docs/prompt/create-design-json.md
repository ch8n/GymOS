### 🎯 Objective

Analyze the **existing HTML files (and any attached screenshots)** to extract a **complete, AI-readable design system** and output it as a single `design.json` file.

This file will act as the **source of truth for the product’s visual language**, enabling any AI or developer to **faithfully recreate the UI without seeing the original designs**.

You are acting as:

* A **Creative Director**
* A **Design Systems Architect**
* A **Senior Frontend Engineer**

---

### 🧠 Analysis Instructions (Critical)

1. **Deeply inspect actual usage**, not intent

   * Derive tokens from **real values used in HTML/CSS**
   * Ignore unused styles, dead classes, or accidental inconsistencies

2. **Detect patterns, not instances**

   * Normalize spacing, colors, radii, font sizes into **semantic scales**
   * Example: convert `padding: 12px, 14px, 16px` → spacing scale with rationale

3. **Abstract to intent**

   * Do not just list values
   * Explain *why* the system uses them (hierarchy, density, emphasis, rhythm)

4. **Be opinionated but grounded**

   * Resolve inconsistencies into a clean system
   * Document assumptions when normalization is required

---

### 📦 Output Requirements

Produce **one file only**:

```
design.json
```

No markdown. No explanations outside JSON.
Comments may be included **inside JSON as `_comment` fields only**.

---

### 🧩 `design.json` Structure (Required)

```json
{
  "meta": {
    "designPhilosophy": "",
    "visualPersonality": "",
    "density": "",
    "accessibilityLevel": "",
    "platformIntent": ""
  },

  "foundations": {
    "color": {
      "palette": {
        "brand": {},
        "neutral": {},
        "semantic": {}
      },
      "usageGuidelines": {}
    },

    "typography": {
      "fontFamilies": {},
      "scales": {
        "display": [],
        "heading": [],
        "body": [],
        "caption": []
      },
      "lineHeights": {},
      "fontWeights": {},
      "usageGuidelines": {}
    },

    "spacing": {
      "scale": [],
      "layoutSpacing": {},
      "componentSpacing": {},
      "usageGuidelines": {}
    },

    "radii": {
      "scale": [],
      "usageGuidelines": {}
    },

    "elevation": {
      "levels": {},
      "shadowTokens": {},
      "usageGuidelines": {}
    },

    "motion": {
      "durations": {},
      "easings": {},
      "usageGuidelines": {}
    }
  },

  "components": {
    "button": {
      "variants": {},
      "sizes": {},
      "states": {},
      "anatomy": {},
      "designRules": {}
    },

    "input": {},
    "select": {},
    "checkbox": {},
    "radio": {},
    "card": {},
    "modal": {},
    "tooltip": {},
    "badge": {},
    "navigation": {},
    "table": {},
    "list": {}
  },

  "layout": {
    "gridSystem": {},
    "breakpoints": {},
    "containerRules": {},
    "zIndexScale": {}
  },

  "designPrinciples": [
    "",
    "",
    ""
  ],

  "doAndDonts": {
    "do": [],
    "dont": []
  }
}
```

---

### 🎨 What to Capture (Non-Negotiable)

* **Exact color values** → mapped to **semantic tokens**
* **Typography hierarchy** → intent-based naming (`heading-lg`, not `32px`)
* **Spacing rhythm** → consistent modular scale
* **Component anatomy** → padding, gaps, alignment rules
* **States** → hover, active, disabled, focus (visual + behavioral)
* **Design philosophy** → minimal / bold / utilitarian / expressive
* **Consistency rules** → what must never change

---

### 🧪 Quality Bar (Must Pass)

Before finalizing `design.json`, validate:

* ✅ Could another AI rebuild the UI **pixel-close** from this file alone?
* ✅ Are tokens semantic, not implementation-leaky?
* ✅ Does every component explain *how and when* it should be used?
* ✅ Are inconsistencies resolved into a clean system?

If not, refine.

---

### 🚫 Explicitly Avoid

* Raw CSS dumps
* One-off values without abstraction
* Naming tokens after colors (`blue500`) instead of meaning (`primary`)
* Referencing screenshots directly in the output

---

### ✅ Final Instruction

Produce **only** the final `design.json`.

No commentary.
No markdown.
No explanation.