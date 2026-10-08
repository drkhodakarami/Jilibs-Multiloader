# Tractus - Mod Architecture Knowledge Base

## Overview

Tractus is the fluid extraction utility mod of the [[Ars Mundi]] ecosystem.

Name:

Tractus

Pronunciation:

TRAK-tus

Meaning:

Tractus comes from the Latin concept of:

- pulling
- drawing
- movement
- transfer
- being carried along a path

The name represents the purpose of this mod:

> Moving resources from where they exist to where they are needed.

---

# Role in Ars Mundi

Ars Mundi is divided into different disciplines.

Each mod represents a specific area of mastery.

Tractus represents:

> The discipline of extracting and moving natural resources.

Tractus focuses on one specific problem:

Collecting fluids and fluid-like resources from the world without requiring manual repetitive actions.

---

# Core Philosophy

## Extraction Without Industrialization

Many technology mods solve resource collection by introducing:

- machines
- power systems
- factories
- complex automation

Tractus intentionally avoids this.

The philosophy is:

> A simple resource collection problem should have a simple solution.

Tractus does not attempt to become a complete technology system.

It only handles the first step:

Getting resources from the world.

---

# Tractus Is Not a Machine Mod

Although Tractus adds a functional block, it is not part of Machinum.

It does not contain:

- processors
- factories
- production chains
- energy systems
- industrial automation

The block exists as a focused utility.

---

# Tractus Is Not a Fluid Network

Tractus extracts fluids.

It does not transport fluids.

Fluid transportation belongs to:

Fistula

Fistula provides:

- pipes
- transfer systems
- infrastructure

Tractus provides:

- the extraction point

---

# Tractus Block

Tractus adds a single specialized block.

Purpose:

Extract fluids and fluid-like resources from the world.

---

# Functionality

The Tractus block can interact with:

- fluid blocks in the world
- cauldrons containing fluids
- powdered snow cauldrons

---

# Fluid Block Extraction

When Tractus detects a valid fluid block:

The block:

1. Extracts the fluid.
2. Stores the resource internally.
3. Removes the original fluid block.

Examples:

- water
- lava
- future compatible fluids

---

# Cauldron Extraction

Tractus can extract resources stored inside cauldrons.

Supported sources:

- water cauldrons
- lava cauldrons
- powdered snow cauldrons

When extraction happens:

The filled cauldron is replaced with:

- empty cauldron

The extracted resource is stored inside Tractus.

---

# Powdered Snow Extraction

Tractus treats powdered snow as a fluid-like resource.

When extracting from a powdered snow cauldron:

Input:

Powdered snow cauldron

Output:

- empty cauldron
- stored powdered snow

This allows powdered snow to participate in the same resource extraction system.

---

# Internal Storage

Tractus contains internal storage for extracted resources.

The internal storage exists for handling and transfer.

It is not intended to replace dedicated storage systems.

Long-term storage belongs to:

- Vas
- Cista

---

# Redstone Interaction

Tractus provides a simple redstone feedback system.

Whenever successful extraction occurs:

Tractus sends a redstone pulse to neighboring blocks.

---

# Redstone Behavior

The pulse is emitted to:

- side neighbors
- back neighbor

The front side is reserved for the main interaction direction.

---

# Example Usage

A player connects redstone dust around Tractus.

When Tractus successfully extracts:

- water
- lava
- powdered snow

the redstone receives a pulse.

This allows:

- extraction detection
- simple automation triggers
- control mechanisms

---

# Design Philosophy

## The World Should React

Tractus does not constantly output signals.

The redstone pulse represents an event:

> A resource has been successfully extracted.

The world reacts to the player's action.

---

# No Energy Requirement

Tractus intentionally does not require energy.

Reason:

Not every player wants a complete technology progression.

A player using only:

- [[Materia]]
- [[Arma]]
- [[Lorica]]
- [[Cultus]]
- [[Praxis]]

can still benefit from Tractus.

---

# Relationship With Other Mods

## Materia

Provides:

- materials
- crafting components

Tractus uses Materia resources in its recipes.

---

## Vas

Vas provides:

- fluid containers
- non-solid storage systems

Relationship:

Tractus collects.

Vas stores.

---

## Fistula

Fistula provides:

- pipes
- transportation systems

Relationship:

Tractus extracts.

Fistula moves.

---

## Machinum

Machinum provides:

- machines
- processors
- industrial production

Relationship:

Tractus can provide resources for Machinum systems.

However, Tractus remains fully functional without Machinum.

---

## Potestas

Potestas provides:

- energy generation
- energy storage

Tractus does not require energy.

It remains independent from power systems.

---

# What Does Not Belong in Tractus

## Fluid Containers

Belongs to:

Vas

---

## Fluid Transportation

Belongs to:

Fistula

---

## Machine Processing

Belongs to:

Machinum

---

## Energy Systems

Belongs to:

Potestas

---

## Large Storage Systems

Belongs to:

Cista

---

## Player Abilities

Belongs to:

Praxis

---

# Ars Vitae Relationship

Tractus supports the [[Ars Vitae]] philosophy.

Ars Vitae focuses on improving the player's experience without forcing industrial gameplay.

Tractus improves:

- survival convenience
- resource gathering
- building preparation

without requiring:

- machines
- power
- automation networks

---

# Ars Mundi Relationship

In the complete Ars Mundi ecosystem:

Tractus represents the first step of resource handling.

The progression:
