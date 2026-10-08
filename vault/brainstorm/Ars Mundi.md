# Ars Mundi - Ecosystem Architecture Knowledge Base

## Overview

**Ars Mundi** ("The Art of the World") is the name of the complete Minecraft mod ecosystem. [[List]]

Ars Mundi is not a single mod. It is a collection of modular Fabric mods designed to work together as a coherent gameplay framework.

The philosophy behind Ars Mundi is:

> The player learns the art of mastering the Minecraft world.

The ecosystem sits between three concepts:

- Vanilla Minecraft survival mechanics
- Technology and automation systems
- Artificially powerful abilities that feel almost magical but are not based on traditional magic systems

Ars Mundi is not a magic mod.

It does not focus on:

- spells
- mana
- wizards
- fantasy classes

Instead, it focuses on advanced tools, machines, and systems that allow players to overcome Minecraft's limitations.

Examples:

- Tools that can instantly chop trees.
- Mining systems capable of tunnel excavation.
- Machines capable of processing large areas.
- Automated resource systems.
- Reality-altering blocks.
- Equipment with extraordinary abilities.

The player is not using magic.

The player is using mastery over materials, mechanisms, energy, and reality.

---

# Core Philosophy

## Modular Gameplay

Ars Mundi is designed as a collection of independent but interconnected modules.

Each mod represents a specific gameplay domain.

Players decide the complexity of their world by choosing which modules to install.

A small installation may provide:

- materials
- tools
- armor

A complete installation may provide:

- machines
- automation
- energy
- transport
- storage
- dimensions
- world manipulation
- advanced abilities

The ecosystem does not assume players will add mods later.

A Minecraft world is normally created with a fixed mod list and played for a long period.

Therefore:

> The selected modules define the intended gameplay philosophy of that world.

---

# Progression Philosophy

## Early Game

The ecosystem intentionally makes early progression more demanding.

Players need to:

- gather resources
- build infrastructure
- process materials
- invest time before gaining powerful abilities

Powerful systems should feel earned.

---

## Mid Game

Automation and advanced tools reduce repetitive tasks.

Examples:

- Faster resource gathering
- Automated processing
- Better storage
- Fluid handling
- Energy systems

The player spends less time on tedious tasks.

---

## Late Game

The goal is not unlimited resources.

The goal is freedom.

Players still interact with the world.

However:

- Large building projects become practical.
- Mining becomes less repetitive.
- Farming becomes easier.
- Resource collection becomes less of a time sink.
- Creativity becomes the main focus.

The player approaches a creative-building experience while remaining in survival.

---

# Architecture Philosophy

## Dependency Model

Materia is the foundation of Ars Mundi.

Every ecosystem mod depends on Materia.

This is intentional.

Materia provides the shared language of the ecosystem:

- materials
- components
- shared resources
- common tags
- universal ingredients

The dependency structure is:

Materia

↓

Arma  
Lorica  
Machinum  
Potestas  
Fistula  
Vas  
Cista  
Peram  
Cultus  
Praxis  
Mutare  
Virtus  
and future modules

---

# Mod Naming Philosophy

The ecosystem uses Latin-inspired names.

The reasons:

- They create a unified identity.
- They avoid generic technical names.
- They allow many different gameplay systems to coexist.
- They make each mod feel like a discipline or field of knowledge.

The names are intentionally diverse.

Not every mod uses the same suffix or structure.

The meaning of the name is more important than following a strict naming pattern.

---

# Materia

## Meaning

[[Materia]] represents elements, matter, and substance.

## Purpose

Materia is the material foundation of Ars Mundi.

It answers:

> What things are made from?

It does not answer:

> How things are manufactured.

---

# Arma

## Meaning

Arma means tool or instrument.

## Purpose

Arma is the tool-focused module.

It contains:

- swords
- shovels
- axes
- hoes
- pickaxes
- hammers
- specialized tools

It does not contain:

- armor
- machines
- energy systems
- storage

---

## Design Goal

Arma tools eventually become extremely powerful.

Examples:

- instant tree chopping
- advanced mining
- tunnel excavation
- special abilities

They may appear magical, but they are treated as advanced tools.

---

# Lorica

## Meaning

Lorica means armor or protective equipment.

## Purpose

Lorica contains armor systems.

It is separated from Arma because protection and tools represent different gameplay areas.

Contents:

- helmets
- chestplates
- leggings
- boots

Future abilities may interact with Virtus.

---

# Machinum

## Meaning

Machinum represents machines and mechanisms.

## Purpose

Machinum is the manufacturing and automation layer.

It provides:

- processors
- miners
- machines
- industrial systems

Machinum transforms Materia materials into useful manufactured products.

---

## Manufacturing Philosophy

Materia defines materials.

Machinum defines how materials are shaped.

Examples:

- casting
- processing
- manufacturing
- automation

---

## Molds

Manufacturing molds belong to Machinum.

They are not Materia items.

Reason:

A mold is not a material property.

It is a production method.

Examples:

- tool head molds
- gear molds
- plate molds
- rod molds
- nugget molds

---

# Potestas

## Meaning

Potestas means power, capability, authority.

## Purpose

Potestas handles energy generation and storage.

It exists separately because not every player wants industrial systems.

The ecosystem uses the established Minecraft energy API infrastructure.

Potestas does not create a new energy API.

It provides:

- generators
- energy storage blocks

Energy movement belongs to Fistula.

---

# Fistula

## Meaning

Fistula means pipe, tube, conduit.

## Purpose

Fistula provides transport systems.

Examples:

- item cables
- energy cables
- fluid pipes
- other transport networks

Fistula moves resources.

It does not generate them.

---

# Vas

## Meaning

Vas means vessel or container.

## Purpose

Vas provides non-solid resource containers.

Examples:

- fluid containers
- gas containers
- capacitor items
- battery items

Vas is different from:

Cista:
block storage

Peram:
portable inventory storage

---

# Cista

## Meaning

Cista means chest or container.

## Purpose

Cista provides advanced storage blocks.

Features:

- storage blocks
- shulker-like behavior
- contents survive breaking
- larger capacity
- future fluid tank support

The name represents containers, not only treasure.

---

# Peram

## Meaning

Peram represents a bag or pouch.

## Purpose

Peram provides backpacks.

Contents:

- normal backpack
- Ender-linked backpack

The name was chosen because it provides diversity from the many Latin "-um" names.

---

# Cultus

## Meaning

Cultus represents refinement, decoration, and cultivation.

## Purpose

Cultus provides aesthetic blocks.

Contents:

- decorative blocks
- gem blocks
- doors
- trapdoors
- buttons
- special glass systems

The previous name Decortic was rejected because although it sounded related to decoration, its meaning was not appropriate.

---

# Altum

## Meaning

Altum represents height and elevation.

## Purpose

Altum provides elevator systems.

Contents:

A single elevator block mechanic.

Players place multiple instances and travel vertically between them.

---

# Tractus

## Meaning

Tractus represents pulling, extraction, and drawing.

## Purpose

Tractus provides fluid extraction.

Contents:

Pump block.

Behavior:

- searches for water/lava
- stores fluid internally
- fills containers

---

# Praxis

## Meaning

Praxis means action, application, practice.

## Purpose

Praxis provides player-focused utilities.

Examples:

- player teleporters
- entity teleporters
- infinite water bucket
- personal utility devices

---

# Virtus

## Meaning

Virtus means impulse, force, momentum.

## Purpose

Virtus unlocks hidden potential.

It contains:

- one major block
- one major mechanic

Purpose:

Enhance tools and armor beyond normal limits.

It heavily uses End-related resources:

- Ender pearls
- End materials

The philosophy is not magic enchantment.

It is activation of potential.

---

# Mutare

## Meaning

Mutare means to change, transform, alter.

## Purpose

Mutare provides world alteration systems.

These are not machines.

They modify reality through artificial rules.

Examples:

## Chunk alteration blocks

A block may:

- consume a chunk
- remove normal blocks
- preserve valuable mineable resources

## Fluid generation blocks

Examples:

- water generation
- lava generation

Mutare represents controlled world manipulation.

---

# Recipe Philosophy

Recipes define progression.

Items should not care where they came from.

A Gear is a Gear.

A Plate is a Plate.

Other recipes only depend on the existence of the component.

---

## Recipe Paths

Without Machinum:

Materia provides simple survival-friendly recipes.

Example:

Gear:
crafting table recipe.

---

With Machinum:

The ecosystem can use industrial production.

Example:

Gear:
machine production.

The player chooses the progression style when creating the world.

---

# Final Philosophy

Ars Mundi represents mastery over Minecraft.

The ecosystem is divided into disciplines:

Materia:
Matter.

Arma:
Tools.

Lorica:
Protection.

Machinum:
Transformation.

Potestas:
Energy.

Fistula:
Transport.

Vas:
Containers.

Cista:
Storage.

Peram:
Portable storage.

Cultus:
Beauty.

Praxis:
Player utilities.

Mutare:
World alteration.

Virtus:
Potential unlocking.

Together they form:

**Ars Mundi — The Art of the World.**