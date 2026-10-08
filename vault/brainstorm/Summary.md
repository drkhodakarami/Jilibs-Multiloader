# Ars Mundi / Ars Vitae — Ecosystem Architecture Summary

> **Generated from full vault analysis** — All 10 documented modules + 2 pack definitions read and synthesized.

---

## Two-Tier Architecture

| **Ars Vitae** — "The Art of Life" (Survival-Focused) | **Ars Mundi** — "The Art of the World" (Complete Ecosystem) |
|------------------------------------------------------|-------------------------------------------------------------|
| Materia, Arma, Lorica, Peram, Cista, Praxis, Mutare, Cultus, Nudare, Altum, Tractus | All Vitae modules + Machinum, Potestas, Fistula, Vas, Augmentum, Virtus, Regnum, Impulsus |

**Philosophy**: Ars Vitae improves survival without industrial mechanics. Ars Mundi adds machines, energy, transport, automation, dimensions, and reality manipulation.

---

## Module Registry (19 Planned)

| # | Module | Latin Meaning | Domain | Status | Lines |
|---|--------|--------------|--------|--------|-------|
| 01 | **Materia** | Element, material, substance | **Foundation** — materials, gems, alloys, components | ✅ Complete | 781 |
| 02 | **Arma** | Tool, instrument | Tools (swords, pickaxes, hammers, excavators) | ✅ Complete | 719 |
| 03 | **Lorica** | Armor, cuirass | Armor with enhancement abilities | ✅ Complete | 968 |
| 04 | **Cultus** | Cultivation, refinement | Decorative blocks (full architectural sets per gem) | ✅ Complete | 579 |
| 05 | **Praxis** | Action, practice | Player utilities (teleport, infinite water, flight, wall-climb) | ✅ Complete | 572 |
| 06 | **Mutare** | To change, transform | World alteration blocks (fluid gen, tunneling, chunk clearing) | ✅ Complete | 634 |
| 07 | **Nudare** | To strip, make bare | Single block: auto-strips logs | ✅ Complete | 374 |
| 08 | **Tractus** | Drawing, pulling | Fluid extraction block (water/lava/powdered snow) | ✅ Complete | 425 |
| 09 | **Virtus** | Impulse, driving force | **Activation system** — Helios/Selene altars unlock hidden potential | ✅ Complete | 585 |
| 10 | **Altum** | Height, elevation | Vertical space: elevators, angel blocks (place in void) | ✅ Complete | 404 |
| 11 | **Potestas** | Power, authority | Energy generation/storage | ✅ Complete | 398 |
| 12 | **Machinum** | Machine, mechanism | Manufacturing/automation machines (13 machines + molds) | ✅ Complete | 1598 |
| 13 | **Vas** | Vessel, container | Fluid/gas containers, batteries | ⬜ Empty | 0 |
| 14 | **Augmentum** | Enhancement | Upgrades | ⬜ Empty | 0 |
| 15 | **Regnum** | Realm, kingdom | Dimensions, portals | ⬜ Empty | 0 |
| 16 | **Cista** | Chest, box | Advanced storage blocks | ⬜ Empty | 0 |
| 17 | **Peram** | Bag, pouch | Backpacks (normal + Ender-linked) | ⬜ Empty | 0 |
| 18 | **Fistula** | Pipe, tube | Cables & pipes (item/energy/fluid transport) | ⬜ Empty | 0 |
| 19 | **Impulsus** | Impulse, force | Redstone systems | ⬜ Empty | 0 |

**Total documented**: ~9,350 lines across 12 modules + 2 pack files.

---

## Core Design Principles (Enforced Across All Modules)

1. **Not Magic** — No spells, mana, wizards, fantasy classes. Everything framed as "advanced material science / mastery."
2. **Not Technology Progression Tiers** — Materials represent *properties/identities*, not numerical upgrades (Signalum = signal conduction, not "tier 3 metal").
3. **Strict Separation of Concerns** — Each mod owns ONE domain:
   - Materia = material definitions only
   - Machinum = production methods only
   - Arma = tool behavior only
   - Virtus = activation/unlocking only
4. **Recipe Philosophy** — "A Gear is a Gear." Same item identity; different production paths based on installed modules (crafting table vs machine).
5. **Two-State Systems** — Tools/armor have *Normal* (vanilla-like) and *Enhanced* (Virtus-activated) states.
6. **Virtus as Cross-Cutting Activation Layer** — Helios (central altar) + 8 Selene (surrounding altars) structure at mid-day/mid-night unlocks potential. No energy required.
7. **Mutatio as Intermediate** — Mutare's world-alteration blocks created via Mutatio → Virtus activation.

---

## Materia Material System (The Shared Vocabulary)

### Exotic Materials
| Material | Pronunciation | Concept | Primary Usage |
|----------|--------------|---------|---------------|
| **Exodium** | ek-SO-dee-um | End-related, exotic properties, unusual physics | Bridge to exotic behavior, advanced systems |

### Gems (Unique Identities, Not Just Colors)
| Gem | Pronunciation | Represents | Concept |
|-----|--------------|------------|---------|
| **Carminis** | KAR-mi-nis | Ruby | Vitality, heat, strength, intensity |
| **Glaucus** | GLAW-kus | Sapphire | Clarity, sky/ocean tones, control |
| **Flavum** | FLA-vum | Citrine | Brightness, golden coloration, disruption |

### Alloys (Property-Specific, Not Tier Progression)
| Alloy | Pronunciation | Concept | Primary Module |
|-------|--------------|---------|----------------|
| **Signalum** | sig-NA-lum | Signal/communication, redstone | Impulsus, redstone cables |
| **Resistant Alloy** | re-ZIS-tant | Containment, durability, stability | Fluid/gas/pressure pipes (Fistula) |
| **Vibrant Alloy** | VY-brant | Activity, movement, dynamic systems | Item cables (Fistula) |
| **Energetic Alloy** | en-er-JET-ik | Energy interaction | Potestas (generators, storage) |
| **Exodium Alloy** | ek-SO-dee-um | Exotic End properties + material science | Dispersion systems |
| **Thermium** | THER-mee-um | Heat/thermal behavior | Heat cables |

### Components (Universal Material Forms — NOT Machine Parts)
| Component | Purpose |
|-----------|---------|
| **Gear** | Mechanical rotation, moving systems |
| **Rod** | Structural, shafts, supports, long components |
| **Plate** | Flattened form, sheets, panels, structural surfaces |
| **Reinforced Plate** | Layered construction, improved durability |
| **Dust** | Powdered materials, processed resources, intermediate states |
| **Nugget** | Small material fragments, flexible crafting amounts |

---

## Critical Cross-Mod Dependency Graph

```
Materia (FOUNDATION — every mod depends on this)
    │
    ├─→ Arma (tools) ←──────────────┐
    ├─→ Lorica (armor) ←────────────────────┤
    ├─→ Cultus (decoration)                 │
    ├─→ Praxis (player utilities)           │
    ├─→ Mutare (world alteration)           │
    ├─→ Peram (backpacks)                   │
    ├─→ Cista (storage blocks)              │
    ├─→ Nudare (log stripping)              │
    ├─→ Tractus (fluid extraction)          │
    └─→ Altum (vertical space)              │
                                            │
                              ┌─────────────┴─────────────┐
                              ▼                           ▼
                         IMPETUS                    (Ars Vitae complete)
                     (Activation Layer)
                     Helios + 8 Selene
                     No energy required
                              │
                              ▼
                     ┌────────┴────────┐
                     ▼               ▼
                Ars Vitae        Ars Mundi
             (survival only)   (+ machines, energy,
                               transport, dimensions,
                               reality manipulation)
```

### Key Activation Relationships
| Module | Normal State | Enhanced State (via Virtus) |
|--------|--------------|------------------------------|
| **Arma** | Vanilla-like tools (hammer=pickaxe, excavator=shovel) | Multi-block mining, special sword abilities (cooked meat, knockback, blindness) |
| **Lorica** | Protection + stats only | Per-piece effects (regen, night vision, flight, invisibility) + full set bonuses |
| **Mutare** | 1 block per Mutatio (shaped recipe) | 4 blocks per Mutatio (Virtus activation) |
| **Praxis** | Flight (Levitas) locked | Exodium full armor set → Flight; Leather boots → Gravitas (wall climb) |

---

## Module-Specific Highlights

### Materia (01)
- **Philosophy**: "Before mastering the world, understand what the world is made of."
- **Rule 1**: Define materials, not usage. Gear exists; Machinum manufactures it; Arma uses it in recipes.
- **Rule 2**: Shared vocabulary — no duplicate "machine gear", "industrial gear".
- **Rule 3**: Avoid unnecessary complexity — no circuits, processors, magical artifacts.

### Arma (02)
- **Tool categories**: Sword, Pickaxe, Shovel, Axe, Hoe + **Hammer** (pickaxe-like) + **Excavator** (shovel-like)
- **Material tiers**: Vanilla (wood→netherite) + Gems (Carminis/Glaucus/Flavum) + Exodium
- **Sword abilities** (Virtus-activated):
  - Carminis: cooked meat drops
  - Glaucus: massive knockback
  - Flavum: blindness on targets
  - Copper: poison + rotten flesh drops
  - Exodium: TBD (highest exotic potential)

### Lorica (03)
- **Armor sets**: Emerald, Amethyst, Carminis, Glaucus, Flavum, Exodium, Copper
- **Per-piece effects** + **Full set bonuses** (all require Virtus)
- **Exodium full set** → Flight (Levitas via Praxis) — peak ecosystem reward
- **Leather boots** → Gravitas (wall climb) — early-game mobility

### Cultus (04)
- **Complete architectural vocabulary per material**: Full Block, Slab, Stair, Door, Trapdoor, Button, Wall, Fence, Fence Gate
- **Materials**: Carminis (warmth/royalty), Glaucus (elegance/aquatic), Flavum (prosperity/illumination), Exodium (mystery/End)
- **Pure creative expression** — no machines, no automation, no processing.

### Praxis (05)
- **Iterum**: Personal teleport (register 1 location, cross-dimension)
- **Locus**: Entity teleport (animals/mobs, same dimension only)
- **Chalice**: Infinite water bucket
- **Levitas**: Creative-like flight (Exodium full armor + Virtus only)
- **Gravitas**: Wall climbing (Leather boots + Virtus OR potion)

### Mutare (06)
- **Mutatio** → Virtus activation → Specific block:
  - **Fontis**: Water generation
  - **Siccus**: Water removal
  - **Calor**: Lava generation
  - **Siccatio**: Lava removal
  - **Fodina**: Horizontal tunneling (collects drops)
  - **Descensus**: Vertical shaft to bedrock (preserves ores)
  - **Pons**: Protected bridge (Nether lava lakes)
  - **Vastatio**: Chunk clearing to bedrock (preserves ores)
- **Without Virtus**: Shaped recipes, 1 block yield
- **With Virtus**: 4 block yield from same Mutatio

### Nudare (07)
- Single block: auto-strips logs (full stack < 20 seconds)
- No energy, no automation networks — simple problem, simple solution
- Complements axes (axes still harvest; Nudare prepares)

### Tractus (08)
- Single block: extracts fluid blocks (water/lava) + cauldrons (water/lava/powdered snow)
- Internal storage (not long-term) → redstone pulse on extraction
- No energy required → works in pure Ars Vitae
- **Extracts** → **Vas stores** → **Fistula transports**

### Virtus (09)
- **Helios**: Central altar (holds object to transform)
- **Selene**: 8 surrounding altars (hold ingredients: Exodium, gems, etc.)
- **Structure**: 5×5 with 1-block gap: `-O-O- / OOOOO / -O+O- / OOOOO / -O-O-`
- **Activation**: Mid-day or mid-night (recipe-dependent)
- **Visual feedback**: Helios changes appearance when structure valid
- **Not a machine, not magic** — "Mastery and understanding create extraordinary results"

### Altum (10)
- **Elevator**: Vertical teleport between aligned elevators
- **Angel Block**: Place in void/sky without support surface
- Enables Cultus building in impossible locations
- No energy, no transport networks — pure spatial mastery

### Potestas (11)
- **6 Generators**: Solarium (solar), Thermum (heat), Motus (kinetic), Ventus (wind), Infernum (Nether), Resonator (End)
- **Reservoirs**: Energy storage blocks using vanilla material tiers (Wood→Exodium), gem-tier 6 split into 4 equal options
- **Not a new API** — integrates with established Minecraft energy infrastructure
- **Not part of Ars Vitae** — energy generation belongs to Ars Mundi only

### Machinum (12)
- **13 machines**, each doing one focused job — no tech trees, no tier progression
- **Processing chain**: Pulveriser (ore→dust, 2x yield), Energetic Furnace (4x parallel smelting), Alloy Mixer, Smeltery + Cast Publisher
- **Construction chain**: Printer→Schema→Builder (design-to-construction pipeline)
- **Utility machines**: Pump (fluid extraction, energy-powered), Chunk Loader, Animal Feeder, Single Block Farm, Tesseract (cross-dimensional teleport), Librarian Cage (centralized trading)
- **Molds**: Machinum-owned production method — Cast Publisher creates casts, Smeltery reads them
- **Recipe philosophy**: Same item as crafting table, different production path — "A Gear is a Gear"

---

## Pack Definitions

### Ars Vitae ("The Art of Life")
**Modules**: Materia, Arma, Lorica, Peram, Cista, Praxis, Mutare, Cultus, Nudare, Altum, Tractus
**Focus**: Survival, exploration, player capability, preparation, tools, armor, storage, utilities, world interaction
**Excludes**: Machines, energy, transport, industrial processing, advanced enhancement (Virtus)

### Ars Mundi ("The Art of the World")
**Modules**: All Ars Vitae + Machinum, Potestas, Fistula, Vas, Augmentum, Virtus, Regnum, Impulsus, Cista, Peram
**Focus**: Complete mastery — machines, automation, energy, transport, industrial systems, reality manipulation, dimensions

---

## Empty Modules Requiring Design (Priority Order)

| Module | Dependencies | Key Design Questions |
|--------|-------------|---------------------|
| **Fistula (18)** | Materia (alloys), Potestas | Cable/pipe types (item/energy/fluid), transfer rates, network logic |
| **Vas (13)** | Materia, Potestas | Fluid/gas containers, battery items, capacity tiers |
| **Cista (16)** | Materia | Storage block variants, shulker-like behavior, capacity |
| **Peram (17)** | Materia | Backpack tiers, Ender-link mechanics, inventory UI |
| **Augmentum (14)** | Virtus, Arma/Lorica | Upgrade slots, upgrade types, application mechanics |
| **Impulsus (19)** | Materia (Signalum), Potestas | Redstone components, logic gates, signal processing |
| **Regnum (15)** | Virtus, Materia (Exodium) | Dimension registration, portal mechanics, Origo/Virtus keys |

---

## Implementation Notes for Fabric

- **Loader**: Fabric (explicitly stated in Ars Mundi.md)
- **Dependency model**: Materia required by all; Virtus required for enhanced states
- **Recipe system**: Data-driven (JSON), conditional on installed modules
- **Registration**: DeferredRegister pattern for items/blocks
- **Networking**: Custom packets for Virtus activation, Tractus redstone, Altum teleport
- **Data components** (1.20.5+): Use for Mutatio state, Iterum/Locus destinations, armor enhancement flags

---

## Documentation Gaps to Address

1. **Materia/1.4 - Ingredients.md** — Empty, needs crafting ingredient definitions
2. **Materia/Summary.md** — Empty
3. **Modules 11-19** — All empty, need full architecture docs matching 01-10 quality
4. **Cross-module recipe tables** — How Gear/Plate/Rod recipes change with/without Machinum
5. **Virtus recipe specifications** — Exact ingredient lists per transformation
6. **Mutare block parameters** — Range, speed, blacklist configurations
7. **Altum elevator linking logic** — Search algorithm, cooldown, multi-player
8. **Praxis effect durations/amplifiers** — Balance numbers for Levitas/Gravitas

---

## Final Philosophy Statement

> **Ars Mundi represents mastery over Minecraft.**
>
> The ecosystem is divided into disciplines:
> - Materia: Matter
> - Arma: Tools
> - Lorica: Protection
> - Machinum: Transformation
> - Potestas: Energy
> - Fistula: Transport
> - Vas: Containers
> - Cista: Storage
> - Peram: Portable storage
> - Cultus: Beauty
> - Praxis: Player utilities
> - Mutare: World alteration
> - Virtus: Potential unlocking
> - Altum: Vertical space
> - Nudare: Refinement
> - Tractus: Extraction
> - Augmentum: Enhancement
> - Regnum: Realms
> - Impulsus: Signal
>
> Together they form: **Ars Mundi — The Art of the World.**