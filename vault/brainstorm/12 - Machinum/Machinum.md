# Machinum - Mod Architecture Knowledge Base

## Overview

Machinum is the manufacturing and industrial automation mod of the [[Ars Mundi]] ecosystem.

Name:

Machinum

Pronunciation:

ma-KEE-num

Meaning:

Machinum comes from the Latin concept of:

- machine
- mechanism
- device
- apparatus constructed to perform a task

The name represents the purpose of this mod:

> Transforming raw materials into processed forms through structured industrial operations.

Machinum provides the machines that do the heavy work the player should not repeat manually.

---


# Role in Ars Mundi

Ars Mundi is divided into different disciplines.

Each mod represents a specific area of mastery.

Machinum represents:

> The discipline of manufacturing, processing, and industrial automation.

While other mods focus on:

- materials
- tools
- armor
- energy generation
- player abilities
- storage
- transportation

Machinum focuses on the machines that process and transform materials.

[[Materia]] provides:

- materials
- components
- ingredients
- raw resources

[[Potestas]] provides:

- energy generation
- energy storage

Machinum transforms those inputs into:

- processed materials
- manufactured components
- refined outputs
- automated services

Machinum answers:

> How are materials shaped, processed, and manufactured at scale?

---


# Core Philosophy

## Every Machine Does One Job Well

Machinum is not a technology progression system.

There are no tiers of machines that unlock other tiers of machines.

There is no "basic machine → advanced machine → ultimate machine" ladder.

Instead, each machine solves exactly one problem.

The philosophy:

> A player should choose a machine because it solves a specific need, not because it is the next step in a forced progression.

---


## Manufacturing Without Complexity

Many technology mods introduce:

- nested processing chains
- multi-step crafting trees
- hidden dependencies
- mandatory tech trees

Machinum intentionally avoids this.

Each machine has:

- one clear purpose
- straightforward input/output
- no hidden mechanics
- no mandatory progression order

The player chooses machines based on what they need.

Not based on what the mod tells them to build first.

---


# Machinum Is Not a Technology Progression

Machinum does not contain:

- tech trees
- tiered machine upgrades
- forced unlock sequences
- research systems

A player can install Machinum alongside any combination of Ars Mundi modules.

There is no requirement to:

- build specific machines before other machines
- follow a prescribed order
- complete stages or tiers

Each machine stands alone.

---


# Machinum Is Not a Material Mod

Machinum does not define materials.

It uses [[Materia]] materials for construction and recipes.

Example:

- Materia defines what Energetic Alloy is.
- Machinum builds a machine using Energetic Alloy.
- The machine produces processed outputs.
- The material identity remains Materia's domain.

---


# Machinum Is Not Energy Generation

Machinum does not generate energy.

It consumes energy from [[Potestas]].

The relationship:

Potestas generates and stores.

Machinum consumes and processes.

The player may choose to install Machinum with Potestas, or use an external energy mod as a bridge.

---


# Machinum Is Not Transport

Machinum does not move items between locations.

Item transportation, piping, and logistics belong to:

[[Fistula]]

Machinum handles:

- what happens when items arrive at a machine
- what the machine does with them
- what the machine outputs

Fistula handles:

- how items get to the machine
- how items leave the machine

---


# Molds

## Manufacturing Molds

Molds are the method through which Machinum shapes materials.

Molds belong to Machinum.

They are not [[Materia]] items.

Reason:

A mold is not a material property.

It is a production method.

---


## Mold Types

Machinum provides molds for various material forms.

Examples:

- tool head molds
- gear molds
- plate molds
- rod molds
- nugget molds

---


## Mold Relationship With Smeltery

Molds are used inside the Smeltery.

The Smeltery reads the mold pattern and produces items accordingly.

Without a mold:

The Smeltery does not know what form the material should take.

Without the Smeltery:

The mold has no machine to execute the shaping.

---


## Mold Relationship With Materia

Materia defines the output forms:

- Gear
- Rod
- Plate
- Reinforced Plate
- Dust
- Nugget

Machinum molds create the physical production paths for those forms.

Materia answers:

> What is a Gear?

Machinum answers:

> How is a Gear manufactured?

---


# Machines

Machinum contains distinct machines.

Each machine performs a specific industrial operation.

---


# Pulveriser

## Purpose

The Pulveriser processes raw ores into dust form.

---

## Functionality

Input:

- Raw ores (iron, gold, copper, lapis, redstone, etc.)

Output:

- 2 dust per 1 raw ore

The Pulveriser doubles the yield of raw ore processing.

This represents the first step in industrial ore refinement.

---

## Design Philosophy

Minecraft ores normally drop a limited amount of material.

The Pulveriser gives the player more value from each mined ore.

The player invests:

- Materia materials for construction
- Potestas energy for operation

The player receives:

- doubled output per ore

The ratio is straightforward: 1 raw ore becomes 2 dust.

No hidden mechanics. No multi-step requirements.

---

## Relationship With Materia

The Pulveriser uses [[Materia]] materials for construction.

Output dust matches the material system defined by Materia.

The dust produced follows Materia's material identity.

---


# Energetic Furnace

## Purpose

The Energetic Furnace is the energy-powered equivalent of the vanilla furnace.

---

## Functionality

Input:

- Smeltable items (ores, food, sand, logs, etc.)

Output:

- Standard smelted results

Key difference from vanilla furnace:

The Energetic Furnace processes 4 recipes simultaneously.

This provides 4x throughput compared to a single vanilla furnace.

---

## Design Philosophy

The vanilla furnace is the most fundamental Minecraft machine.

It serves the player from early game to late game.

The Energetic Furnace respects this role while improving efficiency.

The philosophy:

> The player should not spend time waiting for basic smelting when better options exist.

---

## Energy Requirement

The Energetic Furnace uses Potestas energy.

Without energy, it does not function.

This creates a natural progression:

- Early game: vanilla furnace
- Mid game: Energetic Furnace with Potestas infrastructure

---

## Relationship With Potestas

The Energetic Furnace consumes energy from [[Potestas]] generators or Reservoirs.

Direct connection:

Reservoir → Energetic Furnace

Or through [[Fistula]]:

Reservoir → Cable → Energetic Furnace

---


# Cast Publisher

## Purpose

The Cast Publisher prints cast patterns that guide the Smeltery in manufacturing.

---

## Functionality

Input:

- Blank cast materials
- Design specifications

Output:

- Completed casts

The Cast Publisher takes a pattern definition and transfers it onto a physical cast.

The resulting cast is then used inside the Smeltery as a manufacturing guide.

---

## Design Philosophy

The Cast Publisher represents the planning stage of manufacturing.

The player decides what to produce.

The Cast Publisher prepares the guide.

The Smeltery executes the production.

This separation gives the player control over what is being manufactured at any time.

---

## Relationship With Smeltery

The Cast Publisher creates casts.

The Smeltery uses casts.

Without the Cast Publisher, the Smeltery has no molds to work with.

Without the Smeltery, casts have no production machine to execute them.

---


# Smeltery

## Purpose

The Smeltery is the primary manufacturing machine.

It accepts ingredients and uses cast patterns to create processed outputs.

---

## Functionality

Input:

- Raw materials or components
- Casts (from the Cast Publisher)

Output:

- Shaped manufactured items

The Smeltery reads the pattern from the placed cast.

It combines this pattern with the provided ingredients.

The result is a manufactured product.

---

## Design Philosophy

The Smeltery is the heart of Machinum production.

It transforms Materia components into useful manufactured forms.

The Smeltery does not replace crafting.

It complements crafting.

Some items may be crafted by hand.

Other items require the precision and scale of the Smeltery.

---

## Relationship With Molds

The Smeltery depends on molds created by the Cast Publisher.

The workflow:

```
Cast Publisher → Cast → Smeltery → Manufactured Item
```

Without molds, the Smeltery cannot determine what to produce.

Without ingredients, the Smeltery has nothing to transform.

---


## Relationship With Materia

The Smeltery consumes [[Materia]] materials.

The outputs follow Materia's component system:

- Gears
- Rods
- Plates
- Reinforced Plates
- Dusts
- Nuggets

The material identity remains consistent.

Machinum provides the production method.

Materia provides the material definition.

---


# Alloy Mixer

## Purpose

The Alloy Mixer combines different ingredients to create alloys.

---

## Functionality

Input:

- Two or more base materials
- Specific combination ratios

Output:

- Alloy result

The Alloy Mixer takes individual materials and fuses them into a new alloy.

---

## Design Philosophy

Alloys in the ecosystem represent functional properties.

- Signalum represents communication
- Energetic Alloy represents energy interaction
- Resistant Alloy represents containment
- Vibrant Alloy represents dynamic motion
- Thermium represents thermal behavior

The Alloy Mixer is how these alloys are physically produced.

Without the Alloy Mixer:

Alloys exist as concepts in Materia but have no manufacturing path.

With the Alloy Mixer:

The player can produce alloys from raw materials.

---

## Relationship With Materia

The Alloy Mixer produces alloys defined by [[Materia]].

Materia defines:

> Signalum represents communication and signals.

The Alloy Mixer executes:

> Combine Signalum ingredients to produce Signalum alloy.

The conceptual identity belongs to Materia.

The physical production belongs to Machinum.

---


# Builder

## Purpose

The Builder constructs structures from printed schemas.

---

## Functionality

Input:

- A printed schema (from the Printer)
- Required materials

Output:

- A completed structure

The Builder reads the schema and places blocks according to the design.

---

## Design Philosophy

The Builder is the final step in the design-to-construction pipeline.

The player designs a structure.

The Printer produces a readable schema.

The Builder executes the construction.

This allows the player to:

- design structures once
- reproduce them anywhere
- scale construction beyond manual placement

---

## Relationship With Printer

The Builder depends on schemas from the Printer.

The workflow:

```
Player Design → Printer → Schema → Builder → Structure
```

Without a schema, the Builder has nothing to construct.

Without the Builder, schemas are only documents.

---


## Relationship With Cultus

The Builder creates structures.

[[Cultus]] provides the decorative blocks used within those structures.

The Builder places blocks. Cultus defines which blocks are available for creative construction.

---


# Printer

## Purpose

The Printer produces schemas from digital or manual design files.

---

## Functionality

Input:

- Design data (blueprints, schematics)

Output:

- Physical schema item

The Printer reads a design and transfers it to a portable schema format.

The resulting schema can be carried to a Builder anywhere in the world.

---

## Design Philosophy

The Printer represents the design-to-documentation process.

The player creates a vision.

The Printer preserves that vision in a portable form.

The schema becomes a blueprint that travels with the player.

---

## Relationship With Builder

The Printer creates schemas.

The Builder consumes schemas.

Together they form the design-to-construction pipeline.

---


# Pump

## Purpose

The Pump extracts fluids from the world and stores or transfers them.

---

## Functionality

Input:

- Fluid blocks in the world (water, lava, etc.)
- Fluids above the Pump

Output:

- Fluids directed to an internal tank or any tank placed directly above

The Pump can:

- draw fluids downward from the environment
- push fluids upward into a connected container

---

## Design Philosophy

The Pump is a focused fluid handling solution.

It does not attempt to be a complete fluid management system.

Fluid transportation and piping belong to [[Fistula]].

The Pump handles the extraction and placement point.

---

## Relationship With Tractus

[[Tractus]] also handles fluid extraction.

The difference:

- Tractus is a focused survival utility. No energy required. Works in Ars Vitae.
- The Pump is a Machinum machine. Uses Potestas energy. Part of the industrial system.

Both extract fluids. The Pump adds energy-powered throughput and vertical fluid movement.

---

## Relationship With Fistula

[[Fistula]] provides pipes and transport networks.

The Pump places fluids into tanks or systems.

Fistula moves fluids between distant locations.

The Pump is the origin point. Fistula is the journey.

---


# Chunk Loader

## Purpose

The Chunk Loader keeps a specific chunk loaded regardless of player proximity.

---

## Functionality

When placed and powered:

The chunk containing the Chunk Loader remains loaded.

This allows:

- machines to continue operating
- crops to continue growing
- systems to remain active

---

## Design Philosophy

Many Minecraft machines stop functioning when the player moves away.

The Chunk Loader prevents this interruption.

It is a utility block for maintaining infrastructure.

---

## Relationship With Potestas

The Chunk Loader may require Potestas energy to maintain operation.

This creates a cost-benefit balance:

- energy is consumed continuously
- the chunk remains active
- the player decides when the benefit justifies the energy cost

---

## Relationship With Other Machines

The Chunk Loader enables Machinum machines to operate without player presence.

A factory using:

- Pulveriser
- Energetic Furnace
- Smeltery

can continue operating as long as:

- the chunk is loaded
- energy is supplied

---


# Animal Feeder

## Purpose

The Animal Feeder automates animal breeding by feeding animals automatically.

---

## Functionality

Input:

- Feed items (wheat, carrots, seeds, etc.)

Output:

- Automatic feeding of nearby animals
- Breeding occurs without manual player interaction

---

## Design Philosophy

Animal breeding in vanilla Minecraft requires repetitive manual interaction.

The Animal Feeder removes this repetition.

The player:

- places the block
- provides feed
- walks away

Animals breed without further player attention.

---

## Relationship With Materia

The Animal Feeder is constructed using [[Materia]] materials.

The design follows Machinum's philosophy:

One machine, one job, clear purpose.

---


# Tesseract

## Purpose

The Tesseract creates a remote connection between two points, bridging items or fluids across distance and dimensions.

---

## Functionality

Input:

- Two Tesseract blocks placed in different locations

Output:

- A linked connection between them

Items or fluids entering one Tesseract emerge from the paired Tesseract.

The connection works:

- within the same dimension
- across different dimensions
- across any distance

---

## Design Philosophy

The Tesseract solves the problem of distance.

Normally:

- items must travel through physical pipes
- fluids must be pumped through physical networks
- dimension boundaries cannot be crossed

The Tesseract bypasses these limitations.

The philosophy:

> When two points exist in the world, the distance between them should not prevent connection.

---

## Relationship With Fistula

[[Fistula]] handles physical transport networks.

The Tesseract handles teleportation-based transport.

They are complementary systems:

- Fistula: network-based transport
- Tesseract: point-to-point teleportation

The player chooses based on:

- infrastructure needs
- dimension requirements
- design preference

---


# Single Block Farm

## Purpose

The Single Block Farm produces food from a single block placement.

---

## Functionality

Output:

- Food items equivalent to a 9x9 farm for that specific crop

A single block:

- grows crops internally
- harvests automatically
- produces food at a rate comparable to a large manual farm

---

## Design Philosophy

Farming in vanilla Minecraft requires:

- large land areas
- manual planting
- manual harvesting
- repetitive maintenance

The Single Block Farm condenses this entire process into one block.

The philosophy:

> Not every player wants to build farms. Some want to eat.

---

## Relationship With Animal Feeder

The Animal Feeder automates animal breeding.

The Single Block Farm automates crop farming.

Together they cover:

- animal products
- crop products

Without requiring large farm infrastructure.

---


# Librarian Cage

## Purpose

The Librarian Cage provides a centralized trading interface for village villagers.

---

## Functionality

The Librarian Cage sits in the middle of a village trading hall.

It provides:

- organized exchange interface
- different types of trades
- easy navigation between trade categories

The player interacts with a single interface instead of individual villagers.

---

## Design Philosophy

Village trading in vanilla Minecraft requires:

- finding individual villagers
- managing professions
- physically moving between them
- remembering who offers what

The Librarian Cage centralizes this experience.

The philosophy:

> Trading should be organized, not chaotic.

---

## Relationship With Praxis

[[Praxis]] provides player utilities like teleportation.

The Librarian Cage provides organized trading.

Together they improve the player's relationship with village infrastructure.

---


# Recipe Philosophy

## Crafting With and Without Machinum

The ecosystem supports two production methods for many items.

Without Machinum:

Items are crafted using the vanilla crafting table.

With Machinum:

The same items can be produced through machines.

Example:

A Gear:

- Without Machinum: crafted on a crafting table using Materia materials
- With Machinum: manufactured in the Smeltery using a gear mold

The output is the same.

The production method differs.

---

## Machine Independence

Each machine stands on its own.

The player does not need to:

- build the Pulveriser before the Smeltery
- install the Printer before the Builder
- have an Alloy Mixer before using the Energetic Furnace

Each machine can be installed and used independently.

---


# Energy Consumption

All Machinum machines consume energy from [[Potestas]].

The energy flow:

```
Potestas (Generators / Reservoirs)
    ↓
Fistula (Cables — optional)
    ↓
Machinum (Machines)
    ↓
Processed Output
```

Without Potestas:

Machinum machines do not function.

With Potestas:

Each machine draws energy as needed for its operation.

---

## Energy Balance

Machines consume energy proportional to their workload.

The player must balance:

- energy production capacity
- number of active machines
- desired throughput

This creates meaningful infrastructure decisions without forced progression.

---


# Relationship With Other Mods

## Materia

[[Materia]] provides:

- materials
- components (Gear, Rod, Plate, Reinforced Plate, Dust, Nugget)
- alloys (Signalum, Energetic Alloy, Resistant Alloy, Vibrant Alloy, Exodium Alloy, Thermium)
- gems (Carminis, Glaucus, Flavum)
- exotic materials (Exodium)

Machinum uses Materia resources for:

- machine construction recipes
- processed output forms
- alloy production inputs

Materia defines what exists.

Machinum defines how it is manufactured.

---


## Potestas

[[Potestas]] provides:

- energy generation
- energy storage (Reservoirs)

Machinum consumes energy for all machine operations.

Relationship:

Potestas: generates and stores.

Machinum: consumes and processes.

The player may choose to install Machinum without Potestas by using an external energy mod, or Potestas without Machinum for energy-dependent non-Machinum systems.

---


## Fistula

[[Fistula]] provides:

- pipes
- cables
- item transport
- fluid transport
- energy transport

Relationship:

Fistula moves resources to and from Machinum machines.

Machinum processes resources once they arrive.

Fistula: the highway.

Machinum: the factory.

---


## Virtus

[[Virtus]] provides:

- ability activation
- potential unlocking

Machinum does not require Virtus.

Machines operate through energy and material input.

However, Virtus-enhanced tools and armor may:

- mine resources more efficiently
- gather materials faster

This indirectly improves the supply chain feeding Machinum machines.

---


## Cultus

[[Cultus]] provides:

- decorative blocks
- architectural elements

Machinum provides:

- industrial machines

Cultus does not handle machine aesthetics.

Machinum does not provide decorative blocks.

They serve completely different purposes.

---


## Arma

[[Arma]] provides:

- tools

Machinum provides:

- machines

A player may use Arma tools to gather resources.

Machinum machines process those resources.

The tool gathers. The machine transforms.

---


## Lorica

[[Lorica]] provides:

- armor systems

Machinum provides:

- industrial systems

No direct relationship.

Lorica protects the player.

Machinum processes materials.

---


## Mutare

[[Mutare]] provides:

- environmental transformation blocks

Machinum provides:

- industrial machines

No direct relationship.

Mutare changes the world directly.

Machinum transforms materials internally.

---


## Tractus

[[Tractus]] provides:

- fluid extraction (no energy required)

Machinum provides:

- fluid pumping (energy required)

Both handle fluid extraction.

Tractus is the survival solution.

The Pump is the industrial solution.

---


## Altum

[[Altum]] provides:

- vertical space utilities

Machinum provides:

- manufacturing systems

No direct relationship.

Altum handles spatial mastery.

Machinum handles material transformation.

---


## Nudare

[[Nudare]] provides:

- automated log stripping

Machinum provides:

- industrial processing

Nudare is a focused survival block.

Machinum machines are energy-powered industrial tools.

They solve different scales of the same problem: reducing manual labor.

---


## Praxis

[[Praxis]] provides:

- player-focused utilities

Machinum provides:

- machine-focused systems

Praxis changes how the player interacts with the world.

Machinum changes how materials are processed.

---


# What Does Not Belong in Machinum

## Material Definitions

Belongs to:

[[Materia]]

Machinum uses materials. It does not define them.

---

## Energy Generation

Belongs to:

[[Potestas]]

Machinum consumes energy. It does not generate it.

---

## Item And Fluid Transportation

Belongs to:

[[Fistula]]

Machinum processes items. It does not transport them across distances.

---

## Tools

Belongs to:

[[Arma]]

Machinum builds machines. Arma builds tools.

---

## Armor

Belongs to:

[[Lorica]]

Machinum does not provide player protection equipment.

---

## Decorative Blocks

Belongs to:

[[Cultus]]

Machinum does not provide aesthetic construction blocks.

---

## Player Abilities

Belongs to:

[[Praxis]]

Machinum does not change the player.

---

## Ability Infusion

Belongs to:

[[Virtus]]

Machinum operates through energy, not through potential activation.

---

## World Transformation

Belongs to:

[[Mutare]]

Machinum processes materials internally. Mutare changes the external world.

---

## Fluid Extraction (No Energy)

Belongs to:

[[Tractus]]

Machinum requires energy for all operations.

---


# Ars Vitae Relationship

Machinum is NOT part of [[Ars Vitae]].

Ars Vitae focuses on survival without industrial technology.

Players wanting only survival improvements use:

- Materia
- Arma
- Lorica
- Cultus
- Praxis
- Peram
- Cista
- Nudare
- Tractus
- Altum
- Mutare

Without needing:

- machines
- energy systems
- industrial processing

Machinum belongs to the complete Ars Mundi ecosystem.

---


# Ars Mundi Relationship

In the complete Ars Mundi ecosystem:

Machinum represents the industrial processing layer.

The progression:

```
Materia
Materials & Components
    ↓
Potestas
Energy Generation & Storage
    ↓
Fistula
Energy & Item Transport (optional)
    ↓
Machinum
Industrial Processing & Manufacturing
```

Machinum is the reason the industrial infrastructure exists.

Without machines, processed materials cannot be manufactured at scale.

Without [[Potestas]], machines cannot operate.

Without [[Materia]], machines have no materials to process.

Together they form:

```
Materia (materials)
    → Potestas (energy)
        → Fistula (transport)
            → Machinum (processing)
                → Useful manufactured products
```

---


# Final Philosophy

Machinum represents the mastery of manufacturing.

The player begins with manual crafting.

Then machines reduce the repetition.

Then automation frees the player from standing at a furnace.

The machines are not infinite.

They require:

- energy supply
- material input
- placement strategy
- infrastructure planning

Every machine does one job.

Every job is done well.

No forced progression. No mandatory tech trees.

The player chooses what to build based on what they need.

**Machinum — The Industry of the World.**
