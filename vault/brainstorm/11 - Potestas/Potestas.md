# Potestas - Mod Architecture Knowledge Base

## Overview

Potestas is the energy generation and storage mod of the [[Ars Mundi]] ecosystem.

Name:
Potestas

Pronunciation:
poh-TES-tas

Meaning:
Potestas comes from the Latin concept of:
- power
- capability
- authority
- mastery over force

The name represents the purpose of this mod:
> Generating, storing, and mastering the energy that drives advanced systems.

---

# Role in Ars Mundi

Ars Mundi is divided into different disciplines.
Each mod represents a specific area of mastery.
Potestas represents:
> The discipline of energy generation and storage.

While other mods focus on:
- materials
- tools
- machines
- player abilities
- storage
- transportation
- world transformation

Potestas focuses on providing the energy foundation that powers industrial systems.

[[Materia]] provides:
- energy-related materials (Energetic Alloy)
- exotic resources (Exodium)

Potestas transforms those materials into:
- generators
- energy storage blocks (Reservoirs)

Potestas answers:
> How does the player harness power to drive advanced systems?

---

# Core Philosophy

## Energy Is a Separate Discipline

Potestas exists separately because not every player wants industrial systems.
The ecosystem uses the established Minecraft energy API infrastructure.
Potestas does not create a new energy API.
It provides generators and storage that integrate with existing energy systems.

---

# Generators

Potestas provides six distinct generator types.
Each generator represents a different energy source.
All generators are built using Materia materials.

---

## Solarium

### Concept
Solar energy generator.

### Name Origin
Solarium — from Latin *solaris*, relating to the sun.

### Functionality
Generates energy from sunlight.
Output scales with:
- time of day
- weather conditions
- dimension (Overworld only)

### Materials
Requires Materia materials for construction.
Energetic Alloy used in recipe.

---

## Thermum

### Concept
Heat energy generator.

### Name Origin
Thermum — from Latin *therma*, heat.

### Functionality
Generates energy from heat sources.
Accepts:
- lava
- fire
- hot blocks (magma, campfires)

### Materials
Requires Thermium alloy from Materia.
Thermium represents heat-conductive properties.

---

## Motus

### Concept
Kinetic energy generator.

### Name Origin
Motus — from Latin *motus*, movement, motion.

### Functionality
Generates energy from movement.
Primary source:
- flowing water (water wheels)

### Design Note
Water-based kinetic generation is accepted.
Player-driven or mod-driven kinetic sources are not agreed upon.
Motus focuses on natural environmental motion.

### Materials
Requires Vibrant Alloy from Materia.
Vibrant Alloy represents active transport and dynamic properties.

---

## Ventus

### Concept
Wind energy generator.

### Name Origin
Ventus — from Latin *ventus*, wind.

### Functionality
Generates energy from wind.
Output scales with:
- height (Y level)
- weather conditions
- biome wind factors

### Materials
Requires Energetic Alloy and Vibrant Alloy from Materia.

---

## Infernum

### Concept
Nether energy generator.

### Name Origin
Infernum — from Latin *infernum*, the lower world, hell.

### Functionality
Generates energy from Nether-specific sources.
Accepts:
- Nether heat
- blaze-related fuels
- basalt/delta thermal gradients

### Materials
Requires Resistant Alloy from Materia.
Resistant Alloy represents containment and durability for hostile environments.

---

## Resonator

### Concept
Exotic energy generator.

### Name Origin
Resonator — a device that exhibits resonance, responding strongly to specific frequencies.

### Functionality
Generates energy from End-related resonance.
Uses Exodium's exotic properties to tap into dimensional energy.

### Design Note
The name was intentionally chosen as "Resonator" instead of "Exodium Generator".
Reason:
- "Exodium Generator" implies a simple tier upgrade
- Resonator represents a distinct operating principle
- It resonates with End frequencies, not just burns fuel

### Materials
Requires Exodium and Exodium Alloy from Materia.
Exodium Alloy combines normal material science with End-related properties.

---

# Energy Storage: Reservoirs

Potestas does not use the terms "Battery" or "Capacitor".
Instead, energy storage blocks are called **Reservoirs**.

Name agreed upon:
> Reservoir — a place where fluid or energy collects and is stored.

---

## Reservoir Tiers

Reservoirs follow a material-based tier progression.
Energetic Alloy, Vibrant Alloy, Signalum, and Resistant Alloy are intentionally NOT used for Reservoir tiers.
Reason: Those alloys represent functional properties (energy conduction, motion, signaling, containment), not storage capacity progression.

| Tier | Material | Notes                            |
| ---- | -------- | -------------------------------- |
| 1    | Wood     | Basic survival storage           |
| 2    | Stone    | Early game upgrade               |
| 3    | Iron     | Standard mid-game                |
| 4    | Copper   | Conductive improvement           |
| 5    | Gold     | High conductivity                |
| 6    | Carminis | Gem-tier (vitality/intensity)    |
| 6    | Glaucus  | Gem-tier (clarity/control)       |
| 6    | Flavum   | Gem-tier (brightness/disruption) |
| 6    | Amethyst | Gem-tier (perception/refinement) |
| 7    | Diamond  | High-end vanilla                 |
| 8    | Emerald  | Civilization/prosperity tier     |
| 9    | Exodium  | Exotic End-tier maximum          |

### Tier 6 Design Philosophy
Four gem materials share Tier 6.
They provide equal capacity but different identities.
This allows player choice based on:
- aesthetic preference
- material availability
- thematic build alignment

---

# What Does Not Belong in Potestas

The following systems intentionally do not belong in Potestas.

---

## Energy Transfer
Belongs to:
[[Fistula]]
Fistula provides cables, pipes, and transport networks.
Potestas generates and stores. Fistula moves.

---

## Machines
Belongs to:
[[Machinum]]
Machinum provides processors, factories, and industrial production.
Potestas provides the energy to run them.

---

## Material Generation
Belongs to:
[[Materia]]
Materia provides all materials including Energetic Alloy.
Potestas consumes materials, does not create them.

---

## Player Abilities
Belongs to:
[[Praxis]]
Praxis provides personal capabilities.
Potestas provides infrastructure energy.

---

## World Transformation
Belongs to:
[[Mutare]]
Mutare changes the environment.
Potestas powers the systems that may assist transformation.

---

## Ability Infusion
Belongs to:
[[Virtus]]
Virtus unlocks hidden potential in items.
Potestas provides raw energy capacity.

---

# Relationship With Other Mods

## Materia
[[Materia]] provides:
- Energetic Alloy (energy conduction)
- Vibrant Alloy (dynamic properties)
- Signalum (signal/control systems)
- Resistant Alloy (containment)
- Exodium (exotic properties)
- Exodium Alloy (advanced exotic behavior)
- Thermium (heat conduction)

Potestas uses these materials for generator and Reservoir recipes.

---

## Machinum
[[Machinum]] consumes energy from Potestas.
Relationship:
Potestas generates/stores.
Machinum processes/manufactures.
The player may choose to install Machinum without Potestas (using other energy mods) or Potestas without Machinum (using energy for other mods).

---

## Fistula
[[Fistula]] provides the transport layer.
Relationship:
Potestas: Reservoir → Fistula: Cable → Machinum: Machine
Energy flows through Fistula infrastructure.

---

## Virtus
[[Virtus]] does not require energy.
Virtus activations are ritualistic/structural, not energy-based.
However, Virtus-enhanced items may interact with energy systems (e.g., Exodium tools with energy abilities).

---

# Ars Vitae Relationship

Potestas is NOT part of [[Ars Vitae]].
Ars Vitae focuses on survival without industrial technology.
Energy generation and storage belong to the complete Ars Mundi ecosystem.
Players wanting only survival improvements use Ars Vitae modules (Materia, Arma, Lorica, Praxis, etc.) without Potestas.

---

# Ars Mundi Relationship

In the complete Ars Mundi ecosystem:
Potestas represents the energy foundation.
The progression:

```
Materia
Materials
↓
Potestas
Energy Generation & Storage
↓
Fistula
Energy Transport
↓
Machinum
Industrial Processing
```

Potestas enables the technology progression.
Without energy, machines cannot operate.
Without machines, automation cannot exist.

---

# Final Philosophy

Potestas represents the mastery of force.
The player begins with manual labor.
Then tools extend their reach.
Then energy replaces their effort.

The generators are not infinite.
They require:
- placement strategy
- environmental awareness
- material investment
- infrastructure planning

The Reservoirs are not unlimited.
They require:
- tier progression
- material diversity
- capacity planning

Energy is not magic.
It is harvested, stored, and directed.
**Potestas — The Power of the World.**